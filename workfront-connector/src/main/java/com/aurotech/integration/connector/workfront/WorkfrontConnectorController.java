package com.aurotech.integration.connector.workfront;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurotech.integration.connector.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/connector/workfront")
public class WorkfrontConnectorController {
	@Autowired
	WorkfrontService ws;

	@RequestMapping(value = "/createOrUpdateTask", method = RequestMethod.POST)
	public void createOrUpdateTask(@RequestParam(required = true) String task) throws JsonProcessingException,
			IOException {
		ws.createOrUpdateTask(CommonUtils.stringToJsonNode(task));
	}

}
