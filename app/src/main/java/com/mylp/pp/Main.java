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

//�������̵Ĳ���

public class Main extends Activity implements upTitle,upGV {
	private boolean flag = true;// �����ؼ�����Ϊflase,������ĻҲ�û�ֵ

	private SensorManager mSensorManager;// ע�ᴫ�������б�
	private Sensor orientation; // ���򴫸���

	private Year y = new Year();// ��ȡ��

	private TextView tv;//����
	
	private TextView ts;//������ʾ����

	private static final String TAG = "---MainActivity";

	private ImageView mPointer;// ����ͼƬ

	private MySensorEventListener listener;// �����¼�

	protected final Handler mHandler = new Handler();

	protected Runnable mCompassViewUpdater = new Runnable() {
		 
		
		@Override
		public void run() {

			
			mPointer.setRotation(-value);
			tv.setText("����:" + value + "��");
			mHandler.postDelayed(mCompassViewUpdater, 33);// 33���׺�����ִ���Լ����ȶ�ʱ����
			
			if (Utils.showTS(value)==1) {
				ts.setVisibility(View.VISIBLE);
			}else{
				ts.setVisibility(View.INVISIBLE);
			}
         
			if (flag) {
			//Utils.Flag(value)&&�������ֵ�ж���ture,�����Ѿ�����ͬ��ɽ�ķ�Χ,ˢ��gv
			//flag�����������ڽ�����,û�б���ͣ����	
			refresh();
           }
		}

		

	};

	public float value;

	private TextView ll;// ����

	private Spinner sp;// Ԫ��ѡ����

	private TextView sptext;//����ʱ��

	private GridView gv;//�Ź�����

	private int y1;//��ȡ���������ֵ

	private NumFactory factory;//���ֵ������Լ�����

	private GV gvDate;
	
	private TextView tvfz,tvfx;//����˵��,������,������

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
		
		
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);// ע�ᴫ����

		orientation = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);// ���򴫸���;�Ѿ���ʱ�ķ���

		
		
		listener = new MySensorEventListener();

	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();

		Click.onClick(ll, y,1);
		Click.onClick(sp,factory,gvDate,gv,value);//�ڶ��ؼ��ļ���ҲҪʵ��ˢ�¿���
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

	// �����˴������仯
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
		// ע�����
		Register();
		mHandler.postDelayed(mCompassViewUpdater, 33);// 33���׺�����ִ���Լ����ȶ�ʱ����
	}

	// ����һ��ע�������ʼ����
	private void Register() {
		mSensorManager.registerListener(listener, orientation, Sensor.TYPE_ACCELEROMETER);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		mSensorManager.unregisterListener(listener);
	}

	// �˳�����
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			flag = false;
			// ���ע��
			mSensorManager.unregisterListener(listener);

			startActivity(new Intent(Main.this, ao.class));
			finish(); // ����˫���˳�����
		}
		;
		return false;
	}

	@Override
	public void up() {
		int s = y.getGety() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety();
		ll.setText("����:" + s+"�й�"+NumFactory.Num[Utils.selectStart(s)-1]+"��");
		System.out.println(ll.getText().toString());
	
		//ˢ�¿���
		factory.sortNum4(Utils.selectStart(s));
		//Toast.makeText(Main.this,selectStart(s)+"��������:"+factory.getNum4().get(4), 0).show();
		gvDate.setFactory(factory,value);
		gv.setAdapter(gvDate);
		 
		 
		 
	}
	
	@Override
	public void up2() {
		int s = y.getGety2() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety2();
		//sptext.setText("��������:");
		sp.setSelection(Utils.select(s) - 1);
		
		//ˢ�¿���,�ڶ����ؼ�ѡ��Ԫ���̵�����,���̻���Ҫ��sp��ȥ����һ��;
		factory.sortNum3(Utils.select(s));
		//Toast.makeText(Main.this,Utils.select(s)+"��������:"+factory.getNum3().get(4), 0).show();
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
		
		//����������ĸ���,ͨ����������getNum3()�����õ�
		 setDown = Utils.setDown(factory.getNum3(),v1);
		 setUp = Utils.setUp(factory.getNum3(),v2);

		  b1=Utils.zYY(v1,factory.getNum1().get(4),tvfz);
		  b2=Utils.xYY(v2,factory.getNum2().get(4),tvfx);
		
		
			
		} finally {
			//�����й����ֺ�,���ݲ���ֵ�ж�˳��
			factory.sortNum1(setDown,b1);
			factory.sortNum2(setUp,b2);
			//Toast.makeText(Main.this,selectStart(s)+"��������:"+factory.getNum4().get(4), 0).show();
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
