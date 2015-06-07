package com.kcb;

import com.cn.daming.deskclock.R;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CourseFragment extends Fragment {
	DBAdapter db;
	TextView b22, b23, b24, b25, b26, b27,b32, b33, b34, b35, b36,b37, b42, b43, b44,
			b45, b46, b47,b52, b53, b54, b55, b56,b57, b62, b63, b64, b65, b66, b67,b72,
			b73, b74, b75, b76,b77, b82, b83, b84, b85, b86,b87;
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		return super.onContextItemSelected(item);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.course_fragment, container, false);
		init(view);
		return view;
	}
	
	public void init(View view) {
		b22 = (TextView) view.findViewById(R.id.a22);
		b23 = (TextView) view.findViewById(R.id.a23);
		b24 = (TextView) view.findViewById(R.id.a24);
		b25 = (TextView) view.findViewById(R.id.a25);
		b26 = (TextView) view.findViewById(R.id.a26);
		b27 = (TextView) view.findViewById(R.id.a27);
		
		b32 = (TextView) view.findViewById(R.id.a32);
		b33 = (TextView) view.findViewById(R.id.a33);
		b34 = (TextView) view.findViewById(R.id.a34);
		b35 = (TextView) view.findViewById(R.id.a35);
		b36 = (TextView) view.findViewById(R.id.a36);
		b37 = (TextView) view.findViewById(R.id.a37);
		
		b42 = (TextView) view.findViewById(R.id.a42);
		b43 = (TextView) view.findViewById(R.id.a43);
		b44 = (TextView) view.findViewById(R.id.a44);
		b45 = (TextView) view.findViewById(R.id.a45);
		b46 = (TextView) view.findViewById(R.id.a46);
		b47 = (TextView) view.findViewById(R.id.a47);
		
		b52 = (TextView) view.findViewById(R.id.a52);
		b53 = (TextView) view.findViewById(R.id.a53);
		b54 = (TextView) view.findViewById(R.id.a54);
		b55 = (TextView) view.findViewById(R.id.a55);
		b56 = (TextView) view.findViewById(R.id.a56);
		b57 = (TextView) view.findViewById(R.id.a57);
		
		b62 = (TextView) view.findViewById(R.id.a62);
		b63 = (TextView) view.findViewById(R.id.a63);
		b64 = (TextView) view.findViewById(R.id.a64);
		b65 = (TextView) view.findViewById(R.id.a65);
		b66 = (TextView) view.findViewById(R.id.a66);
		b67 = (TextView) view.findViewById(R.id.a67);
		
		b72 = (TextView) view.findViewById(R.id.a72);
		b73 = (TextView) view.findViewById(R.id.a73);
		b74 = (TextView) view.findViewById(R.id.a74);
		b75 = (TextView) view.findViewById(R.id.a75);
		b76 = (TextView) view.findViewById(R.id.a76);
		b77 = (TextView) view.findViewById(R.id.a77);
		
		b82 = (TextView) view.findViewById(R.id.a82);
		b83 = (TextView) view.findViewById(R.id.a83);
		b84 = (TextView) view.findViewById(R.id.a84);
		b85 = (TextView) view.findViewById(R.id.a85);
		b86 = (TextView) view.findViewById(R.id.a86);
		b87 = (TextView) view.findViewById(R.id.a87);

		b22.setLongClickable(true);
		b23.setLongClickable(true);
		b24.setLongClickable(true);
		b25.setLongClickable(true);
		b26.setLongClickable(true);
		b27.setLongClickable(true);
		
		b32.setLongClickable(true);
		b33.setLongClickable(true);
		b34.setLongClickable(true);
		b35.setLongClickable(true);
		b36.setLongClickable(true);
		b37.setLongClickable(true);
		
		b42.setLongClickable(true);
		b43.setLongClickable(true);
		b44.setLongClickable(true);
		b45.setLongClickable(true);
		b46.setLongClickable(true);
		b47.setLongClickable(true);
		
		b52.setLongClickable(true);
		b53.setLongClickable(true);
		b54.setLongClickable(true);
		b55.setLongClickable(true);
		b56.setLongClickable(true);
		b57.setLongClickable(true);
		
		b62.setLongClickable(true);
		b63.setLongClickable(true);
		b64.setLongClickable(true);
		b65.setLongClickable(true);
		b66.setLongClickable(true);
		b67.setLongClickable(true);
		
		b72.setLongClickable(true);
		b73.setLongClickable(true);
		b74.setLongClickable(true);
		b75.setLongClickable(true);
		b76.setLongClickable(true);
		b77.setLongClickable(true);
		
		b82.setLongClickable(true);
		b83.setLongClickable(true);
		b84.setLongClickable(true);
		b85.setLongClickable(true);
		b86.setLongClickable(true);
		b87.setLongClickable(true);
	}
	
	@Override
	public void onResume() {
		db = new DBAdapter(getActivity());
		db.open();
		Cursor cursor = null;
		cursor = db.getAllTitles();
		if (cursor.getCount() < 2) {
			for (int i = 1; i <= 45; i++) {
				db.inserttable(i, " ", " ", " ", " ", " ", " ", " ");

			}
		}
		duqu.duquing(getActivity(), b22, 2);
		duqu.duquing(getActivity(), b23, 3);
		duqu.duquing(getActivity(), b24, 4);
		duqu.duquing(getActivity(), b25, 5);
		duqu.duquing(getActivity(), b26, 6);
		duqu.duquing(getActivity(), b27, 7);
		
		duqu.duquing(getActivity(), b32, 8);
		duqu.duquing(getActivity(), b33, 9);
		duqu.duquing(getActivity(), b34, 10);
		duqu.duquing(getActivity(), b35, 11);
		duqu.duquing(getActivity(), b36, 12);
		duqu.duquing(getActivity(), b37, 13);
		
		duqu.duquing(getActivity(), b42, 14);
		duqu.duquing(getActivity(), b43, 15);
		duqu.duquing(getActivity(), b44, 16);
		duqu.duquing(getActivity(), b45, 17);
		duqu.duquing(getActivity(), b46, 18);
		duqu.duquing(getActivity(), b47, 19);
		
		duqu.duquing(getActivity(), b52, 20);
		duqu.duquing(getActivity(), b53, 21);
		duqu.duquing(getActivity(), b54, 22);
		duqu.duquing(getActivity(), b55, 23);
		duqu.duquing(getActivity(), b56, 24);
		duqu.duquing(getActivity(), b57, 25);
		
		duqu.duquing(getActivity(), b62, 26);
		duqu.duquing(getActivity(), b63, 27);
		duqu.duquing(getActivity(), b64, 28);
		duqu.duquing(getActivity(), b65, 29);
		duqu.duquing(getActivity(), b66, 30);
		duqu.duquing(getActivity(), b67, 31);
		
		duqu.duquing(getActivity(), b72, 32);
		duqu.duquing(getActivity(), b73, 33);
		duqu.duquing(getActivity(), b74, 34);
		duqu.duquing(getActivity(), b75, 35);
		duqu.duquing(getActivity(), b76, 36);
		duqu.duquing(getActivity(), b77, 37);
		
		duqu.duquing(getActivity(), b82, 38);
		duqu.duquing(getActivity(), b83, 39);
		duqu.duquing(getActivity(), b84, 40);
		duqu.duquing(getActivity(), b85, 41);
		duqu.duquing(getActivity(), b86, 42);
		duqu.duquing(getActivity(), b87, 43);
		cursor.close();

		db.close();
		b22.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				Intent intent22 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 2);
				intent22.putExtras(bundle);
				startActivityForResult(intent22, 2);
				return true;
			}
		});
		b23.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent23 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 3);
				intent23.putExtras(bundle);
				startActivityForResult(intent23, 3);
				return true;
			}
		});
		b24.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent24 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 4);
				intent24.putExtras(bundle);
				startActivityForResult(intent24, 4);
				return true;

			}
		});
		b25.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent25 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 5);
				intent25.putExtras(bundle);
				startActivityForResult(intent25, 5);
				return true;

			}
		});
		b26.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent26 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 6);
				intent26.putExtras(bundle);
				startActivityForResult(intent26, 6);
				return true;

			}
		});
		
		b27.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent27 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 7);
				intent27.putExtras(bundle);
				startActivityForResult(intent27, 7);
				return true;

			}
		});
		
		b32.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent32 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 8);
				intent32.putExtras(bundle);
				startActivityForResult(intent32, 8);
				return true;

			}
		});
		b33.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent33 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 9);
				intent33.putExtras(bundle);
				startActivityForResult(intent33, 9);
				return true;

			}
		});
		b34.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent34 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 10);
				intent34.putExtras(bundle);
				startActivityForResult(intent34, 10);
				return true;

			}
		});
		b35.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent35 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 11);
				intent35.putExtras(bundle);
				startActivityForResult(intent35, 11);
				return true;

			}
		});
		b36.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent36 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 12);
				intent36.putExtras(bundle);
				startActivityForResult(intent36, 12);
				return true;

			}
		});
		
		b37.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent37 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 13);
				intent37.putExtras(bundle);
				startActivityForResult(intent37, 13);
				return true;

			}
		});
		b42.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent42 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 14);
				intent42.putExtras(bundle);
				startActivityForResult(intent42, 14);
				return true;

			}
		});
		b43.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent43 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 15);
				intent43.putExtras(bundle);
				startActivityForResult(intent43, 15);
				return true;
			}
		});
		b44.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent44 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 16);
				intent44.putExtras(bundle);
				startActivityForResult(intent44, 16);
				return true;

			}
		});
		b45.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent45 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 17);
				intent45.putExtras(bundle);
				startActivityForResult(intent45, 17);
				return true;

			}
		});
		b46.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent46 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 18);
				intent46.putExtras(bundle);
				startActivityForResult(intent46, 18);
				return true;

			}
		});
		
		b47.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent47 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 19);
				intent47.putExtras(bundle);
				startActivityForResult(intent47, 19);
				return true;

			}
		});
		b52.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent52 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 20);
				intent52.putExtras(bundle);
				startActivityForResult(intent52, 20);
				return true;

			}
		});
		b53.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent53 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 21);
				intent53.putExtras(bundle);
				startActivityForResult(intent53, 21);
				return true;

			}
		});
		b54.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent54 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 22);
				intent54.putExtras(bundle);
				startActivityForResult(intent54, 22);
				return true;

			}
		});
		b55.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent55 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 23);
				intent55.putExtras(bundle);
				startActivityForResult(intent55, 23);
				return true;

			}
		});
		b56.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent56 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 24);
				intent56.putExtras(bundle);
				startActivityForResult(intent56, 24);
				return true;

			}
		});
		
		b57.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent57 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 25);
				intent57.putExtras(bundle);
				startActivityForResult(intent57, 25);
				return true;

			}
		});
		b62.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent62 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 26);
				intent62.putExtras(bundle);
				startActivityForResult(intent62, 26);
				return true;

			}
		});
		b63.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent63 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 27);
				intent63.putExtras(bundle);
				startActivityForResult(intent63, 27);
				return true;

			}
		});
		b64.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent64 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 28);
				intent64.putExtras(bundle);
				startActivityForResult(intent64, 28);
				return true;

			}
		});
		b65.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent65 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 29);
				intent65.putExtras(bundle);
				startActivityForResult(intent65, 29);
				return true;

			}
		});
		b66.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent66 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 30);
				intent66.putExtras(bundle);
				startActivityForResult(intent66, 30);
				return true;

			}
		});
		
		b67.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent67 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 31);
				intent67.putExtras(bundle);
				startActivityForResult(intent67, 31);
				return true;

			}
		});
		b72.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent72 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 32);
				intent72.putExtras(bundle);
				startActivityForResult(intent72, 32);
				return true;

			}
		});
		b73.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent73 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 33);
				intent73.putExtras(bundle);
				startActivityForResult(intent73, 33);
				return true;

			}
		});
		b74.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent74 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 34);
				intent74.putExtras(bundle);
				startActivityForResult(intent74, 34);
				return true;

			}
		});
		b75.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent75 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 35);
				intent75.putExtras(bundle);
				startActivityForResult(intent75, 35);
				return true;

			}
		});
		b76.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent76 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 36);
				intent76.putExtras(bundle);
				startActivityForResult(intent76, 36);
				return true;

			}
		});
		
		b77.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent77 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 37);
				intent77.putExtras(bundle);
				startActivityForResult(intent77, 37);
				return true;

			}
		});
		b82.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent82 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 38);
				intent82.putExtras(bundle);
				startActivityForResult(intent82, 38);
				return true;

			}
		});
		b83.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent83 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 39);
				intent83.putExtras(bundle);
				startActivityForResult(intent83, 39);
				return true;

			}
		});
		b84.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent84 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 40);
				intent84.putExtras(bundle);
				startActivityForResult(intent84, 40);
				return true;

			}
		});
		b85.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent85 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 41);
				intent85.putExtras(bundle);
				startActivityForResult(intent85, 41);
				return true;

			}
		});
		b86.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent86 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 42);
				intent86.putExtras(bundle);
				startActivityForResult(intent86, 42);
				return true;

			}
		});
		
		b87.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stu
				Intent intent87 = new Intent(getActivity(), shezhi.class);
				Bundle bundle = new Bundle();
				bundle.putInt("key", 43);
				intent87.putExtras(bundle);
				startActivityForResult(intent87, 43);
				return true;

			}
		});
		
		super.onResume();
	}
	
	
	

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		db.open();
		switch (requestCode) {
		case 2:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b22);
			break;
		case 3:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b23);
			break;
		case 4:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b24);
			break;
		case 5:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b25);
			break;
		case 6:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b26);
			break;
		case 7:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b27);
			break;
		case 8:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b32);
			break;
		case 9:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b33);
			break;
		case 10:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b34);
			break;
		case 11:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b35);
			break;
		case 12:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b36);
			break;
			
		case 13:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b37);
			break;
		case 14:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b42);
			break;
		case 15:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b43);
			break;
		case 16:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b44);
			break;
		case 17:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b45);
			break;
		case 18:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b46);
			break;
			
		case 19:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b47);
			break;
		case 20:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b52);
			break;
		case 21:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b53);
			break;
		case 22:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b54);
			break;
		case 23:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b55);
			break;
		case 24:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b56);
			break;
			
		case 25:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b57);
			break;
		case 26:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b62);
			break;
		case 27:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b63);
			break;
		case 28:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b64);
			break;
		case 29:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b65);
			break;
		case 30:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b66);
			break;
			
		case 31:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b67);
			break;
		case 32:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b72);
			break;
		case 33:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b73);
			break;
		case 34:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b74);
			break;
		case 35:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b75);
			break;
		case 36:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b76);
			break;
		case 37:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b77);
			break;
			
		case 38:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b82);
			break;
		case 39:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b83);
			break;
		case 40:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b84);
			break;
		case 41:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b85);
			break;
		case 42:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b86);
			break;
		
		case 43:
			db.updateTitle(requestCode, requestCode, intent.getExtras()
					.getString("classname"),
					intent.getExtras().getString("address"), intent.getExtras()
							.getString("tel"),
					intent.getExtras().getString("teachername"), intent
							.getExtras().getString("suxing"), intent
							.getExtras().getString("zhoushu"), intent
							.getExtras().getString("beizhu"));
			love(requestCode, b87);
			break;
		default:
			break;
		}
	}

	public void love(int i, TextView textView) {
		Cursor myCursor = null;
		myCursor = db.getAllTitles();
		myCursor.moveToFirst();

		while (myCursor.moveToNext()) {

			if (myCursor.getInt(myCursor.getColumnIndex("myid")) == i) {
				textView.setText(myCursor.getString(myCursor
						.getColumnIndex("classname")) + "\n");
				textView.append(myCursor.getString(myCursor
						.getColumnIndex("address")) + "\n");
				textView.append(myCursor.getString(myCursor
						.getColumnIndex("zhoushu")) + "\n");

			}

		}
	}

	

}

