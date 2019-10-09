package com.mylp;

import java.util.Timer;
import java.util.TimerTask;







import com.mylp.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class gb extends AppCompatActivity {
	
	
	
	

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.d);
		
		 
		
		 final Animation rotate=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView iv=(ImageView)findViewById(R.id.imageView18);
		 final Animation l2=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivl2=(ImageView)findViewById(R.id.imageView12);
		 final Animation l3=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivl3=(ImageView)findViewById(R.id.imageView13);
		 final Animation l4=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivl4=(ImageView)findViewById(R.id.imageView14);
		 final Animation l5=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivl5=(ImageView)findViewById(R.id.imageView15);
		 final Animation l6=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivl6=(ImageView)findViewById(R.id.imageView16);
		 final Animation l7=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivl7=(ImageView)findViewById(R.id.imageView17);
		 final Animation l1=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivl1=(ImageView)findViewById(R.id.imageView11);
		 
		 
		 
		 final Animation rotateq=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivq=(ImageView)findViewById(R.id.imageView21);
		 final Animation rotate26=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView iv26=(ImageView)findViewById(R.id.imageView26);
		 final Animation rotate22=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView iv22=(ImageView)findViewById(R.id.imageView22);
		 final Animation rotate23=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView iv23=(ImageView)findViewById(R.id.imageView23);
		 final Animation rotate27=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView iv27=(ImageView)findViewById(R.id.imageView27);
		 final Animation rotate25=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView iv25=(ImageView)findViewById(R.id.imageView25);
		 final Animation rotate24=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView iv24=(ImageView)findViewById(R.id.imageView24);
         final Animation rotate1=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView iv1=(ImageView)findViewById(R.id.imageView28);
		 
		 //按钮2第二图
		 final Animation b21=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb21=(ImageView)findViewById(R.id.imageView21);
          final Animation b22=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb22=(ImageView)findViewById(R.id.imageView21);
     final Animation b23=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb23=(ImageView)findViewById(R.id.imageView21);
   final Animation b24=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb24=(ImageView)findViewById(R.id.imageView21);
    final Animation b25=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb25=(ImageView)findViewById(R.id.imageView21);
 final Animation b26=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb26=(ImageView)findViewById(R.id.imageView21);
final Animation b27=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb27=(ImageView)findViewById(R.id.imageView21);
 final Animation b28=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb28=(ImageView)findViewById(R.id.imageView21);
		
		 final Animation b121=AnimationUtils.loadAnimation(this,R.anim.a_a45);
		 final ImageView ivb121=(ImageView)findViewById(R.id.imageView11);
		 
          final Animation b122=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb122=(ImageView)findViewById(R.id.imageView12);
     
		 final Animation b123=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivb123=(ImageView)findViewById(R.id.imageView13);
  
		 final Animation b124=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb124=(ImageView)findViewById(R.id.imageView21);
   
		 final Animation b125=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb125=(ImageView)findViewById(R.id.imageView21);
 
		 final Animation b126=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb126=(ImageView)findViewById(R.id.imageView21);

		 final Animation b127=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivb127=(ImageView)findViewById(R.id.imageView21);

     final Animation b128=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb128=(ImageView)findViewById(R.id.imageView21);
		 
		 
		
		  //按钮3第二图

			
		 final Animation b3121=AnimationUtils.loadAnimation(this,R.anim.a_45);
		 final ImageView ivb3121=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b3122=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb3122=(ImageView)findViewById(R.id.imageView21);
     
		 final Animation b3123=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb3123=(ImageView)findViewById(R.id.imageView21);
  
		 final Animation b3124=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb3124=(ImageView)findViewById(R.id.imageView21);
   
		 final Animation b3125=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb3125=(ImageView)findViewById(R.id.imageView21);
 
		 final Animation b3126=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb3126=(ImageView)findViewById(R.id.imageView21);

		 final Animation b3127=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb3127=(ImageView)findViewById(R.id.imageView21);

     final Animation b3128=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb3128=(ImageView)findViewById(R.id.imageView21);
		 
		 
		 
		 final Animation b321=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivb321=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b322=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb322=(ImageView)findViewById(R.id.imageView21);
		 
     final Animation b323=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb323=(ImageView)findViewById(R.id.imageView21);
		 
   final Animation b324=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivb324=(ImageView)findViewById(R.id.imageView21);
		 
    final Animation b325=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivb325=(ImageView)findViewById(R.id.imageView21);
		 
 final Animation b326=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb326=(ImageView)findViewById(R.id.imageView21);
		 
