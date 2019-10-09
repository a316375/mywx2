package com.mylp;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.widget.ImageView;

public class s  extends la{
	private byte[] decodes;
	private String xz,bitstring;
	private InputStream isa;
	private Bitmap bitmap2,bitmap3,bitmapa;
	private ImageView shizhixian;
	

	void s(){

		bitmapa = BitmapFactory.decodeStream(isa);
		shizhixian = (ImageView) findViewById(R.id.shizhixian);
		shizhixian.setImageBitmap(bitmapa);
		
	}

}
