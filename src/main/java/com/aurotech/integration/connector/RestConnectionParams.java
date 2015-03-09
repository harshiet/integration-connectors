package com.aurotech.integration.connector;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class RestConnectionParams implements ConnectionParams {

	private String url;
	private String username;
	private String password;
	private final String DEFAULT_PROTOCOL = "https://";
	private static final Logger logger = LogManager.getLogger(RestConnectionParams.class.getName());

	public void setURL(String url) throws MalformedURLException {

		URL httpURL;
		try {
			httpURL = new URL(url);
		} catch (MalformedURLException mex) {
			if (mex.getMessage().contains("no protocol") || mex.getMessage().contains("unknown protocol"))
				url = DEFAULT_PROTOCOL + url;
			httpURL = new URL(url);
		}
		int port = httpURL.getPort();
		this.url = httpURL.getProtocol() + "://" + httpURL.getHost() + (port != -1 ? ":" + httpURL.getPort() : "");
		logger.debug(this.url);
	}

	public void setUsername(String username) {
		this.username = username;

	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getURL() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
