package com.mylp;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;


	/** 
	 * �Զ���һ��View�̳�ImageView������һ��ͨ�õ���תͼƬ��Դ�ķ��� 
	 *  
	 * @author way 
	 *  
	 */  
	public class vp extends ImageView {  
	    private float mDirection;// ������ת������  
	    private Drawable compass;// ͼƬ��Դ  
	      
	    //����������  
	    public vp(Context context) {  
	        super(context);  
	        mDirection = 0.0f;// Ĭ�ϲ���ת  
	        compass = null;  
	    }  
	  
	    public vp(Context context, AttributeSet attrs) {  
	        super(context, attrs);  
	        mDirection = 0.0f;  
	        compass = null;  
	    }  
	  
	    public vp(Context context, AttributeSet attrs, int defStyle) {  
	        super(context, attrs, defStyle);  
	        mDirection = 0.0f;  
	        compass = null;  
	    }  
	  
	    @Override  
	    protected void onDraw(Canvas canvas) {  
	        if (compass == null) {  
	            compass = getDrawable();// ��ȡ��ǰview��ͼƬ��Դ  
	            compass.setBounds(0, 0, getWidth(), getHeight());// ͼƬ��Դ��view��λ�ã��˴��൱�ڳ���view  
	        }  
	  
	        canvas.save();  
	        canvas.rotate(mDirection, getWidth()/2 , getHeight() / 2);// ��ͼƬ���ĵ���ת��  
	        compass.draw(canvas);// ����ת���ͼƬ����view�ϣ���������ת�������  
	        canvas.restore();// ����һ��  
	    }  
	  
	    /** 
	     * �Զ�����·���ķ��� 
	     *  
	     * @param direction 
	     *            ����ķ��� 
	     */  
	    public void updateDirection(float direction) {  
	        mDirection = direction;  
	        invalidate();// ����ˢ��һ�£����·���  
	    }

		
			/**  
			   * ��Assets�ж�ȡͼƬ  
			   */  
			 public void   getImageFromAssetsFile(String fileName)  
			  {  
			      Bitmap image = null;  
			      AssetManager am = getResources().getAssets();  
			      try  
			      {  
			          InputStream is = am.open(fileName);  
			          image = BitmapFactory.decodeStream(is);  
			          is.close();  
			      }  
			      catch (IOException e)  
			      {  
			          e.printStackTrace();  
			      }  
			  
			      return;  
			  
			  }  
		  
	  
	}  

