package com.mylp.pp.toolbar;


import java.io.UnsupportedEncodingException;

import com.mylp.R;
import com.mylp.pp.BaseString.BaseString;

import android.app.Activity;

import android.widget.Toolbar.OnMenuItemClickListener;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

public class TBClick implements OnMenuItemClickListener{

	Activity activity;
	public TBClick(Activity activity) {
		super();
		this.activity=activity;

	}

	@Override
	public boolean onMenuItemClick(MenuItem arg0) {
		 
		
		 
		switch (arg0.getItemId()) {
		
		case R.id.exit:
			System.exit(0);
			break;
		case R.id.about:
			try {
				Toast.makeText(activity, BaseString.decode(BaseString.s1), 1).show();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.vip:
			try {
				Toast.makeText(activity, BaseString.decode(BaseString.s2), 1).show();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.help:
			try {
				Toast.makeText(activity, BaseString.decode(BaseString.s3), 1).show();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		
		return false;
	}

}
