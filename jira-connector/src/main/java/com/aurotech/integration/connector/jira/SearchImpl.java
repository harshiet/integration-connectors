package com.aurotech.integration.connector.jira;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aurotech.integration.connector.ConnectionParams;
import com.aurotech.integration.connector.RestConnector;
import com.aurotech.integration.connector.CommonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public class SearchImpl implements Search {
	public static int PAGESIZE = 800;
	public static int PAGESIZE_Sizing = 100;
	private static final Logger logger = LogManager.getLogger(SearchImpl.class.getName());
	private RestConnector restConnector;

	public SearchImpl() throws KeyManagementException, NoSuchAlgorithmException {
		restConnector = RestConnector.getInstance();
		restConnector.setAuthenticated(true);
		restConnector.setJson(true);
	}

	public int size(ConnectionParams conn, List<String> fields, String filter) throws Exception {
		String searchJson = buildSearchJson(fields, filter, 0, PAGESIZE_Sizing);
		String response = restConnector.post(conn, Metadata.ISSUE_SEARCH_URI, searchJson);
		JsonNode json = CommonUtils.stringToJsonNode(response);
		int size = json.get("total").asInt();
		return size;
	}

	public List<JsonNode> find(ConnectionParams conn, List<String> fields, String filter) throws Exception {
		int total = 0;
		int fetched = 0;
		List<JsonNode> results = new ArrayList<JsonNode>();
		do {
			String searchJson = buildSearchJson(fields, filter, fetched, PAGESIZE);
			String response = restConnector.post(conn, Metadata.ISSUE_SEARCH_URI, searchJson);
			JsonNode json = CommonUtils.stringToJsonNode(response);
			JsonNode issuesFetched = json.get("issues");
			fetched += issuesFetched.size();
			CommonUtils.addAll(results, issuesFetched.elements());
			total = json.get("total").asInt();
		} while (fetched < total);
		return results;
	}

	private String buildSearchJson(List<String> fields, String filter, int startAt, int pageSize)
			throws JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startAt", startAt);
		map.put("maxResults", pageSize);
		map.put("expand", new String[] { "" });
		if (StringUtils.isNotEmpty(filter)) {
			filter = filter.replace("\\\\", "\\");
			map.put("jql", filter);
		}
		map.put("fields", fields);
		String searchJson = CommonUtils.objectToJsonString(map);
		logger.debug("Search JSON:" + searchJson);
		return searchJson;
	}

}
