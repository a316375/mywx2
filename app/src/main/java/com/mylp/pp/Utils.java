package com.mylp.pp;

import java.util.ArrayList;
import java.util.Arrays;

import android.widget.TextView;

public class Utils {

	/**һ������ֵ,�����ж϶����Ƿ񳬹�15��,�ǵĻ����½���**/
	static float Chache = -1;

	/**��ʼ��ɽ�Ǹ�����**/
	static int up,down=0;
	
	private static int point;
	
	/***
	 * ���㵱�������</br>
	 * ÿ60��ļ��ӷֱ���1 4 7��ͷ,���� ��Ԫ����һ������Ԫ�����й�������Ԫ�߳����λ����������������
	 * ��Ԫ������ݣ�1864-1923�� 1864�Ǽ���;1��ͷ1-9-8-7-6��ʼ�� ע��:���Ź��ŷ���˳��
	 * @param time ��
	 **/
	public static int selectStart(int time) {
		time += 7;
		return 9 - (time % 9);// ���ص��������
	}

	/***
	 * * ����ĳĳ��ʲôԪ�˵���,20��һ������</br>
	 * ����1-9��9���� (i % 180) / 20 ƫ����i -= 4;
	 * @param time ��
	 **/
	public static int select(int time) {
		time -= 4;
		if ((time % 180) / 20 + 7 > 9)
			return (time % 180) / 20 - 2;
		return (time % 180) / 20 + 7;// ����ĳĳ������ʲôԪ��20��һ������
	}

	/**��������</br>
	 * 
	 * 2��Ԫ��������î��������Ǭ������������ 
	 * 1��Ԫ�����ﶡ������������������������ 
	 * 0��Ԫ������δ���������ɼױ���������
	 * ÿ45��һ��ѭ��,Ȼ��ƫ��7.5��,����2����,0/1 ��Ϊfalse ��Ϊture
	 * @param center �м�ֵ
	 **/
	public static boolean zYY(float f, Integer center,TextView tv) {
		f+=180;
		if(f>360)f-=360;
		 
		//���㱾λ�õ������,��0��1��2
		int three=setThreeYuan(f);
		
		try {
			 //����õ�5������ֱ�Ӽ���˳��
			if (center==5) {
				 f += 7.5f;
				 if (((f % 90) / 45) > 1){return true;}
				 else{ return false;}
			}else{
				//�����µ��㷨����˳��
				 
				//�õ�����ֵ��Ԫ���̵�λ��
				point = -1;
				//�õ�����ֵ,��������ֵ��Ԫ�����е��ĸ�λ��
				for (int i = 0; i < NumFactory.YDpan.length; i++) {
					if (NumFactory.YDpan[i]==center) {
						point=i;
					}
				}
				 
				
				
				//�鿴��Ӧ����Ԫ��������˵��ĸ�,���Ҹ���Ԫ���̵����������������
				//������ж����������Ϳ���,��Ϊȫ���������ʱ��,Ĭ�Ϸ���ture��
				//��0 ��1 ��2
				
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
//				if (point==0) System.out.println("��");
//				if (point==1) System.out.println("��");
//				if (point==2) System.out.println("��");
//				if (point==3) System.out.println("��");
//				if (point==4) System.out.println("��");
//				if (point==5) System.out.println("��");
//				if (point==6) System.out.println("��");
//				if (point==7) System.out.println("��");
//				if (point==8) System.out.println("Ǭ");
				 
			    return true;//��������
			    
			}
			
		} finally {
			//tv.setText("��"+center.toString()+":"+NumFactory.ThreeYuan[three]);
		}
		
		
	}
	/**�������</br>
	 * 
	 * 1��Ԫ��������î��������Ǭ������������ 
	 * 2��Ԫ�����ﶡ������������������������ 
	 * 0��Ԫ������δ���������ɼױ���������
	 * ÿ45��һ��ѭ��,Ȼ��ƫ��7.5��,����2����,0/1 ��Ϊfalse ��Ϊture
	 * @param center �м�ֵ
	 **/
	
	public static boolean xYY(float f, Integer center,TextView tv) {
		//���㱾λ�õ������,��0��1��2
		int three=setThreeYuan(f);
		
		try {
			//����õ�5������ֱ�Ӽ���˳��
			if (center==5) {
				f += 7.5f;
				if (((f % 90) / 45) > 1){return true;}
				else{ return false;}
			}else{
				//�����µ��㷨����˳��
				
				//�õ�����ֵ��Ԫ���̵�λ��
				point = -1;
				//�õ�����ֵ,��������ֵ��Ԫ�����е��ĸ�λ��
				for (int i = 0; i < NumFactory.YDpan.length; i++) {
					if (NumFactory.YDpan[i]==center) {
						point=i;
					}
				}

				
				
				//�鿴��Ӧ����Ԫ��������˵��ĸ�,���Ҹ���Ԫ���̵����������������
				//������ж����������Ϳ���,��Ϊȫ���������ʱ��,Ĭ�Ϸ���ture��
				//��0��1��2
				
				if (three==0) {
					if(point==0||point==2||point==6||point==8)return false;
				}
				if(three==1||three==2){
					if(point==1||point==3||point==5||point==7)return false;
				}
				
				return true;//��������
			}
			
		} finally {
			//tv.setText("��"+center.toString()+":"+NumFactory.ThreeYuan[three]);
		}
		
		
		
	}
	
	/**�����ǰ���������ڵĵ�����
	 * ��0 ��1 ��2
	 * **/
	
	private static int setThreeYuan(float f){
		
		f+=22.5f;
		if (f<0)f+=360;
		return (int) ((f%45)/15);
	}
	
	
	

	/****
	 * ������ɽһ��,���ӹ�Ϊ0 ÿ45��һ����,����0-7,ƫ��22.5�� 0��,1��,2��,3��,4��,5��,6��,7Ǭ
	 */
	public static int Gua(float f) {

		f += 22.5f;
		return (int) ((f % 360) / 45);
	}
	
	/****
	 * ����������λ�ø��Ź�������"��"�ֵ�position���Ƚ�
	 * </br>0��,1��,2��,3��,4��,5��,6��,7Ǭ
	 * </br>ת��Ϊ 0��,1��,2��,3��,4��,5��,6��,7��,8Ǭ
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
	 * �õ��м��ֵ,���ø��м������*
	 * *
	 * *�����ķ���: 0��,1��,2��,3��,4��,5��,6��,7Ǭ*
	 * * nums : 
	 * 0��,1��,2��,
	 * 3��,4�м�,5��,
	 * 6��,7��,8Ǭ
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
	 * �õ��м��ֵ,���ø��м��ɽ�� �õ��м��ֵ,���ø��м������ * 
	 * �����ķ���: 0��,1��,2��,3��,4��,5��,6��,7Ǭ
	 *  nums :  0��,1��,2��,
	 *          3��,4�м�,5��,
	 *          6��,7��,8Ǭ
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

	/** ���������������Ƿ�����ͬ��ɽ�ķ�Χ��,���û�����**/
	public static boolean Flag(float f) {
	
		f+= 7.5f;
		float date = (f % 360) / 15;
		if (Chache != date) {
			Chache = date;
			return true;
		}

		return false;
	}

	
	/***���Է�Χ</br>
	 * ÿ15��һ���ж�,9��6��������̵��㷨</br>
	 * ����1�����ķ�Χ</br>
	 * 00000000011111100000000111111***/
	public	static int showTS(float f){
		f+=4.5f;
		int y=(int) (f%15);
		if (y<9)return 0;
		else return 1;
	}
	
	 
}
