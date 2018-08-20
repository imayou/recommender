package com.ifa.recommender;

import java.util.Date;

//@Service(version = "1.0.0")
public class HelloImpl implements Hello {
	@Override
    public String sayHello(String name) {
        return "Hello, " + name + ", " + new Date();
    }
}