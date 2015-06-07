package com.kcb;

import com.cn.daming.deskclock.R;
import com.portaura.zxing.encode.QRcode;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class QRFragment extends Fragment {
	
	private TextView textView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.qr_fragment, container, false);
		
		textView = (TextView)view.findViewById(R.id.textView1);
		textView.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),QRcode.class);
				startActivity(intent);
				
			}
		});
		return view;
	}
}
