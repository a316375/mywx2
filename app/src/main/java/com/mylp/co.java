package com.mylp;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


import com.mylp.R;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/** 
 * MainActivity 
 *  
 * @author way 
 *  
 */  
public class co extends Activity implements SensorEventListener {  
//    private static final int EXIT_TIME = 2000;// ���ΰ����ؼ��ļ���ж�  
	y msview;// ˮƽ����ͼ
	// ����ˮƽ���ܴ���������б�ǣ������ýǶȣ����ݽ�ֱ����λ�ڱ߽硣
	int MAX_ANGLE = 30;
	// ����Sensor������2
	SensorManager mSensorManager2;
	
    private final float MAX_ROATE_DEGREE = 1.0f;// �����תһ�ܣ���360��  
    private SensorManager mSensorManager;// �������������  
    private Sensor mOrientationSensor;// ����������  
  //  private LocationManager mLocationManager;// λ�ù������  
  //  private String mLocationProvider;// λ���ṩ�����ƣ�GPS�豸��������  
    private float mDirection;// ��ǰ���㷽��  
    private float mTargetDirection;// Ŀ�긡�㷽��  
    private AccelerateInterpolator mInterpolator;// �����ӿ�ʼ���������仯����һ�����ٵĹ���,����һ����������  
    protected final Handler mHandler = new Handler();  
    private boolean mStopDrawing;// �Ƿ�ָֹͣ������ת�ı�־λ  
 //   private boolean mChinease;// ϵͳ��ǰ�Ƿ�ʹ������  
    private long firstExitTime = 0L;// ���������һ�ΰ����ؼ���ʱ��  
  
    View mCompassView;  
    vp mPointer;// ָ����view  
 //   TextView mLocationTextView;// ��ʾλ�õ�view  
//    LinearLayout mDirectionLayout;// ��ʾ���򣨶�����������view  
//    LinearLayout mAngleLayout;// ��ʾ���������view  
    
   
  
