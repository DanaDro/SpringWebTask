package com.dana.springTask2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTaskApplication.class, args);
		System.out.println("IoC container was loaded");
	}

}
