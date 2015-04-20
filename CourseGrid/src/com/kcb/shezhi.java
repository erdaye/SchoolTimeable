package com.kcb;

import com.cn.daming.deskclock.R;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class shezhi extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.xin);
		this.getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
		final EditText kcmEditText = (EditText) findViewById(R.id.kcm_edit);
		final EditText didianEditText = (EditText) findViewById(R.id.address_edit);
		final EditText laoshiEditText = (EditText) findViewById(R.id.teachername_edit);
		final EditText haomaEditText = (EditText) findViewById(R.id.haoma_edit);
		final EditText suxingEditText = (EditText) findViewById(R.id.suxing_edit);
		final EditText zhou_shuEditText = (EditText) findViewById(R.id.zhoushu_edit);
		final EditText beizhuEditText = (EditText) findViewById(R.id.beizhu_edit);
		TextView trueButton = (TextView) findViewById(R.id.sure);
		TextView falseButton = (TextView) findViewById(R.id.qu_xiao);

		Bundle b = getIntent().getExtras();
		int e = b.getInt("key");
		Cursor cursor = null;
		DBAdapter db = new DBAdapter(shezhi.this);
		db.open();
		cursor = db.getAllTitles();

		cursor.moveToFirst();

		while (cursor.moveToNext()) {
			int m = cursor.getInt(cursor.getColumnIndex("myid"));
			if (m == e) {
				kcmEditText.setText(cursor.getString(cursor
						.getColumnIndex("classname")));
				didianEditText.setText(cursor.getString(cursor
						.getColumnIndex("address")));
				haomaEditText.setText(cursor.getString(cursor
						.getColumnIndex("tel")));
				laoshiEditText.setText(cursor.getString(cursor
						.getColumnIndex("teachername")));
				suxingEditText.setText(cursor.getString(cursor
						.getColumnIndex("suxing")));
				zhou_shuEditText.setText(cursor.getString(cursor
						.getColumnIndex("zhoushu")));
				beizhuEditText.setText(cursor.getString(cursor
						.getColumnIndex("beizhu")));

			}

		}
		trueButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (kcmEditText.length() != 0) {

					Intent dataIntent = new Intent();
					dataIntent.putExtra("classname", kcmEditText.getText()
							.toString());
					dataIntent.putExtra("address", didianEditText.getText()
							.toString());
					dataIntent.putExtra("teachername", laoshiEditText.getText()
							.toString());
					dataIntent.putExtra("tel", haomaEditText.getText()
							.toString());
					dataIntent.putExtra("suxing", suxingEditText.getText()
							.toString());
					dataIntent.putExtra("zhoushu", zhou_shuEditText.getText()
							.toString());
					dataIntent.putExtra("beizhu", beizhuEditText.getText()
							.toString());
					setResult(RESULT_OK, dataIntent);
					finish();

					Toast.makeText(shezhi.this, R.string.insert_suc,
							Toast.LENGTH_SHORT).show();

				} else {
					Toast.makeText(shezhi.this, R.string.insert_none,
							Toast.LENGTH_SHORT).show();
				}

			}
		});
		falseButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				setResult(RESULT_CANCELED);

				Intent intent = new Intent(shezhi.this, MainActivity.class);
				startActivity(intent);
				shezhi.this.finish();
			}
		});
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Intent intent = new Intent();
			intent.setClass(shezhi.this, MainActivity.class);
			startActivity(intent);
			shezhi.this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);

	}

}
