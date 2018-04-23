package com.xlbs.dataoperatservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDiscoveryClient//c创建针对Eureka客户端的实例
@EnableTransactionManagement//开启事务管理
@SpringBootApplication
public class DataoperatserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataoperatserviceApplication.class, args);
	}
}
