package com.mylp.pp;

import java.util.ArrayList;
import java.util.Arrays;

import android.widget.TextView;

public class Utils {

	/**一个缓存值,用来判断度数是否超过15度,是的话更新界面**/
	static float Chache = -1;

	/**初始化山星跟坐星**/
	static int up,down=0;
	
	private static int point;
	
	/***
	 * 计算当年的流运</br>
	 * 每60年的甲子分别是1 4 7开头,逆推 上元甲子一白求、中元四绿中宫留、下元七赤居中位，逐年逆行是真宗
	 * 上元甲子年份：1864-1923年 1864是甲子;1开头1-9-8-7-6开始逆 注意:进九宫排法是顺飞
	 * @param time 年
	 **/
	public static int selectStart(int time) {
		time += 7;
		return 9 - (time % 9);// 返回当年的流运
	}

	/***
	 * * 计算某某年什么元运当令,20年一当令运</br>
	 * 返回1-9的9个运 (i % 180) / 20 偏移量i -= 4;
	 * @param time 年
	 **/
	public static int select(int time) {
		time -= 4;
		if ((time % 180) / 20 + 7 > 9)
			return (time % 180) / 20 - 2;
		return (time % 180) / 20 + 7;// 计算某某年属于什么元运20年一当令运
	}

	/**坐的阴阳</br>
	 * 
	 * 2天元龙，子午卯酉属阴，乾坤艮巽属阳。 
	 * 1人元龙，癸丁乙辛属阴，亥申寅巳属阳。 
	 * 0地元龙，戌未丑辰属阴，壬甲丙庚属阳。
	 * 每45度一个循环,然后偏移7.5度,返回2个数,0/1 阴为false 阳为ture
	 * @param center 中间值
	 **/
	public static boolean zYY(float f, Integer center,TextView tv) {
		f+=180;
		if(f>360)f-=360;
		 
		//计算本位置的天地人,地0天1人2
		int three=setThreeYuan(f);
		
		try {
			 //如果得到5则按阴阳直接计算顺逆
			if (center==5) {
				 f += 7.5f;
				 if (((f % 90) / 45) > 1){return true;}
				 else{ return false;}
			}else{
				//否则新的算法计算顺逆
				 
				//得到中心值在元旦盘的位置
				point = -1;
				//拿到中心值,计算中心值在元旦盘中的哪个位置
				for (int i = 0; i < NumFactory.YDpan.length; i++) {
					if (NumFactory.YDpan[i]==center) {
						point=i;
					}
				}
				 
				
				
				//查看对应的是元旦盘天地人的哪个,并且根据元旦盘的天地人来设置阴阳
				//这里的判断设置阴数就可以,因为全都不满足的时候,默认返回ture的
				//地0 天1 人2
				
//				if (three==0) {
//					if(point%2==0)return false;
//				}
//			    if(three==1||three==2){
//					if(point%2==1&&point!=5)return false;
//				}
				
				if (three==0) {
					if(point==0||point==2||point==6||point==8)return false;
				}
				if(three==1||three==2){
					if(point==1||point==3||point==5||point==7)return false;
				}
	// 
//				if (point==0) System.out.println("巽");
//				if (point==1) System.out.println("离");
//				if (point==2) System.out.println("坤");
//				if (point==3) System.out.println("震");
//				if (point==4) System.out.println("中");
//				if (point==5) System.out.println("兑");
//				if (point==6) System.out.println("艮");
//				if (point==7) System.out.println("坎");
//				if (point==8) System.out.println("乾");
				 
			    return true;//返回阳数
			    
			}
			
		} finally {
			//tv.setText("坐"+center.toString()+":"+NumFactory.ThreeYuan[three]);
		}
		
		
	}
	/**向的阴阳</br>
	 * 
	 * 1天元龙，子午卯酉属阴，乾坤艮巽属阳。 
	 * 2人元龙，癸丁乙辛属阴，亥申寅巳属阳。 
	 * 0地元龙，戌未丑辰属阴，壬甲丙庚属阳。
	 * 每45度一个循环,然后偏移7.5度,返回2个数,0/1 阴为false 阳为ture
	 * @param center 中间值
	 **/
	
