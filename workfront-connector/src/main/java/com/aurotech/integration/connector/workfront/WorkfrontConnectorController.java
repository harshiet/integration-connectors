package com.aurotech.integration.connector.workfront;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/connector/workfront")
public class WorkfrontConnectorController {
	@Autowired
	WorkfrontService ws;

	@RequestMapping(value = "/createOrUpdateTask", method = RequestMethod.POST)
	public void createOrUpdateTask(@RequestBody JsonNode tasks)
			throws JsonProcessingException, IOException {
		ws.createOrUpdateTask(tasks);
	}

}
