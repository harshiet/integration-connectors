package com.aurotech.integration.params;

public interface ConnectionParams {

	public void setURL(String url) throws Exception;

	public void setUsername(String username);

	public void setPassword(String password);

	public String getURL();

	public String getUsername();

	public String getPassword();

}
