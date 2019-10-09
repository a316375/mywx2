package com.mylp.pp;

import java.util.Calendar;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class TimePickerDialog extends AlertDialog implements upTitle {

	private TimePicker mDateTimePicker;
	private Year y;
	private upTitle up;

	@SuppressWarnings("deprecation")
	public TimePickerDialog(Context context, final Year y, final int i) {
		super(context);

		up=(upTitle) context;//这里的context是Main自己,由于实现了接口,所以可以强制转型
		this.y = y;
		mDateTimePicker = new TimePicker(context, y,this,i);
		setView(mDateTimePicker);

		setButton("确定", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.out.println("-----" + y.getGety());
				
				if (i==1) 
				up.up();
				else up.up2();
			}
		});
		setButton2("取消", (OnClickListener) null);

		int s = y.getGety() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety();
		int s2 = y.getGety2() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety2();
		setTitle(i==1?"你查询的流年是:" +  s:"你建造时间的设置是:" +  s2);
		 
        
		y.setGety( s );
        y.setGety2( s2);
		 
		
		
	}


	@Override
	public void up() {
		setTitle("你查询的流年是:" + y.getGety());
		
	}


	@Override
	public void up2() {
		setTitle("你建造时间的设置是:" + y.getGety2());
	}

	 

}

