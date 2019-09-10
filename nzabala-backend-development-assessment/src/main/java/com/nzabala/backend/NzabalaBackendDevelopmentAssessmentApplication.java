package com.nzabala.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaAuditing
@EnableJpaRepositories("com.nzabala.repository")
@EntityScan("com.nzabala.models")
@ComponentScan({"com.nzabala.config", "com.nzabala.services", "com.nzabala.daos", "com.nzabala.bussiness"})
public class NzabalaBackendDevelopmentAssessmentApplication extends SpringBootServletInitializer{
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NzabalaBackendDevelopmentAssessmentApplication.class).properties("spring.config.name:nzabala");
    }
	public static void main(String[] args) {
		SpringApplication.run(NzabalaBackendDevelopmentAssessmentApplication.class, args);
	}
}
