package com.mylp.pp.toolbar;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class BTClick implements OnClickListener{

	@Override
	public void onClick(View v) {
		Toast.makeText(v.getContext(), "请静止罗盘后再去设置时间", 1).show();
	}

}
