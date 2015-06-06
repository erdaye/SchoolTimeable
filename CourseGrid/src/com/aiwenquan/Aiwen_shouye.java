package com.aiwenquan;
import com.cn.daming.deskclock.R;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Aiwen_shouye extends ListFragment {

	private ListView lv;
	private String[] adapterdata;
	private AiwenListAdapter adapter; 
	
@Override
public void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	
}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
	
		adapter=new AiwenListAdapter(getActivity());
		setListAdapter(adapter);
		View view=inflater.inflate(R.layout.aiwen_shouye, container,false);
		
		return view;
		
	

		
	}
	
	
}
