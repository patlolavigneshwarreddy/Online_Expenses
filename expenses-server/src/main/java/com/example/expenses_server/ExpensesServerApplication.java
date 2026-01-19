package com.example.expenses_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
@EnableFeignClients
public class ExpensesServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpensesServerApplication.class, args);
	}

}
