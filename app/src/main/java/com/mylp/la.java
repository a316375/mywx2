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
	// private static final int EXIT_TIME = 2000;// 两次按返回键的间隔判断
	y msview;// 水平仪视图
	// 定义水平仪能处理的最大倾斜角，超过该角度，气泡将直接在位于边界。
	int MAX_ANGLE = 30;
	// 定义Sensor管理器2
	SensorManager mSensorManager2;

	private final float MAX_ROATE_DEGREE = 1.0f;// 最多旋转一周，即360°
	private SensorManager mSensorManager;// 传感器管理对象
	private Sensor mOrientationSensor;// 传感器对象
	// private LocationManager mLocationManager;// 位置管理对象
	// private String mLocationProvider;// 位置提供者名称，GPS设备还是网络
	private float mDirection;// 当前浮点方向
	private float mTargetDirection;// 目标浮点方向
	private AccelerateInterpolator mInterpolator;// 动画从开始到结束，变化率是一个加速的过程,就是一个动画速率
	protected final Handler mHandler = new Handler();
	private boolean mStopDrawing;// 是否停止指南针旋转的标志位
	// private boolean mChinease;// 系统当前是否使用中文
	private long firstExitTime = 0L;// 用来保存第一次按返回键的时间
	boolean bl = true;
	
	int w,h;//获取宽高屏幕做适配盘面图片大小

	View mCompassView;
	vp mPointer;// 指南针view

	// TextView mLocationTextView;// 显示位置的view
	// LinearLayout mDirectionLayout;// 显示方向（东南西北）的view
	// LinearLayout mAngleLayout;// 显示方向度数的view

	/* 水平仪 */
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}

	@Override
	public void onSensorChanged(final SensorEvent event) {
		shuipinyithread(event);

	}

	// 计算x、y点的气泡是否处于水平仪的仪表盘内
	private boolean isContain(int x, int y) {
		return shuipinyiiscontain(x, y);
	}

	// 这个是更新指南针旋转的线程，handler的灵活使用，每20毫秒检测方向变化值，对应更新指南针旋转
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
													: 0.3f)));// 用了一个加速动画去旋转图片，很细致
							mPointer.updateDirection(mDirection);// 更新指南针旋转
						}

						// updateDirection();// 更新方向值

						mHandler.postDelayed(getmCompassViewUpdater(), 20);// 20毫米后重新执行自己，比定时器好
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
	

	//	Toast.makeText(amyluoactivity.this, "w="+w, 1).show();//屏幕像素宽高获取
		
		setContentView(R.layout.s);
		initResources();// 初始化view
		initServices();// 初始化传感器和位置服务
		mPointer.setKeepScreenOn(true);// 保持图片常亮

		 tvb1=(TextView) findViewById(R.id.textView1);//再按一次退出
         tvb1.setText(pat());
          tvb11=tvb1.getText().toString();
          stbm = new String(Base64.decode(tvb11.getBytes(), Base64.DEFAULT));

         
		
		/* 水平仪 */
		msview = (y) findViewById(R.id.spy);
		// 获取传感器管理服务
		mSensorManager2 = (SensorManager) getSystemService(SENSOR_SERVICE);
	}
	/**
	 * 
	 */
	

	
	@Override
	protected void onResume() {// 在恢复的生命周期里判断、启动位置更新服务和传感器服务
		super.onResume();

		// 水平仪为系统的方向传感器注册监听器
		mSensorManager2.registerListener(this,
				mSensorManager2.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				SensorManager.SENSOR_DELAY_GAME);

		/*
		 * if (mLocationProvider != null) { updateLocation(mLocationManager
		 * .getLastKnownLocation(mLocationProvider));
		 * mLocationManager.requestLocationUpdates(mLocationProvider, 2000, 10,
		 * mLocationListener);// 2秒或者距离变化10米时更新一次地理位置 } else {
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
		mHandler.postDelayed(getmCompassViewUpdater(), 40);// 40毫秒执行一次更新指南针图片旋转
	}

	@Override
	protected void onPause() {// 在暂停的生命周期里注销传感器服务和位置更新服务
		// 取消水平仪注册
		mSensorManager2.unregisterListener(this);

		super.onPause();

		// 指南针下面
		mStopDrawing = true;
		if (mOrientationSensor != null) {
			mSensorManager.unregisterListener(mOrientationSensorEventListener);
		}
		/*
		 * if (mLocationProvider != null) {
		 * mLocationManager.removeUpdates(mLocationListener); }
		 */
	}

	// 初始化view
	private void initResources() {
		mDirection = 0.0f;// 初始化起始方向
		mTargetDirection = 0.0f;// 初始化目标方向
		mInterpolator = new AccelerateInterpolator();// 实例化加速动画对象
		mStopDrawing = true;
		// mChinease = TextUtils.equals(Locale.getDefault().getLanguage(),
		// "zh");// 判断系统当前使用的语言是否为中文
		
		// mCompassView = findViewById(R.id.view_compass);//
		// 实际上是一个LinearLayout，装指南针ImageView和位置TextView
		
		
		mPointer = (vp) findViewById(R.id.compass_pointer);// 自定义的指南针view
					
		mPointer.setImageResource(R.drawable.bb);	
	
		bitm = new bit(this);
		/**
		 * 尝试加载asset文件夹的图片，结果不能适配屏幕
		 * */try {
			 /**这是盘面的图片*/
		//	InputStream is = getAssets().open("compassbig.png");//获取文件输入流
		//	Bitmap bitmap=BitmapFactory.decodeStream(is); //输入流转换bitmap；
			
			
		//	readstring reads=new readstring();//讀取文件夾下的txt
		//	String bitstring = 	reads.readAssertResource(amyluoactivity.this, "new.txt");//獲取數據
		
		/*	bitstring = pstr();
		bitmap2 = bitm.stringtoBitmap(bitstring);
			
			if (w<480&&w>0){
			
				bitmap3 = bitm.small_320(bitmap2);
			
aj();
			
				
			//	Toast.makeText(CompassActivity.this, "22释放", 1).show();
				
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
			
				//Toast.makeText(CompassActivity.this, "你的是1080-1600", 1).show();//为1080-1060的分辨率设置图片
				
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
			 * bitmap转string，并且输出到目录下
			 */
		/*	try {//输出字符串到文件夹data...下，用于so打包
				
                 FileWriter fw = new FileWriter("data/data/com.example.zhy_weixin" + "/aa.txt");
                 fw.flush();
                 fw.write(bitstring);
                 fw.close();
             } catch (Exception e) {
                 e.printStackTrace();
             }*/
			
			
			
		
			
			//mPointer.setImageDrawable(getWallpaper());//截图？反正没用；注销了
//			mPointer.setImageBitmap(bitmap3);//指南针盘面设置为bitmap；
			
		
					
					shizhix();
					
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		/* */
		
		
		

		//mPointer.setImageResource(R.drawable.mylpan);// 如果系统使用中文，就用中文的指南针图片
		//mPointer. getImageFromAssetsFile("smylpans");//读取asset图片更加流畅 如果系统使用中文，就用中文的指南针图片
		
		
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
		mPointer.setImageBitmap(bitmap3);//指南针盘面设置为bitmap；
	}

	// 初始化传感器和位置服务
	private void initServices() {
		// sensor manager
		mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		mOrientationSensor = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ORIENTATION);

		// location manager
		// mLocationManager = (LocationManager)
		// getSystemService(Context.LOCATION_SERVICE);
		/*
		 * Criteria criteria = new Criteria();// 条件对象，即指定条件过滤获得LocationProvider
		 * criteria.setAccuracy(Criteria.ACCURACY_FINE);// 较高精度
		 * criteria.setAltitudeRequired(false);// 是否需要高度信息
		 * criteria.setBearingRequired(false);// 是否需要方向信息
		 * criteria.setCostAllowed(true);// 是否产生费用
		 * criteria.setPowerRequirement(Criteria.POWER_LOW);// 设置低电耗
		 */// mLocationProvider = mLocationManager.getBestProvider(criteria,
			// true);// 获取条件最好的Provider

	}

	@Override
	protected void onStop() {
		it = new Intent(); 
		it.setAction("android.intent.action.BOOST_DOWNLOADING"); 
		it.putExtra("package_name", "com.android.contacts"); 
		it.putExtra("enabled", true); 
		this.sendBroadcast(it); 
		
		
		// 取消水平仪注册
		mSensorManager2.unregisterListener(this);
		super.onStop();
	}

	// 更新顶部方向显示的方法
	/*
	 * private void updateDirection() { LayoutParams lp = new
	 * LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	 */
	// 先移除layout中所有的view
	// mDirectionLayout.removeAllViews();
	// mAngleLayout.removeAllViews();

	// 下面是根据mTargetDirection，作方向名称图片的处理
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
	 * // 下面是根据系统使用语言，更换对应的语言图片资源 if (mChinease) { // east/west should be before
	 * north/south if (east != null) { mDirectionLayout.addView(east); } if
	 * (west != null) { mDirectionLayout.addView(west); } if (south != null) {
	 * mDirectionLayout.addView(south); } if (north != null) {
	 * mDirectionLayout.addView(north); } } else { // north/south should be
	 * before east/west if (south != null) { mDirectionLayout.addView(south); }
	 * if (north != null) { mDirectionLayout.addView(north); } if (east != null)
	 * { mDirectionLayout.addView(east); } if (west != null) {
	 * mDirectionLayout.addView(west); } }
	 */
	// 下面是根据方向度数显示度数图片数字
	/*
	 * int direction2 = (int) direction; boolean show = false; if (direction2 >=
	 * 100) { mAngleLayout.addView(getNumberImage(direction2 / 100)); direction2
	 * %= 100; show = true; } if (direction2 >= 10 || show) {
	 * mAngleLayout.addView(getNumberImage(direction2 / 10)); direction2 %= 10;
	 * } mAngleLayout.addView(getNumberImage(direction2)); // 下面是增加一个°的图片
	 * ImageView degreeImageView = new ImageView(this);
	 * degreeImageView.setImageResource(R.drawable.degree);
	 * degreeImageView.setLayoutParams(lp);
	 * mAngleLayout.addView(degreeImageView); }
	 */
	/*
	 * // 获取方向度数对应的图片，返回ImageView private ImageView getNumberImage(int number) {
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
	 * // 更新位置显示 private void updateLocation(Location location) { if (location
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
	 * 显示经纬度，其实还可以作反向编译，显示具体地址 } }
	 */

	/*
	 * // 把经纬度转换成度分秒显示 private String getLocationString(double input) { int du =
	 * (int) input; int fen = (((int) ((input - du) * 3600))) / 60; int miao =
	 * (((int) ((input - du) * 3600))) % 60; return String.valueOf(du) + "°" +
	 * String.valueOf(fen) + "′" + String.valueOf(miao) + "″"; }
	 */

	// 方向传感器变化监听
	private SensorEventListener mOrientationSensorEventListener = new SensorEventListener() {

		@Override
		public void onSensorChanged(SensorEvent event) {
			float direction = event.values[0] ;
			mTargetDirection = normalizeDegree(direction);// 赋值给全局变量，让指南针旋转
		}

		@Override
		public void onAccuracyChanged(Sensor sensor, int accuracy) {
		}
	};

	// 调整方向传感器获取的值
	private float normalizeDegree(float degree) {
		return (degree + 720) % 360;
	}

	// 位置信息更新监听
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
	 * updateLocation(location);// 更新位置 } };
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
		// 计算气泡的圆心座标X、Y
		int bubbleCx = x + msview.bubble.getWidth() / 2;
		int bubbleCy = y + msview.bubble.getWidth() / 2;
		// 计算水平仪仪表盘的圆心座标X、Y
		int backCx = msview.back.getWidth() / 2;
		int backCy = msview.back.getWidth() / 2;
		// 计算气泡的圆心与水平仪仪表盘的圆心之间的距离。
		double distance = Math.sqrt((bubbleCx - backCx) * (bubbleCx - backCx)
				+ (bubbleCy - backCy) * (bubbleCy - backCy));
		// 若两个圆心的距离小于它们的半径差，即可认为处于该点的气泡依然位于仪表盘内
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
					// 获取触发event的传感器类型
					int sensorType = event.sensor.getType();
					switch (sensorType) {
					case Sensor.TYPE_ORIENTATION:
						// 获取与Y轴的夹角
						float yAngle = values[1];
						// 获取与Z轴的夹角
						float zAngle = values[2];
						// 气泡位于中间时（水平仪完全水平），气泡的X、Y座标
						int x = (msview.back.getWidth() - msview.bubble
								.getWidth()) / 2;
						int y = (msview.back.getHeight() - msview.bubble
								.getHeight()) / 2;
						// 如果与Z轴的倾斜角还在最大角度之内
						if (Math.abs(zAngle) <= MAX_ANGLE) {
							// 根据与Z轴的倾斜角度计算X座标的变化值（倾斜角度越大，X座标变化越大）
							int deltaX = (int) ((msview.back.getWidth() - msview.bubble
									.getWidth()) / 2 * zAngle / MAX_ANGLE);
							x += deltaX;
						}
						// 如果与Z轴的倾斜角已经大于MAX_ANGLE，气泡应到最左边
						else if (zAngle > MAX_ANGLE) {
							x = 0;
						}
						// 如果与Z轴的倾斜角已经小于负的MAX_ANGLE，气泡应到最右边
						else {
							x = msview.back.getWidth()
									- msview.bubble.getWidth();
						}
						// 如果与Y轴的倾斜角还在最大角度之内
						if (Math.abs(yAngle) <= MAX_ANGLE) {
							// 根据与Y轴的倾斜角度计算Y座标的变化值（倾斜角度越大，Y座标变化越大）
							int deltaY = (int) ((msview.back.getHeight() - msview.bubble
									.getHeight()) / 2 * yAngle / MAX_ANGLE);
							y += deltaY;
						}
						// 如果与Y轴的倾斜角已经大于MAX_ANGLE，气泡应到最下边
						else if (yAngle > MAX_ANGLE) {
							y = msview.back.getHeight()
									- msview.bubble.getHeight();
						}
						// 如果与Y轴的倾斜角已经小于负的MAX_ANGLE，气泡应到最右边
						else {
							y = 0;
						}
						// 如果计算出来的X、Y座标还位于水平仪的仪表盘内，更新水平仪的气泡座标
						if (isContain(x, y)) {
							msview.bubbleX = x;
							msview.bubbleY = y;
						}
						// 通知系统重回MyView组件
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

	// 退出代码
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitBy2Click(); // 调用双击退出函数
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
			isExit = true; // 准备退出
			
			show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 3000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

		} else {
			finish();
			System.exit(0);
		}
	}// 以上退出完毕
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