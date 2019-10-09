package com.mylp.pp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.location.GpsStatus.NmeaListener;

public class NumFactory {

	static NumFactory factory = new NumFactory();

	public static NumFactory Creat() {
		return factory;
	}

	public NumFactory() {
		creatNums();
	}

	final static String Num[] = { "һ", "��", "��", "��", "��", "��", "��", "��", "��", "ʮ" };
	 
	final static String[] GNum = { "��", "��", "��", "��", "", "��", "��", "��", "Ǭ"  };

	/**Ԫ��������**/
	final static int[] YDpan={4,9,2,3,5,7,8,1,6};
	/**Array��ʽ��**/
	final static List<int[]> YDPan= Arrays.asList(YDpan);
	
	final static String[] ThreeYuan=new String[]{"��Ԫ��","��Ԫ��","��Ԫ��"};
	 
	
	/**ɽ**/
	private ArrayList<Integer> num1;// ɽ
	/**��**/
	private ArrayList<Integer> num2;// ��
	/**Ԫ��**/
	private ArrayList<Integer> num3;// Ԫ��
	/**����**/
	private ArrayList<Integer> num4;// ����

	public ArrayList<Integer> getNum1() {
		return num1;
	}

	public void setNum1(ArrayList<Integer> num1) {
		this.num1 = num1;
	}

	public ArrayList<Integer> getNum2() {
		return num2;
	}

	public void setNum2(ArrayList<Integer> num2) {
		this.num2 = num2;
	}

	/**��ȡԪ��**/
	public ArrayList<Integer> getNum3() {
		return num3;
	}

	public void setNum3(ArrayList<Integer> num3) {
		this.num3 = num3;
	}

	/**��ȡ����**/
	public ArrayList<Integer> getNum4() {
		return num4;
	}

	public void setNum4(ArrayList<Integer> num4) {
		this.num4 = num4;
	}

	public void creatNums() {
		if (num1 == null) {
			num1 = new ArrayList<Integer>();
			num2 = new ArrayList<Integer>();
			num3 = new ArrayList<Integer>();
			num4 = new ArrayList<Integer>();

			for (int i = 1; i <= 9; i++) {
				num1.add(i);
				num2.add(i);
				num3.add(i);
				num4.add(i);

			}
		}
	}

//	public ArrayList<Integer> sortNum1() {
//		return num1;
//	}
//
//	public ArrayList<Integer> sortNum2() {
//		return num2;
//	}
//
//	public ArrayList<Integer> sortNum3() {
//		return num3;
//	}

	/**����ɽ��
	 * @param i �Ź��м��ֵ
	 * @param b true˳flase��**/
	public void sortNum1(int i, boolean b) {
		i -= 1;
		if (b) {
			num1.set(0, (i + 8) % 9 + 1);
			num1.set(1, (i + 4) % 9 + 1);
			num1.set(2, (i + 6) % 9 + 1);
			num1.set(3, (i + 7) % 9 + 1);
			num1.set(4, (i) % 9 + 1);
			num1.set(5, (i + 2) % 9 + 1);
			num1.set(6, (i + 3) % 9 + 1);
			num1.set(7, (i + 5) % 9 + 1);
			num1.set(8, (i + 1) % 9 + 1);
		} else {
			num1.set(0, (i + 1) % 9 + 1);
			num1.set(1, (i + 5) % 9 + 1);
			num1.set(2, (i + 3) % 9 + 1);
			num1.set(3, (i + 2) % 9 + 1);
			num1.set(4, (i) % 9 + 1);
			num1.set(5, (i + 7) % 9 + 1);
			num1.set(6, (i + 6) % 9 + 1);
			num1.set(7, (i + 4) % 9 + 1);
			num1.set(8, (i + 8) % 9 + 1);

		}
	}

	/**��������
	 * @param i �Ź��м��ֵ
	 * @param b true˳flase��****/
	public void sortNum2(int i, boolean b) {
		i -= 1;
		if (b) {
			num2.set(0, (i + 8) % 9 + 1);
			num2.set(1, (i + 4) % 9 + 1);
			num2.set(2, (i + 6) % 9 + 1);
			num2.set(3, (i + 7) % 9 + 1);
			num2.set(4, (i) % 9 + 1);
			num2.set(5, (i + 2) % 9 + 1);
			num2.set(6, (i + 3) % 9 + 1);
			num2.set(7, (i + 5) % 9 + 1);
			num2.set(8, (i + 1) % 9 + 1);
		} else {
			num2.set(0, (i + 1) % 9 + 1);
			num2.set(1, (i + 5) % 9 + 1);
			num2.set(2, (i + 3) % 9 + 1);
			num2.set(3, (i + 2) % 9 + 1);
			num2.set(4, (i) % 9 + 1);
			num2.set(5, (i + 7) % 9 + 1);
			num2.set(6, (i + 6) % 9 + 1);
			num2.set(7, (i + 4) % 9 + 1);
			num2.set(8, (i + 8) % 9 + 1);

		}
	}

	/**����Ԫ��**/
	public void sortNum3(int i) {
		i -= 1;
		num3.set(0, (i + 8) % 9 + 1);
		num3.set(1, (i + 4) % 9 + 1);
		num3.set(2, (i + 6) % 9 + 1);
		num3.set(3, (i + 7) % 9 + 1);
		num3.set(4, (i) % 9 + 1);
		num3.set(5, (i + 2) % 9 + 1);
		num3.set(6, (i + 3) % 9 + 1);
		num3.set(7, (i + 5) % 9 + 1);
		num3.set(8, (i + 1) % 9 + 1);
	}

	/**��������**/
	public void sortNum4(int i) {
		i -= 1;
		num4.set(0, (i + 8) % 9 + 1);
		num4.set(1, (i + 4) % 9 + 1);
		num4.set(2, (i + 6) % 9 + 1);
		num4.set(3, (i + 7) % 9 + 1);
		num4.set(4, (i) % 9 + 1);
		num4.set(5, (i + 2) % 9 + 1);
		num4.set(6, (i + 3) % 9 + 1);
		num4.set(7, (i + 5) % 9 + 1);
		num4.set(8, (i + 1) % 9 + 1);

	}

}
