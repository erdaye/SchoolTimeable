package com.myclass;
import com.cn.daming.deskclock.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mynote extends Activity {
	
  private TextView tvtitle,tvcontent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mynote);
		  tvcontent=(TextView) findViewById(R.id.mycontent);
	      tvtitle=(TextView) findViewById(R.id.mytitle);
			
		 
		final Intent getIntent=getIntent();
		tvtitle.setText(getIntent.getStringExtra("title"));
		tvcontent.setText(getIntent.getStringExtra("content"));
		
	}

}
