package com.harry;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MyAndroidActivity extends Activity {
	private Timer timer = new Timer();
	private TextView textView;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			switch(msg.what){
				case 200:
					textView.setText(String.format("%tT", Calendar.getInstance()));
					break;
			}
		}
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textView = (TextView) findViewById(R.id.text);
        
        timer.schedule(new TimerTask(){
			@Override
			public void run() {
				Message msg = new Message();
				msg.what = 200;
				handler.sendMessage(msg);
			}
        }, 0,1000);
    }
}