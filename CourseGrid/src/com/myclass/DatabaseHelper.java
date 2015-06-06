package com.myclass;

import android.R.integer;
import android.R.string;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper  extends SQLiteOpenHelper {
	
	private static final String DB__NAME="MyRelation.db";
	private static final String TABLE_NAME="relation";
	private  static final String CREATE_TABLE="create table relation(_id integer primary key autoincrement,kemuname text,startdate text,starttime text,enddate text,endtime text,content text);";
    private SQLiteDatabase db;
	public DatabaseHelper(Context context) {
		super(context, DB__NAME, null, 2);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void insert(ContentValues values)//charu
	{
		
		SQLiteDatabase  db=getWritableDatabase();
		db.insert(TABLE_NAME, null, values);
		db.close();
	}
	
	public void del(int id) //shanchu
	
	{
		if(db==null)
			db=getWritableDatabase();
		db.delete(TABLE_NAME, "_id=?",new String[]{String.valueOf(id)});
	
	}
	
	public Cursor query()
	{
		
		SQLiteDatabase db=getWritableDatabase();
		Cursor cursor =db.query(TABLE_NAME,null, null, null, null, null, null, null);
		if(cursor.getCount()==0)
				{
			System.out.print("zheshi kongde ");
			
				}
		return cursor;
		
		
	}
	
	public Cursor query2(int  id)
	{
		
		SQLiteDatabase db=getWritableDatabase();

     

     Cursor c=db.query(TABLE_NAME, null, "_id=?", new String[]{String.valueOf(id)}, null, null, null, null);
     return c;

}
		
		
	
	public void  close()
	{
		if(db!=null) db.close();
	}
	
	public void update(int  id,ContentValues cv1)
	{
		SQLiteDatabase db=getWritableDatabase();
	
//		cv.put("kemuname",kemuname);
//		cv.put("startdate", startdate);
//		cv.put("startime", starttime);
//		cv.put("enddate", enddate);
//		cv.put("endtime", endtime);
//		cv.put("content", content);
		
		db.update(TABLE_NAME, cv1, "_id=?", new String[]{String.valueOf(id)});

		//同样可以使用execSQL方法来执行一条“更新”的SQL语句

//		String UPDATE_DATA="update relation set kemuname= where xxx";
//		db.execSQL(UPDATE_DATA);
		
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		
		// TODO Auto-generated method stub
		this.db=db;
		db.execSQL(CREATE_TABLE);
	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	
}
