package com.aurotech.integration.connector.workfront;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/connector/workfront")
public class WorkfrontConnectorController {
	WorkfrontService ws;

	@RequestMapping("/createOrUpdateTask")
	public void createOrUpdateTask(@RequestParam(required = true) JsonNode task) {
		ws.createOrUpdateTask(task);
	}

}
