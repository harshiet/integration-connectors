package com.aurotech.integration.connector.jira;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.aurotech.integration.common.CommonUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Utils {
	public static void clean(List<JsonNode> results) {
		for (JsonNode node : results) {
			clean(node);
		}
	}

	public static void clean(List<JsonNode> results, String[] remove) {
		for (JsonNode node : results) {
			clean(node, remove);
		}
	}

	public static void clean(JsonNode node, String[] remove) {
		if (node.isArray()) {
			Iterator<JsonNode> elements = node.elements();
			while (elements.hasNext()) {
				clean(elements.next());
			}
		} else {
			if (node instanceof ObjectNode) {
				ObjectNode object = (ObjectNode) node;
				for (String attr : Metadata.REMOVABLE_ATTRIBUTES) {
					if (node.has(attr)) {
						object.remove(attr);
					}
				}
				if (remove != null) {
					for (String attr : remove) {
						if (node.has(attr)) {
							object.remove(attr);
						}
					}
				}
			}
		}
	}

	public static void clean(JsonNode node) {
		clean(node, null);
	}

	public static String clean(String jsonStr, String[] remove) throws Exception {
		List<JsonNode> l = CommonUtils.stringToJsonList(jsonStr);
		clean(l, remove);
		return CommonUtils.objectToJsonString(l);

	}

	public static String clean(String jsonStr) throws Exception {
		return clean(jsonStr, new String[] {});
	}

	public static void validateResponse(String result) throws SearchException, Exception {
		if (org.apache.commons.lang3.StringUtils.contains(result, Metadata.ERROR_MESSAGES)) {
			throw new SearchException(result);
		}

	}

	public static String toJiraDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}

}
