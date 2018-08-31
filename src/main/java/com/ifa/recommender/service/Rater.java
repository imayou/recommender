package com.ifa.recommender.service;

import com.ifa.recommender.domain.Info;
import com.ifa.recommender.domain.Rating;

public class Rater {
	public Rating build(Info info) {
		Rating r = new Rating();
		r.cfAdd();
		r.ywAdd();
		r.jcAdd();
		r.zrAdd();
		r.zjAdd();
		if (info.getVtype2().contains("个人")) {
			r.jcAdd();
			r.ywAdd();
			r.setZr(0);
		} else if (info.getVtype2().contains("企业") || info.getVtype2().contains("机关")) {
			r.cfAdd();r.cfAdd();r.cfAdd();
			r.setZr(4);
			r.setZj(1);
		}
		// age
		int age = Integer.parseInt(info.getAge());
		if (age >= 18 && age < 25) {
			r.ywAdd();
			r.zjAdd();
		} else if (age >= 25 && age < 35) {
			r.ywAdd();r.ywAdd();
			r.zjAdd();
			r.jcAdd();
		} else if (age >= 35 && age <= 50) {
			r.ywAdd();r.ywAdd();r.ywAdd();
			r.zjAdd();r.zjAdd();
			r.setJc(5);
		} else if (age > 50) {
			r.setYw(3);
			r.setZj(4);
			r.setJc(4);
		}
		// address
		if (info.getAddress().contains(" ")) {

		} else if (info.getAddress().contains(" ")) {

		}
		// year
		int year = Integer.parseInt(info.getYear());
		if (year < 2) {
			r.setCf(4);
			r.setYw(4);
		}else if (year >= 2 &&year < 3) {
			r.setCf(4);
			r.setYw(3);
		} else if (year >= 3 && year < 6) {
			r.setCf(3);
			r.setYw(2);
		} else if (year >= 6 && year < 10) {
			r.setCf(2);
			r.setYw(3);
		} else if (year >= 10) {
			r.setCf(1);
			r.setYw(4);
		}
		if (info.getVtype().contains("挂车") || info.getVtype().contains("摩托") || info.getVtype().contains("拖拉")) {
			r.setCf(1);
			r.ywReduce();
			if (info.getVtype().contains("挂车")&&(info.getVtype2().contains("企业") || info.getVtype2().contains("机关"))) {
				r.zrAdd();
				r.setZj(1);
				r.cfAdd();
			}
		} else if (info.getVtype().contains("非营业")) {
			r.zrAdd();
			r.ywAdd();
		}else {
			if (info.getVtype2().contains("个人")) {
				r.setZr(1);
			}
			r.cfAdd();
		}
		return r;
	}
}
