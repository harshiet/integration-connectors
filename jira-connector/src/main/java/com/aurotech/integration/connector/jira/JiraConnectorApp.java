package com.aurotech.integration.connector.jira;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JiraConnectorApp {
	private static final Logger logger = LogManager.getLogger(JiraConnectorApp.class.getName());

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JiraConnectorApp.class, args);
	}
}
