package com.aurotech.integration.connector.jira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.aurotech.integration.repository" })
public class JiraConnectorApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JiraConnectorApp.class, args);
	}
}