    // ����Ǹ���ָ������ת���̣߳�handler�����ʹ�ã�ÿ20�����ⷽ��仯ֵ����Ӧ����ָ������ת  
    protected Runnable mCompassViewUpdater = new Runnable() {  
        @Override  
        public void run() {  
            if (mPointer != null && !mStopDrawing) {  
                if (mDirection != mTargetDirection) {  
  
                    // calculate the short routine  
                    float to = mTargetDirection;  
                    if (to - mDirection > 180) {  
                        to -= 360;  
                    } else if (to - mDirection < -180) {  
                        to += 360;  
                    }  
  
                    // limit the max speed to MAX_ROTATE_DEGREE  
                    float distance = to - mDirection;  
                    if (Math.abs(distance) > MAX_ROATE_DEGREE) {  
                        distance = distance > 0 ? MAX_ROATE_DEGREE  
                                : (-1.0f * MAX_ROATE_DEGREE);  
                    }  
  
                    // need to slow down if the distance is short  
                    mDirection = normalizeDegree(mDirection  
                            + ((to - mDirection) * mInterpolator  
                                    .getInterpolation(Math.abs(distance) > MAX_ROATE_DEGREE ? 0.4f  
                                            : 0.3f)));// ����һ�����ٶ���ȥ��תͼƬ����ϸ��  
                    mPointer.updateDirection(mDirection);// ����ָ������ת  
                }  
  
          //      updateDirection();// ���·���ֵ  
  
                mHandler.postDelayed(mCompassViewUpdater, 20);// 20���׺�����ִ���Լ����ȶ�ʱ����  
            }  
        }  
    };   
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.s);  
        initResources();// ��ʼ��view  
        initServices();// ��ʼ����������λ�÷���  
        mPointer.setKeepScreenOn(true);// ����ͼƬ����
        
    	/* ˮƽ�� */
		msview = (y) findViewById(R.id.spy);
		// ��ȡ�������������
		mSensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);
  
       
    } 
  
   
  
  
    @Override  
    protected void onResume() {// �ڻָ��������������жϡ�����λ�ø��·���ʹ���������  
        super.onResume();  

		// ˮƽ��Ϊϵͳ�ķ��򴫸���ע�������
		mSensorManager2.registerListener(this,
				mSensorManager2.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);
		
      /*  if (mLocationProvider != null) {  
            updateLocation(mLocationManager  
                    .getLastKnownLocation(mLocationProvider));  
            mLocationManager.requestLocationUpdates(mLocationProvider, 2000,  
                    10, mLocationListener);// 2����߾���仯10��ʱ����һ�ε���λ��  
        } else {  
            mLocationTextView.setText(R.string.cannot_get_location);  
        }  */
        if (mOrientationSensor != null) {  
            mSensorManager.registerListener(mOrientationSensorEventListener,  
                    mOrientationSensor, SensorManager.SENSOR_DELAY_GAME);  
        } else {  
//            Toast.makeText(this, R.string.cannot_get_location, Toast.LENGTH_SHORT)  
//                    .show();  // R.string.
        }  
        mStopDrawing = false;  
        mHandler.postDelayed(mCompassViewUpdater, 40);// 40����ִ��һ�θ���ָ����ͼƬ��ת  
    }  
  
    @Override  
    protected void onPause() {// ����ͣ������������ע�������������λ�ø��·���  
    	// ȡ��ˮƽ��ע��
		mSensorManager2.unregisterListener(this);
		
		super.onPause();  
        
    
		//ָ��������
        mStopDrawing = true;  
        if (mOrientationSensor != null) {  
            mSensorManager.unregisterListener(mOrientationSensorEventListener);  
        }  
       /* if (mLocationProvider != null) {  
            mLocationManager.removeUpdates(mLocationListener);  
        }  */
    }  
  
    // ��ʼ��view  
    private void initResources() {  
        mDirection = 0.0f;// ��ʼ����ʼ����  
        mTargetDirection = 0.0f;// ��ʼ��Ŀ�귽��  
        mInterpolator = new AccelerateInterpolator();// ʵ�������ٶ�������  
        mStopDrawing = true;  
     //   mChinease = TextUtils.equals(Locale.getDefault().getLanguage(), "zh");// �ж�ϵͳ��ǰʹ�õ������Ƿ�Ϊ����  
  
      //  mCompassView = findViewById(R.id.view_compass);// ʵ������һ��LinearLayout��װָ����ImageView��λ��TextView  
        mPointer = (vp) findViewById(R.id.compass_pointer);// �Զ����ָ����view  
     //   mLocationTextView = (TextView) findViewById(R.id.textview_location);// ��ʾλ����Ϣ��TextView  
//        mDirectionLayout = (LinearLayout) findViewById(R.id.layout_direction);// ������ʾ�������ƣ�������������LinearLayout  
    //    mAngleLayout = (LinearLayout) findViewById(R.id.layout_angle);// ������ʾ������������LinearLayout  
  
        mPointer.setImageResource(R.drawable.mylpan );// ���ϵͳʹ�����ģ��������ĵ�ָ����ͼƬ  
    }  
  
    // ��ʼ����������λ�÷���  
    private void initServices() {  
        // sensor manager  
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);  
        mOrientationSensor = mSensorManager  
                .getDefaultSensor(Sensor.TYPE_ORIENTATION);  
  
        // location manager  
    //    mLocationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);  
     /*   Criteria criteria = new Criteria();// �������󣬼�ָ���������˻��LocationProvider  
        criteria.setAccuracy(Criteria.ACCURACY_FINE);// �ϸ߾���  
        criteria.setAltitudeRequired(false);// �Ƿ���Ҫ�߶���Ϣ  
        criteria.setBearingRequired(false);// �Ƿ���Ҫ������Ϣ  
        criteria.setCostAllowed(true);// �Ƿ��������  
        criteria.setPowerRequirement(Criteria.POWER_LOW);// ���õ͵��  
*/    //    mLocationProvider = mLocationManager.getBestProvider(criteria, true);// ��ȡ������õ�Provider  
  
    }  
    
    @Override
	protected void onStop() {
		// ȡ��ˮƽ��ע��
		mSensorManager2.unregisterListener(this);
		super.onStop();
	}
	/* ˮƽ�� */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		float[] values = event.values;
		// ��ȡ����event�Ĵ���������
		int sensorType = event.sensor.getType();
		switch (sensorType) {
		case Sensor.TYPE_ORIENTATION:
			// ��ȡ��Y��ļн�
			float yAngle = values[1];
			// ��ȡ��Z��ļн�
			float zAngle = values[2];
			// ����λ���м�ʱ��ˮƽ����ȫˮƽ�������ݵ�X��Y����
			int x = (msview.back.getWidth() - msview.bubble.getWidth()) / 2;
			int y = (msview.back.getHeight() - msview.bubble.getHeight()) / 2;
			// �����Z�����б�ǻ������Ƕ�֮��
			if (Math.abs(zAngle) <= MAX_ANGLE) {
				// ������Z�����б�Ƕȼ���X����ı仯ֵ����б�Ƕ�Խ��X����仯Խ��
				int deltaX = (int) ((msview.back.getWidth() - msview.bubble
						.getWidth()) / 2 * zAngle / MAX_ANGLE);
				x += deltaX;
			}
			// �����Z�����б���Ѿ�����MAX_ANGLE������Ӧ�������
			else if (zAngle > MAX_ANGLE) {
				x = 0;
			}
			// �����Z�����б���Ѿ�С�ڸ���MAX_ANGLE������Ӧ�����ұ�
			else {
				x = msview.back.getWidth() - msview.bubble.getWidth();
			}
			// �����Y�����б�ǻ������Ƕ�֮��
			if (Math.abs(yAngle) <= MAX_ANGLE) {
				// ������Y�����б�Ƕȼ���Y����ı仯ֵ����б�Ƕ�Խ��Y����仯Խ��
				int deltaY = (int) ((msview.back.getHeight() - msview.bubble
						.getHeight()) / 2 * yAngle / MAX_ANGLE);
				y += deltaY;
			}
			// �����Y�����б���Ѿ�����MAX_ANGLE������Ӧ�����±�
			else if (yAngle > MAX_ANGLE) {
				y = msview.back.getHeight() - msview.bubble.getHeight();
			}
			// �����Y�����б���Ѿ�С�ڸ���MAX_ANGLE������Ӧ�����ұ�
			else {
				y = 0;
			}
			// ������������X��Y���껹λ��ˮƽ�ǵ��Ǳ����ڣ�����ˮƽ�ǵ���������
			if (isContain(x, y)) {
				msview.bubbleX = x;
				msview.bubbleY = y;
			}
			// ֪ͨϵͳ�ػ�MyView���
			msview.postInvalidate();
			break;
		}
	}

	// ����x��y��������Ƿ���ˮƽ�ǵ��Ǳ�����
	private boolean isContain(int x, int y) {
		// �������ݵ�Բ������X��Y
		int bubbleCx = x + msview.bubble.getWidth() / 2;
		int bubbleCy = y + msview.bubble.getWidth() / 2;
		// ����ˮƽ���Ǳ��̵�Բ������X��Y
		int backCx = msview.back.getWidth() / 2;
		int backCy = msview.back.getWidth() / 2;
		// �������ݵ�Բ����ˮƽ���Ǳ��̵�Բ��֮��ľ��롣
		double distance = Math.sqrt((bubbleCx - backCx) * (bubbleCx - backCx)
				+ (bubbleCy - backCy) * (bubbleCy - backCy));
		// ������Բ�ĵľ���С�����ǵİ뾶�������Ϊ���ڸõ��������Ȼλ���Ǳ�����
		if (distance < (msview.back.getWidth() - msview.bubble.getWidth()) / 2) {
			return true;
		} else {
			return false; 
		}
	}

  
    // ���¶���������ʾ�ķ���  
   /* private void updateDirection() {  
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  */
        // ���Ƴ�layout�����е�view  
