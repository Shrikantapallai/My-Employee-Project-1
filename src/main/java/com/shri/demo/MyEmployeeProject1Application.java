package com.shri.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class MyEmployeeProject1Application {
	@PostConstruct
	public void init() {
		System.out.println("in it method called");
	}

	public static void main(String[] args) {
		SpringApplication.run(MyEmployeeProject1Application.class, args);
	}

}
