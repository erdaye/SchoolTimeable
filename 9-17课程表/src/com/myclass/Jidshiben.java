package com.myclass;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.cn.daming.deskclock.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Jidshiben extends Activity {
	
	private Button hButton,rijibut,createButton;
	private ListView lv1;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.comon_note_page);
		hButton=(Button) findViewById(R.id.zuoye);
		rijibut=(Button) findViewById(R.id.riji);
		
		lv1=(ListView) findViewById(R.id.commonnote);
		createButton=(Button) findViewById(R.id.CreateNew2);
		 getRelationFromDB2();
		createButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(Jidshiben.this,Newriji.class);
				startActivity(myIntent);
			}
		});
		rijibut.setBackgroundColor(getResources().getColor(R.color.mynyellow));
		hButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent =new Intent(Jidshiben.this,Homework_page.class);
				startActivity(intent);
				//overridePendingTransition(R.anim.out_to_left, R.anim.in_from_right);
				
			}
		});
	}
	
	

	

private void getRelationFromDB2() {
	// TODO Auto-generated method stub
	final DBadapter dbHelper=new DBadapter(this);
	Cursor cursor=dbHelper.query3();
	
	String[] from={"_id","title","nowtime"};
	int []to={R.id._id,R.id.title,R.id.time};
	@SuppressWarnings("deprecation")
	SimpleCursorAdapter scadapter=new SimpleCursorAdapter(this, R.layout.common_list_item, cursor, from, to);
	lv1.setAdapter(scadapter);
	
	lv1.setOnItemLongClickListener(new  AdapterView.OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long id) {
			// TODO Auto-generated method stub
			
			final long temp=id;
			AlertDialog.Builder adbuilder=new  AlertDialog.Builder(Jidshiben.this);
			adbuilder.setMessage("确认要删除这条记录么？").setPositiveButton("对呀", new  DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dbHelper.del2((int)temp);
					Cursor cursor=dbHelper.query3();
					
					String[] from={"_id","title"};
					int []to={R.id._id,R.id.title};
					@SuppressWarnings("deprecation")
					SimpleCursorAdapter scadapter=new SimpleCursorAdapter(getApplicationContext(), R.layout.common_list_item, cursor, from, to);
					Jidshiben.this.lv1.setAdapter(scadapter);
					
				}
			}).setNegativeButton("手滑", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			AlertDialog aleraDialog=adbuilder.create();
			aleraDialog.show();return true;
		}
	});
//	lv1.setOnClickListener(new OnClickListener() {
		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			
//			Intent intent=new Intent(Jidshiben.this,XiangqingPage.class);
//			intent .putExtra("_id",TvView.get );
//			intent.putExtra("kemuname", "kemuname");
//			intent.putExtra("startdate", "startdate");
//			intent.putExtra("starttime","starttime");
//			startActivity(intent);
//			
//			
//			
//			
//		}
//	});
      lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long id2) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(Jidshiben.this,Mynote.class);
			final long temp=id2;
//		   Cursor cursor=dbHelper.query32((int)temp);
		 
		    String  str[]={"0","0"};
			 duquing(getApplicationContext(), str, (int)temp);
			    intent.putExtra("title",str[0]);
			    intent.putExtra("content",str[1]);
			    
		        intent.putExtra("id",(int)temp );
		    startActivity(intent);
		  
		}
	});
dbHelper.close();
	
	
	
	
}


public static String[]  duquing(Context context, String []str, int j) {
	Cursor cursor = null;
	final DBadapter db = new DBadapter(context);
	
	cursor = db.query3();
	Bundle bundle=new Bundle();

	cursor.moveToFirst();
	while (cursor.moveToNext()) {
		int m = cursor.getInt(cursor.getColumnIndex("_id"));

		if (m == j) {
			     str[0]=cursor.getString(cursor
					.getColumnIndex("title"));
			     str[1]=cursor.getString(cursor.getColumnIndex("content"));
			     
			

		}
	}return str;
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	if(requestCode==0x111 && requestCode==0x111)
		getRelationFromDB2();
		
}

}
