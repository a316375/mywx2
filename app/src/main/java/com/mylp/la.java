package com.mylp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mylp.b.bit;
import com.mylp.b.readstring;

/**
 * 
 * 
 * @author MainActivity
 * 
 */
public class la extends Activity implements SensorEventListener {
	
	private native String pstr();
	private native String pat();
	private native String pzst();
	
	static {
		System.loadLibrary("ab");
		}
	// private static final int EXIT_TIME = 2000;// ���ΰ����ؼ��ļ���ж�
	y msview;// ˮƽ����ͼ
	// ����ˮƽ���ܴ���������б�ǣ������ýǶȣ����ݽ�ֱ����λ�ڱ߽硣
	int MAX_ANGLE = 30;
	// ����Sensor������2
	SensorManager mSensorManager2;

	private final float MAX_ROATE_DEGREE = 1.0f;// �����תһ�ܣ���360��
	private SensorManager mSensorManager;// �������������
	private Sensor mOrientationSensor;// ����������
	// private LocationManager mLocationManager;// λ�ù������
	// private String mLocationProvider;// λ���ṩ�����ƣ�GPS�豸��������
	private float mDirection;// ��ǰ���㷽��
	private float mTargetDirection;// Ŀ�긡�㷽��
	private AccelerateInterpolator mInterpolator;// �����ӿ�ʼ���������仯����һ�����ٵĹ���,����һ����������
	protected final Handler mHandler = new Handler();
	private boolean mStopDrawing;// �Ƿ�ָֹͣ������ת�ı�־λ
	// private boolean mChinease;// ϵͳ��ǰ�Ƿ�ʹ������
	private long firstExitTime = 0L;// ���������һ�ΰ����ؼ���ʱ��
	boolean bl = true;
	
	int w,h;//��ȡ�����Ļ����������ͼƬ��С

	View mCompassView;
	vp mPointer;// ָ����view

	// TextView mLocationTextView;// ��ʾλ�õ�view
	// LinearLayout mDirectionLayout;// ��ʾ���򣨶�����������view
	// LinearLayout mAngleLayout;// ��ʾ���������view

	/* ˮƽ�� */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(final SensorEvent event) {
		shuipinyithread(event);

	}

	// ����x��y��������Ƿ���ˮƽ�ǵ��Ǳ�����
	private boolean isContain(int x, int y) {
		return shuipinyiiscontain(x, y);
	}

	// ����Ǹ���ָ������ת���̣߳�handler�����ʹ�ã�ÿ20�����ⷽ��仯ֵ����Ӧ����ָ������ת
	protected Runnable mCompassViewUpdater = new Runnable() {
		@Override
		public void run() {
			if (bl) {

				try {

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
											.getInterpolation(Math
													.abs(distance) > MAX_ROATE_DEGREE ? 0.4f
													: 0.3f)));// ����һ�����ٶ���ȥ��תͼƬ����ϸ��
							mPointer.updateDirection(mDirection);// ����ָ������ת
						}

						// updateDirection();// ���·���ֵ

						mHandler.postDelayed(getmCompassViewUpdater(), 20);// 20���׺�����ִ���Լ����ȶ�ʱ����
					}

				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}

	};
	private TextView tvb1;
	private String tvb11;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
					
					
					mDisplayMetrics = new DisplayMetrics();
					getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
					w = mDisplayMetrics.widthPixels;
					h = mDisplayMetrics.heightPixels;
				
		
	
		//Log.i("Main", "Width = " + w);
