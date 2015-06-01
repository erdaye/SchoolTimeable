package com.myclass;
import javax.security.auth.PrivateCredentialPermission;

import  com.myclass.R;

import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View.OnClickListener;


public class Homework_page extends Activity {
	
	private Button  CHButton;
	private ListView lv;
	private String[] adapterdata;
	private int key;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.r_homework);
	CHButton=(Button) findViewById(R.id.CreateNew);
	lv=(ListView) findViewById(R.id.homework_listview);
	
	//lv.setAdapter(new  ArrayAdapter<String>(Homework_page.this,R.layout.homework_list_item,strs));
	adapterdata=new String[]{"shuxue","yuwen","yingyu"};
	//adapterdata[0]=getIntent().getStringExtra("ETkemu1");
	lv.setAdapter(new ArrayAdapter<String>(Homework_page.this,android.R.layout.simple_list_item_1 ,adapterdata));
	CHButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	    Intent intent=new  Intent(Homework_page.this,Set_homework.class);
	    intent.putExtra("key", lv.getLastVisiblePosition()-lv.getFirstVisiblePosition()+1);
	    startActivity(intent);
	    
		}
	});
}
}
