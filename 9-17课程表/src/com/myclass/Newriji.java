package com.myclass;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cn.daming.deskclock.R;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Newriji extends Activity {
	
	private TextView tvtitle,tvcontent;
	private Button submit;
	private String nowtime;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.common_note);
		tvcontent=(TextView) findViewById(R.id.rijicontent);
		tvtitle=(TextView) findViewById(R.id.rijititle);
		submit=(Button) findViewById(R.id.submit1);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		nowtime=df.format(new Date());// new Date()为获取当前系统时间

		
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(tvtitle.length()!=0)
				{
				
				final ContentValues vs=new ContentValues();
				vs.put("title", tvtitle.getText().toString());
				vs.put("content", tvcontent.getText().toString());
				vs.put("nowtime", nowtime);
				final DBadapter dbadapter=new DBadapter(getApplicationContext());		
				   dbadapter.insert2(vs);
				Intent i=new  Intent(Newriji.this,Jidshiben.class);
				startActivity(i);
				}
				else  
					
						Toast .makeText(Newriji.this, "还没有添加任何科目哦~", Toast .LENGTH_LONG).show();
			}
		});
	
	}

}
