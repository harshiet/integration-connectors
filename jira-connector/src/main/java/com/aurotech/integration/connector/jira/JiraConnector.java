package com.aurotech.integration.connector.jira;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.JsonNode;


public class JiraConnector {
	private static final Logger logger = LogManager.getLogger(JiraConnector.class.getName());

	public static void main(String[] args) throws Exception {
		JiraService js = new JiraServiceImpl();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		List<JsonNode> issues = js.findUpdatedIssues(sdf.parse("01/01/2015"), sdf.parse("05/01/2015"));
		logger.debug(issues);
	}
}