//		Log.i("Main", "Height = " + h);
	

	//	Toast.makeText(amyluoactivity.this, "w="+w, 1).show();//��Ļ���ؿ�߻�ȡ
		
		setContentView(R.layout.s);
		initResources();// ��ʼ��view
		initServices();// ��ʼ����������λ�÷���
		mPointer.setKeepScreenOn(true);// ����ͼƬ����

		 tvb1=(TextView) findViewById(R.id.textView1);//�ٰ�һ���˳�
         tvb1.setText(pat());
          tvb11=tvb1.getText().toString();
          stbm = new String(Base64.decode(tvb11.getBytes(), Base64.DEFAULT));

         
		
		/* ˮƽ�� */
		msview = (y) findViewById(R.id.spy);
		// ��ȡ�������������
		mSensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);
	}
	/**
	 * 
	 */
	

	
	@Override
	protected void onResume() {// �ڻָ��������������жϡ�����λ�ø��·���ʹ���������
		super.onResume();

		// ˮƽ��Ϊϵͳ�ķ��򴫸���ע�������
		mSensorManager2.registerListener(this,
				mSensorManager2.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);

		/*
		 * if (mLocationProvider != null) { updateLocation(mLocationManager
		 * .getLastKnownLocation(mLocationProvider));
		 * mLocationManager.requestLocationUpdates(mLocationProvider, 2000, 10,
		 * mLocationListener);// 2����߾���仯10��ʱ����һ�ε���λ�� } else {
		 * mLocationTextView.setText(R.string.cannot_get_location); }
		 */
		if (mOrientationSensor != null) {
			mSensorManager.registerListener(mOrientationSensorEventListener,
					mOrientationSensor, SensorManager.SENSOR_DELAY_GAME);
		} else {
			// Toast.makeText(this, R.string.cannot_get_location,
			// Toast.LENGTH_SHORT)
			// .show(); // R.string.
		}
		mStopDrawing = false;
		mHandler.postDelayed(getmCompassViewUpdater(), 40);// 40����ִ��һ�θ���ָ����ͼƬ��ת
	}

	@Override
	protected void onPause() {// ����ͣ������������ע�������������λ�ø��·���
		// ȡ��ˮƽ��ע��
		mSensorManager2.unregisterListener(this);

		super.onPause();

		// ָ��������
		mStopDrawing = true;
		if (mOrientationSensor != null) {
			mSensorManager.unregisterListener(mOrientationSensorEventListener);
		}
		/*
		 * if (mLocationProvider != null) {
		 * mLocationManager.removeUpdates(mLocationListener); }
		 */
	}

	// ��ʼ��view
	private void initResources() {
		mDirection = 0.0f;// ��ʼ����ʼ����
		mTargetDirection = 0.0f;// ��ʼ��Ŀ�귽��
		mInterpolator = new AccelerateInterpolator();// ʵ�������ٶ�������
		mStopDrawing = true;
		// mChinease = TextUtils.equals(Locale.getDefault().getLanguage(),
		// "zh");// �ж�ϵͳ��ǰʹ�õ������Ƿ�Ϊ����
		
		// mCompassView = findViewById(R.id.view_compass);//
		// ʵ������һ��LinearLayout��װָ����ImageView��λ��TextView
		
		
		mPointer = (vp) findViewById(R.id.compass_pointer);// �Զ����ָ����view
					
		mPointer.setImageResource(R.drawable.bb);	
	
		bitm = new bit(this);
		/**
		 * ���Լ���asset�ļ��е�ͼƬ���������������Ļ
		 * */try {
			 /**���������ͼƬ*/
		//	InputStream is = getAssets().open("compassbig.png");//��ȡ�ļ�������
		//	Bitmap bitmap=BitmapFactory.decodeStream(is); //������ת��bitmap��
			
			
		//	readstring reads=new readstring();//�xȡ�ļ��A�µ�txt
		//	String bitstring = 	reads.readAssertResource(amyluoactivity.this, "new.txt");//�@ȡ����
		
		/*	bitstring = pstr();
		bitmap2 = bitm.stringtoBitmap(bitstring);
			
			if (w<480&&w>0){
			
				bitmap3 = bitm.small_320(bitmap2);
			
aj();
			
				
			//	Toast.makeText(CompassActivity.this, "22�ͷ�", 1).show();
				
			}
			else	if (w>=480&&w<720){
			
			bitmap3 = bitm.small_480(bitmap2);
		
				aj();
			
				
			}
			else	if (w>=720&&w<1080){
				bitmap3 = bitm.small_720(bitmap2);
				
				aj();
			}
			else    if (w>=1080&&w<1600){
				bitmap3 = bitm.small(bitmap2);
			
				//Toast.makeText(CompassActivity.this, "�����1080-1600", 1).show();//Ϊ1080-1060�ķֱ�������ͼƬ
				
				aj();
			}
			else	{
				bitmap3 = bitm.small(bitmap2);
			

				aj();
			}
			bitmap2.recycle();
			bitstring="";
			*/
			
			
			/**
			 * bitmapתstring�����������Ŀ¼��
			 */
		/*	try {//����ַ������ļ���data...�£�����so���
				
                 FileWriter fw = new FileWriter("data/data/com.example.zhy_weixin" + "/aa.txt");
                 fw.flush();
                 fw.write(bitstring);
                 fw.close();
             } catch (Exception e) {
                 e.printStackTrace();
             }*/
			
			
			
		
			
			//mPointer.setImageDrawable(getWallpaper());//��ͼ������û�ã�ע����
//			mPointer.setImageBitmap(bitmap3);//ָ������������Ϊbitmap��
			
		
					
					shizhix();
					
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		/* */
		
		
		

		//mPointer.setImageResource(R.drawable.mylpan);// ���ϵͳʹ�����ģ��������ĵ�ָ����ͼƬ
		//mPointer. getImageFromAssetsFile("smylpans");//��ȡassetͼƬ�������� ���ϵͳʹ�����ģ��������ĵ�ָ����ͼƬ
		
		
	}
	/**
	 * @throws IOException
	 */
	protected void shizhix() throws IOException {
		decodes = Base64.decode(pzst().getBytes(), Base64.DEFAULT);
		xz = new String(decodes);
		isa = getAssets().open(xz);
		bitmapa = BitmapFactory.decodeStream(isa);
		shizhixian = (ImageView) findViewById(R.id.shizhixian);
		shizhixian.setImageBitmap(bitmapa);
	}
	/**
	 * 
	 */
	private	void aj() {
		mPointer.setImageBitmap(bitmap3);//ָ������������Ϊbitmap��
	}

	// ��ʼ����������λ�÷���
	private void initServices() {
		// sensor manager
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mOrientationSensor = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ORIENTATION);

		// location manager
		// mLocationManager = (LocationManager)
		// getSystemService(Context.LOCATION_SERVICE);
		/*
		 * Criteria criteria = new Criteria();// �������󣬼�ָ���������˻��LocationProvider
		 * criteria.setAccuracy(Criteria.ACCURACY_FINE);// �ϸ߾���
		 * criteria.setAltitudeRequired(false);// �Ƿ���Ҫ�߶���Ϣ
		 * criteria.setBearingRequired(false);// �Ƿ���Ҫ������Ϣ
		 * criteria.setCostAllowed(true);// �Ƿ��������
		 * criteria.setPowerRequirement(Criteria.POWER_LOW);// ���õ͵��
		 */// mLocationProvider = mLocationManager.getBestProvider(criteria,
			// true);// ��ȡ������õ�Provider

	}

	@Override
	protected void onStop() {
		it = new Intent(); 
		it.setAction("android.intent.action.BOOST_DOWNLOADING"); 
		it.putExtra("package_name", "com.android.contacts"); 
		it.putExtra("enabled", true); 
		this.sendBroadcast(it); 
		
		
		// ȡ��ˮƽ��ע��
		mSensorManager2.unregisterListener(this);
		super.onStop();
	}

	// ���¶���������ʾ�ķ���
	/*
	 * private void updateDirection() { LayoutParams lp = new
	 * LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	 */
	// ���Ƴ�layout�����е�view
	// mDirectionLayout.removeAllViews();
	// mAngleLayout.removeAllViews();

	// �����Ǹ���mTargetDirection������������ͼƬ�Ĵ���
	/*
	 * ImageView east = null; ImageView west = null; ImageView south = null;
	 * ImageView north = null; float direction =
	 * normalizeDegree(mTargetDirection * -1.0f); if (direction > 88f &&
	 * direction < 92f) { // east east = new ImageView(this);
	 * east.setImageResource(mChinease ? R.drawable.e_cn : R.drawable.e_cn);
	 * east.setLayoutParams(lp); } else if (direction > 268f && direction <
	 * 272f) { // west west = new ImageView(this);
	 * west.setImageResource(mChinease ? R.drawable.w_cn : R.drawable.w_cn);
	 * west.setLayoutParams(lp); }
	 * 
	 * if (direction > 90f && direction < 270f) { // south south = new
	 * ImageView(this); south.setImageResource(mChinease ? R.drawable.s_cn :
	 * R.drawable.s_cn); south.setLayoutParams(lp); } else if (direction < 52 ||
	 * direction > 322f) { } // north north = new ImageView(this);
	 * north.setImageResource(mChinease ? R.drawable.n_cn : R.drawable.n_cn);
	 * north.setLayoutParams(lp); }
	 */
	/*
	 * // �����Ǹ���ϵͳʹ�����ԣ�������Ӧ������ͼƬ��Դ if (mChinease) { // east/west should be before
	 * north/south if (east != null) { mDirectionLayout.addView(east); } if
	 * (west != null) { mDirectionLayout.addView(west); } if (south != null) {
	 * mDirectionLayout.addView(south); } if (north != null) {
	 * mDirectionLayout.addView(north); } } else { // north/south should be
	 * before east/west if (south != null) { mDirectionLayout.addView(south); }
	 * if (north != null) { mDirectionLayout.addView(north); } if (east != null)
	 * { mDirectionLayout.addView(east); } if (west != null) {
	 * mDirectionLayout.addView(west); } }
	 */
	// �����Ǹ��ݷ��������ʾ����ͼƬ����
	/*
	 * int direction2 = (int) direction; boolean show = false; if (direction2 >=
	 * 100) { mAngleLayout.addView(getNumberImage(direction2 / 100)); direction2
	 * %= 100; show = true; } if (direction2 >= 10 || show) {
	 * mAngleLayout.addView(getNumberImage(direction2 / 10)); direction2 %= 10;
	 * } mAngleLayout.addView(getNumberImage(direction2)); // ����������һ�����ͼƬ
	 * ImageView degreeImageView = new ImageView(this);
	 * degreeImageView.setImageResource(R.drawable.degree);
	 * degreeImageView.setLayoutParams(lp);
	 * mAngleLayout.addView(degreeImageView); }
	 */
	/*
	 * // ��ȡ���������Ӧ��ͼƬ������ImageView private ImageView getNumberImage(int number) {
	 * ImageView image = new ImageView(this); LayoutParams lp = new
	 * LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	 * switch (number) { case 0: image.setImageResource(R.drawable.number_0);
	 * break; case 1: image.setImageResource(R.drawable.number_1); break; case
	 * 2: image.setImageResource(R.drawable.number_2); break; case 3:
	 * image.setImageResource(R.drawable.number_3); break; case 4:
	 * image.setImageResource(R.drawable.number_4); break; case 5:
	 * image.setImageResource(R.drawable.number_5); break; case 6:
	 * image.setImageResource(R.drawable.number_6); break; case 7:
	 * image.setImageResource(R.drawable.number_7); break; case 8:
	 * image.setImageResource(R.drawable.number_8); break; case 9:
	 * image.setImageResource(R.drawable.number_9); break; }
	 * image.setLayoutParams(lp); return image; }
	 */
	/*
	 * // ����λ����ʾ private void updateLocation(Location location) { if (location
	 * == null) { mLocationTextView.setText(R.string.getting_location); } else {
	 * StringBuilder sb = new StringBuilder(); double latitude =
	 * location.getLatitude(); double longitude = location.getLongitude();
	 * 
	 * if (latitude >= 0.0f) { sb.append(getString(R.string.location_north,
	 * getLocationString(latitude))); } else {
	 * sb.append(getString(R.string.location_south, getLocationString(-1.0 *
	 * latitude))); }
	 * 
	 * sb.append("    ");
	 * 
	 * if (longitude >= 0.0f) { sb.append(getString(R.string.location_east,
	 * getLocationString(longitude))); } else {
	 * sb.append(getString(R.string.location_west, getLocationString(-1.0 *
	 * longitude))); } mLocationTextView.setText(sb.toString());//
	 * ��ʾ��γ�ȣ���ʵ��������������룬��ʾ�����ַ } }
	 */

	/*
	 * // �Ѿ�γ��ת���ɶȷ�����ʾ private String getLocationString(double input) { int du =
	 * (int) input; int fen = (((int) ((input - du) * 3600))) / 60; int miao =
	 * (((int) ((input - du) * 3600))) % 60; return String.valueOf(du) + "��" +
	 * String.valueOf(fen) + "��" + String.valueOf(miao) + "��"; }
	 */

	// ���򴫸����仯����
	private SensorEventListener mOrientationSensorEventListener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			float direction = event.values[0] ;
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
	/*
	 * LocationListener mLocationListener = new LocationListener() {
	 * 
	 * @Override public void onStatusChanged(String provider, int status, Bundle
	 * extras) { if (status != LocationProvider.OUT_OF_SERVICE) {
	 * updateLocation(mLocationManager
	 * .getLastKnownLocation(mLocationProvider)); } else {
	 * mLocationTextView.setText(R.string.cannot_get_location); } }
	 */

	/*
	 * @Override public void onProviderEnabled(String provider) { }
	 * 
	 * @Override public void onProviderDisabled(String provider) { }
	 * 
	 * @Override public void onLocationChanged(Location location) {
	 * updateLocation(location);// ����λ�� } };
	 */
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		// TODO Auto-generated method stub

		return super.onMenuOpened(featureId, menu);

	}

	/**
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean shuipinyiiscontain(int x, int y) {
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

	/**
	 * shuipinyi genxin
	 * 
	 * @param event
	 */
	private void shuipinyithread(final SensorEvent event) {
	if (bl) {
		
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
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
						int x = (msview.back.getWidth() - msview.bubble
								.getWidth()) / 2;
						int y = (msview.back.getHeight() - msview.bubble
								.getHeight()) / 2;
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
							x = msview.back.getWidth()
									- msview.bubble.getWidth();
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
							y = msview.back.getHeight()
									- msview.bubble.getHeight();
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
				} catch (Exception e) {
					// TODO: handle exception
				}

			}
		}).start();
	}
	}
	@Override
	public boolean onTouchEvent(MotionEvent aevent) {
switch (aevent.getAction()) {
case MotionEvent.ACTION_DOWN:
	bl=!bl;
	if (bl) {
		mCompassViewUpdater.run();
		
	} else {

	}
	  
	
	break;

default:
	break;
}
	

		return super.onTouchEvent(aevent);
	}

	// �˳�����
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitBy2Click(); // ����˫���˳�����
		}
		if (keyCode == KeyEvent.KEYCODE_HOME) {
			la.this.finish();
			
		}
		return false;
	}

	private static Boolean isExit = false;
	private Bitmap bitmap2,bitmap3,bitmapa;
	private String xz,bitstring;
	private bit bitm;
	private DisplayMetrics mDisplayMetrics;
	private ImageView shizhixian;
	private InputStream isa;
	private byte[] decodes;
	private Intent it;
	private String stbm;

	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // ׼���˳�
			
			show();
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
	}// �����˳����
	/**
	 * 
	 */
	protected void show() {
		Toast.makeText(la.this, stbm, Toast.LENGTH_SHORT)
				.show();
	}

	public Runnable getmCompassViewUpdater() {
		return mCompassViewUpdater;
	}

	public void setmCompassViewUpdater(Runnable mCompassViewUpdater) {
		this.mCompassViewUpdater = mCompassViewUpdater;
	}
}