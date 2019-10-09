package com.mylp.pp;

import java.util.ArrayList;
import java.util.Calendar;

import com.mylp.R;
import com.mylp.ao;
import com.mylp.pp.BaseString.PPString;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.DatePicker;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

//玄空排盘的布局

public class Main extends Activity implements upTitle,upGV {
	private boolean flag = true;// 按返回键设置为flase,触摸屏幕也置换值

	private SensorManager mSensorManager;// 注册传感器的列表
	private Sensor orientation; // 方向传感器

	private Year y = new Year();// 获取年

	private TextView tv;//度数
	
	private TextView ts;//替卦提示文字

	private static final String TAG = "---MainActivity";

	private ImageView mPointer;// 罗盘图片

	private MySensorEventListener listener;// 监听事件

	protected final Handler mHandler = new Handler();

	protected Runnable mCompassViewUpdater = new Runnable() {
		 
		
		@Override
		public void run() {

			
			mPointer.setRotation(-value);
			tv.setText("度数:" + value + "°");
			mHandler.postDelayed(mCompassViewUpdater, 33);// 33毫米后重新执行自己，比定时器好
			
			if (Utils.showTS(value)==1) {
				ts.setVisibility(View.VISIBLE);
			}else{
				ts.setVisibility(View.INVISIBLE);
			}
         
			if (flag) {
			//Utils.Flag(value)&&如果布尔值判断是ture,代表已经不在同个山的范围,刷新gv
			//flag代表任务正在进行中,没有被暂停界面	
			refresh();
           }
		}

		

	};

	public float value;

	private TextView ll;// 流年

	private Spinner sp;// 元运选择器

	private TextView sptext;//建造时间

	private GridView gv;//九宫布局

	private int y1;//获取的流年的数值

	private NumFactory factory;//数字的设置以及更新

	private GV gvDate;
	
	private TextView tvfz,tvfx;//辅助说明,辅助坐,辅助向

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		 
		setContentView(ViewFactory.creat(this));

		mPointer = ViewFactory.getIV( );

		tv = ViewFactory.getTV( );
		
		ts = ViewFactory.getts();

		ll = ViewFactory.getLL( );

		sp = ViewFactory.getSP( );
		
		sptext = ViewFactory.getsptext( );
		
		gv = ViewFactory.getGv();

		factory = NumFactory.Creat();
		
		tvfz=ViewFactory.gettvfz();
		tvfz.setText(PPString.strs[6]);
		
		tvfx=ViewFactory.gettvfx();
		
		gvDate = new GV(this,factory);
		
		
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);// 注册传感器

		orientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);// 方向传感器;已经过时的方法

		
		
		listener = new MySensorEventListener();

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		Click.onClick(ll, y,1);
		Click.onClick(sp,factory,gvDate,gv,value);//第二控件的监听也要实现刷新卡牌
		Click.onClick(sptext,y,2);

		
		y1 = y.getGety2() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety2();
		sp.setSelection(Utils.select(y1) - 1);
		
		factory.sortNum4(y1);
		gv.setAdapter(gvDate);
		 
		 
		
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			
			flag = !flag;
			Log.i(TAG, flag + "");
			if (flag) {
				Register();
				mCompassViewUpdater.run();
			} else {
				mSensorManager.unregisterListener(listener);
			}
			break;

		default:
			break;
		}

		return super.onTouchEvent(event);
	}

	// 监听了传感器变化
	class MySensorEventListener implements SensorEventListener {

		@Override
		public void onSensorChanged(SensorEvent event) {

			value = (event.values[0] + 720) % 360;

		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		// 注册监听
		Register();
		mHandler.postDelayed(mCompassViewUpdater, 33);// 33毫米后重新执行自己，比定时器好
	}

	// 开启一个注册监听开始工作
	private void Register() {
		mSensorManager.registerListener(listener, orientation, Sensor.TYPE_ACCELEROMETER);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		mSensorManager.unregisterListener(listener);
	}

	// 退出代码
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			flag = false;
			// 解除注册
			mSensorManager.unregisterListener(listener);

			startActivity(new Intent(Main.this, ao.class));
			finish(); // 调用双击退出函数
		}
		;
		return false;
	}

	@Override
	public void up() {
		int s = y.getGety() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety();
		ll.setText("流年:" + s+"中宫"+NumFactory.Num[Utils.selectStart(s)-1]+"运");
		System.out.println(ll.getText().toString());
	
		//刷新卡牌
		factory.sortNum4(Utils.selectStart(s));
		//Toast.makeText(Main.this,selectStart(s)+"重新排序:"+factory.getNum4().get(4), 0).show();
		gvDate.setFactory(factory,value);
		gv.setAdapter(gvDate);
		 
		 
		 
	}
	
	@Override
	public void up2() {
		int s = y.getGety2() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety2();
		//sptext.setText("建运设置:");
		sp.setSelection(Utils.select(s) - 1);
		
		//刷新卡牌,第二个控件选择元旦盘的排盘,排盘还需要在sp中去设置一遍;
		factory.sortNum3(Utils.select(s));
		//Toast.makeText(Main.this,Utils.select(s)+"重新排序:"+factory.getNum3().get(4), 0).show();
		gvDate.setFactory(factory,value);
		gv.setAdapter(gvDate);
		
	}

	 
	
	@Override
	public void upData() {
		 
		
	}

	
	public void refresh() {
		float v1=0,v2=0;
		int setDown=0,setUp=0;
		boolean b1=true,b2=true;
		try {
		 v1=value;
		 v2=value;
		
		//设置数组第四个数,通过第三个数getNum3()来设置的
		 setDown = Utils.setDown(factory.getNum3(),v1);
		 setUp = Utils.setUp(factory.getNum3(),v2);

		  b1=Utils.zYY(v1,factory.getNum1().get(4),tvfz);
		  b2=Utils.xYY(v2,factory.getNum2().get(4),tvfx);
		
		
			
		} finally {
			//设置中宫数字后,根据布尔值判断顺逆
			factory.sortNum1(setDown,b1);
			factory.sortNum2(setUp,b2);
			//Toast.makeText(Main.this,selectStart(s)+"重新排序:"+factory.getNum4().get(4), 0).show();
			gvDate.setFactory(factory,value);
			gv.setAdapter(gvDate);
		}
		
		
		
		//Toast.makeText(getApplicationContext(), factory.getNum1().get(4)+"--"+factory.getNum2().get(4), 0).show();
		
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.vip) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	
}
