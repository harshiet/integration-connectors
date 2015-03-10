package com.aurotech.integration.connector.jira;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/connector/jira")
public class JiraConnectorController {
	JiraService js;

	public JiraConnectorController() throws Exception {
		js = new JiraServiceImpl();
	}

	@RequestMapping("/updatedIssues")
	public List<JsonNode> updatedIssues(@RequestParam(required = true) Date startDate,
			@RequestParam(required = true) Date endDate) throws Exception {
		return js.findUpdatedIssues(startDate, endDate);
	}
}
