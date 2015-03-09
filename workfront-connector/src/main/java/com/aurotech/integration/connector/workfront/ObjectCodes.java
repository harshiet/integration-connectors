package com.aurotech.integration.connector.workfront;

import org.apache.commons.lang3.StringUtils;

public enum ObjectCodes {

	PROJECT("PROJ"), GROUP("GROUP"), CATEGORY("CATEGORY"), TEMPLATE("TMPL"), USER("USER"), TEAM_MEMBER("PTEAM"), TASK(
			"TASK"), USER_UNIQUE_ID("emailAddr"), TIMESHEET_TEMPLATE("TSHTMP"), TIMESHEET("TSHET", "Timesheet"), USER_SUPER_OFFICE(
			"DE:Super Office"), PROJECT_SUPER_OFFICES("DE:Super Offices"), TIMESHEET_PROFILE("TSPRO"), TIMED_NOTIFICATION(
			"TMNOT"), NOTIFICATION_RECORD("TMNR"), NOTE("NOTE"), ISSUE("OPTASK"), APPROVAL_PROCESS("ARVPRC"), NOTES(
			"NOTE"), DOCUMENT("DOCUMENT");

	private String code;
	private String name;

	private ObjectCodes(String s) {
		code = s;
	}

	private ObjectCodes(String s, String n) {
		code = s;
		name = n;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		if (StringUtils.isEmpty(name)) {
			return code;
		}
		return name;
	}

	public static ObjectCodes getByName(String name) {
		for (ObjectCodes code : ObjectCodes.values()) {
			if (code.getName().equalsIgnoreCase(name)) {
				return code;
			}
		}
		return null;
	}

}
