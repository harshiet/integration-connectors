package com.aurotech.integration.jira;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/connector/jira")
public class JiraConnectorController {
	@Autowired
	JiraService js;

	@RequestMapping("/updatedIssues")
	public List<JsonNode> updatedIssues(
			@RequestParam(required = true) String customer) throws Exception {
		return js.findUpdatedIssues(customer);
	}
}