final Animation b327=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb327=(ImageView)findViewById(R.id.imageView21);
		 
 final Animation b328=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivb328=(ImageView)findViewById(R.id.imageView21);
		 
		 
		 
		 //按钮4第二图
		 
		 
		 final Animation b421=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb421=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b422=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb422=(ImageView)findViewById(R.id.imageView21);
		 
     final Animation b423=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb423=(ImageView)findViewById(R.id.imageView21);
		 
   final Animation b424=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb424=(ImageView)findViewById(R.id.imageView21);
		 
    final Animation b425=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb425=(ImageView)findViewById(R.id.imageView21);
		 
 final Animation b426=AnimationUtils.loadAnimation(this,R.anim.a_45);
		 final ImageView ivb426=(ImageView)findViewById(R.id.imageView21);
		 
final Animation b427=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb427=(ImageView)findViewById(R.id.imageView21);
		 
 final Animation b428=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb428=(ImageView)findViewById(R.id.imageView21);
		 
		 
		 
		
		 final Animation b4121=AnimationUtils.loadAnimation(this,R.anim.a_135);
		 final ImageView ivb4121=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b4122=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb4122=(ImageView)findViewById(R.id.imageView21);
     
		 final Animation b4123=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb4123=(ImageView)findViewById(R.id.imageView21);
  
		 final Animation b4124=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb4124=(ImageView)findViewById(R.id.imageView21);
   
		 final Animation b4125=AnimationUtils.loadAnimation(this,R.anim.a_135 );
		 final ImageView ivb4125=(ImageView)findViewById(R.id.imageView21);
 
		 final Animation b4126=AnimationUtils.loadAnimation(this,R.anim.a_a135 );
		 final ImageView ivb4126=(ImageView)findViewById(R.id.imageView21);

		 final Animation b4127=AnimationUtils.loadAnimation(this,R.anim.a_a45 );
		 final ImageView ivb4127=(ImageView)findViewById(R.id.imageView21);

     final Animation b4128=AnimationUtils.loadAnimation(this,R.anim.a_45 );
		 final ImageView ivb4128=(ImageView)findViewById(R.id.imageView21);
		 
		 
		
		 
		 
		 //按钮5第二图
		 final Animation b521=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb521=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b522=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb522=(ImageView)findViewById(R.id.imageView21);
		 
     final Animation b523=AnimationUtils.loadAnimation(this,R.anim.a_180 );
		 final ImageView ivb523=(ImageView)findViewById(R.id.imageView21);
		 
   final Animation b524=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb524=(ImageView)findViewById(R.id.imageView21);
		 
    final Animation b525=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb525=(ImageView)findViewById(R.id.imageView21);
		 
 final Animation b526=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb526=(ImageView)findViewById(R.id.imageView21);
		 
final Animation b527=AnimationUtils.loadAnimation(this,R.anim.a_a180);
		 final ImageView ivb527=(ImageView)findViewById(R.id.imageView21);
		 
 final Animation b528=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb528=(ImageView)findViewById(R.id.imageView21);
		
		 final Animation b5121=AnimationUtils.loadAnimation(this,R.anim.a_a180);
		 final ImageView ivb5121=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b5122=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb5122=(ImageView)findViewById(R.id.imageView21);
     
		 final Animation b5123=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb5123=(ImageView)findViewById(R.id.imageView21);
  
		 final Animation b5124=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb5124=(ImageView)findViewById(R.id.imageView21);
   
		 final Animation b5125=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb5125=(ImageView)findViewById(R.id.imageView15);
 
		 final Animation b5126=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb5126=(ImageView)findViewById(R.id.imageView16);

		 final Animation b5127=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb5127=(ImageView)findViewById(R.id.imageView17);

     final Animation b5128=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb5128=(ImageView)findViewById(R.id.imageView18);
		 
		 
		 
		 
		 
		 //按钮6第二图
		 
		 final Animation b621=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb621=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b622=AnimationUtils.loadAnimation(this,R.anim.a_180);
		 final ImageView ivb622=(ImageView)findViewById(R.id.imageView22);
		 
     final Animation b623=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb623=(ImageView)findViewById(R.id.imageView23);
		 
   final Animation b624=AnimationUtils.loadAnimation(this,R.anim.a_180 );
		 final ImageView ivb624=(ImageView)findViewById(R.id.imageView24);
		 
    final Animation b625=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb625=(ImageView)findViewById(R.id.imageView25);
		 
 final Animation b626=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb626=(ImageView)findViewById(R.id.imageView26);
		 
