package com.myclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class DBadapter {
	public static final String Id = "_id";
	public static final String Kemuname = "kemuname";
	public static final String startdata = "startdate";
	public static final String startime = "starttime";
	public static final String enddatte= "enddate";
	public static final String endtime = "endtime";
	public static final String content = "content";
	private static final String DATABASE_NAME = "homework.db";
	private static final String DATABASE_TABLE = "event";
	private static final String TAG = "DBadapter";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table event(_id integer not null primary key autoincrement, myid integer , kemuname text ,	startdate text ,starttime text ,enddate text,endtime text ,content text)";

	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public DBadapter(Context ctx) {
		this.context = ctx;
		DBHelper = new DatabaseHelper(context);
	}

	private static class DatabaseHelper extends SQLiteOpenHelper// ToSDCardSQLiteOpenHelper
	{
		DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
			Log.i("TAG", "create database--------");

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
					+ newVersion + ", which will destroy all old data");
			db.execSQL("DROP TABLE IF EXISTS titles");
			onCreate(db);
		}
	}

	
	public DBadapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		DBHelper.close();
	}

	public long inserttable(int myid, String kemuname, String startdate,
			String starttime, String enddate, String endtime, String content) {
		ContentValues cv = new ContentValues();
		cv.put("myid", myid);
		cv.put("kemuname", kemuname);
		cv.put("startdate",startdate);
		cv.put("startime", starttime);
		cv.put("enddate", enddate);
		cv.put("endtime", endtime);
		cv.put("content", content);
		
		return db.insert(DATABASE_TABLE, null, cv);
	}

	public boolean deleteTitle(long id) {
		return db.delete(DATABASE_TABLE, Id + "=" + id, null) > 0;
	}

	public Cursor getAllTitles() {
		return db.query(DATABASE_TABLE,
				new String[] { "myid", "kemuname", "startdate", "enddate",
						"startime", "endtime", "content" }, null, null,
				null, null, null);
	}

	

	public boolean updateTitle(int id, int myid, String kemuname,
			String startdate, String startrime, String enddate, String endtime,
			String content, String beizhu) {
		ContentValues cv = new ContentValues();
		cv.put("myid", myid);
		cv.put("kemuname", kemuname);
		cv.put("startdate", startdate);
		cv.put("startime", startime);
		cv.put("enddate", enddate);
		cv.put("endtime", endtime);
		cv.put("content", content);
		
		return db.update(DATABASE_TABLE, cv, Id + "=" + id, null) > 0;
	}

}
