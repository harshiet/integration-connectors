package com.aurotech.integration.jira;

import java.util.List;

import com.aurotech.integration.params.ConnectionParams;
import com.fasterxml.jackson.databind.JsonNode;

public interface Search {

	public int size(ConnectionParams conn, List<String> fields, String filter) throws Exception;

	public List<JsonNode> find(ConnectionParams conn, List<String> fields, String filter) throws Exception;

}
