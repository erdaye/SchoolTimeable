package com.kcb;


import java.util.Timer;
import java.util.TimerTask;

import com.aiwenquan.Aiwen_shouye;
import com.cn.daming.deskclock.DeskClockMainActivity;
import com.cn.daming.deskclock.R;
import com.me.Me_shouye;

import android.R.integer;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends Activity {

	private RadioButton course, share, notification, scan;
	private Fragment courseFragment, QRcode, alarmFragment, cameraFragment;
	FragmentManager fgManager;
	private TextView tv1;
//	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main_activity);
		tv1=(TextView) findViewById(R.id.goodtitle);
		//
		fgManager = getFragmentManager();
		init();
		Intent getintent=getIntent();
		int  id=getintent.getIntExtra("fragid", -1);
		if(id>0)
		{
		if (id==1)
		share.setVisibility(0);}
		course.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				courseFragment = new CourseFragment();
				changeFrament(courseFragment, null, "talkFragment");
				changeRadioButtonImage(v.getId());
				tv1.setText("课程表");
			}
		});
		
		share.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				QRcode = new NoteFragment();
				changeFrament(QRcode, null, "Homework_page");
				changeRadioButtonImage(v.getId());
				tv1.setText("笔记本");
			}
		});
		
		notification.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				alarmFragment = new Aiwen_shouye();
				changeFrament(alarmFragment, null, "Aiwen_shouye");
				changeRadioButtonImage(v.getId());
				tv1.setText("爱问圈");
			}
		});
		
		scan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cameraFragment = new Me_shouye();
				changeFrament(cameraFragment, null, "me_shouye");
				changeRadioButtonImage(v.getId());
				tv1.setText("我");
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