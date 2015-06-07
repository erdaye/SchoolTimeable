package com.myclass;
import com.aiwenquan.Aiwen_shouye;
import com.cn.daming.deskclock.R;

import android.view.View.OnClickListener;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Shareto extends Activity {
	private EditText sharetoEditText;
	private  Button sharetonoButton;
	private Button sharetookButton;
	private ImageView imageView;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.shareto);
	sharetoEditText=(EditText) findViewById(R.id.shareto_text);
	sharetonoButton=(Button) findViewById(R.id.shareto_no);
	sharetookButton=(Button) findViewById(R.id.shareto_ok);
	imageView=(ImageView) findViewById(R.id.shareto_image);
	final Intent i=getIntent();
	sharetoEditText.setText(i.getStringExtra("mycontent"));
	Bitmap bmpBitmap=BitmapFactory.decodeFile(i.getStringExtra("mypic"));
	imageView.setImageBitmap(bmpBitmap);
	imageView.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			LayoutInflater inflater=LayoutInflater.from(Shareto.this);
			View imageentryview=inflater.inflate(R.layout.imageviewcheck, null);
			final AlertDialog dialog=new AlertDialog.Builder(Shareto.this).create();
			ImageView img=(ImageView) imageentryview.findViewById(R.id.largeimage);
			Bitmap bmpBitmap=BitmapFactory.decodeFile(i.getStringExtra("mypic"));
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
	
	sharetonoButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			AlertDialog.Builder aBuilder=new AlertDialog.Builder(Shareto.this);
			aBuilder.setMessage("确认要退出编辑吗?").setPositiveButton("退出", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
					finish();
		
				}
			}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			AlertDialog alertDialog=aBuilder.create();
			alertDialog.show();
		}
	});
	
	sharetookButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
//			Intent  intent =new Intent(Shareto.this,Aiwen_shouye.class);
//			startActivity(intent);
			Toast .makeText(Shareto.this, "分享成功", Toast .LENGTH_LONG).show();
			finish();
			
		}
	});
}
  @Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
	  
	// TODO Auto-generated method stub
	  
	  AlertDialog.Builder aBuilder=new AlertDialog.Builder(Shareto.this);
		aBuilder.setMessage("确认要退出编辑吗?").setPositiveButton("退出", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
				finish();
	
			}
		}).setNegativeButton("取消", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				
			}
		});
		AlertDialog alertDialog=aBuilder.create();
		alertDialog.show();
	return false;
}
}
