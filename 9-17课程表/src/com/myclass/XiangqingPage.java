package com.myclass;


import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

import com.cn.daming.deskclock.R;
import com.portaura.zxing.encode.QRcode;

import android.R.drawable;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class XiangqingPage extends Activity {
	
	public	TextView chazhi1;
	private EditText ETkemu11,ETkaishiriqi1,ETkaishishijian1,ETjiezhiriqi1,ETjiezhishijian1,ETcontent1;
	private Button querenButton,shareButton;
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.newdetail_content);
		final Button okbut1=(Button) findViewById(R.id.okbuton);
		  ETkemu11=(EditText) findViewById(R.id.kemutext1);
	      ETkaishiriqi1=(EditText) findViewById(R.id.qishidate1);
			
		 ETkaishishijian1 =(EditText) findViewById(R.id.qishitime1);
		 ETjiezhiriqi1=(EditText) findViewById(R.id.jiezhidate1);
		 ETjiezhishijian1=(EditText) findViewById(R.id.jiezhitime1);
		ETcontent1=(EditText) findViewById(R.id.neirongtext1);
		shareButton=(Button) findViewById(R.id.hshare);
		imageView=(ImageView) findViewById(R.id.content_myview1);
		final Intent getIntent=getIntent();
		ETkemu11.setText(getIntent.getStringExtra("kemuname"));
		ETkaishiriqi1.setText(getIntent.getStringExtra("startdate"));
		ETkaishishijian1.setText(getIntent.getStringExtra("starttime"));
		ETjiezhiriqi1.setText(getIntent.getStringExtra("enddate"));
		ETjiezhishijian1.setText(getIntent.getStringExtra("endtime"));
		ETcontent1.setText(getIntent.getStringExtra("content"));
		
		Bitmap bmpBitmap=BitmapFactory.decodeFile(getIntent.getStringExtra("mypic"));
		imageView.setImageBitmap(bmpBitmap);
		imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				LayoutInflater inflater=LayoutInflater.from(XiangqingPage.this);
				View imageentryview=inflater.inflate(R.layout.imageviewcheck, null);
				final AlertDialog dialog=new AlertDialog.Builder(XiangqingPage.this).create();
				ImageView img=(ImageView) imageentryview.findViewById(R.id.largeimage);
				Bitmap bmpBitmap=BitmapFactory.decodeFile(getIntent.getStringExtra("mypic"));
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
		
		ShareSDK.initSDK(this);
	   okbut1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			final ContentValues values=new ContentValues();
			
			//values.put("_id", getIntent.getIntExtra("id", 1));
			values.put("kemuname", ETkemu11.getText().toString());
			values.put("startdate", ETkaishiriqi1.getText().toString());
			values.put("starttime", ETkaishishijian1.getText().toString());
			values.put("enddate", ETjiezhiriqi1.getText().toString());
			values.put("endtime", ETjiezhishijian1.getText().toString());
			values.put("content", ETcontent1.getText().toString());
			
			
			final DatabaseHelper dbHelper=new DatabaseHelper(getApplicationContext());		
		   dbHelper.update(getIntent.getIntExtra("id", 2), values);
			Intent intent3=new Intent(XiangqingPage.this,Homework_page.class);		
		    startActivity(intent3);
		}
	});
	   shareButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			OnekeyShare oks = new OnekeyShare();

			oks.setNotification(R.drawable.ic_launcher,
					getString(R.string.app_name));
			oks.setTitle("share image");
			oks.setText( ETcontent1.getText().toString());
			
			oks.setImagePath(getIntent.getStringExtra("mypic"));
         
			oks.show(XiangqingPage.this);
			Drawable drawable=getResources().getDrawable(R.drawable.ic_clock_alarm_on);
			Resources resources=getResources();
			Bitmap bitmap=BitmapFactory.decodeResource(resources, R.drawable.notification1);
			oks.setCustomerLogo(bitmap,"爱问圈",new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					Intent intent=new Intent(XiangqingPage.this,Shareto.class);
					intent.putExtra("mycontent",ETcontent1.getText().toString() );
					intent .putExtra("mypic", getIntent.getStringExtra("mypic"));
					startActivity(intent);
					
				}
			} );
			
			
		}
	});
		
		
	}
	


		
		
	}

