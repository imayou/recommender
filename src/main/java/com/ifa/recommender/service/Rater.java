package com.ifa.recommender.service;

import com.ifa.recommender.domain.Info;
import com.ifa.recommender.domain.Rating;

public class Rater {
	public Rating build(Info info) {
		Rating r = new Rating();
		r.cfAdd();
		r.jcAdd();
		r.zjAdd();
		r.ywAdd();
		r.zrAdd();
		if (info.getVtype2().contains("")) {
			r.cfAdd();
		} else if (info.getVtype2().contains(" ")) {
			r.cfAdd();
		}
		if (info.getVtype().contains(" ")) {

		} else if (info.getVtype().contains(" ")) {

		}
		// age
		if (info.getAge().contains(" ")) {
			r.setYw(3);
		} else if (info.getAge().contains(" ")) {
			r.setZj(4);
			r.setYw(5);
			r.setJc(3);
			r.setCf(1);
			r.setZr(4);
		}
		// address
		if (info.getAddress().contains(" ")) {

		} else if (info.getAddress().contains(" ")) {

		}
		// year
		if (info.getYear().contains(" ")) {

		} else if (info.getYear().contains(" ")) {

		}
		
		return r;
	}
}
