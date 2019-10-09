package com.mylp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

import com.mylp.R;

import android.content.pm.ApplicationInfo;
import android.os.Bundle;

import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class va extends AppCompatActivity {
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

	
	private Animation m1;
	private LinearInterpolator mlin;
	private Animation m2;
	private LinearInterpolator mlin2;
	private Animation m3;
	private LinearInterpolator mlin3;
	private Animation m4;
	private LinearInterpolator mlin4;
	private Animation m5;
	private LinearInterpolator mlin5;
	private Animation m6;
	private LinearInterpolator mlin6;
	private Animation m7;
	private LinearInterpolator mlin7;
	private Animation m8;
	private LinearInterpolator mlin8;
	private Animation m9;
	private LinearInterpolator mlin9;
	private Animation m10;
	private LinearInterpolator mlin10;
	
	private Animation mq;
	private LinearInterpolator mlinq;
	private Animation mw;
	private LinearInterpolator mlinw;
	private Animation me;
	private LinearInterpolator mline;
	private Animation mr;
	private LinearInterpolator mlinr;
	private Animation mt;
	private LinearInterpolator mlint;
	private Animation my;
	private LinearInterpolator mliny;
	private Animation ma;
	private LinearInterpolator mlina;
	private Animation ms;
	private LinearInterpolator mlins;
	private Animation md;
	private LinearInterpolator mlind;
	private Animation mf;
	private LinearInterpolator mlinf;
	private Animation mg;
	private LinearInterpolator mling;
	private Animation mh;
	private LinearInterpolator mlinh;
	
	
	
	private Button m1m;
	private Button m2m;
	private Button m3m;
	private Button m4m;
	private Button m5m;
	private Button m6m;
	private Button m7m;
	private Button m8m;
	private Button m9m;
	private Button m10m;
	private Button mqm;
	private Button mwm;
	private Button mem;
	private Button mrm;
	private Button mtm;
	private Button mym;
	private Button mam;
	private Button msm;
	private Button mdm;
	private Button mfm;
	private Button mgm;
	private Button mhm;
	
	private ImageView m1a;
	private ImageView m2a;
	private ImageView m3a;
	private ImageView m4a;
	private ImageView m5a;
	private ImageView m6a;
	private ImageView m7a;
	private ImageView m8a;
	private ImageView m9a;
	private ImageView m10a;
	
	private ImageView mqa;
	private ImageView mwa;
	private ImageView mea;
	private ImageView mra;
	private ImageView mta;
	private ImageView mya;
	private ImageView maa;
	private ImageView msa;
	private ImageView mda;
	private ImageView mfa;
	private ImageView mga;
	private ImageView mha;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.c);
	
		 
		
		m1a=(ImageView)findViewById(R.id.imageView2);
		m2a=(ImageView)findViewById(R.id.imageView2);
		m3a=(ImageView)findViewById(R.id.imageView2);
		m4a=(ImageView)findViewById(R.id.imageView2);
		m5a=(ImageView)findViewById(R.id.imageView2);
		m6a=(ImageView)findViewById(R.id.imageView2);
		m7a=(ImageView)findViewById(R.id.imageView2);
		m8a=(ImageView)findViewById(R.id.imageView2);
		m9a=(ImageView)findViewById(R.id.imageView2);
		m10a=(ImageView)findViewById(R.id.imageView2);
		
		mqa=(ImageView)findViewById(R.id.imageView1);
		mwa=(ImageView)findViewById(R.id.imageView1);
		mea=(ImageView)findViewById(R.id.imageView1);
		mra=(ImageView)findViewById(R.id.imageView1);
		mta=(ImageView)findViewById(R.id.imageView1);
		mya=(ImageView)findViewById(R.id.imageView1);
		maa=(ImageView)findViewById(R.id.imageView1);
		msa=(ImageView)findViewById(R.id.imageView1);
		mda=(ImageView)findViewById(R.id.imageView1);
		mfa=(ImageView)findViewById(R.id.imageView1);
		mga=(ImageView)findViewById(R.id.imageView1);
		mha=(ImageView)findViewById(R.id.imageView1);
		
		
		m1=AnimationUtils.loadAnimation(this, R.anim.asyjrop);
		mlin=new LinearInterpolator();
		m1.setInterpolator(mlin);
		
		m2=AnimationUtils.loadAnimation(this, R.anim.asymrop);
		mlin2=new LinearInterpolator();
		m2.setInterpolator(mlin2);
		
		m3=AnimationUtils.loadAnimation(this, R.anim.asysrop);
		mlin3=new LinearInterpolator();
		m3.setInterpolator(mlin3);
		
		m4=AnimationUtils.loadAnimation(this, R.anim.asyhrop);
		mlin4=new LinearInterpolator();
		m4.setInterpolator(mlin4);
		
		m5=AnimationUtils.loadAnimation(this, R.anim.asytrop);
		mlin5=new LinearInterpolator();
		m5.setInterpolator(mlin5);
		
		m6=AnimationUtils.loadAnimation(this, R.anim.asyj_0rop);
		mlin6=new LinearInterpolator();
		m6.setInterpolator(mlin6);
		
		m7=AnimationUtils.loadAnimation(this, R.anim.asym_0rop);
		mlin7=new LinearInterpolator();
		m7.setInterpolator(mlin7);
		
		m8=AnimationUtils.loadAnimation(this, R.anim.asys_0rop);
		mlin8=new LinearInterpolator();
		m8.setInterpolator(mlin8);
		
		m9=AnimationUtils.loadAnimation(this, R.anim.asyh_0rop);
		mlin9=new LinearInterpolator();
		m9.setInterpolator(mlin9);
		
		m10=AnimationUtils.loadAnimation(this, R.anim.asyt_0rop);
		mlin10=new LinearInterpolator();
		m10.setInterpolator(mlin10);
		
		
		
		mq=AnimationUtils.loadAnimation(this, R.anim.asq);
		mlinq=new LinearInterpolator();
		mq.setInterpolator(mlinq);
		
		mw=AnimationUtils.loadAnimation(this, R.anim.asw);
		mlinw=new LinearInterpolator();
		mw.setInterpolator(mlinw);
		
		me=AnimationUtils.loadAnimation(this, R.anim.ase);
		mline=new LinearInterpolator();
		me.setInterpolator(mline);
		
		mr=AnimationUtils.loadAnimation(this, R.anim.asr);
		mlinr=new LinearInterpolator();
		mr.setInterpolator(mlinr);
		
		mt=AnimationUtils.loadAnimation(this, R.anim.ast);
		mlint=new LinearInterpolator();
		mt.setInterpolator(mlint);
		
		my=AnimationUtils.loadAnimation(this, R.anim.asy);
		mliny=new LinearInterpolator();
		my.setInterpolator(mliny);
		
		ma=AnimationUtils.loadAnimation(this, R.anim.asa);
		mlina=new LinearInterpolator();
		ma.setInterpolator(mlina);
		
		ms=AnimationUtils.loadAnimation(this, R.anim.ass);
		mlins=new LinearInterpolator();
		ms.setInterpolator(mlins);
		
		md=AnimationUtils.loadAnimation(this, R.anim.asd);
		mlind=new LinearInterpolator();
		md.setInterpolator(mlind);
		
		mf=AnimationUtils.loadAnimation(this, R.anim.asf);
		mlinf=new LinearInterpolator();
		mf.setInterpolator(mlinf);
		
		mg=AnimationUtils.loadAnimation(this, R.anim.asg);
		mling=new LinearInterpolator();
		mg.setInterpolator(mling);
		
		mh=AnimationUtils.loadAnimation(this, R.anim.ash);
		mlinh=new LinearInterpolator();
		mh.setInterpolator(mlinh);
		
		
		
		
		m1m=(Button)findViewById(R.id.button1);
		m2m=(Button)findViewById(R.id.button2);
		m3m=(Button)findViewById(R.id.button3);
		m4m=(Button)findViewById(R.id.button4);
		m5m=(Button)findViewById(R.id.button5);
		m6m=(Button)findViewById(R.id.button6);
		m7m=(Button)findViewById(R.id.button7);
		m8m=(Button)findViewById(R.id.button7);
		m9m=(Button)findViewById(R.id.button9);
		m10m=(Button)findViewById(R.id.button10);
		
		mqm=(Button)findViewById(R.id.buttonq);
		mwm=(Button)findViewById(R.id.buttonw);
		mem=(Button)findViewById(R.id.button7);
		mrm=(Button)findViewById(R.id.buttonr);
		mtm=(Button)findViewById(R.id.buttont);
		mym=(Button)findViewById(R.id.buttony);
		mam=(Button)findViewById(R.id.buttona);
		msm=(Button)findViewById(R.id.buttons);
		mdm=(Button)findViewById(R.id.buttond);
		mfm=(Button)findViewById(R.id.button7);
		mgm=(Button)findViewById(R.id.buttong);
		mhm=(Button)findViewById(R.id.buttonh);
		
		
		
		
		
		
		  mqm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtonq();
				}
			});
		  mwm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtonw();
				}
			});
		  mem.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtone();
				}
			});
		  
		  mrm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtonr();
				}
			});
		  mtm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtont();
				}
			});
		  mym.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtony();
				}
			});
		  mam.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtona();
				}
			});
		  msm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtons();
				}
			});
		  
		  mdm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtond();
				}
			});
		  mfm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtonf();
				}
			});
		  mgm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtong();
				}
			});
		  mhm.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					mButtonh();
				}
			});
		  
		  
		  
        m2m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton2();
			}
		});
        

        m3m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton3();
			}
		});
        m4m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton4();
			}
		});
        m5m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton5();
			}
		});
        m6m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton6();
			}
		});
        m7m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton7();
			}
		});
        m8m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton8();
			}
		});
        m9m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton9();
			}
		});
        m10m.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton10();
			}
		});
		
		m1m.setOnClickListener(new View.OnClickListener(){
			
	
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mButton();
				
				
			}
		});
	
	}
	private void mButton(){
		m1a.startAnimation(m1);}
	private void mButton2(){
		m2a.startAnimation(m2);}
			private void mButton3(){
				m3a.startAnimation(m3);}
				private void mButton4(){
					m4a.startAnimation(m4);}
					private void mButton5(){
						m5a.startAnimation(m5);}
						private void mButton6(){
							m6a.startAnimation(m6);}
							private void mButton7(){
								m7a.startAnimation(m7);}
								private void mButton8(){
									m8a.startAnimation(m8);}
									private void mButton9(){
										m9a.startAnimation(m9);}
										private void mButton10(){
											m10a.startAnimation(m10);
	}
										private void mButtonq(){
											mqa.startAnimation(mq);
	}	private void mButtonw(){
		mwa.startAnimation(mw);
}	private void mButtone(){
	mea.startAnimation(me);
}	private void mButtonr(){
	mra.startAnimation(mr);
}	private void mButtont(){
	mta.startAnimation(mt);
}	private void mButtony(){
	mya.startAnimation(my);
}	private void mButtona(){
	maa.startAnimation(ma);
}	private void mButtons(){
	msa.startAnimation(ms);
}	private void mButtond(){
	mda.startAnimation(md);
}	private void mButtonf(){
	mfa.startAnimation(mf);
}	private void mButtong(){
	mga.startAnimation(mg);
}	private void mButtonh(){
	mha.startAnimation(mh);
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
     }  ;
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
      Toast.makeText(this, "再按一次返回", Toast.LENGTH_SHORT).show();  
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
