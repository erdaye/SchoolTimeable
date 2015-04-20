package com.kcb;

import com.cn.daming.deskclock.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class qidong extends Activity{

	boolean _active = true;
	int _splashTime = 3000;
	@Override 
	public void onCreate(Bundle savedInstanceState){

		super.onCreate(savedInstanceState);
		setContentView(R.layout.hxa); //获取图片资源，准备启动logo

		Thread splashTread = new Thread() {
			@Override
			public void run() {
				try {
					int waited = 0;
					while(_active && (waited < _splashTime)) {
						sleep(100);
						if(_active) {
							waited += 100;
						}
					}
				} catch(InterruptedException e) {
					// do nothing
				} finally {
					finish();
					// 启动主应用
					Intent intent = new Intent(); 

					intent.setClass(qidong.this, MainActivity.class); 

					startActivity(intent); 


					finish();
				}
			}
		};

splashTread.start();


}

}