	public static boolean xYY(float f, Integer center,TextView tv) {
		//计算本位置的天地人,地0天1人2
		int three=setThreeYuan(f);
		
		try {
			//如果得到5则按阴阳直接计算顺逆
			if (center==5) {
				f += 7.5f;
				if (((f % 90) / 45) > 1){return true;}
				else{ return false;}
			}else{
				//否则新的算法计算顺逆
				
				//得到中心值在元旦盘的位置
				point = -1;
				//拿到中心值,计算中心值在元旦盘中的哪个位置
				for (int i = 0; i < NumFactory.YDpan.length; i++) {
					if (NumFactory.YDpan[i]==center) {
						point=i;
					}
				}

				
				
				//查看对应的是元旦盘天地人的哪个,并且根据元旦盘的天地人来设置阴阳
				//这里的判断设置阴数就可以,因为全都不满足的时候,默认返回ture的
				//地0天1人2
				
				if (three==0) {
					if(point==0||point==2||point==6||point==8)return false;
				}
				if(three==1||three==2){
					if(point==1||point==3||point==5||point==7)return false;
				}
				
				return true;//返回阳数
			}
			
		} finally {
			//tv.setText("向"+center.toString()+":"+NumFactory.ThreeYuan[three]);
		}
		
		
		
	}
	
	/**算出当前度数所属于的地天人
	 * 地0 天1 人2
	 * **/
	
	private static int setThreeYuan(float f){
		
		f+=22.5f;
		if (f<0)f+=360;
		return (int) ((f%45)/15);
	}
	
	
	

	/****
	 * 计算三山一宫,壬子癸为0 每45度一个宫,返回0-7,偏移22.5度 0坎,1艮,2震,3巽,4离,5坤,6兑,7乾
	 */
	public static int Gua(float f) {

		f += 22.5f;
		return (int) ((f % 360) / 45);
	}
	
	/****
	 * 计算后天八卦位置给九宫格设置"向"字的position做比较
	 * </br>0坎,1艮,2震,3巽,4离,5坤,6兑,7乾
	 * </br>转换为 0巽,1离,2坤,3震,4空,5兑,6艮,7坎,8乾
	 */
	public static int Gua2(float f) {

		int i=Gua(f);
		if (i==0)return 7;
		if (i==1)return 6;
		if (i==2)return 3;
		if (i==3)return 0;
		if (i==4)return 1;
		if (i==5)return 2;
		if (i==6)return 5;
		if (i==7)return 8;
		
		return -1;
	}


	/**
	 * 拿到中间的值,设置给中间的向星*
	 * *
	 * *度数的返回: 0坎,1艮,2震,3巽,4离,5坤,6兑,7乾*
	 * * nums : 
	 * 0巽,1离,2坤,
	 * 3震,4中间,5兑,
	 * 6艮,7坎,8乾
	 */
	public static int setUp(ArrayList<Integer> nums, float f) {
		int gong = Gua(f);
		if (gong == 0)return nums.get(7);
		if (gong == 1)return nums.get(6);
		if (gong == 2)return nums.get(3);
		if (gong == 3)return nums.get(0);
		if (gong == 4)return nums.get(1);
		if (gong == 5)return nums.get(2);
		if (gong == 6)return nums.get(5);
		if (gong == 7)return nums.get(8);

		return 0;
	}

	/**
	 * 拿到中间的值,设置给中间的山星 拿到中间的值,设置给中间的向星 * 
	 * 度数的返回: 0坎,1艮,2震,3巽,4离,5坤,6兑,7乾
	 *  nums :  0巽,1离,2坤,
	 *          3震,4中间,5兑,
	 *          6艮,7坎,8乾
	 */
	public static int setDown(ArrayList<Integer> nums, float f) {

		int gong = Gua(f);
		if (gong == 0) return nums.get(1);
		if (gong == 1) return nums.get(2);
		if (gong == 2) return nums.get(5);
		if (gong == 3) return nums.get(8);
		if (gong == 4) return nums.get(7);
		if (gong == 5) return nums.get(6);
		if (gong == 6) return nums.get(3);
		if (gong == 7) return nums.get(0);

		return 0;
	}

	/** 这个开关用来检测是否落在同个山的范围内,内置缓存数**/
	public static boolean Flag(float f) {
	
		f+= 7.5f;
		float date = (f % 360) / 15;
		if (Chache != date) {
			Chache = date;
			return true;
		}

		return false;
	}

	
	/***替卦范围</br>
	 * 每15度一个判断,9跟6计算入兼盘的算法</br>
	 * 出现1代表兼的范围</br>
	 * 00000000011111100000000111111***/
	public	static int showTS(float f){
		f+=4.5f;
		int y=(int) (f%15);
		if (y<9)return 0;
		else return 1;
	}
	
	 
}
