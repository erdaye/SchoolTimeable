package com.portaura.zxing;

import java.io.IOException;
import java.util.Collection;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.PowerManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;





import android.widget.Toast;

import com.cn.daming.deskclock.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.kcb.MainActivity;
import com.kcb.ResultActivity;
/*import com.kcb.ABC;*/
/*import com.kcb.daikaifa;*/
/*import com.kcb.shezhi;*/
import com.portaura.zxing.camera.CameraManager;

public final class CaptureActivity extends Activity implements
		SurfaceHolder.Callback {

	private CameraManager cameraManager;
	private CaptureActivityHandler handler;
	private ViewfinderView viewfinderView;
	private TextView statusView;
	private View resultView;
	// private Result lastResult;
	private boolean hasSurface;
	private Collection<BarcodeFormat> decodeFormats;
	private String characterSet;
	private InactivityTimer inactivityTimer;
	private BeepManager beepManager;
	PowerManager pm;
	PowerManager.WakeLock mWakeLock;
	String displayContents;

	ViewfinderView getViewfinderView() {
		return viewfinderView;
	}

	public Handler getHandler() {
		return handler;
	}

	CameraManager getCameraManager() {
		return cameraManager;
	}

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
		mWakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "My Tag");
		setContentView(R.layout.capture);

		hasSurface = false;
		inactivityTimer = new InactivityTimer(this);
		beepManager = new BeepManager(this);

		// PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
	}

	@Override
	protected void onResume() {
		super.onResume();
		cameraManager = new CameraManager(getApplication());
		viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
		Button daoruButton = (Button) findViewById(R.id.encodeButton);
       daoruButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
			    if(displayContents.length()>300){
					new Thread() {
						@Override
						public void run() {
							Log.i("开始导入", displayContents);
							DaoRu.DaoRuing(displayContents, CaptureActivity.this);
							Intent intent = new Intent(CaptureActivity.this,
									MainActivity.class);
							Log.v("111", "2");
							startActivity(intent);

							CaptureActivity.this.finish();
							Log.v("111", "3");
						}
					}.start();
					}else{
						Toast.makeText(CaptureActivity.this, "非课程信息无法导入",
								Toast.LENGTH_SHORT).show();
					}
			}
       });

	
		viewfinderView.setCameraManager(cameraManager);
		resultView = findViewById(R.id.result_view);
		statusView = (TextView) findViewById(R.id.status_view);
		handler = null;
		mWakeLock.acquire();
		resetStatusView();

		SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
		SurfaceHolder surfaceHolder = surfaceView.getHolder();
		if (hasSurface) {
			// The activity was paused but not stopped, so the surface still
			// exists. Therefore
			// surfaceCreated() won't be called, so init the camera here.
			initCamera(surfaceHolder);
		} else {
			// Install the callback and wait for surfaceCreated() to init the
			// camera.
			surfaceHolder.addCallback(this);
			surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		}
		beepManager.updatePrefs();
		inactivityTimer.onResume();
		// Intent intent = getIntent();
		decodeFormats = null;
		characterSet = "utf-8";
	}

	@Override
	protected void onPause() {
		if (handler != null) {
			handler.quitSynchronously();
			handler = null;
		}
		inactivityTimer.onPause();
		cameraManager.closeDriver();
		if (!hasSurface) {
			SurfaceView surfaceView = (SurfaceView) findViewById(R.id.preview_view);
			SurfaceHolder surfaceHolder = surfaceView.getHolder();
			surfaceHolder.removeCallback(this);
		}
		super.onPause();
		mWakeLock.release();
	}

	@Override
	protected void onDestroy() {
		inactivityTimer.shutdown();
		super.onDestroy();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			// if (source == IntentSource.NATIVE_APP_INTENT) {
			setResult(RESULT_CANCELED);
			finish();
			return true;
			// }
		} else if (keyCode == KeyEvent.KEYCODE_FOCUS
				|| keyCode == KeyEvent.KEYCODE_CAMERA) {
			// Handle these events so they don't launch the Camera app
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		if (holder == null) {
		}
		if (!hasSurface) {
			hasSurface = true;
			initCamera(holder);
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		hasSurface = false;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	public void handleDecode(Result rawResult, Bitmap barcode) {
		inactivityTimer.onActivity();
		ResultHandler resultHandler = ResultHandlerFactory.makeResultHandler(
				this, rawResult);

		if (barcode == null) {
			handleDecodeInternally(rawResult, resultHandler, null);
		} else {
			beepManager.playBeepSoundAndVibrate();
			drawResultPoints(barcode, rawResult);
			handleDecodeInternally(rawResult, resultHandler, barcode);
		}
	}

	private void drawResultPoints(Bitmap barcode, Result rawResult) {
		ResultPoint[] points = rawResult.getResultPoints();
		if (points != null && points.length > 0) {
			Canvas canvas = new Canvas(barcode);
			Paint paint = new Paint();
			paint.setColor(getResources().getColor(R.color.result_image_border));
			paint.setStrokeWidth(3.0f);
			paint.setStyle(Paint.Style.STROKE);
			Rect border = new Rect(2, 2, barcode.getWidth() - 2,
					barcode.getHeight() - 2);
			canvas.drawRect(border, paint);

			paint.setColor(getResources().getColor(R.color.result_points));
			if (points.length == 2) {
				paint.setStrokeWidth(4.0f);
				drawLine(canvas, paint, points[0], points[1]);
			} else if (points.length == 4
					&& (rawResult.getBarcodeFormat() == BarcodeFormat.UPC_A || rawResult
							.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
				drawLine(canvas, paint, points[0], points[1]);
				drawLine(canvas, paint, points[2], points[3]);
			} else {
				paint.setStrokeWidth(10.0f);
				for (ResultPoint point : points) {
					canvas.drawPoint(point.getX(), point.getY(), paint);
				}
			}
		}
	}

	private static void drawLine(Canvas canvas, Paint paint, ResultPoint a,
			ResultPoint b) {
		canvas.drawLine(a.getX(), a.getY(), b.getX(), b.getY(), paint);
	}

	// Put up our own UI for how to handle the decoded contents.
	private void handleDecodeInternally(Result rawResult,
			ResultHandler resultHandler, Bitmap barcode) {
		statusView.setVisibility(View.GONE);
		viewfinderView.setVisibility(View.GONE);
		resultView.setVisibility(View.VISIBLE);

		ImageView barcodeImageView = (ImageView) findViewById(R.id.barcode_image_view);
		if (barcode == null) {
			barcodeImageView.setImageBitmap(BitmapFactory.decodeResource(
					getResources(), R.drawable.b_g2));
		} else {
			barcodeImageView.setImageBitmap(barcode);
		}

		TextView contentsTextView = (TextView) findViewById(R.id.contents_text_view);
		displayContents = resultHandler.getDisplayContents();

		contentsTextView.setText(displayContents);

	}

/*	public void gotogene(View v) {
		Intent intent= new Intent(CaptureActivity.this, daikaifa.class);
		DaoRu.DaoRuing(displayContents, CaptureActivity.this);
		startActivity(intent);
	}*/

	private void initCamera(SurfaceHolder surfaceHolder) {
		try {
			cameraManager.openDriver(surfaceHolder);
			if (handler == null) {
				handler = new CaptureActivityHandler(this, decodeFormats,
						characterSet, cameraManager);
			}
			
		} catch (IOException ioe) {
			displayFrameworkBugMessageAndExit();
		} catch (RuntimeException e) {
			displayFrameworkBugMessageAndExit();
		}
	}

	private void displayFrameworkBugMessageAndExit() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.app_name));
		builder.setMessage(getString(R.string.msg_camera_framework_bug));
		builder.setPositiveButton(R.string.button_ok, new FinishListener(this));
		builder.setOnCancelListener(new FinishListener(this));
		builder.show();
	}

	private void resetStatusView() {
		resultView.setVisibility(View.GONE);
		statusView.setText(R.string.msg_default_status);
		statusView.setVisibility(View.VISIBLE);
		viewfinderView.setVisibility(View.VISIBLE);
	}

	public void drawViewfinder() {
		viewfinderView.drawViewfinder();
	}

/*	public void shareByTb(View v) {

	}

	public void sendToServer(View v) {

	}
*/
	/*
	  public void gotogene(View v) { 
		  String displayContents =
	  resultHandler.getDisplayContents(); 
	  DaoRu.DaoRuing(displayContents, CaptureActivity); }
	 */

	public void rep(View v) {
		onPause();
		onDestroy();
		onCreate(null);
		onResume();
	}
}

