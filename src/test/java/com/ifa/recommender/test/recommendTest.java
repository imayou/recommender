package com.ifa.recommender.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.ifa.recommender.test.recommender.recommend;

/**
 * Created by legotime
 */
public class recommendTest {
	public static void main(String[] args) {
		// int[] a = {1,2,3,4};
		String[] pp = { "0310 0332 0334 0360 0361 0340 0362", "0310 0332 0360 0361 0364", "0310 0340 0330 0332 0364", "0310 0340 0330 0331 0364", "0310 0340 0330 0361",
				"0310 0340 0330 0332 0361" };
		String s = "0361 0332 0330";
		recommend rec = new recommend();

		String[] ps = { "0310", "0330", "0331", "0332", "0334", "0340", "0360", "0361", "0362", "0364" };
		String[] products = new String[100];
		for (int ii = 0; ii < 100; ii++) {
			int l = new Random().nextInt(5) + 4;
			// rand.nextInt(8 - 4 + 1) + 4;
			String[] pod = new String[l];
			for (int i = 0; i < l; i++) {
				int index = new Random().nextInt(10);
				pod[i] = ps[index];
			}
			StringBuilder astr = new StringBuilder();
			pod = (String[]) ifRepeat(pod);

			for (String string : pod) {
				astr.append(string + ", ");
			}
			System.err.println(astr.toString());
			products[ii] = astr.toString().substring(0, astr.length() - 2);
		}

		rec.fit(products);
		double[] doubles = rec.recommendFun(s);
		System.out.println(Arrays.toString(doubles));
		System.out.println(rec.getProduct());
		// [cake, cat, cate, coco, dog, pen, pie, water]
		// [0.0, 0.0, 0.0, 0.0, 0.8, 0.0, 0.0, 0.0]

		// 所以推荐 买了 pie cake pen cate 的人买 dog
	}

	// 需要传入一个Object数组，然后返回去重后的数组
	public static Object[] ifRepeat(Object[] arr) {
		// 用来记录去除重复之后的数组长度和给临时数组作为下标索引
		int t = 0;
		// 临时数组
		Object[] tempArr = new Object[arr.length];
		// 遍历原数组
		for (int i = 0; i < arr.length; i++) {
			// 声明一个标记，并每次重置
			boolean isTrue = true;
			// 内层循环将原数组的元素逐个对比
			for (int j = i + 1; j < arr.length; j++) {
				// 如果发现有重复元素，改变标记状态并结束当次内层循环
				if (arr[i] == arr[j]) {
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
		Object[] newArr = new Object[t];
		// 用arraycopy方法将刚才去重的数组拷贝到新数组并返回
		System.arraycopy(tempArr, 0, newArr, 0, t);
		return newArr;
	}
}