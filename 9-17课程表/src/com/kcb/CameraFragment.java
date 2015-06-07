package com.kcb;

import com.cn.daming.deskclock.R;
import com.portaura.zxing.CaptureActivity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CameraFragment extends Fragment {
	private Button button;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.camera_fragment, container, false);
		
		button = (Button)view.findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(),CaptureActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		return view;
	}
	

}
