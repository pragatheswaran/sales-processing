package com.message.sales.salesprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalesProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesProcessingApplication.class, args);
		SaleThread runnable = new SaleThread();
		Thread td = new Thread(runnable);
		td.start();
	}
}
