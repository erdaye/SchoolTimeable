package com.myclass;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HomeworkContent extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_content);
        final Button okbut=(Button) findViewById(R.id.okbut);
		final EditText  ETkemu1=(EditText) findViewById(R.id.kemutext);
		final EditText   ETkaishiriqi=(EditText) findViewById(R.id.qishidate);
		
		final EditText ETkaishishijian =(EditText) findViewById(R.id.qishitime);
		final EditText ETjiezhiriqi=(EditText) findViewById(R.id.jiezhidate);
		final EditText ETjiezhishijian=(EditText) findViewById(R.id.jiezhitime);
		final EditText ETcontent=(EditText) findViewById(R.id.neirongtext);
		Intent getintent=getIntent();
		ETkemu1.setText(getintent.getStringExtra("ETkemu"));
		ETkaishiriqi.setText(getintent.getStringExtra("eTStartDate"));
		ETkaishishijian.setText(getintent.getStringExtra("Etstarttime"));
		ETjiezhiriqi.setText(getintent.getStringExtra("ETenddate"));
		ETjiezhishijian.setText(getintent.getStringExtra("ETendtime"));
		ETcontent.setText(getintent.getStringExtra("eTcontent"));
		okbut.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent3=new Intent(HomeworkContent.this,Homework_page.class);
				intent3.putExtra("ETkemu1", ETkemu1.getText());
				intent3.putExtra("ETkaishishijian", ETkaishiriqi.getText());
				
				startActivity(intent3);
				
			}
		} );
	}
    
}
