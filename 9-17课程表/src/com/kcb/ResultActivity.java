package com.kcb;


import com.cn.daming.deskclock.R;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class ResultActivity extends Activity {
	
	TextView b22, b23, b24, b25, b26, b32, b33, b34, b35, b36, b42, b43, b44,
	b45, b46, b52, b53, b54, b55, b56, b62, b63, b64, b65, b66, b72,
	b73, b74, b75, b76, b82, b83, b84, b85, b86;

	private String result;
	public String  partb22[],partb23[],partb24[],partb25[],partb26[],
				   partb32[],partb33[],partb34[],partb35[],partb36[],
				   partb42[],partb43[],partb44[],partb45[],partb46[],
				   partb52[],partb53[],partb54[],partb55[],partb56[],
				   partb62[],partb63[],partb64[],partb65[],partb66[],
	 			   partb72[],partb73[],partb74[],partb75[],partb76[],
	               partb82[],partb83[],partb84[],partb85[],partb86[];
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.course_fragment);
		
		Intent intent=getIntent();
		result=intent.getStringExtra("data");
		
		b22 = (TextView) findViewById(R.id.a22);
		b23 = (TextView) findViewById(R.id.a23);
		b24 = (TextView) findViewById(R.id.a24);
		b25 = (TextView) findViewById(R.id.a25);
		b26 = (TextView) findViewById(R.id.a26);
		b32 = (TextView) findViewById(R.id.a32);
		b33 = (TextView) findViewById(R.id.a33);
		b34 = (TextView) findViewById(R.id.a34);
		b35 = (TextView) findViewById(R.id.a35);
		b36 = (TextView) findViewById(R.id.a36);
		b42 = (TextView) findViewById(R.id.a42);
		b43 = (TextView) findViewById(R.id.a43);
		b44 = (TextView) findViewById(R.id.a44);
		b45 = (TextView) findViewById(R.id.a45);
		b46 = (TextView) findViewById(R.id.a46);
		b52 = (TextView) findViewById(R.id.a52);
		b53 = (TextView) findViewById(R.id.a53);
		b54 = (TextView) findViewById(R.id.a54);
		b55 = (TextView) findViewById(R.id.a55);
		b56 = (TextView) findViewById(R.id.a56);
		b62 = (TextView) findViewById(R.id.a62);
		b63 = (TextView) findViewById(R.id.a63);
		b64 = (TextView) findViewById(R.id.a64);
		b65 = (TextView) findViewById(R.id.a65);
		b66 = (TextView) findViewById(R.id.a66);
		b72 = (TextView) findViewById(R.id.a72);
		b73 = (TextView) findViewById(R.id.a73);
		b74 = (TextView) findViewById(R.id.a74);
		b75 = (TextView) findViewById(R.id.a75);
		b76 = (TextView) findViewById(R.id.a76);
		b82 = (TextView) findViewById(R.id.a82);
		b83 = (TextView) findViewById(R.id.a83);
		b84 = (TextView) findViewById(R.id.a84);
		b85 = (TextView) findViewById(R.id.a85);
		b86 = (TextView) findViewById(R.id.a86);
		
		String encode[] = result.split("%");
		Log.i("源字符串为---", result);
		
		Log.i("分解后字符串为----", encode[0]);
		
		partb22=encode[1].split("#");
		Log.i("b22--", partb22[1]);
		b22.setText(partb22[1]+" "+partb22[2]+" "+partb22[6]);
		
		partb23=encode[2].split("#");
		Log.i("b23--", partb23[1]);
		b23.setText(partb23[1]+" "+partb23[2]+" "+partb23[6]);
		
		partb24=encode[3].split("#");
		b24.setText(partb24[1]+" "+partb24[2]+" "+partb24[6]);
		
		partb25=encode[4].split("#");
		Log.i("b25", partb25[1]);
		b25.setText(partb25[1]+" "+partb25[2]+" "+partb25[6]);
		
		partb26=encode[5].split("#");
		Log.i("b26--", partb26[1]);
		b26.setText(partb26[1]+" "+partb26[2]+" "+partb26[6]);
		
		partb32=encode[6].split("#");
		b32.setText(partb32[1]+" "+partb32[2]+" "+partb32[6]);
		
		partb33=encode[7].split("#");
		b33.setText(partb33[1]+" "+partb33[2]+" "+partb33[6]);
		
		partb34=encode[8].split("#");
		b34.setText(partb34[1]+" "+partb34[2]+" "+partb34[6]);
		
		partb35=encode[9].split("#");
		b35.setText(partb35[1]+" "+partb35[2]+" "+partb35[6]);
		
		partb36=encode[10].split("#");
		b36.setText(partb36[1]+" "+partb36[2]+" "+partb36[6]);
		
		partb42=encode[11].split("#");
		b42.setText(partb42[1]+" "+partb42[2]+" "+partb42[6]);
		
		partb43=encode[12].split("#");
		b43.setText(partb43[1]+" "+partb43[2]+" "+partb43[6]);
		
		partb44=encode[13].split("#");
		b44.setText(partb44[1]+" "+partb44[2]+" "+partb44[6]);
		
		partb45=encode[14].split("#");
		b45.setText(partb45[1]+" "+partb45[2]+" "+partb45[6]);
		
		partb46=encode[15].split("#");
		b46.setText(partb46[1]+" "+partb46[2]+" "+partb46[6]);
		
		partb52=encode[16].split("#");
		b52.setText(partb52[1]+" "+partb52[2]+" "+partb52[6]);
		
		partb53=encode[17].split("#");
		b53.setText(partb53[1]+" "+partb53[2]+" "+partb53[6]);
		
		partb54=encode[18].split("#");
		b54.setText(partb54[1]+" "+partb54[2]+" "+partb54[6]);
		
		partb55=encode[19].split("#");
		b55.setText(partb55[1]+" "+partb55[2]+" "+partb55[6]);
		
		partb56=encode[20].split("#");
		b56.setText(partb56[1]+" "+partb56[2]+" "+partb56[6]);
		
		partb62=encode[21].split("#");
		b62.setText(partb62[1]+" "+partb62[2]+" "+partb62[6]);
		
		partb63=encode[22].split("#");
		b63.setText(partb63[1]+" "+partb63[2]+" "+partb63[6]);
		
		partb64=encode[23].split("#");
		b64.setText(partb64[1]+" "+partb64[2]+" "+partb64[6]);
		
		partb65=encode[24].split("#");
		b65.setText(partb65[1]+" "+partb65[2]+" "+partb65[6]);
		
		partb66=encode[25].split("#");
		b66.setText(partb66[1]+" "+partb66[2]+" "+partb66[6]);
		
		partb72=encode[26].split("#");
		b72.setText(partb72[1]+" "+partb72[2]+" "+partb72[6]);
		
		partb73=encode[27].split("#");
		b73.setText(partb73[1]+" "+partb73[2]+" "+partb73[6]);
		
		partb74=encode[28].split("#");
		b74.setText(partb74[1]+" "+partb74[2]+" "+partb74[6]);
		
		partb75=encode[29].split("#");
		b65.setText(partb75[1]+" "+partb75[2]+" "+partb75[6]);
		
		partb76=encode[30].split("#");
		b66.setText(partb76[1]+" "+partb76[2]+" "+partb76[6]);
		
		partb82=encode[31].split("#");
		b62.setText(partb82[1]+" "+partb82[2]+" "+partb82[6]);
		
		partb83=encode[32].split("#");
		b63.setText(partb83[1]+" "+partb83[2]+" "+partb83[6]);
		
		partb84=encode[33].split("#");
		b64.setText(partb84[1]+" "+partb84[2]+" "+partb84[6]);
		
		partb85=encode[34].split("#");
		b65.setText(partb85[1]+" "+partb85[2]+" "+partb85[6]);
		
		partb86=encode[35].split("#");
		b66.setText(partb86[1]+" "+partb86[2]+" "+partb86[6]);
	}
	
  
	private static int FIRST = Menu.FIRST;
	private static int SECOND = Menu.FIRST+1;
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(1, FIRST,  1, "取消");
		menu.add(2, SECOND, 2, "导入");
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if(id == 1){
			finish();
		}
		
		//这边好像有点问题
		if(id ==2){
			daoRu();			
			Toast.makeText(ResultActivity.this, "正在导入，请稍等。。", Toast.LENGTH_LONG).show();
		}
		return super.onOptionsItemSelected(item);
	}
   
	
	void daoRu(){
		Cursor cursor = null;
		System.out.println("----");
		DBAdapter  db = new DBAdapter(ResultActivity.this);
		System.out.println("----");
		db.open();   
		cursor = db.getAllTitles();
		while(cursor.moveToNext()){
			int m= cursor.getInt(cursor.getColumnIndex("myid"));
			System.out.println(m);
			Log.i("m====", ""+m);
			if(  m == Integer.parseInt(partb22[0])){
				db.updateTitle(m, m, partb22[1],partb22[2],partb22[3],partb22[4],partb22[5],partb22[6],partb22[7]);
			}
			
			if(  m == Integer.parseInt(partb23[0])){
				db.updateTitle(m, m, partb23[1],partb23[2],partb23[3],partb23[4],partb23[5],partb23[6],partb23[7]);
			}
			
			if(  m == Integer.parseInt(partb24[0])){
				db.updateTitle(m, m, partb24[1],partb24[2],partb24[3],partb24[4],partb24[5],partb24[6],partb24[7]);
			}
			
			if(  m == Integer.parseInt(partb25[0])){
				db.updateTitle(m, m, partb25[1],partb25[2],partb25[3],partb25[4],partb25[5],partb25[6],partb25[7]);
			}
			
			if(  m == Integer.parseInt(partb26[0])){
				db.updateTitle(m, m, partb26[1],partb26[2],partb26[3],partb26[4],partb26[5],partb26[6],partb26[7]);
			}
			
			if(  m == Integer.parseInt(partb32[0])){
				db.updateTitle(m, m, partb32[1],partb32[2],partb32[3],partb32[4],partb32[5],partb32[6],partb32[7]);
			}
			
			if(  m == Integer.parseInt(partb33[0])){
				db.updateTitle(m, m, partb33[1],partb33[2],partb33[3],partb33[4],partb33[5],partb33[6],partb33[7]);
			}
			
			if(  m == Integer.parseInt(partb34[0])){
				db.updateTitle(m, m, partb34[1],partb34[2],partb34[3],partb34[4],partb34[5],partb34[6],partb34[7]);
			}
			
			if(  m == Integer.parseInt(partb35[0])){
				db.updateTitle(m, m, partb35[1],partb35[2],partb35[3],partb35[4],partb35[5],partb35[6],partb35[7]);
			}
			
			if(  m == Integer.parseInt(partb36[0])){
				db.updateTitle(m, m, partb36[1],partb36[2],partb36[3],partb36[4],partb36[5],partb36[6],partb36[7]);
			}
			
			if(  m == Integer.parseInt(partb42[0])){
				db.updateTitle(m, m, partb42[1],partb42[2],partb42[3],partb42[4],partb42[5],partb42[6],partb42[7]);
			}
			
			if(  m == Integer.parseInt(partb43[0])){
				db.updateTitle(m, m, partb43[1],partb43[2],partb43[3],partb43[4],partb43[5],partb43[6],partb43[7]);
			}
			
			if(  m == Integer.parseInt(partb44[0])){
				db.updateTitle(m, m, partb44[1],partb44[2],partb44[3],partb44[4],partb44[5],partb44[6],partb44[7]);
			}
			
			if(  m == Integer.parseInt(partb45[0])){
				db.updateTitle(m, m, partb45[1],partb45[2],partb45[3],partb45[4],partb45[5],partb45[6],partb45[7]);
			}
			
			if(  m == Integer.parseInt(partb46[0])){
				db.updateTitle(m, m, partb46[1],partb46[2],partb46[3],partb46[4],partb46[5],partb46[6],partb46[7]);
			}
			
			if(  m == Integer.parseInt(partb52[0])){
				db.updateTitle(m, m, partb52[1],partb52[2],partb52[3],partb52[4],partb52[5],partb52[6],partb52[7]);
			}
			
			if(  m == Integer.parseInt(partb53[0])){
				db.updateTitle(m, m, partb53[1],partb53[2],partb53[3],partb53[4],partb53[5],partb53[6],partb53[7]);
			}
			
			if(  m == Integer.parseInt(partb54[0])){
				db.updateTitle(m, m, partb54[1],partb54[2],partb54[3],partb54[4],partb54[5],partb54[6],partb54[7]);
			}
			
			if(  m == Integer.parseInt(partb55[0])){
				db.updateTitle(m, m, partb55[1],partb55[2],partb55[3],partb55[4],partb55[5],partb55[6],partb55[7]);
			}
			
			if(  m == Integer.parseInt(partb56[0])){
				db.updateTitle(m, m, partb56[1],partb56[2],partb56[3],partb56[4],partb56[5],partb56[6],partb56[7]);
			}
			
			if(  m == Integer.parseInt(partb62[0])){
				db.updateTitle(m, m, partb62[1],partb62[2],partb62[3],partb62[4],partb62[5],partb62[6],partb62[7]);
			}
			
			if(  m == Integer.parseInt(partb63[0])){
				db.updateTitle(m, m, partb63[1],partb63[2],partb63[3],partb63[4],partb63[5],partb63[6],partb63[7]);
			}
			
			if(  m == Integer.parseInt(partb64[0])){
				db.updateTitle(m, m, partb64[1],partb64[2],partb64[3],partb64[4],partb64[5],partb64[6],partb64[7]);
			}
			
			if(  m == Integer.parseInt(partb65[0])){
				db.updateTitle(m, m, partb65[1],partb65[2],partb65[3],partb65[4],partb65[5],partb65[6],partb65[7]);
			}
			
			if(  m == Integer.parseInt(partb66[0])){
				db.updateTitle(m, m, partb66[1],partb66[2],partb66[3],partb66[4],partb66[5],partb66[6],partb66[7]);
			}
			
			
			duqu.duquing(ResultActivity.this, b22, 2);
			duqu.duquing(ResultActivity.this, b23, 3);
			duqu.duquing(ResultActivity.this, b24, 4);
			duqu.duquing(ResultActivity.this, b25, 5);
			duqu.duquing(ResultActivity.this, b26, 6);
			duqu.duquing(ResultActivity.this, b32, 7);
			duqu.duquing(ResultActivity.this, b33, 8);
			duqu.duquing(ResultActivity.this, b34, 9);
			duqu.duquing(ResultActivity.this, b35, 10);
			duqu.duquing(ResultActivity.this, b36, 11);
			duqu.duquing(ResultActivity.this, b42, 12);
			duqu.duquing(ResultActivity.this, b43, 13);
			duqu.duquing(ResultActivity.this, b44, 14);
			duqu.duquing(ResultActivity.this, b45, 15);
			duqu.duquing(ResultActivity.this, b46, 16);
			duqu.duquing(ResultActivity.this, b52, 17);
			duqu.duquing(ResultActivity.this, b53, 18);
			duqu.duquing(ResultActivity.this, b54, 19);
			duqu.duquing(ResultActivity.this, b55, 20);
			duqu.duquing(ResultActivity.this, b56, 21);
			duqu.duquing(ResultActivity.this, b62, 22);
			duqu.duquing(ResultActivity.this, b63, 23);
			duqu.duquing(ResultActivity.this, b64, 24);
			duqu.duquing(ResultActivity.this, b65, 25);
			duqu.duquing(ResultActivity.this, b66, 26);
		}
	}
	
	
}
	
