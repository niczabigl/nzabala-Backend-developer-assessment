package com.nzabala.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan(basePackages="com.nzabala.services")
public class NzabalaBackendDevelopmentAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(NzabalaBackendDevelopmentAssessmentApplication.class, args);
	}
}