final Animation b627=AnimationUtils.loadAnimation(this,R.anim.a_a90);
		 final ImageView ivb627=(ImageView)findViewById(R.id.imageView27);
		 
 final Animation b628=AnimationUtils.loadAnimation(this,R.anim.a_180 );
		 final ImageView ivb628=(ImageView)findViewById(R.id.imageView28);
		
		
		 
		 final Animation b6121=AnimationUtils.loadAnimation(this,R.anim.a_a90);
		 final ImageView ivb6121=(ImageView)findViewById(R.id.imageView11);
		 
          final Animation b6122=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb6122=(ImageView)findViewById(R.id.imageView12);
     
		 final Animation b6123=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb6123=(ImageView)findViewById(R.id.imageView13);
  
		 final Animation b6124=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb6124=(ImageView)findViewById(R.id.imageView14);
   
		 final Animation b6125=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb6125=(ImageView)findViewById(R.id.imageView15);
 
		 final Animation b6126=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb6126=(ImageView)findViewById(R.id.imageView16);

		 final Animation b6127=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb6127=(ImageView)findViewById(R.id.imageView17);

     final Animation b6128=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb6128=(ImageView)findViewById(R.id.imageView18);
		 
		 
		 //按钮7第二图
		 final Animation b721=AnimationUtils.loadAnimation(this,R.anim.a_a180 );
		 final ImageView ivb721=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b722=AnimationUtils.loadAnimation(this,R.anim.a_a90);
		 final ImageView ivb722=(ImageView)findViewById(R.id.imageView22);
		 
     final Animation b723=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb723=(ImageView)findViewById(R.id.imageView23);
		 
   final Animation b724=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb724=(ImageView)findViewById(R.id.imageView24);
		 
    final Animation b725=AnimationUtils.loadAnimation(this,R.anim.a_180 );
		 final ImageView ivb725=(ImageView)findViewById(R.id.imageView25);
		 
 final Animation b726=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb726=(ImageView)findViewById(R.id.imageView26);
		 
final Animation b727=AnimationUtils.loadAnimation(this,R.anim.a_0);
		 final ImageView ivb727=(ImageView)findViewById(R.id.imageView27);
		 
 final Animation b728=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb728=(ImageView)findViewById(R.id.imageView28);
		
		
		 
		 final Animation b7121=AnimationUtils.loadAnimation(this,R.anim.a_0);
		 final ImageView ivb7121=(ImageView)findViewById(R.id.imageView11);
		 
          final Animation b7122=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb7122=(ImageView)findViewById(R.id.imageView12);
     
		 final Animation b7123=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb7123=(ImageView)findViewById(R.id.imageView13);
  
		 final Animation b7124=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb7124=(ImageView)findViewById(R.id.imageView14);
   
		 final Animation b7125=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb7125=(ImageView)findViewById(R.id.imageView15);
 
		 final Animation b7126=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb7126=(ImageView)findViewById(R.id.imageView16);

		 final Animation b7127=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb7127=(ImageView)findViewById(R.id.imageView17);

     final Animation b7128=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb7128=(ImageView)findViewById(R.id.imageView18);
		 
		 
		 
		 
		 
		 
		 
		 //按钮8第二图
		 
		 final Animation b821=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb821=(ImageView)findViewById(R.id.imageView11);
		 
          final Animation b822=AnimationUtils.loadAnimation(this,R.anim.a_a90);
		 final ImageView ivb822=(ImageView)findViewById(R.id.imageView12);
		 
     final Animation b823=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb823=(ImageView)findViewById(R.id.imageView13);
		 
   final Animation b824=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb824=(ImageView)findViewById(R.id.imageView14);
		 
    final Animation b825=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb825=(ImageView)findViewById(R.id.imageView15);
		 
 final Animation b826=AnimationUtils.loadAnimation(this,R.anim.a_a90 );
		 final ImageView ivb826=(ImageView)findViewById(R.id.imageView16);
		 
