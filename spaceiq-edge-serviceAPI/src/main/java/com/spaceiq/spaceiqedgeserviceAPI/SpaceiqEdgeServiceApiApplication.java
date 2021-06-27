package com.spaceiq.spaceiqedgeserviceAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableAutoConfiguration(exclude= DataSourceAutoConfiguration.class)
public class SpaceiqEdgeServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceiqEdgeServiceApiApplication.class, args);
	}

}
