package com.example.plaid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class PlaidApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaidApplication.class, args);
	}

}
