package com.portaura.zxing;

import com.kcb.DBAdapter;

import android.R.integer;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;


public class DaoRu {

	public static void DaoRuing(String s, CaptureActivity context) {
		String[] ss = new String[400];
		Cursor cursor = null;
		DBAdapter db = new DBAdapter(context);
		db.open();
		cursor = db.getAllTitles();

		ss = s.split("#");

		for (int i = 0; i < ss.length; i++) {

			Log.i(i + "11122%", ss[i] + "");

		}
		cursor.moveToFirst();
		cursor.moveToNext();
		for (int k = 9, j = 2; j <= 43 && k <= ss.length; j++, k++) {

			int m = cursor.getInt(cursor.getColumnIndex("myid"));
			Log.i("m", m + "m");
			Log.i(k + "ss[k]", ss[k] + "m");
			if (m == Integer.parseInt(ss[++k])) {
				Log.i("111", "6");
				db.updateTitle(m, m, ss[++k], ss[++k], ss[++k], ss[++k],
						ss[++k], ss[++k], ss[++k]);
				Log.i("111", "7");

			}
			cursor.moveToNext();

		}

	}

}



