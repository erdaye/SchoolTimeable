package com.kcb;


import java.util.Timer;
import java.util.TimerTask;

import com.cn.daming.deskclock.DeskClockMainActivity;
import com.cn.daming.deskclock.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.Toast;
public class MainActivity extends Activity {

	private RadioButton course, share, notification, scan;
	private Fragment courseFragment, QRcode, alarmFragment, cameraFragment;
	FragmentManager fgManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		fgManager = getFragmentManager();
		init();
		course.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				courseFragment = new CourseFragment();
				changeFrament(courseFragment, null, "talkFragment");
				changeRadioButtonImage(v.getId());
			}
		});
		
		share.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				QRcode = new QRFragment();
				changeFrament(QRcode, null, "QRcode");
				changeRadioButtonImage(v.getId());
			}
		});
		
		notification.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				alarmFragment = new DeskClockMainActivity();
				changeFrament(alarmFragment, null, "alarmFragment");
				changeRadioButtonImage(v.getId());
			}
		});
		
		scan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cameraFragment = new CameraFragment();
				changeFrament(cameraFragment, null, "cameraFragment");
				changeRadioButtonImage(v.getId());
			}
		});
	}

	// 初始化信息
	public void init() {
		course = (RadioButton) findViewById(R.id.course);
		share = (RadioButton) findViewById(R.id.share);
		notification = (RadioButton) findViewById(R.id.notification);
		scan = (RadioButton) findViewById(R.id.scan);
		courseFragment = new CourseFragment();
		changeFrament(courseFragment, null, "talkFragment");
		// 更换 android:drawableTop图pain资源
		course.setCompoundDrawablesWithIntrinsicBounds(0,
				R.drawable.course1, 0, 0);
	}

	// 切界面
	public void changeFrament(Fragment fragment, Bundle bundle, String tag) {

		for (int i = 0, count = fgManager.getBackStackEntryCount(); i < count; i++) {
			fgManager.popBackStack();
		}
		FragmentTransaction fg = fgManager.beginTransaction();
		fragment.setArguments(bundle);
		fg.add(R.id.fragmentRoot, fragment, tag);
		fg.addToBackStack(tag);
		fg.commit();

	}

	// 更换RadioButton图片
	public void changeRadioButtonImage(int btids) {
		int[] imageh = { R.drawable.share2, R.drawable.notification2,
				R.drawable.camera2, R.drawable.course2 };
		int[] imagel = { R.drawable.share1, R.drawable.notification1,
				R.drawable.camera1, R.drawable.course1 };
		int[] rabt = { R.id.share, R.id.notification, R.id.scan,
				R.id.course };
		switch (btids) {
		case R.id.share:
			changeImage(imageh, imagel, rabt, 0);
			break;
		case R.id.notification:
			changeImage(imageh, imagel, rabt, 1);
			break;
		case R.id.scan:
			changeImage(imageh, imagel, rabt, 2);
			break;
		case R.id.course:
			changeImage(imageh, imagel, rabt, 3);
			break;
		default:
			break;
		}
	}

	private static Boolean isQuit = false;
	Timer timer = new Timer();
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isQuit == false) {
				isQuit = true;
				Toast.makeText(getBaseContext(), "亲！再按一次就退出了哦",
						Toast.LENGTH_SHORT).show();
				TimerTask task = null;
				task = new TimerTask() {
					@Override
					public void run() {
						isQuit = false;
					}
				};
				timer.schedule(task, 2000);
			} else {
				finish();
				System.exit(0);
			}
		}
		return false;
	}
	
	public void changeImage(int[] image1, int[] image2, int[] rabtid, int index) {
		for (int i = 0; i < image1.length; i++) {
			if (i != index) {
				((RadioButton) findViewById(rabtid[i]))
						.setCompoundDrawablesWithIntrinsicBounds(0, image1[i],
								0, 0);
			} else {
				((RadioButton) findViewById(rabtid[i]))
						.setCompoundDrawablesWithIntrinsicBounds(0, image2[i],
								0, 0);
			}
		}
	}

}