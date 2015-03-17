package com.aurotech.integration.connector.workfront;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.aurotech.integration.params.ConnectionParams;
import com.aurotech.integration.params.RestConnectionParams;
import com.fasterxml.jackson.databind.JsonNode;

@Component
public class WorkfrontServiceImpl implements WorkfrontService {
	WorkfrontCRUDService workfrontCRUDService;
	private static final Logger logger = LogManager.getLogger(WorkfrontServiceImpl.class.getName());

	public WorkfrontServiceImpl() throws Exception {
		ConnectionParams connectionParams = new RestConnectionParams();
		connectionParams.setURL("https://pharmaref1.attask-ondemand.com/");
		connectionParams.setUsername("harsh.agarwal@aurotechcorp.com");
		connectionParams.setPassword("Welcome123!");
		workfrontCRUDService = new WorkfrontCRUDServiceImpl(connectionParams);

	}

	public void createOrUpdateTask(JsonNode task) {
		
	}

}
