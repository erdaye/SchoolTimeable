package com.kcb;


import com.cn.daming.deskclock.DeskClockMainActivity;
import com.cn.daming.deskclock.R;
import com.portaura.zxing.CaptureActivity;
import com.portaura.zxing.encode.QRcode;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class SelectPicPopupWindow extends Activity implements OnClickListener{

	private Button btn_take_photo, btn_pick_photo, btn_cancel,btn_alarm;
	private LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alert_dialog);
		btn_take_photo = (Button) this.findViewById(R.id.btn_take_photo);
		btn_pick_photo = (Button) this.findViewById(R.id.btn_pick_photo);
		btn_cancel = (Button) this.findViewById(R.id.btn_cancel);
		btn_alarm = (Button) this.findViewById(R.id. btn_alarm);
		layout=(LinearLayout)findViewById(R.id.pop_layout);
		
		
		layout.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "��ʾ����������ⲿ�رմ��ڣ�", 
						Toast.LENGTH_SHORT).show();	
			}
		});

		btn_cancel.setOnClickListener(this);
		btn_pick_photo.setOnClickListener(this);
		btn_take_photo.setOnClickListener(this);
		btn_alarm.setOnClickListener(this);
	}
	

	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_take_photo:
			
			Intent openCameraIntent = new Intent(SelectPicPopupWindow.this,
					CaptureActivity.class);
			startActivity(openCameraIntent);
			
			break;
		case R.id.btn_pick_photo:		
			
			startActivity(new Intent(SelectPicPopupWindow.this, QRcode.class));
			break;
		case R.id.btn_cancel:			
			
			
			break;
			
		case R.id.btn_alarm:
			startActivity(new Intent(SelectPicPopupWindow.this, DeskClockMainActivity.class));
		default:
			break;
		}
		finish();
	}
	
}
