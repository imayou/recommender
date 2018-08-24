package com.ifa.recommender.util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by root on 3/28/17.
 */
public class StringUtil {
	public static int StringArrayDistinctedSize(String[] strings) {
		HashSet<String> strSet = new HashSet<String>();
		for (String string : strings) {
			String[] splited = string.split("\\s+");
			Collections.addAll(strSet, splited);
		}
		return strSet.size();
	}

	public static TreeSet<String> StringArrayDistincted(String[] strings) {
		TreeSet<String> strSet = new TreeSet<String>();
		for (String string : strings) {
			String[] splited = string.split("\\s+");
			Collections.addAll(strSet, splited);
		}
		return strSet;
	}

	public static String[] StringtoArray(String str) {
		TreeSet<String> strSet = new TreeSet<String>();
		String[] splited = str.split("\\s+");
		Collections.addAll(strSet, splited);
		return splited;
	}

	// 需要传入一个Object数组，然后返回去重后的数组
	public static String[] ifRepeat(String[] arr) {
		// 用来记录去除重复之后的数组长度和给临时数组作为下标索引
		int t = 0;
		// 临时数组
		String[] tempArr = new String[arr.length];
		// 遍历原数组
		for (int i = 0; i < arr.length; i++) {
			// 声明一个标记，并每次重置
			boolean isTrue = true;
			// 内层循环将原数组的元素逐个对比
			for (int j = i + 1; j < arr.length; j++) {
				// 如果发现有重复元素，改变标记状态并结束当次内层循环
				if (arr[i].equals(arr[j])) {
					isTrue = false;
					break;
				}
			}
			// 判断标记是否被改变，如果没被改变就是没有重复元素
			if (isTrue) {
				// 没有元素就将原数组的元素赋给临时数组
				tempArr[t] = arr[i];
				// 走到这里证明当前元素没有重复，那么记录自增
				t++;
			}
		}
		// 声明需要返回的数组，这个才是去重后的数组
		String[] newArr = new String[t];
		// 用arraycopy方法将刚才去重的数组拷贝到新数组并返回
		System.arraycopy(tempArr, 0, newArr, 0, t);
		return newArr;
	}

	// 需要传入一个Object数组，然后返回去重后的数组
	public static String[] setToArray(Set<String> strs) {
		return null;
	}

	public static double[] bubbleSort(double[] arr) {
		//int[] arr = { 12, 23, 34, 56, 56, 56, 78 };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {// -1为了防止溢出
				if (arr[j] > arr[j + 1]) {
					double temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}
}
