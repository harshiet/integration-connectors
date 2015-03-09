package com.aurotech.integration.connector.jira;

import java.util.List;

import com.aurotech.integration.connector.ConnectionParams;
import com.fasterxml.jackson.databind.JsonNode;

public interface Search {

	public int size(ConnectionParams conn, List<String> fields, String filter) throws Exception;

	public List<JsonNode> find(ConnectionParams conn, List<String> fields, String filter) throws Exception;

}
