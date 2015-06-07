package com.kcb;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

	public static final String Id = "_id";
	public static final String Classname = "classname";
	public static final String Address = "address";
	public static final String TeacherName = "teachername";
	
	private static final String DATABASE_NAME = "lesson.db";
	private static final String DATABASE_TABLE = "event";
	private static final String TAG = "DBAdapter";
	private static final int DATABASE_VERSION = 1;
	
	private static final String DATABASE_CREATE = "create table event (_id integer not null primary key autoincrement,myid integer ,classname text ,	address text ,tel text ,teachername text,suxing text ,zhoushu text ,beizhu text)";

	private final Context context;
	private DatabaseHelper DBHelper;
	private SQLiteDatabase db;

	public DBAdapter(Context ctx) {
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

	// ---����ݿ�---
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}// ---�ر���ݿ�---

	public void close() {
		DBHelper.close();
	}// ---����ݿ��в���һ������---

	public long inserttable(int myid, String classname, String address,
			String tel, String teachername, String suxing, String zhoushu,
			String beizhu) {
		ContentValues cv = new ContentValues();
		cv.put("myid", myid);
		cv.put("classname", classname);
		cv.put("address", address);
		cv.put("tel", tel);
		cv.put("teachername", teachername);
		cv.put("suxing", suxing);
		cv.put("zhoushu", zhoushu);
		cv.put("beizhu", beizhu);
		return db.insert(DATABASE_TABLE, null, cv);
	}// ---ɾ��һ��ָ������---

	public boolean deleteTitle(long id) {
		return db.delete(DATABASE_TABLE, Id + "=" + id, null) > 0;
	}// ---�������б���---

	public Cursor getAllTitles() {
		return db.query(DATABASE_TABLE,
				new String[] { "myid", "classname", "address", "teachername",
						"tel", "suxing", "zhoushu", "beizhu" }, null, null,
				null, null, null);
	}// ---����һ��ָ������---

	// ---����һ������---

	public boolean updateTitle(int id, int myid, String classname,
			String address, String tel, String teachername, String suxing,
			String zhoushu, String beizhu) {
		ContentValues cv = new ContentValues();
		cv.put("myid", myid);
		cv.put("classname", classname);
		cv.put("address", address);
		cv.put("tel", tel);
		cv.put("teachername", teachername);
		cv.put("suxing", suxing);
		cv.put("zhoushu", zhoushu);
		cv.put("beizhu", beizhu);
		return db.update(DATABASE_TABLE, cv, Id + "=" + id, null) > 0;
	}
}
