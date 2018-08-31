package com.ifa.recommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class RecommenderApplication {
	public static void main(String[] args) {
		// start embedded zookeeper server
		new EmbeddedZooKeeper(2181, false).start();
		SpringApplication.run(RecommenderApplication.class, args);
	}


	@Bean
	public RouterFunction<?> blogroute() {
		/*return RouterFunctions.nest(RequestPredicates.path("/api"), RouterFunctions
				.route(RequestPredicates.GET("/blogs"), req -> ServerResponse.ok().body(blogRepository.findAll(), Topic.class))
				.andRoute(RequestPredicates.GET("/blogs/id/{id}"), req -> ServerResponse.ok().body(blogRepository.findById(req.pathVariable("id")), Topic.class))
				.andRoute(RequestPredicates.POST("/blogs"), req -> ServerResponse.ok().body(blogRepository.saveAll(req.bodyToFlux(Topic.class)), Topic.class))
				.andRoute(RequestPredicates.DELETE("/blogs/id/{id}"), req -> ServerResponse.ok().body(blogRepository.deleteById(req.pathVariable("id")), Void.class)));*/
		return RouterFunctions.nest(RequestPredicates.PATCH("/api"), RouterFunctions.route(RequestPredicates.GET("/hello"), req -> ServerResponse.ok().body(Mono.just("你猜！"), String.class)));
	}
}
