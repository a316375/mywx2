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

	final static String Num[] = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };
	 
	final static String[] GNum = { "巽", "离", "坤", "震", "", "兑", "艮", "坎", "乾"  };

	/**元旦盘数组**/
	final static int[] YDpan={4,9,2,3,5,7,8,1,6};
	/**Array格式的**/
	final static List<int[]> YDPan= Arrays.asList(YDpan);
	
	final static String[] ThreeYuan=new String[]{"地元龙","天元龙","人元龙"};
	 
	
	/**山**/
	private ArrayList<Integer> num1;// 山
	/**向**/
	private ArrayList<Integer> num2;// 向
	/**元令**/
	private ArrayList<Integer> num3;// 元令
	/**年令**/
	private ArrayList<Integer> num4;// 年令

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

	/**获取元令**/
	public ArrayList<Integer> getNum3() {
		return num3;
	}

	public void setNum3(ArrayList<Integer> num3) {
		this.num3 = num3;
	}

	/**获取年令**/
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

	/**排序山星
	 * @param i 九宫中间的值
	 * @param b true顺flase逆**/
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

	/**排序向星
	 * @param i 九宫中间的值
	 * @param b true顺flase逆****/
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

	/**排序元令**/
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

	/**排序年令**/
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
