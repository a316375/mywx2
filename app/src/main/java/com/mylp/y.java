package com.mylp;



import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class y extends View {
	 // ����ˮƽ���Ǳ���ͼƬ
    Bitmap back;
    // ����ˮƽ���е�����ͼ��
    Bitmap bubble;
    // ����ˮƽ�������� ��X��Y����
    int bubbleX, bubbleY;
    

    public y(Context context, AttributeSet attrs) {
        super(context, attrs);
        
        
        // ����ˮƽ��ͼƬ������ͼƬ
        back = BitmapFactory.decodeResource(getResources(), R.drawable.big);
       
        bubble = BitmapFactory
                .decodeResource(getResources(), R.drawable.small);
    }

    @Override
    protected void onDraw(Canvas canvas) {
    	
    	
        super.onDraw(canvas);
        // ����ˮƽ�Ǳ���ͼƬ
        canvas.drawBitmap(back,0,0, null);
       
        // �������������������
        canvas.drawBitmap(bubble, bubbleX, bubbleY, null);
    }
    
   
}


