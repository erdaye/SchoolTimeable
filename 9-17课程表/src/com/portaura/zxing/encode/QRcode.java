package com.portaura.zxing.encode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.utils.UIHandler;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.tencent.qzone.QZone.ShareParams;

import com.cn.daming.deskclock.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.kcb.DBAdapter;

public class QRcode extends Activity implements Callback {
	EditText inputText;
	TextView showTextView;
	ImageView qrImageView, scalImageView;
	private static final int WHITE = 0xFFFFFFFF;
	private static final int BLACK = 0xFF000000;
	private BarcodeFormat f;
	Bitmap bitmap;
	LinearLayout ll;
	Button share, encode2DBtn;
	private String s1, s2 = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ShareSDK.initSDK(this);

		setContentView(R.layout.activity_qrpic);
		encode2DBtn = (Button) findViewById(R.id.encode2DBtn);
		share = (Button) findViewById(R.id.share);
		DBAdapter db = new com.kcb.DBAdapter(QRcode.this);
		db.open();
		Cursor cursor = null;
		cursor = db.getAllTitles();
		for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
			s1 = ("$" + "#" + cursor.getString(cursor.getColumnIndex("myid"))
					+ "#"
					+ cursor.getString(cursor.getColumnIndex("classname"))
					+ "#" + cursor.getString(cursor.getColumnIndex("address"))
					+ "#" + cursor.getString(cursor.getColumnIndex("tel"))
					+ "#"
					+ cursor.getString(cursor.getColumnIndex("teachername"))
					+ "#" + cursor.getString(cursor.getColumnIndex("suxing"))
					+ "#" + cursor.getString(cursor.getColumnIndex("zhoushu"))
					+ "#" + cursor.getString(cursor.getColumnIndex("beizhu")) + "#");
			s2 = s2 + s1;
		}

		share.setOnClickListener(new OnClickListener() {
			public void onClick(View source) {

				OnekeyShare oks = new OnekeyShare();

				oks.setNotification(R.drawable.ic_launcher,
						getString(R.string.app_name));
				oks.setTitle("share image");
				oks.setText("share");
				oks.setImagePath("/mnt/sdcard/tttt.jpg");

				oks.show(QRcode.this);

			}

		});

		/*
		 * encode2DBtn.setOnClickListener(new OnClickListener() { public void
		 * onClick(View source) {
		 * 
		 * 
		 * qrImageView = (ImageView) findViewById(R.id.image_view);
		 * WindowManager manager = (WindowManager)
		 * getSystemService(WINDOW_SERVICE); Display display =
		 * manager.getDefaultDisplay(); int width = display.getWidth(); int
		 * height = display.getHeight(); int smallerDimension = width < height ?
		 * width : height; smallerDimension = smallerDimension * 13 / 10; int id
		 * = ((Button)View).getId(); if (id == R.id.encode2DBtn) { f =
		 * BarcodeFormat.QR_CODE; bitmap = encodeAsBitmap(s2, f,
		 * smallerDimension, smallerDimension); } else { f =
		 * BarcodeFormat.CODE_128; bitmap = encodeAsBitmap(s2, f,
		 * smallerDimension, smallerDimension / 3); }
		 * 
		 * 
		 * saveMyBitmap("tttt",bitmap);//灏嗗浘鍍忎繚瀛樺埌SD鍗′腑
		 * 
		 * if (bitmap == null) {
		 * showTextView.setText("缂栫爜澶辫触銆傚鏋滄偍鍦ㄧ敓鎴愭潯褰㈢爜锛岃閬靛惊杈撳叆瑙勫垯銆?);
		 * qrImageView.setImageBitmap(null); inputText.setText(""); return; }
		 * qrImageView.setImageBitmap(bitmap);
		 * 
		 * inputText.setText(""); inputText.setHintTextColor(Color.GREEN);
		 * inputText.setHint("鐐瑰嚮鐮佸浘鍙斁澶э紝鍐嶆鐐瑰嚮鍙缉鍥炪€?);
		 * showTextView.setText(contentString);
		 * 
		 * if (id == R.id.encode2DBtn) {
		 * setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); }
		 * else {
		 * setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); }
		 * 
		 * }});
		 */

	}

	public void geneqr(View v) {

		qrImageView = (ImageView) findViewById(R.id.image_view);
		WindowManager manager = (WindowManager) getSystemService(WINDOW_SERVICE);
		Display display = manager.getDefaultDisplay();
		int width = display.getWidth();
		int height = display.getHeight();
		int smallerDimension = width < height ? width : height;
		smallerDimension = smallerDimension * 13 / 10;
		int id = ((Button) v).getId();
		if (id == R.id.encode2DBtn) {
			f = BarcodeFormat.QR_CODE;
			bitmap = encodeAsBitmap(s2, f, smallerDimension, smallerDimension);
		} else {
			f = BarcodeFormat.CODE_128;
			bitmap = encodeAsBitmap(s2, f, smallerDimension,
					smallerDimension / 3);
		}

		saveMyBitmap("tttt", bitmap);// 灏嗗浘鍍忎繚瀛樺埌SD鍗′腑

		share.setVisibility(View.VISIBLE);

		if (bitmap == null) {
			/* showTextView.setText("缂栫爜澶辫触銆傚鏋滄偍鍦ㄧ敓鎴愭潯褰㈢爜锛岃閬靛惊杈撳叆瑙勫垯銆?); */
			qrImageView.setImageBitmap(null);
			/* inputText.setText(""); */
			return;
		}
		qrImageView.setImageBitmap(bitmap);
		/*
		 * inputText.setText(""); inputText.setHintTextColor(Color.GREEN);
		 * inputText.setHint("鐐瑰嚮鐮佸浘鍙斁澶э紝鍐嶆鐐瑰嚮鍙缉鍥炪€?);
		 * showTextView.setText(contentString);
		 */
		if (id == R.id.encode2DBtn) {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		} else {
			setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		if (this.getRequestedOrientation() == Configuration.ORIENTATION_PORTRAIT) {
			qrImageView.setImageBitmap(bitmap);
		}
		if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
			/* inputText.setInputType(InputType.TYPE_NULL); */
		}
	}

	Bitmap encodeAsBitmap(String contents, BarcodeFormat format, int w, int h) {
		String contentsToEncode = contents;
		Map<EncodeHintType, Object> hints = null;
		String encoding = "UTF-8";
		if (encoding != null) {
			hints = new EnumMap<EncodeHintType, Object>(EncodeHintType.class);
			hints.put(EncodeHintType.CHARACTER_SET, encoding);
		}
		MultiFormatWriter writer = new MultiFormatWriter();
		BitMatrix result;
		try {
			result = writer.encode(contentsToEncode, format, w, h, hints);
			int width = result.getWidth();
			int height = result.getHeight();
			int[] pixels = new int[width * height];
			for (int y = 0; y < height; y++) {
				int offset = y * width;
				for (int x = 0; x < width; x++) {
					pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
				}
			}

			Bitmap bitmap = Bitmap.createBitmap(width, height,
					Bitmap.Config.ARGB_8888);
			bitmap.setPixels(pixels, 0, width, 0, 0, width, height);
			return bitmap;
		} catch (Exception e) {
			Log.e("adffeife", e.toString());
			e.printStackTrace();
			return null;
		}
	}

	public void zoomup(View v) {
		ll = (LinearLayout) findViewById(R.id.linear);
		scalImageView = (ImageView) findViewById(R.id.scaleimg);
		ll.setVisibility(View.GONE);
		scalImageView.setVisibility(View.VISIBLE);
		scalImageView.setImageBitmap(bitmap);
	}

	public void zoomdown(View v) {
		ll.setVisibility(View.VISIBLE);
		scalImageView.setVisibility(View.GONE);
	}

	public boolean handleMessage(Message msg) {

		switch (msg.what) {
		case -1:
			Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT)
					.show();
			break;
		case 0:
			Toast.makeText(getApplicationContext(), "cancel",
					Toast.LENGTH_SHORT).show();
			break;
		case 1:
			Toast.makeText(getApplicationContext(), "complete",
					Toast.LENGTH_SHORT).show();
			break;
		}

		return false;

	}

	public void saveMyBitmap(String bitName, Bitmap mBitmap) {
		File f = new File("/sdcard/" + bitName + ".jpg");
		try {
			f.createNewFile();

		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		FileOutputStream fOut = null;
		try {
			fOut = new FileOutputStream(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
		try {
			fOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
