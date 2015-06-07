package com.aiwenquan;

import com.cn.daming.deskclock.R;
import android.view.View.OnClickListener; 
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


class ViewHolder {    
    public ImageView touxiang;  
    public TextView yonghuming;  
    public TextView content_describe;  
   public ImageView image;    
}   

public class AiwenListAdapter extends BaseAdapter {
	
	
	private LayoutInflater mInflater = null;  
    public  AiwenListAdapter(Context context) {
		// TODO Auto-generated constructor stub{  
          super();  
	       mInflater = (LayoutInflater) context  
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
	    }  


	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	 @Override  
	     public View getView(int position, View convertView, ViewGroup parent) {  
	  
	         ViewHolder holder = null;    
	         if (convertView == null) {    
	             holder = new ViewHolder();    
	            convertView = mInflater.inflate(R.layout.aiwen_list_item, null);  
	            holder.touxiang = (ImageView) convertView.findViewById(R.id.mytouxiang);    
	            holder.yonghuming = (TextView) convertView.findViewById(R.id.namestring);    
	             holder.content_describe = (TextView) convertView.findViewById(R.id.content_describe);    
	            holder.image = (ImageView) convertView.findViewById(R.id.image);    
	  
	            convertView.setTag(holder);    
	        } else {    
	            holder = (ViewHolder) convertView.getTag();    
	         }  
	   
	        holder.touxiang.setImageResource(R.drawable.b_g2);  
	         holder.yonghuming.setText("薇安");  
	         holder.content_describe.setText("这题真不会，物理书上第55页");  
	         holder.image.setImageResource(R.drawable.add);  
	   
	         holder.image.setOnClickListener(new OnClickListener(){  
	  
	             @Override  
	             public void onClick(View v) {  
	                 System.out.println("Click on the image image on ListItem ");  
	             }  
	         });  
	   
	         return convertView;  
	     }    
	  
	 }  


