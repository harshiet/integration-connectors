package com.aurotech.integration.jira;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public interface JiraService {

	public void getProject();

	public void createProject();

	public void getIssue();

	public void createIssue();

	public void updateIssue();

	public List<JsonNode> findUpdatedIssues(String customer) throws Exception;

}
