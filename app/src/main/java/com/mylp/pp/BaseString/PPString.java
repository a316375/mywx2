package com.mylp.pp.BaseString;

import java.io.UnsupportedEncodingException;

public class PPString {

	public static String strs[]=new String[7];
	
	public static String[] getStrs() {
		// TODO Auto-generated constructor stub
		try {
			strs[0]=BaseString.getV1();
			strs[1]=BaseString.getV2();
			strs[2]=BaseString.getV3();
			strs[3]=BaseString.getV4();
			strs[4]=BaseString.getV5();
			strs[5]=BaseString.getV6();
			strs[6]=BaseString.getV7();
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return strs;
	}

	 
	 
    
}
