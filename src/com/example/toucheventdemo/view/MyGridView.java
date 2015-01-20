package com.example.toucheventdemo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.GridView;

/**
 * @author KevinSu kevinsu917@126.com
 * @create 2015年1月20日 下午3:07:45
 * @Description: 
 */
/**
 * 自定义gridview，解决GridView中嵌套gridview显示不正常的问题（1行半）
 */
public class MyGridView extends GridView
{
	public MyGridView( Context context , AttributeSet attrs )
	{
		super( context , attrs );
	}
	
	public MyGridView( Context context )
	{
		super( context );
	}
	
	public MyGridView( Context context , AttributeSet attrs , int defStyle )
	{
		super( context , attrs , defStyle );
	}
	
	@Override
	public void onMeasure( int widthMeasureSpec , int heightMeasureSpec )
	{
		int expandSpec = MeasureSpec.makeMeasureSpec( Integer.MAX_VALUE >> 2 , MeasureSpec.AT_MOST );
		super.onMeasure( widthMeasureSpec , expandSpec );
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
		
		Log.i("kevin", "GridView-dispatchTouchEvent-" + str);
		boolean superResult = super.dispatchTouchEvent(ev);
		Log.i("kevin", "GridView-dispatchTouchEvent-" + str +"-Result=" + superResult);
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
			break;
		default:
			str = String.valueOf(ev.getAction());
			break;
		}
		
		Log.i("kevin", "GridView-onInterceptTouchEvent-"+ str);
		boolean superResult = super.onInterceptTouchEvent(ev);
		Log.i("kevin", "GridView-onInterceptTouchEvent-"+ str +"-Result=" + superResult);
		
		return superResult;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) 
	{
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
		
		
		Log.i("kevin", "GridView-onTouchEvent-" + str);
		boolean superResult = super.onTouchEvent(ev);
		Log.i("kevin", "GridView-onTouchEvent-" + str + "-Result=" + superResult);
		return superResult;
	}
}
