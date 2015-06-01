package com.myclass;



import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Set_homework extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.homework_settings);
		final  EditText ETkemu=(EditText) findViewById(R.id.kemu);
		final EditText eTStartDate=(EditText) findViewById(R.id.start_date);
		final EditText Etstarttime=(EditText) findViewById(R.id.start_time);
		final EditText ETenddate=(EditText) findViewById(R.id.end_date);
		final EditText ETendtime=(EditText) findViewById(R.id.end_time);
		final EditText eTcontent=(EditText) findViewById(R.id.content);
		final Button trueButton = (Button) findViewById(R.id.submit);
		final  Button falseButton = (Button) findViewById(R.id.edit);
		
		
      
	Bundle b = getIntent().getExtras();
		int e = b.getInt("key");
		Cursor cursor = null;
		DBadapter db = new DBadapter(Set_homework.this);
		db.open();
		cursor = db.getAllTitles();

		cursor.moveToFirst();
		
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
		trueButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(ETkemu.length()!=0)
				{
					
					Intent dataintent2=new Intent(Set_homework.this,HomeworkContent.class);
					dataintent2.putExtra("kemuname",ETkemu.getText().toString());
					dataintent2.putExtra("startdate", eTStartDate.getText().toString());
					dataintent2.putExtra("starttime", Etstarttime.getText().toString());
					dataintent2.putExtra("enddate", ETenddate.getText().toString());
					dataintent2.putExtra("endtime", ETendtime.getText().toString());
					dataintent2.putExtra("content", eTcontent.getText().toString());
					
				    Toast .makeText(Set_homework.this, "添加成功", Toast .LENGTH_LONG).show();
				    startActivity(dataintent2);
				}
				else
					Toast .makeText(Set_homework.this, "亲，没有添加任何科目哟", Toast .LENGTH_LONG).show();
					
				
			}
		});
		
	}
}
