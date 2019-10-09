package com.mylp.pp;

import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RelativeLayout.LayoutParams;

public class GV extends BaseAdapter {

	Activity a;
	NumFactory factory;
	int f;

	public GV(Activity a, NumFactory factory) {
		super();
		this.a = a;
		this.factory = factory;
	}

	public NumFactory getFactory() {
		return factory;
	}

	public void setFactory(NumFactory factory,float f) {
		this.factory = factory;
		this.f=Utils.Gua2(f);
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 9;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder h ;
		if (convertView == null) {
			RelativeLayout ll = GVrl(position);
			convertView=ll;
			h=new Holder();
			convertView.setTag(h);
			h.tv=(TextView) ll.findViewById(6);
			
		}else {
			h=(Holder) convertView.getTag();
			
		}

		if (position==f) {
			h.tv.setVisibility(View.VISIBLE);
		}else {
			h.tv.setVisibility(View.INVISIBLE);
		}
		
		return convertView;

	}

	private RelativeLayout GVrl(int position) {
		int id1 = 1;
		int id2 = 2;
		int id3 = 3;
		int id4 = 4;
		int id5 = 5;
		int id6 = 6;

		int width = a.getResources().getDisplayMetrics().widthPixels * 2 / 9;

		RelativeLayout ll = new RelativeLayout(a);
		ll.setLayoutParams(new AbsListView.LayoutParams(width, width));
		ll.setBackgroundColor(new Color().argb(155, 155, 155, 155));
		ll.setId(1000);

		TextView tv1 = new TextView(a);
		tv1.setText("" + factory.getNum1().get(position));
		tv1.setTextColor(Color.DKGRAY);
		tv1.setTextSize(20);
		tv1.setGravity(Gravity.CENTER);
		tv1.setHeight(width / 2);
		tv1.setWidth(width / 2);
		tv1.setId(id1);

		ll.addView(tv1);

		TextView tv2 = new TextView(a);
		tv2.setText("" + factory.getNum2().get(position));
		tv2.setTextColor(Color.DKGRAY);
		tv2.setTextSize(20);
		tv2.setGravity(Gravity.CENTER);

		tv2.setId(id2);

		LayoutParams params2 = new LayoutParams(width / 2, width / 2);
		params2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

		ll.addView(tv2, params2);

		TextView tv3 = new TextView(a);
		tv3.setText(NumFactory.Num[factory.getNum3().get(position)-1]);
		tv3.setTextColor(Color.BLACK);
		tv3.setTextSize(20);
		tv3.setGravity(Gravity.CENTER);

		tv3.setId(id3);
		tv3.getPaint().setFakeBoldText(true);
		LayoutParams params3 = new LayoutParams(width / 2, width / 2);
		// params3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		params3.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

		ll.addView(tv3, params3);

		TextView tv4 = new TextView(a);
		tv4.setText("" + factory.getNum4().get(position));
		tv4.setTextColor(Color.GREEN);
		tv4.setTextSize(20);
		tv4.setGravity(Gravity.CENTER);

		tv4.setId(id4);

		LayoutParams params4 = new LayoutParams(width / 2, width / 2);
		params4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		params4.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

		ll.addView(tv4, params4);

		TextView center = new TextView(a);
		center.setText("" + NumFactory.GNum[position]);
		center.setTextColor(Color.BLUE);
		center.setTextSize(20);
		center.setGravity(Gravity.CENTER);
		center.setId(id5);

		LayoutParams centerll = new LayoutParams(width, width);
		centerll.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		centerll.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

		ll.addView(center, centerll);
		
		
		TextView xian = new TextView(a);
		xian.setText("Ïò");
		xian.setTextColor(Color.YELLOW);
		xian.setTextSize(15);
		xian.setGravity(Gravity.CENTER);
		xian.setId(id6);	
		xian.setVisibility(View.INVISIBLE);
		xian.getPaint().setFakeBoldText(true);
		

		LayoutParams xianll = new LayoutParams(width/2, width/2);
		xianll.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		xianll.addRule(RelativeLayout.CENTER_VERTICAL);
		
		ll.addView(xian, xianll);
			

		return ll;
		
	}

}

class Holder {
	TextView tv1, tv2, tv3, tv4, tv;
}