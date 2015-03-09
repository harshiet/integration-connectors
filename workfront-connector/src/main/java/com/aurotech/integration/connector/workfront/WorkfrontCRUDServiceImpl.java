package com.aurotech.integration.connector.workfront;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.aurotech.integration.connector.ConnectionParams;
import com.aurotech.integration.connector.RestConnector;

public class WorkfrontCRUDServiceImpl implements WorkfrontCRUDService {
	private static final int MAX_RESULT_COUNT = 2000;
	private static final Logger logger = LogManager.getLogger(WorkfrontCRUDServiceImpl.class.getName());
	RestConnector rest;
	ConnectionParams connectionParams;

	public WorkfrontCRUDServiceImpl(ConnectionParams connectionParams) throws Exception {
		rest = RestConnector.getInstance();
		this.connectionParams = connectionParams;
		login(connectionParams);
	}

	protected final void login(ConnectionParams connectionParams) throws Exception {
		Map<String, String> params = new LinkedHashMap<String, String>();
		params.put("username", connectionParams.getUsername());
		params.put("password", connectionParams.getPassword());
		String result = rest.post(connectionParams, Metadata.LOGIN_URI, Utils.mapToQueryString(params));
		
	
	}
	// protected final JsonNode searchObjects(String sessionId, ObjectCodes
	// objectCode, Map<String, Object> filter)
	// throws Exception {
	// return searchObjects(sessionId, objectCode, filter, new
	// ArrayList<String>());
	// }
	//
	// public final JSONArray searchObjects(String sessionId, ObjectCodes
	// objectCode, Map<String, Object> filter,
	// List<String> dataElements) throws Exception {
	//
	// if (Utils.isEmpty(dataElements)) {
	// dataElements = new ArrayList<String>();
	// dataElements.add("ID");
	// }
	//
	// if (Utils.isEmpty(filter)) {
	// filter = new HashMap<String, Object>();
	// }
	//
	// filter.put("$$LIMIT", MAX_RESULT_COUNT);
	// JSONArray results =
	// getClientForSession(sessionId).search(objectCode.getCode(), filter,
	// dataElements.toArray(new String[dataElements.size()]));
	// logger.debug("Search: [" + objectCode + "] [" + filter + "]. " +
	// results.length() + " record(s)" + " found.");
	// return results;
	// }
	//
	// public final void logout(String sessionId) throws StreamClientException {
	// getClientForSession(sessionId).logout();
	// getSessionRegistry().remove(sessionId);
	// }
	//
	// protected final JSONObject create(String sessionId, ObjectCodes objCode,
	// Map<String, Object> map)
	// throws StreamClientException {
	// return getClientForSession(sessionId).post(objCode.getCode(), map);
	// }
	//
	// protected final boolean delete(String sessionId, ObjectCodes objCode,
	// String objId) throws StreamClientException {
	// return getClientForSession(sessionId).delete(objCode.getCode(), objId);
	// }
	//
	// public final void update(String sessionId, ObjectCodes objCode, String
	// objectId, Map<String, Object> map)
	// throws StreamClientException {
	// getClientForSession(sessionId).put(objCode.getCode(), objectId, map);
	// }
	//
	// protected final JSONObject executeAction(String sessionId, ObjectCodes
	// objCode, String objectId, String actionName,
	// Map<String, Object> map) throws StreamClientException {
	// return getClientForSession(sessionId).action(objCode.getCode(), objectId,
	// actionName, map);
	// }
	//
	// protected final Object executeAjaxCommand(String sessionId, String
	// commandName, Map<String, Object> map)
	// throws StreamClientException {
	// return getClientForSession(sessionId).ajax(commandName, map);
	// }
	//
	// protected final JSONObject getObject(String sessionId, ObjectCodes
	// objCode, String objID, List<String> fields)
	// throws StreamClientException {
	// return getClientForSession(sessionId).get(objCode.getCode(), objID, new
	// HashSet<String>(fields));
	// }
	//
	// protected final void updateTaskStatus(String sessionId, String taskId,
	// String status) throws StreamClientException {
	// Map<String, Object> map = new HashMap<String, Object>();
	// map.put("status", status);
	// update(sessionId, ObjectCodes.TASK, taskId, map);
	// }
	//
	// protected final File downloadDocument(String sessionId, String
	// documentId) {
	// Client webClient = Client.create();
	// WebResource webResource = webClient.resource(PROTOCOL + serverName +
	// "/document/download?ID=" + documentId
	// + "&sessionID=" + sessionId);
	// File f = webResource.post(File.class);
	// return f;
	// }
	//
	// protected final List<Object> findUserApprovalInformation(String
	// sessionId, String taskId, String userId,
	// Date primaryAuthorSignDate) throws Exception {
	// List<Object> approvalInfomation = new ArrayList<Object>();
	// Map<String, Object> filter = new HashMap<String, Object>();
	// filter.put("objID", taskId);
	// filter.put("ownerID", userId);
	// filter.put("auditText", "Approval Step");
	// filter.put("auditText_Mod", "cicontains");
	//
	// List<String> dataElements = new ArrayList<String>();
	// dataElements.add("auditText");
	// dataElements.add("noteText");
	// dataElements.add("entryDate");
	// JSONArray notes = searchObjects(sessionId, ObjectCodes.NOTES, filter,
	// dataElements);
	// Date latestDate = null;
	// String comments = "";
	// String auditText = "";
	// for (int i = 0; i < notes.length(); i++) {
	// JSONObject note = notes.getJSONObject(i);
	// Date entryDate = DateUtils.parseDate(note.getString("entryDate"),
	// "yyyy-MM-dd'T'HH:mm:ss:SSSZ");
	// if (entryDate.after(primaryAuthorSignDate)) {
	// if (latestDate == null || entryDate.after(latestDate)) {
	// latestDate = entryDate;
	// comments = note.getString("noteText");
	// auditText = note.getString("auditText");
	// }
	// }
	// }
	// approvalInfomation.add(comments);
	// approvalInfomation.add(latestDate);
	// approvalInfomation.add(auditText);
	// return approvalInfomation;
	// //
	// http://panoramadev/attask/api-internal/note/search?objID=51c0b177000041e7fcdef14eef750328&ownerID=50355f12000008fd4f99f7cacc85a28e&fields=auditText,noteText
	//
	// }

	// protected final String login(String serverName, String username, String
	// password) throws StreamClientException,
	// JSONException {
	// this.serverName = serverName;
	// StreamClient client = new StreamClient(getServerUrl(), "/api-internal");
	// JSONObject session = client.login(username, password);
	// String sessionId = session.getString("sessionID");
	// sessionRegistry.put(sessionId, client);
	// return sessionId;
	// }
	//
	// private String getServerUrl() {
	// return PROTOCOL + serverName + "/attask";
	// }
	//
	// protected final String getApiURL(String url) {
	// return getServerUrl() + "/api-internal" + url;
	// }
	//
	// protected final JSONObject createJson(String sessionId, ObjectCodes
	// objCode, String objId, String json)
	// throws StreamClientException {
	// return getClientForSession(sessionId).put(objCode.getCode(), objId, json,
	// null);
	// }
	//
	// protected final Object upload(String sessionId, Map<String, Object> data)
	// throws StreamClientException {
	// return getClientForSession(sessionId).upload(data, null);
	// }

}
