package com.myclass;
import com.cn.daming.deskclock.R;
import com.kcb.MainActivity;
import com.kcb.NoteFragment;

import java.security.PublicKey;

import javax.security.auth.PrivateCredentialPermission;










import android.R.integer;
import android.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.view.View.OnClickListener;


public class Homework_page extends Activity {
	
	private Button  CHButton,back,rijiButton,hButton;
	private ListView lv;
	private String[] adapterdata;
	private int key;
	private RadioButton  rdbut;
	private TextView tView;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.r_homework);
	CHButton=(Button) findViewById(R.id.CreateNew);
	lv=(ListView) findViewById(R.id.homework_listview);
	//rdbut=(RadioButton) findViewById(R.id.zuoye);
     back=(Button) findViewById(R.id.back);
     hButton=(Button) findViewById(R.id.zuoye);
     hButton.setBackgroundColor(getResources().getColor(R.color.mynyellow));
     rijiButton=(Button) findViewById(R.id.riji);
     rijiButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent =new Intent(Homework_page.this,Jidshiben.class);
			startActivity(intent);
			//overridePendingTransition(R.anim.in_from_right,R.anim.out_to_left );
			
		}
	});
     back.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent= new Intent(Homework_page.this,MainActivity.class);
			intent.putExtra("fragid", 1);
			startActivity(intent);
			
			
		}
	});
	
	getRelationFromDB();
	
	
	//lv.setAdapter(new  ArrayAdapter<String>(Homework_page.this,R.layout.homework_list_item,strs));
	//adapterdata=new String[]{"shuxue","yuwen","yingyu"};
	//adapterdata[0]=getIntent().getStringExtra("ETkemu1");
	//lv.setAdapter(new ArrayAdapter<String>(Homework_page.this,android.R.layout.simple_list_item_1 ,adapterdata));
	CHButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
	    Intent intent=new  Intent(Homework_page.this,Set_homework.class);
	    intent.putExtra("key", lv.getLastVisiblePosition()-lv.getFirstVisiblePosition()+1);
	    startActivityForResult(intent, 0x111);
	    
		}
	});
}
private void getRelationFromDB() {
	// TODO Auto-generated method stub
	final DatabaseHelper dbHelper=new DatabaseHelper(this);
	Cursor cursor=dbHelper.query();
	if(cursor!=null)
	{
	String[] from={"_id","kemuname","startdate","starttime"};//���ݿ��ֶ�
	int []to={R.id._id,R.id.kemu4,R.id.qishiriqi,R.id.qishishijian};
	@SuppressWarnings("deprecation")
	SimpleCursorAdapter scadapter=new SimpleCursorAdapter(this, R.layout.homework_list_item, cursor, from, to);
	lv.setAdapter(scadapter);
	}
	else {

		
		adapterdata=new String[]{"shuxue","yuwen","yingyu"};
	
		lv.setAdapter(new ArrayAdapter<String>(Homework_page.this,android.R.layout.simple_list_item_1 ,adapterdata));
	}
	lv.setOnItemLongClickListener(new  AdapterView.OnItemLongClickListener() {

		@Override
		public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
				int arg2, long id) {
			// TODO Auto-generated method stub
			
			final long temp=id;
			AlertDialog.Builder adbuilder=new  AlertDialog.Builder(Homework_page.this);
			adbuilder.setMessage("确认要删除这天记录么？").setPositiveButton("对呀", new  DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					dbHelper.del((int)temp);
					Cursor cursor=dbHelper.query();
					String[] from={"_id","kemuname","startdate","starttime"};
					int []to={R.id._id,R.id.kemu4,R.id.qishiriqi,R.id.qishishijian};
					@SuppressWarnings("deprecation")
					SimpleCursorAdapter scadapter=new SimpleCursorAdapter(getApplicationContext(), R.layout.homework_list_item, cursor, from, to);
					Homework_page.this.lv.setAdapter(scadapter);
					
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
//	lv.setOnClickListener(new OnClickListener() {
		
//		@Override
//		public void onClick(View v) {
//			// TODO Auto-generated method stub
//			
//			Intent intent=new Intent(Homework_page.this,XiangqingPage.class);
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
      lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long id2) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(Homework_page.this,XiangqingPage.class);
			final long temp=id2;
//		   Cursor cursor=dbHelper.query2((int)temp);
		 
		    String  str[]={"0","0","0","0","0","0","0"};
			 duquing(getApplicationContext(), str, (int)temp);
			    intent.putExtra("kemuname",str[0]);
			    intent.putExtra("startdate",str[1]);
			    intent.putExtra("starttime",str[2]);
			    intent.putExtra("enddate",str[3]);
			    intent.putExtra("endtime",str[4]);
			    intent.putExtra("content",str[5]);
		        intent.putExtra("id",(int)temp );
		    startActivity(intent);
		  
		}
	});
dbHelper.close();
	
	
	
	
}


public static String[]  duquing(Context context, String []str, int j) {
	Cursor cursor = null;
	final DatabaseHelper db = new DatabaseHelper(context);
	
	cursor = db.query();
	Bundle bundle=new Bundle();

	cursor.moveToFirst();
	while (cursor.moveToNext()) {
		int m = cursor.getInt(cursor.getColumnIndex("_id"));

		if (m == j) {
			     str[0]=cursor.getString(cursor
					.getColumnIndex("kemuname"));
			     str[1]=cursor.getString(cursor.getColumnIndex("startdate"));
			     str[2]=cursor.getString(cursor.getColumnIndex("starttime"));
			     str[3]=cursor.getString(cursor.getColumnIndex("enddate"));
			     str[4]=cursor.getString(cursor.getColumnIndex("endtime"));
			     str[5]=cursor.getString(cursor.getColumnIndex("content"));
			

		}
	}return str;
}
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
	if(requestCode==0x111 && requestCode==0x111)
		getRelationFromDB();
		
}
}
