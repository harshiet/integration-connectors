package com.aurotech.integration.connector;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public final class RestConnector implements Connector {
	private final int connectTimeoutMillis = 30000;
	private static RestConnector instance = null;
	private static final Logger logger = LogManager.getLogger(RestConnector.class.getName());
	private boolean authenticated = false;
	private boolean json = false;

	private RestConnector() throws KeyManagementException, NoSuchAlgorithmException {
		trustAllCertificates();

	}

	public static RestConnector getInstance() throws KeyManagementException, NoSuchAlgorithmException {
		if (instance == null) {
			instance = new RestConnector();
		}
		return instance;
	}

	public String get(ConnectionParams connectionParams, String path) throws Exception {
		logger.debug(path);
		HttpURLConnection connection = null;

		try {
			connection = getHttpURLConnection(connectionParams, path);
			connection.setRequestMethod("GET");
			connection.setUseCaches(false);
			return readHttpResponse(connection);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public String post(ConnectionParams connectionParams, String path, String postData) throws Exception {
		HttpURLConnection connection = null;
		logger.debug(postData);
		try {
			connection = getHttpURLConnection(connectionParams, path);
			connection.setRequestMethod("POST");
			if (json) {
				connection.setRequestProperty("Content-Type", "application/json");
			}
			connection.setUseCaches(false);
			connection.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
			wr.writeBytes(postData);
			wr.flush();
			wr.close();
			return readHttpResponse(connection);
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	private static String readHttpResponse(HttpURLConnection connection) throws Exception {
		BufferedReader rd;
		try {
			rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		} catch (IOException e) {
			rd = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
		}
		String line;
		StringBuffer response = new StringBuffer();
		while ((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		}
		rd.close();
		String result = response.toString();
		return result;
	}

	private HttpURLConnection getHttpURLConnection(ConnectionParams connectionDetails, String path) throws IOException,
			MalformedURLException {
		String urlToCall = StringUtils.isEmpty(path) ? connectionDetails.getURL() : connectionDetails.getURL() + path;
		logger.debug(urlToCall);
		HttpURLConnection connection = (HttpURLConnection) new URL(urlToCall).openConnection();
		connection.setConnectTimeout(connectTimeoutMillis);
		connection.setReadTimeout(connectTimeoutMillis);
		if (authenticated) {
			String encoded = Base64.encodeBase64String((connectionDetails.getUsername() + ":" + connectionDetails
					.getPassword()).getBytes());
			connection.setRequestProperty("Authorization", "Basic " + encoded);
		}
		return connection;
	}

	private static void trustAllCertificates() throws NoSuchAlgorithmException, KeyManagementException {
		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] certs, String authType) {
			}

			public void checkServerTrusted(X509Certificate[] certs, String authType) {
			}
		} };
		final SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public void setJson(boolean json) {
		this.json = json;
	}

}
