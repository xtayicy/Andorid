package com.harry;

import java.io.File;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyAndroidActivity extends Activity {
	private TextView textView;
	private Button button;
	private EditText editText;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.editText);
        
        button.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View v) {
				String keyWord = editText.getText().toString();
				if(keyWord.equals("")){
					textView.setText("关键字不能为空！");
				}else{
					textView.setText(searchFile(keyWord));
				}
			}
        });
    }
    
    private String searchFile(String keyWord){
    	String result = "";
    	File[] files = new File("/").listFiles();
    	for (File file : files) {
			if(file.getName().indexOf(keyWord) >= 0){
				result += file.getPath() + "\n";
			}
		}
    	
    	if(result.equals("")){
    		result = "找不到文件！";
    	}
    	
    	return result;
    }
}