//        mDirectionLayout.removeAllViews();  
   //     mAngleLayout.removeAllViews();  
  
        // �����Ǹ���mTargetDirection������������ͼƬ�Ĵ���  
    /*    ImageView east = null;  
        ImageView west = null;  
        ImageView south = null;  
        ImageView north = null;  
        float direction = normalizeDegree(mTargetDirection * -1.0f);  
        if (direction > 88f && direction < 92f) {  
            // east  
            east = new ImageView(this);  
            east.setImageResource(mChinease ? R.drawable.e_cn : R.drawable.e_cn);  
            east.setLayoutParams(lp); 
        } else if (direction > 268f && direction < 272f) {  
            // west  
            west = new ImageView(this);  
            west.setImageResource(mChinease ? R.drawable.w_cn : R.drawable.w_cn);  
            west.setLayoutParams(lp);  
        }  
  
        if (direction > 90f && direction < 270f) {  
            // south  
            south = new ImageView(this);  
            south.setImageResource(mChinease ? R.drawable.s_cn : R.drawable.s_cn);  
            south.setLayoutParams(lp);  
        } else if (direction < 52 || direction > 322f) {  }
            // north  
           north = new ImageView(this);  
            north.setImageResource(mChinease ? R.drawable.n_cn : R.drawable.n_cn);  
            north.setLayoutParams(lp);  
        }*/  
   /*     // �����Ǹ���ϵͳʹ�����ԣ�������Ӧ������ͼƬ��Դ  
        if (mChinease) {  
            // east/west should be before north/south  
            if (east != null) {  
                mDirectionLayout.addView(east);  
            }  
            if (west != null) {  
                mDirectionLayout.addView(west);  
            }  
            if (south != null) {  
                mDirectionLayout.addView(south);  
            }  
            if (north != null) {  
                mDirectionLayout.addView(north);  
            }  
        } else {  
            // north/south should be before east/west  
            if (south != null) {  
                mDirectionLayout.addView(south);  
            }  
            if (north != null) {  
                mDirectionLayout.addView(north);  
            }  
            if (east != null) {  
                mDirectionLayout.addView(east);  
            }  
            if (west != null) {  
                mDirectionLayout.addView(west);  
            }  
        }  */
        // �����Ǹ��ݷ��������ʾ����ͼƬ����  
   /*     int direction2 = (int) direction;  
        boolean show = false;  
        if (direction2 >= 100) {  
            mAngleLayout.addView(getNumberImage(direction2 / 100));  
            direction2 %= 100;  
            show = true;  
        }  
        if (direction2 >= 10 || show) {  
            mAngleLayout.addView(getNumberImage(direction2 / 10));  
            direction2 %= 10;  
        }  
        mAngleLayout.addView(getNumberImage(direction2));  
        // ����������һ�����ͼƬ  
        ImageView degreeImageView = new ImageView(this);  
        degreeImageView.setImageResource(R.drawable.degree);  
        degreeImageView.setLayoutParams(lp);  
        mAngleLayout.addView(degreeImageView);  
    }  
  */
  /*  // ��ȡ���������Ӧ��ͼƬ������ImageView  
    private ImageView getNumberImage(int number) {  
        ImageView image = new ImageView(this);  
        LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,  
                LayoutParams.WRAP_CONTENT);  
        switch (number) {  
        case 0:  
            image.setImageResource(R.drawable.number_0);  
            break;  
        case 1:  
            image.setImageResource(R.drawable.number_1);  
            break;  
        case 2:  
            image.setImageResource(R.drawable.number_2);  
            break;  
        case 3:  
            image.setImageResource(R.drawable.number_3);  
            break;  
        case 4:  
            image.setImageResource(R.drawable.number_4);  
            break;  
        case 5:  
            image.setImageResource(R.drawable.number_5);  
            break;  
        case 6:  
            image.setImageResource(R.drawable.number_6);  
            break;  
        case 7:  
            image.setImageResource(R.drawable.number_7);  
            break;  
        case 8:  
            image.setImageResource(R.drawable.number_8);  
            break;  
        case 9:  
            image.setImageResource(R.drawable.number_9);  
            break;  
        }  
        image.setLayoutParams(lp);  
        return image;  
    }  
  */
 /*   // ����λ����ʾ  
    private void updateLocation(Location location) {  
        if (location == null) {  
            mLocationTextView.setText(R.string.getting_location);  
        } else {  
            StringBuilder sb = new StringBuilder();  
            double latitude = location.getLatitude();  
            double longitude = location.getLongitude();  
  
            if (latitude >= 0.0f) {  
                sb.append(getString(R.string.location_north,  
                        getLocationString(latitude)));  
            } else {  
                sb.append(getString(R.string.location_south,  
                        getLocationString(-1.0 * latitude)));  
            }  
  
            sb.append("    ");  
  
            if (longitude >= 0.0f) {  
                sb.append(getString(R.string.location_east,  
                        getLocationString(longitude)));  
            } else {  
                sb.append(getString(R.string.location_west,  
                        getLocationString(-1.0 * longitude)));  
            }  
            mLocationTextView.setText(sb.toString());// ��ʾ��γ�ȣ���ʵ��������������룬��ʾ�����ַ  
        }  
    }  */
  
  /*  // �Ѿ�γ��ת���ɶȷ�����ʾ  
    private String getLocationString(double input) {  
        int du = (int) input;  
        int fen = (((int) ((input - du) * 3600))) / 60;  
        int miao = (((int) ((input - du) * 3600))) % 60;  
        return String.valueOf(du) + "��" + String.valueOf(fen) + "��"  
                + String.valueOf(miao) + "��";  
    }  */
  
    // ���򴫸����仯����  
    private SensorEventListener mOrientationSensorEventListener = new SensorEventListener() {  
  
        @Override  
        public void onSensorChanged(SensorEvent event) {  
            float direction = event.values[0] * -1.0f;  
            mTargetDirection = normalizeDegree(direction);// ��ֵ��ȫ�ֱ�������ָ������ת  
        }  
  
        @Override  
        public void onAccuracyChanged(Sensor sensor, int accuracy) {  
        }  
    };  
  
    // �������򴫸�����ȡ��ֵ  
    private float normalizeDegree(float degree) {  
        return (degree + 720) % 360;  
    }  
  
    // λ����Ϣ���¼���  
    /*LocationListener mLocationListener = new LocationListener() {  
  
        @Override  
        public void onStatusChanged(String provider, int status, Bundle extras) {  
            if (status != LocationProvider.OUT_OF_SERVICE) {  
                updateLocation(mLocationManager  
                        .getLastKnownLocation(mLocationProvider));  
            } else {  
                mLocationTextView.setText(R.string.cannot_get_location);  
            }  
        }  */
  
      /*  @Override  
        public void onProviderEnabled(String provider) {  
        }  
  
        @Override  
        public void onProviderDisabled(String provider) {  
        }  
  
        @Override  
        public void onLocationChanged(Location location) {  
            updateLocation(location);// ����λ��  
        }  
    }; */ 
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
    	// TODO Auto-generated method stub
    
    	return super.onMenuOpened(featureId, menu);
    
    	
    }
  //�˳�����
    @Override  
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
    // TODO Auto-generated method stub  
    if(keyCode == KeyEvent.KEYCODE_BACK)  
       {    
           exitBy2Click();      //����˫���˳�����  
       }  
    return false;  
    }  
    private static Boolean isExit = false;  

    private void exitBy2Click() {  
    Timer tExit = null;  
    if (isExit == false) {  
        isExit = true; // ׼���˳�  
        Toast.makeText(co.this, "�ٰ�һ���˳�����", Toast.LENGTH_SHORT).show();  
        tExit = new Timer();  
        tExit.schedule(new TimerTask() {  
            @Override  
            public void run() {  
                isExit = false; // ȡ���˳�  
            }  
        }, 3000); // ���2������û�а��·��ؼ�����������ʱ��ȡ�����ղ�ִ�е�����  

    } else {  
        finish();  
        System.exit(0);  
    }  
    }//�����˳����
}  