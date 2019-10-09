package com.mylp.pp;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

public class SensorFactory {

	private static float[] accelerometerValues = new float[3];
	private static float[] magneticFieldValues = new float[3];

	
	
	public static SensorManager mSensorManager(Activity activity) {
		return (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);// 注册传感器的列表;
	}

	public static Sensor accelerometer(Activity activity) {
		return mSensorManager(activity).getDefaultSensor(Sensor.TYPE_ACCELEROMETER);// 加速度传感器

	}

	public static Sensor magnetic(Activity activity) {
		return mSensorManager(activity).getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD); // 地磁场传感器

	}

	public static float getF() {
		final float[] values = new float[3];
		float[] R = new float[9];
		SensorManager.getRotationMatrix(R, null, accelerometerValues, magneticFieldValues);
		SensorManager.getOrientation(R, values);
		values[0] = (float) Math.toDegrees(values[0]);
		 
		return values[0];

	}
}
