package com.velocity.chaitali;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PdfReportApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PdfReportApplication.class, args);
	}

}
