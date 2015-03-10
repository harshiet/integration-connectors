package com.aurotech.integration.connector.workfront;

import com.fasterxml.jackson.databind.JsonNode;

public interface WorkfrontService {

	public void createOrUpdateTask(JsonNode task);

}
