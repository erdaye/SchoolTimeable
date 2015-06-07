package com.kcb;

import android.content.Context;
import android.database.Cursor;
import android.widget.TextView;

public class duqu {

	public static void duquing(Context context, TextView textView, int j) {
		Cursor cursor = null;
		DBAdapter db = new DBAdapter(context);
		db.open();
		cursor = db.getAllTitles();

		cursor.moveToFirst();
		while (cursor.moveToNext()) {
			int m = cursor.getInt(cursor.getColumnIndex("myid"));

			if (m == j) {
				textView.setText(cursor.getString(cursor
						.getColumnIndex("classname")) + "\n");
				textView.append(cursor.getString(cursor
						.getColumnIndex("address")) + "\n");
				textView.append(cursor.getString(cursor
						.getColumnIndex("zhoushu")) + "\n");

			}
		}
	}
}

