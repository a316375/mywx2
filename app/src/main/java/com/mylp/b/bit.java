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
        return bytetobitmap(bitstring); //�ֽ�תbitmap 
    }
	public Bitmap stringtoBitmap(String string){
	    return stringtobitmap(string);//����תbitmap
	    }
	
    public String bitmaptoString(Bitmap bitmap){
return bitmaptostring(bitmap);//bitmapתstring
    }
	/**
	 * bitmapתstring
	 * @param bitmap
	 * @return
	 */
	String bitmaptostring(Bitmap bitmap) {
		//��Bitmapת�����ַ���
		    String string=null;
		    ByteArrayOutputStream bStream=new ByteArrayOutputStream();
		    bitmap.compress(CompressFormat.PNG,100,bStream);
		    byte[]bytes=bStream.toByteArray();
		    string=Base64.encodeToString(bytes,Base64.DEFAULT);
		    return string;
	}





	/**
	 * stringתbitmap
	 * @param string
	 * @return
	 */
	
	
	Bitmap stringtobitmap(String string) {
		//���ַ���ת����Bitmap����
	    Bitmap bitmap=null;
	    
	    
  BitmapFactory.Options options = new BitmapFactory.Options();
	    options.inJustDecodeBounds = true;//�������Ϊtrue,������������null(û��ͼ),���뿪�������Խ�������,�����������������ڴ��λͼ��ѯ�����ء�
		options.inSampleSize=1;

		System.out.print(options.outHeight+"sss"+options.outWidth);

		options.inJustDecodeBounds = false;
	// options.inSampleSize = 2;  //����
  
	    
	     
	    
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
	  * �Ŵ���С   
	  * @param bitmap
	  * @return
	  */
	 public static Bitmap big(Bitmap bitmap) {
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(2f,2f); //���Ϳ�Ŵ���С�ı���
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }
	 public static Bitmap small_320(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.16f,0.16f); //���Ϳ�Ŵ���С�ı���
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  
	 public static Bitmap small_480(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.3f,0.3f); //���Ϳ�Ŵ���С�ı���
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  
	 public static Bitmap small_720(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.4f,0.4f); //���Ϳ�Ŵ���С�ı���
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  

	 public static Bitmap small(Bitmap bitmap) {
		 
		 
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.6f,0.6f); //���Ϳ�Ŵ���С�ı���
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  
	 public static Bitmap smallhalf(Bitmap bitmap) {
		  Matrix matrix = new Matrix(); 
		  matrix.postScale(0.8f,0.8f); //���Ϳ�Ŵ���С�ı���
		  Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
		  return resizeBmp;
		 }  



	/**
	 * byteתbitmap��ֹ�ڴ�oom/δ����
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
	
	
	
	
	


