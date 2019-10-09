package com.mylp.pp;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.mylp.R;

import android.app.AlertDialog;
import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Click {

	public static void onClick(final TextView ll, final Year y, final int i) {
		((upTitle) ll.getContext()).up();// 接口的up方法调用一次,设置文字

		ll.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				TimePickerDialog dialog = new TimePickerDialog(ll.getContext(), y, i);

				dialog.show();
			}

		});

	}

	 

	public static void onClick(final Spinner sp, final NumFactory factory, final GV gvDate, final GridView gv,final float value) {
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				//Toast.makeText(sp.getContext(), "设置成功:" + sp.getSelectedItem().toString(), 0).show();// 弹出选中的text
			
				//刷新卡牌,第二个控件选择元旦盘的排盘,排盘还需要在sp中去设置一遍;
				factory.sortNum3(position+1);
				gvDate.setFactory(factory,value);
				gv.setAdapter(gvDate);
				
				((Main)sp.getContext()).refresh();
			
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});

	}

}
