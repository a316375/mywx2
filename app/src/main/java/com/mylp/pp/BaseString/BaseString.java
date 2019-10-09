package com.mylp.pp.BaseString;


import java.io.UnsupportedEncodingException;

import com.mylp.R;

import android.util.Base64;
import android.widget.Toast;

public class BaseString {
 
	/**关于**/
	public static final String s1="57K+5ZOB572X55uYVjIuMArlhYjooYzniYgoMjAxNykK5L2c6ICF5b6u5L+h5Y+3Onh5eGNvZGU=";
	/**支持正版**/
	public static final String s2="5rOo5YaM56CB5q2j5Zyo5byA5Y+R5Lit";
	/**帮助**/
	public static final String s3="54K55Ye757u/6Imy5paH5a2X5Y+v5Lul6LCD5pW05pe26Ze0CueCueWHu+W7uumAoOaXtumXtOezu+e7n+iHquWKqOiuvue9ruWPguaVsArngrnlh7vkuIvliJfmoYbmiYvliqjorr7nva7lj4LmlbA=";
	
	/**触摸屏幕可以静止罗盘**/
	public static final String v1="6Kem5pG45bGP5bmV5Y+v5Lul6Z2Z5q2i572X55uY";
	/**建造时间:**/
	public static final String v2="5bu66YCg5pe26Ze0Og==";
	/**流年:**/
	public static final String v3="5rWB5bm0Og==";
	/**度数**/
	public static final String v4="5bqm5pWw";
	/**提示:此版本暂不支持替卦排盘**/
	public static final String v5="5o+Q56S6OuatpOeJiOacrOaaguS4jeaUr+aMgeabv+WNpuaOkuebmA==";
	/**设置时间太卡**/
	public static final String v6="6K6+572u5pe26Ze05aSq5Y2h";
	
	public static String getV1() throws UnsupportedEncodingException {
		return decode(v1);
	}
	public static String getV2() throws UnsupportedEncodingException {
		return decode(v2);
	}
	public static String getV3() throws UnsupportedEncodingException {
		return decode(v3);
	}
	public static String getV4() throws UnsupportedEncodingException {
		return decode(v4);
	}
	public static String getV5() throws UnsupportedEncodingException {
		return decode(v5);
	}
	public static String getV6() throws UnsupportedEncodingException {
		return decode(v6);
	}
	
	public static String getV7() throws UnsupportedEncodingException {
		return decode(v7);
	}
	
	/**说明:精品罗盘(请在百度应用下载正版)**/
	public static final String v7="57K+5ZOB572X55uYKOivt+WcqOeZvuW6puW6lOeUqOS4i+i9veato+eJiCk=";
	/****/
	public static final String v8="";
	/****/
	public static final String v9="";
	/****/
	public static final String v10="";

	
	/**转换base64
	 * @throws UnsupportedEncodingException */
	public static String encode(String str) throws UnsupportedEncodingException{
		return new String(Base64.encode(str.getBytes("UTF-8"), Base64.DEFAULT));
	}
	/**解密base64
	 * @throws UnsupportedEncodingException **/
	public static String decode(String str) throws UnsupportedEncodingException{
		return new String(Base64.decode(str.getBytes("UTF-8"), Base64.DEFAULT));
	}
}
