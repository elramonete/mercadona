package com.product.mercadona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.product.mercadona"})
public class MercadonaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadonaApplication.class, args);
	}

}
