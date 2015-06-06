package com.kcb;

import com.cn.daming.deskclock.R;
import com.myclass.Homework_page;
import com.portaura.zxing.encode.QRcode;

import android.R.id;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class NoteFragment extends Fragment {
	
	private Button  guideButton;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	View view = inflater.inflate(R.layout.mynote_feiye, container, false);
	guideButton=(Button) view.findViewById(R.id.coming);
	
	guideButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			
			Intent intent2=new Intent(getActivity(), Homework_page.class);
			startActivity(intent2);;
			
		}
	});
	return view;
}
	
}

