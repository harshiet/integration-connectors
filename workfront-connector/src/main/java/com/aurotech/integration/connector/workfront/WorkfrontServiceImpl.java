package com.aurotech.integration.connector.workfront;

import com.aurotech.integration.connector.ConnectionParams;
import com.aurotech.integration.connector.RestConnectionParams;
import com.fasterxml.jackson.databind.JsonNode;

public class WorkfrontServiceImpl implements WorkfrontService {
	WorkfrontCRUDService workfrontCRUDService;

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
