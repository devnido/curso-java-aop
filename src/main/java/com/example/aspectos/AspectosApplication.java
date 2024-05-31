package com.example.aspectos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class AspectosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AspectosApplication.class, args);
	}

}
