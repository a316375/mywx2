package com.mylp.b;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.Base64;
import android.view.View;

public class bit extends View{
	
	
	
	public bit(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	public  Bitmap byteToBitmap(byte[] bitstring) {  
        return bytetobitmap(bitstring); //字节转bitmap 
    }
	public Bitmap stringtoBitmap(String string){
	    return stringtobitmap(string);//数据转bitmap
	    }
	
    public String bitmaptoString(Bitmap bitmap){
return bitmaptostring(bitmap);//bitmap转string
    }
	/**
	 * bitmap转string
	 * @param bitmap
	 * @return
	 */
	String bitmaptostring(Bitmap bitmap) {
		//将Bitmap转换成字符串
		    String string=null;
		    ByteArrayOutputStream bStream=new ByteArrayOutputStream();
		    bitmap.compress(CompressFormat.PNG,100,bStream);
		    byte[]bytes=bStream.toByteArray();
		    string=Base64.encodeToString(bytes,Base64.DEFAULT);
		    return string;
	}





	/**
	 * string转bitmap
	 * @param string
	 * @return
	 */
	
	
	Bitmap stringtobitmap(String string) {
		//将字符串转换成Bitmap类型
	    Bitmap bitmap=null;
	    
	    
  BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;//如果设置为true,译码器将返回null(没有图),但离开…领域仍将被设置,允许调用者无需分配内存的位图查询的像素。
		options.inSampleSize=1;

		System.out.print(options.outHeight+"sss"+options.outWidth);

		options.inJustDecodeBounds = false;
	// options.inSampleSize = 2;  //计算
  
	    
	     
	    
	    try {
	    byte[]bitmapArray;
	    bitmapArray=Base64.decode(string, Base64.DEFAULT);
	    
		   
	bitmap=BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length,options);
	 
	
	} catch (Exception e) {
		bitmap=null;
	e.printStackTrace();
	}
	   
	    return bitmap;
	}
	    
	 /**
	  * 放大缩小   
	  * @param bitmap
	  * @return
	  */
	 public static Bitmap big(Bitmap bitmap) {
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(2f,2f); //长和宽放大缩小的比例
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }
	 public static Bitmap small_320(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.16f,0.16f); //长和宽放大缩小的比例
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  
	 public static Bitmap small_480(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.3f,0.3f); //长和宽放大缩小的比例
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  
	 public static Bitmap small_720(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.4f,0.4f); //长和宽放大缩小的比例
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  

	 public static Bitmap small(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.6f,0.6f); //长和宽放大缩小的比例
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  
	 public static Bitmap smallhalf(Bitmap bitmap) {
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.8f,0.8f); //长和宽放大缩小的比例
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  



	/**
	 * byte转bitmap防止内存oom/未调用
	 * @param bitstring
	 * @return
	 */
public	 Bitmap bytetobitmap(byte[] bitstring) {
		InputStream input = null;  
        Bitmap bitmap = null;  
        BitmapFactory.Options options = new BitmapFactory.Options();  
//        options.inSampleSize = 8;  
        input = new ByteArrayInputStream(bitstring);  
        SoftReference softRef = new SoftReference(BitmapFactory.decodeStream(  
                input, null, options));  
        bitmap = (Bitmap) softRef.get();  
        if (bitstring != null) {  
            bitstring = null;  
        }  
  
        try {  
            if (input != null) {  
                input.close();  
            }  
        } catch (IOException e) {  
        	bitmap=null;
        	e.printStackTrace();  
        }  
        return bitmap;
	} }  
	
	
	
	
	


