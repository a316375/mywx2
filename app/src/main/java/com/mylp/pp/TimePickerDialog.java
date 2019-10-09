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

		up=(upTitle) context;//�����context��Main�Լ�,����ʵ���˽ӿ�,���Կ���ǿ��ת��
		this.y = y;
		mDateTimePicker = new TimePicker(context, y,this,i);
		setView(mDateTimePicker);

		setButton("ȷ��", new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				System.out.println("-----" + y.getGety());
				
				if (i==1) 
				up.up();
				else up.up2();
			}
		});
		setButton2("ȡ��", (OnClickListener) null);

		int s = y.getGety() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety();
		int s2 = y.getGety2() == 0 ? Calendar.getInstance().get(Calendar.YEAR) : y.getGety2();
		setTitle(i==1?"���ѯ��������:" +  s:"�㽨��ʱ���������:" +  s2);
		 
        
		y.setGety( s );
        y.setGety2( s2);
		 
		
		
	}


	@Override
	public void up() {
		setTitle("���ѯ��������:" + y.getGety());
		
	}


	@Override
	public void up2() {
		setTitle("�㽨��ʱ���������:" + y.getGety2());
	}

	 

}

