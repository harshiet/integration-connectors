package com.aurotech.integration.jira;

import com.aurotech.integration.common.CommonUtils;
import com.fasterxml.jackson.databind.JsonNode;

@SuppressWarnings("serial")
public class SearchException extends Exception {
	JsonNode errors;
	String response;

	public SearchException(String message) throws Exception {
		super(message);
		try {
			response = message;
			errors = CommonUtils.stringToJsonNode(message);
		} catch (Exception e) {
			throw e;
		}

	}

	public JsonNode getErrors() {
		return errors;
	}

	public JsonNode getErrorMessages() {
		return errors.get(Metadata.ERROR_MESSAGES);
	}

	public String getResponse() {
		return response;
	}

}
