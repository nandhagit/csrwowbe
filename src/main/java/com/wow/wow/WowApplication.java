package com.wow.wow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class WowApplication extends SpringBootServletInitializer {

	/*
	 * protected SpringApplicationBuilder configure(SpringApplicationBuilder
	 * application) { return application.sources(WowApplication.class); }
	 * 
	 * 
	 */
	public static void main(String[] args) {
		SpringApplication.run(WowApplication.class, args);
	}

}
