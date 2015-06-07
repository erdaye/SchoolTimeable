package com.myclass;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cn.daming.deskclock.R;

import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeworkContent extends Activity {
	
public	TextView chazhi;
private EditText ETkemu1,ETkaishiriqi,ETkaishishijian,ETjiezhiriqi,ETjiezhishijian,ETcontent;
	private ImageView imageview;
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
	imageview=(ImageView) findViewById(R.id.content_myview);
	final Intent getintent=getIntent();
	ETkemu1.setText(getintent.getStringExtra("ETkemu"));
	ETkaishiriqi.setText(getintent.getStringExtra("eTStartDate"));
	ETkaishishijian.setText(getintent.getStringExtra("Etstarttime"));                   
	ETjiezhiriqi.setText(getintent.getStringExtra("ETenddate"));
	ETjiezhishijian.setText(getintent.getStringExtra("ETendtime"));
	ETcontent.setText(getintent.getStringExtra("eTcontent"));
	Bitmap bmpBitmap=BitmapFactory.decodeFile(getintent.getStringExtra("mypic"));
	imageview.setImageBitmap(bmpBitmap);
	imageview.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			LayoutInflater inflater=LayoutInflater.from(HomeworkContent.this);
			View imageentryview=inflater.inflate(R.layout.imageviewcheck, null);
			final AlertDialog dialog=new AlertDialog.Builder(HomeworkContent.this).create();
			ImageView img=(ImageView) imageentryview.findViewById(R.id.largeimage);
			Bitmap bmpBitmap=BitmapFactory.decodeFile(getintent.getStringExtra("mypic"));
			img.setImageBitmap(bmpBitmap);
			dialog.setView(imageentryview);
			dialog.show();
			imageentryview.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialog.cancel();
				}
			});
			
		}
	});
	
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
			values.put("mypic",getintent.getStringExtra("mypic") );
			final DatabaseHelper dbHelper=new DatabaseHelper(getApplicationContext());		
		   dbHelper.insert(values);
			Intent intent3=new Intent(HomeworkContent.this,Homework_page.class);		
		    startActivity(intent3);
			
			
		}
	} );
	}
	
	
	
	
	
	
}
