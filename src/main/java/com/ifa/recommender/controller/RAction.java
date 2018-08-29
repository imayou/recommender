package com.ifa.recommender.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifa.recommender.domain.Info;
import com.ifa.recommender.domain.Rating;
import com.ifa.recommender.service.Rater;

@RestController
@RequestMapping("/r")
public class RAction {
	@PostMapping("/give")
	public Rating r(Info info) {
		Rating r = new Rater().build(info);
		return r;
	}
}
