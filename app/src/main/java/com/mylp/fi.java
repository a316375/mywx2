package com.mylp;

import java.util.Timer;
import java.util.TimerTask;

import com.mylp.R;

import android.content.Intent;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class fi extends AppCompatActivity {
	
	
	private Button myButton=null;
	private Button Button1=null;
	
  @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 
		setContentView(R.layout.fi);
		
		
		 
		
		
		
					
					
					
					
	
					
			
		myButton=(Button)findViewById(R.id.myButton );
		 myButton.setOnClickListener(new MyButtonListener());
		Button1=(Button)findViewById(R.id.button1);
		Button1.setOnClickListener(new Button.OnClickListener(){
		
			 @Override
			   public void onClick(View v) {
			    // TODO Auto-generated method stub
				  
				
			    System.exit(0);  
			    
			   
	            }  
			   
			  });
  }

	private void startAnimation(Animation translateAnimation2) {
	// TODO Auto-generated method stub
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	 class MyButtonListener implements OnClickListener{
		 
		 @Override
	        public void onClick(View v) {
                Intent intent =new Intent();
	            intent.setClass(fi.this, la.class);        
	            fi.this.startActivity(intent);
	            fi.this.finish(); 

	        }

	    }

	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.about) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}



  //�˳�����
	@Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
    // TODO Auto-generated method stub  
    if(keyCode == KeyEvent.KEYCODE_BACK)  
       {    
           exitBy2Click();      //����˫���˳�����  
       }  ;
    return false;  
 }  
/** 
 * ˫���˳����� 
 */  
  private static Boolean isExit = false;  
  
  private void exitBy2Click() {  
    Timer tExit = null;  
    if (isExit == false) {  
        isExit = true; // ׼���˳�  
        Toast.makeText(this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();  
        tExit = new Timer();  
        tExit.schedule(new TimerTask() {  
            @Override  
            public void run() {  
                isExit = false; // ȡ���˳�  
            }  
        }, 2000); // ���2������û�а��·��ؼ�����������ʱ��ȡ�����ղ�ִ�е�����  
  
    } else {  
        finish();  
        System.exit(0);  
    }  
}}//�����˳����