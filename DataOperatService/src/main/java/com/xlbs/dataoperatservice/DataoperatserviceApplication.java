package com.xlbs.dataoperatservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DataoperatserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataoperatserviceApplication.class, args);
	}
}
