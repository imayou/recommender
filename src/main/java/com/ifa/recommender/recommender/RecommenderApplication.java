package com.ifa.recommender.recommender;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecommenderApplication {
	public static void main(String[] args) {
		// start embedded zookeeper server
		new EmbeddedZooKeeper(2181, false).start();
		SpringApplication.run(RecommenderApplication.class, args);
	}

}
