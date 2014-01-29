package com.designs.prereach;

import android.os.Bundle;
import android.os.SystemClock;
import android.app.Activity;
import android.app.Instrumentation;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PreReach extends Activity implements OnClickListener {

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		tv.setText("Touch x:" + ev.getRawX()+ " y:" + ev.getRawY());
		
		return super.dispatchTouchEvent(ev);
	}

	WindowManager.LayoutParams lp;
	Instrumentation I; 
	int x,y;
	Button b;
	TextView tv;
	MotionEvent me1,me2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_reach);
        
        lp.
        I = new Instrumentation();
        b = (Button) findViewById(R.id.b1);
        b.setOnClickListener(this);
        tv = (TextView) findViewById(R.id.tV1);
        tv.setText("Booting");
        me1 = MotionEvent.obtain(1,1,MotionEvent.ACTION_DOWN,120,200,0);
        me2 = MotionEvent.obtain(1, 1, MotionEvent.ACTION_UP, 120, 200, 0);
        
        x=0;
        y=0;
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_pre_reach, menu);
        return true;
    }

	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		tv.setText("Click " + x + " " + y);
		dispatchTouchEvent(me1);
		dispatchTouchEvent(me2);
		/*I.sendPointerSync(MotionEvent.obtain(SystemClock.uptimeMillis(),SystemClock.uptimeMillis(),MotionEvent.ACTION_DOWN, x, y, 0));*/
        	if(x>100){
        		x=0;
        	}else{
        		x++;
        	}
        	if(y>100){
        		y=0;
        	}else{
        		y++;
        	}
	}
}
