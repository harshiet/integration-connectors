package com.aurotech.integration.jira;


public class Metadata {

	public static String[] REMOVABLE_ATTRIBUTES = new String[] { "expand", "self", "avatarUrls", "iconUrl", "viewUrl",
			"searchUrl" };

	public static final String ERROR_MESSAGES = "errorMessages";

	public static final String BASE_PATH = "/rest/api/latest";
	public static final String ISSUE_SEARCH_URI = BASE_PATH + "/search";
	public static final String FIELD_SCHEMA_URI = BASE_PATH + "/field";
	public static final String JQL_AUTOCOMPLETEDATA = BASE_PATH + "/jql/autocompletedata";
	public static final String FILTER_FAVORITE_URI = BASE_PATH + "/filter/favourite";
	public static final String FILTER_DETAILS_URI = BASE_PATH + "/filter";

	// lookup URLs
	public static final String PROJECT_URI = BASE_PATH + "/project";
	public static final String PRIORITY_URI = BASE_PATH + "/priority";
	public static final String RESOLUTION_URI = BASE_PATH + "/resolution";
	public static final String STATUS_URI = BASE_PATH + "/status";
	public static final String ISSUE_TYPE_URI = BASE_PATH + "/issuetype";
	public static String USER_SEARCH_URI = BASE_PATH + "/user/search";

}
