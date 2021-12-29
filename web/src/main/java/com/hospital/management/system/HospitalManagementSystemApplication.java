package com.hospital.management.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hospital.*"})
@EntityScan(basePackages = {"com.hospital.*"})
@EnableJpaRepositories(basePackages = {"com.hospital.*"})
public class HospitalManagementSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementSystemApplication.class, args);
		System.out.println("Started");
	}

}
