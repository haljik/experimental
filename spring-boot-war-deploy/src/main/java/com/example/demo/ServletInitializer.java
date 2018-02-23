package com.example.demo;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import java.util.Properties;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		Properties properties = new Properties();
		properties.put("spring.config.location","file:./conf/demo/");
		return application.sources(DemoApplication.class)
				.properties(properties);
	}

}
