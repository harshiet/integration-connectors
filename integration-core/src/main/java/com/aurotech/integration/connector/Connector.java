package com.aurotech.integration.connector;

import com.aurotech.integration.params.ConnectionParams;

public interface Connector {

	public String get(ConnectionParams connectionParams, String path) throws Exception;

	public String post(ConnectionParams connectionParams, String path, String postData) throws Exception;
}
