package com.mylp.pp;

import java.util.Calendar;

import com.mylp.R;

import android.content.Context;
import android.text.format.DateFormat;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

public class TimePicker extends FrameLayout  {
	private final NumberPicker mDateSpinner;
	private Calendar mDate;
	 
	public TimePicker(Context context, final Year y, final upTitle upt, final int i) {
		super(context);
		 
		mDate = Calendar.getInstance();

		inflate(context, R.layout.datedialog, this);

		mDateSpinner = (NumberPicker) this.findViewById(R.id.np_date);
		mDateSpinner.setMinValue(0);
		mDateSpinner.setMaxValue(20000);
		int s = y.getGety() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety();
		int s2 = y.getGety2() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety2();
		mDateSpinner.setValue(i==1?s:s2);// 获取当前年
		
		
		mDateSpinner.setOnValueChangedListener(new OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				 if (i==1) {
					 y.setGety(newVal);
						upt.up();
				}else{
					 y.setGety2(newVal);
					upt.up2();
					}
				 
			}
		});
	}

	
	 
}


 


