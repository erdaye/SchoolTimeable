package com.me;
import android.view.View.OnClickListener;

import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cn.daming.deskclock.R;

import android.R.anim;
import android.app.Fragment;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Me_shouye extends ListFragment {
	
	private ListView tvme;
	private String[] adapterdata;
	
	 
	    private ArrayAdapter<String> adapter;  
	    private Button touxiangbuButton;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.me, container,false);
		
		tvme=(ListView) view.findViewById(android.R.id.list);
		touxiangbuButton=(Button) view.findViewById(R.id.touxiang);
		 touxiangbuButton.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent(getActivity(),Mesettings.class);
			startActivity(intent);
		}
	});
	
	
		return view;
	}
	
	 public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	    
	       
	        String[] list = {"我提过的问题","我回答过的问题"};  
	        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list );  
	        setListAdapter(adapter);  
	      
	 
	 
	 }
	
	}


