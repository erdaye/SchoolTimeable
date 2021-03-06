package com.myclass;



import java.io.File;
import java.security.PublicKey;

import com.cn.daming.deskclock.R;

import android.R.integer;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Set_homework extends Activity {
	
	private EditText ETkemu,eTStartDate,Etstarttime,ETenddate,ETendtime,eTcontent;
     private Button trueButton,falseButton,cameraButton;
     
     private  static final int REQUEST_SUCCESS_CODE=200;
     private String imagepath;
     private ImageView image;
     
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.homework_settings);
		
		 
		 ETkemu=(EditText) findViewById(R.id.kemu);
		 eTStartDate=(EditText) findViewById(R.id.start_date);
		 Etstarttime=(EditText) findViewById(R.id.start_time);
		 ETenddate=(EditText) findViewById(R.id.end_date);
		ETendtime=(EditText) findViewById(R.id.end_time);
		 eTcontent=(EditText) findViewById(R.id.content);
		trueButton = (Button) findViewById(R.id.submit);
		 falseButton = (Button) findViewById(R.id.edit);
		 cameraButton=(Button) findViewById(R.id.camerabut);
		image=(ImageView) findViewById(R.id.pic);
	
	
	 trueButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(ETkemu.length()!=0)
				{
					
					Intent dataintent2=new Intent(Set_homework.this,HomeworkContent.class);
					dataintent2.putExtra("ETkemu",ETkemu.getText().toString());
					dataintent2.putExtra("eTStartDate", eTStartDate.getText().toString());
					dataintent2.putExtra("Etstarttime", Etstarttime.getText().toString());
					dataintent2.putExtra("ETenddate", ETenddate.getText().toString());
					dataintent2.putExtra("ETendtime", ETendtime.getText().toString());
					dataintent2.putExtra("eTcontent", eTcontent.getText().toString());
					
				    Toast .makeText(Set_homework.this, "添加成功", Toast .LENGTH_LONG).show();
				    startActivity(dataintent2);
				}
				else
					Toast .makeText(Set_homework.this, "还没有添加任何科目哦~", Toast .LENGTH_LONG).show();
					
				
			}
		});
	 
	 cameraButton.setOnClickListener(new  OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			//照片路径
			 imagepath=Environment.getExternalStorageDirectory().getAbsolutePath()+"mypic.jpg";
			 File imageFile=new  File(imagepath);
	
			 Uri imagefileUri=Uri.fromFile(imageFile);
			 Intent  intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			 intent.putExtra(MediaStore.EXTRA_OUTPUT, imagefileUri);
			 startActivityForResult(intent, REQUEST_SUCCESS_CODE);
			
		}
	});
	 
	 	}
	
	
      
//	Bundle b = getIntent().getExtras();
//		int e = b.getInt("key");
//		Cursor cursor = null;
//		DBadapter db = new DBadapter(Set_homework.this);
//		db.open();
//		cursor = db.getAllTitles();
//
//		cursor.moveToFirst();
//		
//		while (cursor.moveToNext()) {
//			int m = cursor.getInt(cursor.getColumnIndex("myid"));
//			if (m == e) {
//				ETkemu.setText(cursor.getString(cursor
//						.getColumnIndexOrThrow("kemuname")));
//				eTStartDate.setText(cursor.getString(cursor
//						.getColumnIndex("startdate")));
//				Etstarttime.setText(cursor.getString(cursor
//						.getColumnIndex("starttime")));
//				ETenddate.setText(cursor.getString(cursor
//						.getColumnIndex("enddate")));
//				ETendtime.setText(cursor.getString(cursor
//						.getColumnIndex("endtime")));
//				eTcontent.setText(cursor.getString(cursor
//						.getColumnIndex("content")));
//				
//
//			}
//
//		}
		
		 
		public void chooseStartDate(View view)
		{
			DatePickerDialog dapted =new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker dp, int year, int monthOfYear,
						int dayOfMonth) {
					// TODO Auto-generated method stub
					eTStartDate.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
					
					
				}
			}, 2015, 6, 1);
			dapted.setMessage("ͯ请选择具体日期");
			dapted.show();
			
		}
		
		
		//ͨ��ʱ��Ի���ѡ��ʼʱ��
		 public  void choosestarttime(View view1)
		 {
			 
			 TimePickerDialog timped=new  TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
				
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					// TODO Auto-generated method stub
					Etstarttime.setText(hourOfDay+":"+minute);
				}
			}, 10,00,true);
			 
			 timped.setMessage("请选择具体时间");
			 timped.show();
		 }
		 
		 public  void chooseenddate(View view2)
		 {
			 DatePickerDialog dapter=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					// TODO Auto-generated method stub
					
					ETenddate.setText(year+"-"+(monthOfYear+1)+"-"+dayOfMonth);
					
				}
			}, 2015, 12, 21);
			 
			 dapter.setMessage("请选择结束日期");
			 dapter.show();
		 }

		 
		 
		 public  void chooseendtime(View  view)
		 {
			 
			 TimePickerDialog timepd=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
				
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					// TODO Auto-generated method stub
					ETendtime.setText(hourOfDay+":"+minute);
				}
			}, 12, 21, true);
			 
			 timepd.setMessage("请选择具体时间 ");
			 timepd.show();
		 }
		 
		 
		
	
		 
		 @Override
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			// TODO Auto-generated method stub
			super.onActivityResult(requestCode, resultCode, data);
			
			if(requestCode==REQUEST_SUCCESS_CODE)
			{
				
				if(resultCode==RESULT_OK)
				{
					
					//����Ƭ��༭Ϊλͼ
					
					Bitmap bmp=BitmapFactory.decodeFile(imagepath);
					//����imageview���ظ���Ƭ
					image.setImageBitmap(bmp);
					
				}
				
				else 
					Toast.makeText(this, "放弃拍照",Toast.LENGTH_LONG).show();
			}
			
			super.onActivityResult(requestCode, resultCode, data);
		}
		 
		 
		 
		
}

	
			 

	

