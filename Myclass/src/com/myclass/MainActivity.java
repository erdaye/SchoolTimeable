package com.myclass;




import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;

public  class MainActivity extends Activity{
	
	private Button buttonw;
	
   @Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);
	buttonw=(Button) findViewById(R.id.button1);
	buttonw.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent  intent1=new Intent(MainActivity.this,Homework_page.class);
			startActivity(intent1);
			
		}
	});
}
	}
	
	

