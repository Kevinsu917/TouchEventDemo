package com.example.toucheventdemo;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * @author KevinSu kevinsu917@126.com
 * @create 2015年1月20日 下午3:47:31
 * @Description:
 */
class MyGridViewAdapter extends BaseAdapter {
	
	Context context;
	ArrayList<String> imageList;
	
	public MyGridViewAdapter(Context mContext, ArrayList<String> imageList) {
	
		context = mContext;
		this.imageList = imageList;
	}
	
	@Override
	public int getCount() {
		return imageList.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = LayoutInflater.from(context).inflate(R.layout.gridview_item, null);
			viewHolder.image = (ImageView) convertView.findViewById(R.id.ivImage);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.image.setImageResource(R.drawable.default_pitcure_small);
		
		return convertView;
	}

	static class ViewHolder {
		ImageView image;
	}
}