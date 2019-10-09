package com.mylp;

import java.util.Timer;
import java.util.TimerTask;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.mylp.R;
import com.mylp.md5.md5;
import com.mylp.pp.Main;

/**
 * 
 * @author 1
 *
 */
public class ao extends AppCompatActivity {
	private Animation ropAnim;
	private LinearInterpolator ropLin;
	private ImageView Viewrop;

	public native String sgtba();

	public native String sgtbb();

	public native String sgtbc();

	public native String sgtbd();

	public native String sgtbe();

	public native String sgtbf();

	public native String sgtbg();

	public native String sgtbh();

	public native String sgtbi();

	public native String sgtbj();

	public native String sgtbk();// 按钮反馈

	public native String sgtbl();// 提示信息

	public native String sgtbm();// 点击进入

	public native String sgtbn();// 点击进退出
	
	public String pp="排盘模式";//玄空排盘;

	static {
		System.loadLibrary("a");
	}
	private TextView x, xb, xc, xd, xe, xf, xg, xh, xi, tvb1, tvb2, tvb3;

	private Button myButton = null;
	private Button Button1 = null;
	private Button Btpp = null;
	// String
	// gtba="https://item.taobao.com/item.htm?spm=686.1000925.0.0.WTzXwf&id=520951308978";
	static String gtba, gtbb, gtbc, gtbd, gtbe, gtbf, gtbg, gtbh, gtbi, tvb11, tvb12, tvb13;

	String o, oo;
	private String sbc;
	private TextView tvb5;
	private String tvb15;

