package com.doc_app.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.doc_app")
public class BootDocAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDocAppApplication.class, args);
	}

}
