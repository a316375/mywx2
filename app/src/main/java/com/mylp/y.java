package com.mylp;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class y extends View {
	 // 定义水平仪仪表盘图片
    Bitmap back;
    // 定义水平仪中的气泡图标
    Bitmap bubble;
    // 定义水平仪中气泡 的X、Y座标
    int bubbleX, bubbleY;
    

    public y(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        
        // 加载水平仪图片和气泡图片
        back = BitmapFactory.decodeResource(getResources(), R.drawable.big);
       
        bubble = BitmapFactory
                .decodeResource(getResources(), R.drawable.small);
    }

    @Override
    protected void onDraw(Canvas canvas) {
    	
    	
        super.onDraw(canvas);
        // 绘制水平仪表盘图片
        canvas.drawBitmap(back,0,0, null);
       
        // 根据气泡座标绘制气泡
        canvas.drawBitmap(bubble, bubbleX, bubbleY, null);
    }
    
   
}


