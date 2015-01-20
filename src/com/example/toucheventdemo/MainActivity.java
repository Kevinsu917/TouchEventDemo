package com.example.toucheventdemo;

import java.util.ArrayList;

import com.example.toucheventdemo.view.MyGridView;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements OnTouchListener{

	private MyGridView myGridView;
	private ArrayList<String> imageList = new ArrayList<String>();
	private MyGridViewAdapter mAdapter;
	
	private PopupWindow pop;
	private View contentView;
	private TextView popShowView;
	private int lastPosition = 0;
	
	private float startX = 0;
	private float startY = 0;
	public static Boolean isLongClickModule = false;
	private View childView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}
	
	private void initView()
	{
		
		for(int i= 0; i < 10; i++)
		{
			imageList.add("");
		}
		
		myGridView = (MyGridView) findViewById(R.id.mgvGridView);
		mAdapter = new MyGridViewAdapter(this, imageList);
		myGridView.setAdapter(mAdapter);
		myGridView.setOnTouchListener(this);
		
		contentView = View.inflate(this, R.layout.pop_window_item , null );
		popShowView = (TextView) contentView.findViewById(R.id.tvShow);
		pop = new PopupWindow(contentView, 200, 200);
	}
	
	
	public void showPopupWindow( final View view , int position )
	{
		if ( pop != null && pop.isShowing( ) || position == -1 )
		{
			return;
		}
		lastPosition = position;
		
		pop.setOutsideTouchable( true );
		pop.setFocusable( false );
		pop.update( );
		
		popShowView.setText(String.valueOf(position));
		
		int[ ] location = new int[ 2 ];
		view.getLocationOnScreen( location );
		
		
		// 这里显示的popWindow的位置处于屏幕中间
		Display My_Display = getWindow( ).getWindowManager( ).getDefaultDisplay( );
		pop.showAtLocation(contentView, Gravity.NO_GRAVITY, My_Display.getWidth()/2, My_Display.getHeight()/2);
	
	}
	
	private void hidePopupWindow()
	{
		if(pop != null && pop.isShowing( )){
			pop.dismiss();
		}
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public boolean onTouch( View v , MotionEvent event )
	{
		switch ( event.getAction( ) )
		{
			case MotionEvent.ACTION_DOWN :
				startX = event.getX( );
				startY = event.getY( );
				Log.i("kevin", "GridView-onTouch-ACTION_DOWN");
				break;
			case MotionEvent.ACTION_MOVE :
				Log.i("kevin", "GridView-onTouch-ACTION_MOVE");
				long longPressTime = 500;
				long lastDownTime = event.getDownTime( );
				long thisEventTime = event.getEventTime( );
				long intervalTime = thisEventTime - lastDownTime;
				if ( intervalTime >= longPressTime )
				{
					isLongClickModule = true;
					int x = ( int ) event.getX( );
					int y = ( int ) event.getY( );
					int motionPosition = myGridView.pointToPosition( x , y );
					childView = myGridView.getChildAt( motionPosition );
					showPopupWindow( childView , motionPosition );
					if ( lastPosition != motionPosition  )
					{
						if ( pop != null && pop.isShowing( ) )
						{
							pop.dismiss( );
						}
						if ( motionPosition != -1 )
						{
							showPopupWindow( childView , motionPosition );
						}
					}
				}
				break;
			case MotionEvent.ACTION_UP :
				Log.i("kevin", "GridView-onTouch-ACTION_UP");
				isLongClickModule = false;
				hidePopupWindow();
				break;
			case MotionEvent.ACTION_CANCEL:
				isLongClickModule = false;
				hidePopupWindow();
				Log.i("kevin", "GridView-onTouch-ACTION_CANCEL");
				break;
		}
		
		return true;
	}
}
