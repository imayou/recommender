package com.ifa.recommender.test;

import java.util.Arrays;

import com.ifa.recommender.test.recommender.recommend;

/**
 * Created by legotime
 */
public class recommendTest {
    public static void main(String[] args) {
        //int[] a = {1,2,3,4};
        String[] products = {"0310 0332 0360 0361 0340 0362 ","0332 0360 0361","0340 0330 0332 0364","0340 0330 0331 0364","0340 0330 0361 0364","0340 0330 0332 0361"};
        String s = "0361 0332 0330";
        recommend rec = new recommend();
        rec.fit(products);
        double[] doubles = rec.recommendFun(s);
        System.out.println(Arrays.toString(doubles));
        System.out.println(rec.getProduct());
        //[cake, cat, cate, coco, dog, pen, pie, water]
        //[0.0, 0.0, 0.0, 0.0, 0.8, 0.0, 0.0, 0.0]

        //所以推荐　买了　pie cake pen cate　的人买 dog
    }
}