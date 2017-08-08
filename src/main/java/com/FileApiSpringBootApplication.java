package com;

import javax.ws.rs.core.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.WebApplicationInitializer;

import com.service.scheduling.FileScheduler;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com")
@EnableScheduling
public class FileApiSpringBootApplication extends SpringBootServletInitializer implements WebApplicationInitializer{
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
	
	@Autowired FileScheduler fileScheduler;
	
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    	fileScheduler.scheduleAtFixedRate();
        return application;
    }
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSender mailSender = new JavaMailSenderImpl();                
        return mailSender;
    }
}
