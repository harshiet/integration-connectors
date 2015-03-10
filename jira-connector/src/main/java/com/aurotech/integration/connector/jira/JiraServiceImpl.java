package com.aurotech.integration.connector.jira;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aurotech.integration.connector.ConnectionParams;
import com.aurotech.integration.connector.RestConnectionParams;
import com.aurotech.integration.connector.RestConnector;
import com.aurotech.integration.connector.CommonUtils;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class JiraServiceImpl implements JiraService {

	// private static final Logger logger =
	// LogManager.getLogger(JiraServiceImpl.class.getName());
	RestConnector rest;
	ConnectionParams connectionParams;
	Search search = new SearchImpl();

	public JiraServiceImpl() throws Exception {
		rest = RestConnector.getInstance();
		connectionParams = new RestConnectionParams();
		connectionParams.setURL("https://jirareports.atlassian.net");
		connectionParams.setUsername("admin");
		connectionParams.setPassword("admin123");
	}

	public void getProject() {
		// TODO Auto-generated method stub

	}

	public void createProject() {
		// TODO Auto-generated method stub

	}

	public void getIssue() {
		// TODO Auto-generated method stub

	}

	public void createIssue() {
		// TODO Auto-generated method stub

	}

	public void updateIssue() {
		// TODO Auto-generated method stub

	}

	public List<JsonNode> findUpdatedIssues(Date startDate, Date endDate) throws Exception {
		String jql = "updated>=\"" + CommonUtils.toJiraDate(startDate) + "\" and updated<\"" + CommonUtils.toJiraDate(endDate)
				+ "\"";
		List<JsonNode> issues = search.find(connectionParams, new ArrayList<String>(), jql);
		return issues;
	}

}
