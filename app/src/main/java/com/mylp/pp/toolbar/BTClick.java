package com.mylp.pp.toolbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class BTClick implements OnClickListener{

	@Override
	public void onClick(View v) {
		Toast.makeText(v.getContext(), "�뾲ֹ���̺���ȥ����ʱ��", 1).show();
	}

}
