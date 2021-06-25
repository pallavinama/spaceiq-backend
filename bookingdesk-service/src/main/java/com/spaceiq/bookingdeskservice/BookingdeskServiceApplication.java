package com.spaceiq.bookingdeskservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BookingdeskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingdeskServiceApplication.class, args);
	}

}
