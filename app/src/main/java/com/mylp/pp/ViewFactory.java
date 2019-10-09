package com.mylp.pp;

import com.mylp.R;
import com.mylp.pp.BaseString.PPString;
import com.mylp.pp.toolbar.BTClick;
import com.mylp.pp.toolbar.TBClick;
import com.mylp.pp.toolbar.toolbar;

import android.app.Activity;
import android.graphics.Color;

import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class ViewFactory {

	final static int ivid = 0x0000001;
	final static int tvid = 0x0000002;
	final static int spid = 0x0000003;
	final static int tsid = 0x0000004;
	final static int fzid = 0x0000005;
	private static String[] str;//�������õļ���
	static TextView tv1;//��ֹ��������
	private static ImageView iv;// ͼƬ
	private static TextView tv;// ����
	private static Spinner sp;// ѡ����
	private static TextView lltext;// ����ʱ��
	private static TextView sptext;// ����ʱ��
	private static GridView gv;// �Ź�view
	private static TextView ts;//��ʾ
	private static String[] provinces;// ����������
	private static TextView tvfz;//����˵��
	private static TextView tvfx;//������

	public static GridView getGv() {
		return gv;
	}

	public static TextView getsptext() {
		return sptext;
	}
	public static TextView gettvfz() {
		return tvfz;
	}
	
	public static TextView gettvfx() {
		return tvfx;
	}

	public static TextView getLL() {
		return lltext;
	}

	public static TextView getts() {
		return ts;
	}
	
	public static Spinner getSP() {
		return sp;
	}

	public static ImageView getIV() {
		return iv;
	}

	public static TextView getTV() {

		return tv;
	}
	
	public static View creat(Activity a) {
		
		int width = a.getResources().getDisplayMetrics().widthPixels * 2 / 3;
		str=PPString.getStrs();
		
		RelativeLayout rl = new RelativeLayout(a);
		rl.setBackgroundResource(R.drawable.prompt1);

		// �������ִ�����Ļ���Ծ�ֹ����
		
	    tv1 = new TextView(a);
		tv1.setTextSize(20);
		tv1.setText(str[0]);//������Ļ���Ծ�ֹ����
		tv1.setGravity(Gravity.CENTER);
		tv1.setTextColor(Color.BLUE);
		tv1.setId(tvid);

		RelativeLayout.LayoutParams p1 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		p1.topMargin = 20;
		p1.addRule(Gravity.CENTER);

		rl.addView(tv1, p1);

		sp = new Spinner(a);
		sp.setId(spid);

		// �������������
		
		provinces = new String[] { "һ��", "����", "����", "����", "����", "����", "����", "����", "����" };
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(a, android.R.layout.simple_spinner_item, provinces);// ������
		arrayAdapter.setDropDownViewResource(android.R.layout.select_dialog_item);// ��ʽ

		sp.setAdapter(arrayAdapter);// ����������

		RelativeLayout.LayoutParams psp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		psp.addRule(RelativeLayout.BELOW, tvid);
		psp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		psp.rightMargin = 20;

		rl.addView(sp, psp);

		// ����ʱ��

		sptext = new TextView(a);
		sptext.setText(str[1]);
		sptext.setTextSize(18);
		sptext.setTextColor(Color.BLACK);
		RelativeLayout.LayoutParams ptext = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		ptext.addRule(RelativeLayout.LEFT_OF, spid);
		ptext.addRule(RelativeLayout.BELOW, tvid);

		rl.addView(sptext, ptext);

		// ��������
		lltext = new TextView(a);
		lltext.setText(str[2]);
		lltext.setTextSize(18);
		lltext.setTextColor(Color.GREEN);
		RelativeLayout.LayoutParams llrl = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		llrl.addRule(RelativeLayout.ALIGN_LEFT);
		llrl.addRule(RelativeLayout.BELOW, tvid);
		llrl.leftMargin = 20;

		rl.addView(lltext, llrl);

		// ͼƬiv
		iv = new ImageView(a);
		iv.setImageResource(R.drawable.bb);
		iv.setId(ivid);

		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
				a.getResources().getDisplayMetrics().widthPixels * 3 / 4,
				a.getResources().getDisplayMetrics().widthPixels * 3 / 4);
		lp.addRule(Gravity.CENTER);
		lp.addRule(RelativeLayout.CENTER_HORIZONTAL);
		lp.addRule(RelativeLayout.CENTER_VERTICAL);

		rl.addView(iv, lp);
		
		
        
		
		TextView tvlin1=new TextView(a);
		tvlin1.setBackgroundColor(Color.RED);
		RelativeLayout.LayoutParams lin1 = new RelativeLayout.LayoutParams(2,width);
		lin1.addRule(Gravity.CENTER);
		lin1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		lin1.addRule(RelativeLayout.CENTER_VERTICAL);
		rl.addView(tvlin1,lin1);
		
		TextView tvlin2=new TextView(a);
		tvlin2.setBackgroundColor(Color.RED);
		RelativeLayout.LayoutParams lin2 = new RelativeLayout.LayoutParams(width,2);
		lin2.addRule(Gravity.CENTER);
		lin2.addRule(RelativeLayout.CENTER_HORIZONTAL);
		lin2.addRule(RelativeLayout.CENTER_VERTICAL);
		rl.addView(tvlin2,lin2);
		
		

		// ����textview
		tv = new TextView(a);
		tv.setTextSize(20);
		tv.setText(str[3]);
		tv.setGravity(Gravity.CENTER);
		tv.setTextColor(Color.BLUE);

		RelativeLayout.LayoutParams p2 = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		p2.addRule(RelativeLayout.ABOVE, ivid);
		p2.bottomMargin = 10;

		rl.addView(tv, p2);
		
		// ��ʾ
		
		ts = new TextView(a);
		ts.setTextSize(18);
		ts.setText(str[4]);
		ts.setGravity(Gravity.CENTER);
		ts.setTextColor(Color.BLUE);
		ts.setVisibility(View.INVISIBLE);//Ĭ������
		ts.setId(tsid);
		
		RelativeLayout.LayoutParams tsll = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT);
		tsll.addRule(RelativeLayout.BELOW, ivid);
		tsll.bottomMargin = 10;
		
		rl.addView(ts,  tsll);

		gv = new GridView(a);
		gv.setNumColumns(3);
		gv.setHorizontalSpacing(20);
		gv.setVerticalSpacing(10);

		

		RelativeLayout.LayoutParams p3 = new RelativeLayout.LayoutParams(width+ 40,width+ 20);
		p3.addRule(Gravity.CENTER);
		p3.addRule(RelativeLayout.CENTER_HORIZONTAL);
		p3.addRule(RelativeLayout.CENTER_VERTICAL);
		gv.setLayoutParams(p3);
		rl.addView(gv);

		
		Toolbar tb=new toolbar(a);
		Button bu=new Button(a);
		bu.setText(str[5]);
		bu.setTextSize(12);
		bu.setBackgroundResource(R.drawable.ca_1);
		bu.setOnClickListener(new BTClick());
		tb.addView(bu);
		tb.inflateMenu(R.menu.main);
		tb.setOnMenuItemClickListener(new TBClick(a));//��������˵�
		
		RelativeLayout.LayoutParams tbll = new RelativeLayout.LayoutParams(
				a.getResources().getDisplayMetrics().widthPixels,
				a.getResources().getDisplayMetrics().heightPixels/10);
		 
		tbll.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		tb.setLayoutParams(tbll);
		rl.addView(tb);
		
		
		// ��ʾ˵��
	   tvfz = new TextView(a);
	   tvfz.setTextSize(12);
	   tvfz.setText(str[3]);
	   tvfz.setGravity(Gravity.CENTER);
	   tvfz.setTextColor(Color.RED);
	   tvfz.setId(fzid);

	   RelativeLayout.LayoutParams tvbottonll = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
					RelativeLayout.LayoutParams.WRAP_CONTENT);
	   tvbottonll.addRule(RelativeLayout.BELOW, tsid);
	   tvbottonll.bottomMargin = 10;
 
	   rl.addView(tvfz, tvbottonll);
	  
	   // ��ʾ˵��,��
	   tvfx = new TextView(a);
	   tvfx.setTextSize(20);
	   tvfx.setGravity(Gravity.CENTER);
	   tvfx.setTextColor(Color.BLUE);
	   
	   
	   RelativeLayout.LayoutParams tvfxll = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
			   RelativeLayout.LayoutParams.WRAP_CONTENT);
	   tvfxll.addRule(RelativeLayout.BELOW, fzid);
	   tvfxll.bottomMargin = 10;
	   
	   rl.addView(tvfx, tvfxll);
		
		
		
		
		
		
		return rl;

	}

}
