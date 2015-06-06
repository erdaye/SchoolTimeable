package com.myclass;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cn.daming.deskclock.R;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HomeworkContent extends Activity {
	
public	TextView chazhi;
private EditText ETkemu1,ETkaishiriqi,ETkaishishijian,ETjiezhiriqi,ETjiezhishijian,ETcontent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_content);
        final Button okbut=(Button) findViewById(R.id.okbut);
	  ETkemu1=(EditText) findViewById(R.id.kemutext);
      ETkaishiriqi=(EditText) findViewById(R.id.qishidate);
		
	 ETkaishishijian =(EditText) findViewById(R.id.qishitime);
	 ETjiezhiriqi=(EditText) findViewById(R.id.jiezhidate);
	 ETjiezhishijian=(EditText) findViewById(R.id.jiezhitime);
	ETcontent=(EditText) findViewById(R.id.neirongtext);
	Intent getintent=getIntent();
	ETkemu1.setText(getintent.getStringExtra("ETkemu"));
	ETkaishiriqi.setText(getintent.getStringExtra("eTStartDate"));
	ETkaishishijian.setText(getintent.getStringExtra("Etstarttime"));                   
	ETjiezhiriqi.setText(getintent.getStringExtra("ETenddate"));
	ETjiezhishijian.setText(getintent.getStringExtra("ETendtime"));
	ETcontent.setText(getintent.getStringExtra("eTcontent"));
	chazhi=(TextView) findViewById(R.id.totaltime);
	okbut.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			
			final ContentValues values=new ContentValues();
			values.put("kemuname", ETkemu1.getText().toString());
			values.put("startdate", ETkaishiriqi.getText().toString());
			values.put("starttime", ETkaishishijian.getText().toString());
			values.put("enddate", ETjiezhiriqi.getText().toString());
			values.put("endtime", ETjiezhishijian.getText().toString());
			values.put("content", ETcontent.getText().toString());
			final DatabaseHelper dbHelper=new DatabaseHelper(getApplicationContext());		
		   dbHelper.insert(values);
			Intent intent3=new Intent(HomeworkContent.this,Homework_page.class);		
		    startActivity(intent3);
			
			
		}
	} );
	}
	
	
	
	
	
	
}
