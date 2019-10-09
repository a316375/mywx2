package com.mylp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.mylp.R;

 
public class ma extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ba);
		Button updateBtn = (Button) findViewById(R.id.btnUpdate);
		updateBtn.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				UpdateManager manager = new UpdateManager(ma.this);
				// �?查软件更�?
				manager.checkUpdate();
			}
		});
 
	}
}