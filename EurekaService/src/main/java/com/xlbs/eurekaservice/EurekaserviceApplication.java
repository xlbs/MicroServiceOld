package com.xlbs.eurekaservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserviceApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaserviceApplication.class).web(true).run(args);
	}


}
