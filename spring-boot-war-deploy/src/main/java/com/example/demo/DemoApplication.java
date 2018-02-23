package com.example.demo;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.UrlResource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${application.name}")
	String applicationName;

	@EventListener
	public void started(ApplicationReadyEvent readyEvent) {

	    logger.info("* application name :{}", applicationName);
	    logger.info("* catalina.home: {}", System.getProperty("catalina.home") );
		logger.info("* catalina.base: {}", System.getProperty("catalina.base") );
		logger.info("* user.dir     : {}", System.getProperty("user.dir") );
		try {
			String contents = IOUtils.readLines(new UrlResource(new URL("file:./conf/demo/application.properties")).getInputStream(), "UTF-8").stream()
					.collect(Collectors.joining("\n"));
			logger.info("* relative url contents: {}", contents);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
