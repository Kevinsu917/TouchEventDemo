package com.example.toucheventdemo.view;

import com.example.toucheventdemo.MainActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * @author KevinSu kevinsu917@126.com
 * @create 2015年1月20日 下午3:08:30
 * @Description:
 */

public class FaceDetailMyScrollView extends ScrollView {

	public FaceDetailMyScrollView(Context context) {
		super(context);
	}

	public FaceDetailMyScrollView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	public FaceDetailMyScrollView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	public boolean arrowScroll(int direction) {
		return super.arrowScroll(direction);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {

		String str = "";

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			str = "ACTION_DOWN";
			break;
		case MotionEvent.ACTION_UP:
			str = "ACTION_UP";
			break;
		case MotionEvent.ACTION_MOVE:
			str = "ACTION_MOVE";
			break; 
		default:
			str = String.valueOf(ev.getAction());
			break;
		}
		
		Log.i("kevin", "ScrollView-dispatchTouchEvent-" + str);
		boolean superResult = super.dispatchTouchEvent(ev);
		Log.i("kevin", "ScrollView-dispatchTouchEvent-" + str + "-Result=" + superResult);
		return superResult;
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {

		String str = "";

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			str = "ACTION_DOWN";
			break;
		case MotionEvent.ACTION_UP:
			str = "ACTION_UP";
			break;
		case MotionEvent.ACTION_MOVE:
			str = "ACTION_MOVE";
			//如果处于点击状态下,同时在滑动,那么不拦截滑动事件
			if(MainActivity.isLongClickModule)
			{
				return false;
			}
			break;
		default:
			str = String.valueOf(ev.getAction());
			break;
		}
		
		Log.i("kevin", "ScrollView-onInterceptTouchEvent-" + str);
		boolean superResult = super.onInterceptTouchEvent(ev);
		Log.i("kevin", "ScrollView-onInterceptTouchEvent-" + str + "-Result=" + superResult);

		return superResult;
	}

	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		String str = "";

		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN:
			str = "ACTION_DOWN";
			break;
		case MotionEvent.ACTION_UP:
			str = "ACTION_UP";
			break;
		case MotionEvent.ACTION_MOVE:
			str = "ACTION_MOVE";
			break;
		default:
			str = String.valueOf(ev.getAction());
			break;
		}

		Log.i("kevin", "ScrollView-onTouchEvent-" + str);
		boolean superResult = super.onTouchEvent(ev);
		Log.i("kevin", "ScrollView-onTouchEvent-" + str + "-Result=" + superResult);
		return superResult;
	}

}
