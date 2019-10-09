package com.mylp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mylp.R;



 



public  class ot extends AppCompatActivity {
	TextView abs;
	public native String  sdssd(); 
	static{
        System.loadLibrary("b");    }
	TextView absb;
	static String a;
	boolean isRunningInEmualtor() {
	    boolean qemuKernel = false;
	    Process process = null;
	    DataOutputStream os = null;
	    try{  
	      process = Runtime.getRuntime().exec("getprop ro.kernel.qemu");  
	      os = new DataOutputStream(process.getOutputStream());
	      BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
	      os.writeBytes("exit\n");  
	      os.flush();
	      process.waitFor();
	      // getprop ro.kernel.qemu == 1  在模拟器
	      // getprop ro.product.model == "sdk"  在模拟器
	      // getprop ro.build.tags == "test-keys"  在模拟器
	      qemuKernel = (Integer.valueOf(in.readLine()) == 1);
	      Log.d("com.droider.checkqemu", "检测到模拟器:" + qemuKernel);			 
	    } catch (Exception e){  
	      qemuKernel = false;
	      Log.d("com.droider.checkqemu", "run failed" + e.getMessage()); 
	    } finally {
	      try{  
	        if (os != null) {  
	          os.close(); 
	          
	        } 
	        if (0!=(getApplicationInfo().flags&=ApplicationInfo.FLAG_DEBUGGABLE)) {  
	            Log.e("DEBUG", "程序被修改为可调试状态！！！");  
	            android.os.Process.killProcess(android.os.Process.myPid());  
	        }  
	        process.destroy();  
	      } catch (Exception e) {
	        
	      }  
	      Log.d("com.droider.checkqemu", "run finally"); 
	    }
	    return qemuKernel;
	  }
	 public static boolean isApkDebugable(Context context) {
	        try {
	            ApplicationInfo info= context.getApplicationInfo();
	                return (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;
	        } catch (Exception e) {
	            
	        }
	        return false;
	    }
	 private Button button1=null;
		private Button button2=null;
	 public static boolean isApkDebugable(Context context,String packageName) {
	        try {
	            PackageInfo pkginfo = context.getPackageManager().getPackageInfo(
	                    packageName, 1);
	            if (pkginfo != null ) {
	                ApplicationInfo info= pkginfo.applicationInfo;
	                return (info.flags&ApplicationInfo.FLAG_DEBUGGABLE)!=0;
	            }
	            
	        } catch (Exception e) {
	            
	        }
	        return false;
	    }
	 
	
	
	private Button button3=null;
	private Button button5=null;
	private Button button4=null;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ca); 
		
		//按钮事件
		button1=(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new MyButtonListener());
		button2=(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new MyButtonListener());
		
		
		button4=(Button)findViewById(R.id.button4);
		
		button5=(Button)findViewById(R.id.button5);
		button3=(Button)findViewById(R.id.button3);
		button3.setOnClickListener( new Button.OnClickListener(){
			
			 @Override
			   public void onClick(View v) {
			   
				  
				 Intent intent =new Intent();
		            intent.setClass(ot.this, gb.class);        
		            ot.this.startActivity(intent);
		          
			   
	            }  
			   
			  });
 
	
	button5.setOnClickListener( new Button.OnClickListener(){
		
		 @Override
		   public void onClick(View v) {
		   
			  
			 Intent intent =new Intent();
	            intent.setClass(ot.this, va.class);        
	            ot.this.startActivity(intent);
	         

		   
            }  
		   
		  });
	
	
	button5.setOnClickListener( new Button.OnClickListener(){
		
		 @Override
		   public void onClick(View v) {
		   
			  
			 Intent intent= new Intent();        
			    intent.setAction("android.intent.action.VIEW");    
			    Uri content_url = Uri.parse("0");   
			    intent.setData(content_url);  
			    startActivity(intent);
		   
           }  
		   
		  });
	absb=(TextView) findViewById(R.id.tx2);
	absb.setText(sdssd());
	a=absb.getText().toString();
	final String e=new String(Base64.decode(a.getBytes(), Base64.DEFAULT));
	abs=(TextView) findViewById(R.id.tx1);

	abs.setText(e);
	
	

}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true; 
	}class MyButtonListener implements OnClickListener{
			 @Override
		        public void onClick(View v){
		        
				
	             Intent intent =new Intent();
	             if(v.getId() == R.id.button1)
			        {
	               intent.setClass(ot.this, ao.class);        
		            ot.this.startActivity(intent);
		           ot.this.overridePendingTransition(R.anim.activity_open,R.anim.activity_close); 
		            
		            ot.this.finish(); 
			 }
	             
	             else     if(v.getId() == R.id.button2){
				 
		            
	               intent.setClass(ot.this, la.class);        
		            ot.this.startActivity(intent);
		            
				 }
			 
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




//退出代码
@Override  
public boolean onKeyDown(int keyCode, KeyEvent event) {  
// TODO Auto-generated method stub  
if(keyCode == KeyEvent.KEYCODE_BACK)  
   {    
       exitBy2Click();      //调用双击退出函数  
   }  
return false;  
}  
/** 
* 双击退出函数 
*/  
private static Boolean isExit = false;  

private void exitBy2Click() {  
Timer tExit = null;  
if (isExit == false) {  
    isExit = true; // 准备退出  
    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();  
    tExit = new Timer();  
    tExit.schedule(new TimerTask() {  
        @Override  
        public void run() {  
            isExit = false; // 取消退出  
        }  
    }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务  

} else {  
    finish();  
    System.exit(0);  
}  
}}//以上退出完毕