final Animation b827=AnimationUtils.loadAnimation(this,R.anim.a_a90);
		 final ImageView ivb827=(ImageView)findViewById(R.id.imageView17);
		 
 final Animation b828=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb828=(ImageView)findViewById(R.id.imageView18);
		
		
		 
		 final Animation b8121=AnimationUtils.loadAnimation(this,R.anim.a_90);
		 final ImageView ivb8121=(ImageView)findViewById(R.id.imageView21);
		 
          final Animation b8122=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb8122=(ImageView)findViewById(R.id.imageView22);
     
		 final Animation b8123=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb8123=(ImageView)findViewById(R.id.imageView23);
  
		 final Animation b8124=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb8124=(ImageView)findViewById(R.id.imageView24);
   
		 final Animation b8125=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb8125=(ImageView)findViewById(R.id.imageView25);
 
		 final Animation b8126=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb8126=(ImageView)findViewById(R.id.imageView26);

		 final Animation b8127=AnimationUtils.loadAnimation(this,R.anim.a_90 );
		 final ImageView ivb8127=(ImageView)findViewById(R.id.imageView27);

     final Animation b8128=AnimationUtils.loadAnimation(this,R.anim.a_0 );
		 final ImageView ivb8128=(ImageView)findViewById(R.id.imageView28);
		 
		 
		 
		 
		 
	
		 
		 Button button11 =(Button)findViewById(R.id.button1);
			button11.setOnClickListener(new OnClickListener(){
				 @Override
			        public void onClick(View v) {
		                Intent intent =new Intent();
			            intent.setClass(gb.this, ma.class);        
			            gb.this.startActivity(intent);
			            gb.this.finish(); 
				
				
			}}
	
					);
		 
		 
		Button button1 =(Button)findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v){
				iv.startAnimation(rotate);
				
				ivl2.startAnimation(l2);
				ivl3.startAnimation(l3);
				ivl4.startAnimation(l4);
				ivl5.startAnimation(l5);
				ivl6.startAnimation(l6);
				ivl7.startAnimation(l7);
				ivl1.startAnimation(l1);
				
				ivq.startAnimation(rotateq);
				iv1.startAnimation(rotate1);
				iv26.startAnimation(rotate26);
				iv22.startAnimation(rotate22);
				iv23.startAnimation(rotate23);
				iv27.startAnimation(rotate27);
				iv25.startAnimation(rotate25);
				iv24.startAnimation(rotate24);
			}}
			);
			
		Button button2 =(Button)findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				ivb21.startAnimation(b21);
				ivb22.startAnimation(b22);
                ivb23.startAnimation(b23);
				ivb24.startAnimation(b24);
				ivb25.startAnimation(b25);
				ivb26.startAnimation(b26);
				ivb27.startAnimation(b27);
				ivb28.startAnimation(b28);
				
				ivb121.startAnimation(b121);
				ivb122.startAnimation(b122);
                ivb123.startAnimation(b123);
				ivb124.startAnimation(b124);
				ivb125.startAnimation(b125);
				ivb126.startAnimation(b126);
				ivb127.startAnimation(b127);
				ivb128.startAnimation(b128);
				
				
				
				
		}
		});
		
		Button button3 =(Button)findViewById(R.id.button3);
		button3.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				ivb321.startAnimation(b321);
				ivb322.startAnimation(b322);
                ivb323.startAnimation(b323);
				ivb324.startAnimation(b324);
				ivb325.startAnimation(b325);
				ivb326.startAnimation(b326);
				ivb327.startAnimation(b327);
				ivb328.startAnimation(b328);
				
				ivb3121.startAnimation(b3121);
				ivb3122.startAnimation(b3122);
                ivb3123.startAnimation(b3123);
				ivb3124.startAnimation(b3124);
				ivb3125.startAnimation(b3125);
				ivb3126.startAnimation(b3126);
				ivb3127.startAnimation(b3127);
				ivb3128.startAnimation(b3128);
				
				
				
				
		}
		});
		
		Button button4=(Button)findViewById(R.id.button4);
		button4.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				ivb421.startAnimation(b421);
				ivb422.startAnimation(b422);
                ivb423.startAnimation(b423);
				ivb424.startAnimation(b424);
				ivb425.startAnimation(b425);
				ivb426.startAnimation(b426);
				ivb427.startAnimation(b427);
				ivb428.startAnimation(b428);
				
				ivb4121.startAnimation(b4121);
				ivb4122.startAnimation(b4122);
                ivb4123.startAnimation(b4123);
				ivb4124.startAnimation(b4124);
				ivb4125.startAnimation(b4125);
				ivb4126.startAnimation(b4126);
				ivb4127.startAnimation(b4127);
				ivb4128.startAnimation(b4128);
				
				
				
				
		}
		});
		

		Button button5=(Button)findViewById(R.id.button5);
		button5.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				ivb521.startAnimation(b521);
				ivb522.startAnimation(b522);
                ivb523.startAnimation(b523);
				ivb524.startAnimation(b524);
				ivb525.startAnimation(b525);
				ivb526.startAnimation(b526);
				ivb527.startAnimation(b527);
				ivb528.startAnimation(b528);
				
				ivb5121.startAnimation(b5121);
				ivb5122.startAnimation(b5122);
                ivb5123.startAnimation(b5123);
				ivb5124.startAnimation(b5124);
				ivb5125.startAnimation(b5125);
				ivb5126.startAnimation(b5126);
				ivb5127.startAnimation(b5127);
				ivb5128.startAnimation(b5128);
				
				
				
				
		}
		});
		
		Button button6=(Button)findViewById(R.id.button6);
		button6.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				ivb621.startAnimation(b621);
				ivb622.startAnimation(b622);
                ivb623.startAnimation(b623);
				ivb624.startAnimation(b624);
				ivb625.startAnimation(b625);
				ivb626.startAnimation(b626);
				ivb627.startAnimation(b627);
				ivb628.startAnimation(b628);
				
				ivb6121.startAnimation(b6121);
				ivb6122.startAnimation(b6122);
                ivb6123.startAnimation(b6123);
				ivb6124.startAnimation(b6124);
				ivb6125.startAnimation(b6125);
				ivb6126.startAnimation(b6126);
				ivb6127.startAnimation(b6127);
				ivb6128.startAnimation(b6128);
				
				
				
				
		}
		});
		Button button7=(Button)findViewById(R.id.button7);
		button7.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				ivb721.startAnimation(b721);
				ivb722.startAnimation(b722);
                ivb723.startAnimation(b723);
				ivb724.startAnimation(b724);
				ivb725.startAnimation(b725);
				ivb726.startAnimation(b726);
				ivb727.startAnimation(b727);
				ivb728.startAnimation(b728);
				
				ivb7121.startAnimation(b7121);
				ivb7122.startAnimation(b7122);
                ivb7123.startAnimation(b7123);
				ivb7124.startAnimation(b7124);
				ivb7125.startAnimation(b7125);
				ivb7126.startAnimation(b7126);
				ivb7127.startAnimation(b7127);
				ivb7128.startAnimation(b7128);
				
				
				
				
		}
		});
		
		
		Button button8=(Button)findViewById(R.id.button7);
		button8.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v){
				
				ivb821.startAnimation(b821);
				ivb822.startAnimation(b822);
                ivb823.startAnimation(b823);
				ivb824.startAnimation(b824);
				ivb825.startAnimation(b825);
				ivb826.startAnimation(b826);
				ivb827.startAnimation(b827);
				ivb828.startAnimation(b828);
				
				ivb8121.startAnimation(b8121);
				ivb8122.startAnimation(b8122);
                ivb8123.startAnimation(b8123);
				ivb8124.startAnimation(b8124);
				ivb8125.startAnimation(b8125);
				ivb8126.startAnimation(b8126);
				ivb8127.startAnimation(b8127);
				ivb8128.startAnimation(b8128);
				
				
				
				
		}
		});

		button5.setOnClickListener( new Button.OnClickListener(){
			
			 @Override
			   public void onClick(View v) {
			   
				  
				 Intent intent =new Intent();
		            intent.setClass(gb.this, fi.class);        
		            gb.this.startActivity(intent);
		         

			   
	            }  
			   
			  });
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.about) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}




//退出代码
	@Override  
public boolean onKeyDown(int keyCode, KeyEvent event) {  
// TODO Auto-generated method stub  
if(keyCode == KeyEvent.KEYCODE_BACK)  
   {    
       exitBy2Click();      //调用双击退出函数  
   }  ;
return false;  
}  
/** 
* 双击退出函数 
*/  
private static Boolean isExit = false;  

private void exitBy2Click() {  
Timer tExit = null;  
if (isExit == false) {  
    isExit = true; // 准备退出  
    Toast.makeText(this, "再按一次退出程序返回", Toast.LENGTH_SHORT).show();  
    tExit = new Timer();  
    tExit.schedule(new TimerTask() {  
        @Override  
        public void run() {  
            isExit = false; // 取消退出  
        }  
    }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务  

} else {  
    finish();  
    System.exit(0);  
}  
}}//以上退出完毕

