package com.hcl.productdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ProductdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductdbApplication.class, args);
	}

}