	// String
	// gtbb="https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	/*
	 * String gtbc=
	 * "https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	 * String gtbd=
	 * "https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	 * String gtbe=
	 * "https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	 * String gtbf=
	 * "https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	 * String gtbg=
	 * "https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	 * String gtbh=
	 * "https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	 * String gtbi=
	 * "https://item.taobao.com/item.htm?spm=686.1000925.0.0.jsUreU&id=523134140335";
	 */ @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.abc_search_viw);

	}

	@Override
	protected void onStart() {
		super.onStart();

		ropAnim = AnimationUtils.loadAnimation(this, R.anim.rop);
		ropLin = new LinearInterpolator();
		ropAnim.setInterpolator(ropLin);

		/* 按钮网址 */
		x = (TextView) findViewById(R.id.textView1);
		x.setText(sgtbk());
		gtba = x.getText().toString();
		final String a = new String(Base64.decode(gtba.getBytes(), Base64.DEFAULT));// 解密base64字節轉換爲string

		xb = (TextView) findViewById(R.id.textView2);
		xb.setText(sgtbb());
		gtbb = xb.getText().toString();
		final String b = new String(Base64.decode(gtbb.getBytes(), Base64.DEFAULT));
		/*
		 * o=
		 * "https://item.taobao.com/item.htm?spm=a1z10.3-c.w4002-11791750679.83.pV1f2z&id=523134140335";
		 * oo=
		 * "https://item.taobao.com/item.htm?spm=a230r.7195193.1997079397.8.pDKS8R&id=520951308978&abbucket=11";
		 * String strBase64 = new String(Base64.encode(o.getBytes(),
		 * Base64.DEFAULT)); Log.i("Test", "encodo>>" + strBase64); String
		 * strBase64oo = new String(Base64.encode(oo.getBytes(),
		 * Base64.DEFAULT)); Log.i("Test", "encodoo>>" + strBase64oo);
		 */

		xc = (TextView) findViewById(R.id.textViewc);
		xc.setText(sgtbc());
		gtbc = xc.getText().toString();
		final String c = new String(Base64.decode(gtbc.getBytes(), Base64.DEFAULT));

		xd = (TextView) findViewById(R.id.textViewd);
		xd.setText(sgtbd());
		gtbd = xd.getText().toString();
		final String d = new String(Base64.decode(gtbd.getBytes(), Base64.DEFAULT));

		xe = (TextView) findViewById(R.id.textViewe);
		xe.setText(sgtbe());
		gtbe = xe.getText().toString();
		final String e = new String(Base64.decode(gtbe.getBytes(), Base64.DEFAULT));

		xf = (TextView) findViewById(R.id.textViewf);
		xf.setText(sgtbf());
		gtbf = xf.getText().toString();
		final String f = new String(Base64.decode(gtbf.getBytes(), Base64.DEFAULT));

		xg = (TextView) findViewById(R.id.textViewg);
		xg.setText(sgtbg());
		gtbg = xg.getText().toString();
		final String g = new String(Base64.decode(gtbg.getBytes(), Base64.DEFAULT));

		xh = (TextView) findViewById(R.id.textViewh);
		xh.setText(sgtbh());
		gtbh = xh.getText().toString();
		final String h = new String(Base64.decode(gtbh.getBytes(), Base64.DEFAULT));

		xi = (TextView) findViewById(R.id.textViewi);
		xi.setText(sgtbi());
		gtbi = xi.getText().toString();
		final String i = new String(Base64.decode(gtbi.getBytes(), Base64.DEFAULT));

		tvb1 = (TextView) findViewById(R.id.textView12);// 点击进入
		tvb1.setText(sgtbm());
		tvb11 = tvb1.getText().toString();
		final String stbm = new String(Base64.decode(tvb11.getBytes(), Base64.DEFAULT));// 解密base64字節轉換爲string

		tvb2 = (TextView) findViewById(R.id.textView13);// 点击退出
		tvb2.setText(sgtbn());
		tvb12 = tvb2.getText().toString();
		final String stbn = new String(Base64.decode(tvb12.getBytes(), Base64.DEFAULT));// 点击退出

		tv3 = (Button) findViewById(R.id.textView3);// 按钮设置文字

		tvb3 = (TextView) findViewById(R.id.textView14);// 点击退出
		tvb3.setText(sgtbl());
		tvb13 = tvb3.getText().toString();
		final String stv3 = new String(Base64.decode(tvb13.getBytes(), Base64.DEFAULT));// 设置按钮文字
		cc = ToSBC(stv3);
		tv3.setText(cc + "");

		tvb5 = (TextView) findViewById(R.id.textView15);// 文本内容
		tvb5.setText(sgtbj());
		tvb15 = tvb5.getText().toString();
		// 文本内容
		final String stb3 = new String(Base64.decode(tvb15.getBytes(), Base64.DEFAULT));
		sbc = ToSBC(stb3);

		tv3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				AlertDialog al = new AlertDialog.Builder(ao.this).create();
				al.setTitle(cc);
				al.setMessage(sbc);
				al.show();

				// Toast.makeText(ao.this, sbc, 1).show();
			}
		});

		// tv3.setText( sbc+"");

		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new ia(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				// Toast.makeText(activityone.this, "" +
				// position,Toast.LENGTH_SHORT).show();
				switch (position) {
				case 0:
					// Toast.makeText(activityone.this, "text",
					// Toast.LENGTH_LONG).show();
					Intent intenta = new Intent();
					intenta.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urla = Uri.parse(a);
					intenta.setData(content_urla);
					startActivity(intenta);

					break;
				case 1:
					Intent intentb = new Intent();
					intentb.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urlb = Uri.parse(b);
					intentb.setData(content_urlb);
					startActivity(intentb);
					break;
				case 2:
					Intent intentc = new Intent();
					intentc.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urlc = Uri.parse(c);
					intentc.setData(content_urlc);
					startActivity(intentc);
					break;
				case 3:
					Intent intentd = new Intent();
					intentd.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urld = Uri.parse(d);
					intentd.setData(content_urld);
					startActivity(intentd);
					break;

				case 4:
					Intent intente = new Intent();
					intente.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urle = Uri.parse(e);
					intente.setData(content_urle);
					startActivity(intente);
					break;
				case 5:
					Intent intentf = new Intent();
					intentf.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urlf = Uri.parse(f);
					intentf.setData(content_urlf);
					startActivity(intentf);
					break;

				case 6:
					Intent intentg = new Intent();
					intentg.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urlg = Uri.parse(g);
					intentg.setData(content_urlg);
					startActivity(intentg);
					break;
				case 7:
					Intent intenth = new Intent();
					intenth.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urlh = Uri.parse(h);
					intenth.setData(content_urlh);
					startActivity(intenth);
					break;
				case 8:
					Intent intenti = new Intent();
					intenti.setAction("android.intent.action.VIEW");
					// 以下这个监听为触发访问网络，uri的b是网址，b的数值从a获取，a的数值从so的strinFromJNI获取
					Uri content_urli = Uri.parse(i);
					intenti.setData(content_urli);
					startActivity(intenti);
					break;
				}

			}
		});

		// 引入图片
		Viewrop = (ImageView) findViewById(R.id.imageView23);
		// 绑定图片与动画效果
		Viewrop.startAnimation(ropAnim);
		ropAnim = AnimationUtils.loadAnimation(this, R.anim.rop);
		ropLin = new LinearInterpolator();
		ropAnim.setInterpolator(ropLin);

		// 引入图片
		Viewrop = (ImageView) findViewById(R.id.imageView11);
		// 绑定图片与动画效果
		Viewrop.startAnimation(ropAnim);
		ropAnim = AnimationUtils.loadAnimation(this, R.anim.ropa);
		ropLin = new LinearInterpolator();
		ropAnim.setInterpolator(ropLin);
		// 引入图片
		Viewrop = (ImageView) findViewById(R.id.imageView12);
		// 绑定图片与动画效果
		Viewrop.startAnimation(ropAnim);
		ropAnim = AnimationUtils.loadAnimation(this, R.anim.ropa);
		ropLin = new LinearInterpolator();
		ropAnim.setInterpolator(ropLin);
		// 引入图片
		Viewrop = (ImageView) findViewById(R.id.imageView12);
		// 绑定图片与动画效果
		Viewrop.startAnimation(ropAnim);

		myButton = (Button) findViewById(R.id.myButton);
		myButton.setText(stbm);
		myButton.setOnClickListener(new MyButtonListener());
		Button1 = (Button) findViewById(R.id.button1);
		Button1.setText(stbn);
		Button1.setOnClickListener(new Button.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				System.exit(0);

			}

		});
		
		
		
		//排盘模式
		Btpp=(Button) findViewById(R.id.textView4);
		Btpp.setText(pp);
		Btpp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(ao.this,Main.class));
				finish();
			}
		});
		
	}

	private String ToSBC(String stv3) {
		char c[] = stv3.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == ' ') {
				c[i] = '\u3000';
			} else if (c[i] < '\177') {
				c[i] = (char) (c[i] + 65248);
			}
		}
		return new String(c);

	}

	private void startAnimation(Animation translateAnimation2) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	class MyButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(ao.this, la.class);
			ao.this.startActivity(intent);
			// activityone.this.finish();

		}

	}

	@Override
	protected void onStop() {

		finish();
		super.onStop();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.about) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	// 退出代码
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			exitBy2Click(); // 调用双击退出函数
		}
		;
		return false;
	}

	/**
	 * 双击退出函数
	 */
	private static Boolean isExit = false;
	private Button tv3;
	private String cc;

	private void exitBy2Click() {
		Timer tExit = null;
		if (isExit == false) {
			isExit = true; // 准备退出
			// Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
			tExit = new Timer();
			tExit.schedule(new TimerTask() {
				@Override
				public void run() {
					isExit = false; // 取消退出
				}
			}, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

		} else {
			finish();
			System.exit(0);
		}
	}
}// 以上退出完毕