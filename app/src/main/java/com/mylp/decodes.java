package com.mylp;

import android.util.Base64;

public class decodes {
	
	
	
	private native String pzst();
	public  decodes(String string ) {
		byte[] decodes=null;
		try {
			decodes = Base64.decode(pzst().getBytes(), Base64.DEFAULT);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return ;
	}
	
}
