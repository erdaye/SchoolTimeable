package com.me;

import com.cn.daming.deskclock.R;
import com.cn.daming.deskclock.R.color;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Spinner;

public class Mesettings extends Activity {
	private Spinner  mySpinner;;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.me_shezhi);
		mySpinner=(Spinner) findViewById(R.id.me_spinner);
		
	}
}
