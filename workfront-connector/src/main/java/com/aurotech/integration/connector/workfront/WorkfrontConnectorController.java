package com.aurotech.integration.connector.workfront;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/connector/workfront")
public class WorkfrontConnectorController {
	WorkfrontService ws;

	@RequestMapping("/createOrUpdateTask")
	public void createOrUpdateTask(@RequestParam(required = true) String task)  {
		ws.createOrUpdateTask(task);
	}

}
