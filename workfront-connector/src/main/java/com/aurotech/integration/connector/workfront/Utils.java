package com.aurotech.integration.connector.workfront;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Utils {

	@SuppressWarnings("rawtypes")
	public static String mapToQueryString(Map<String, String> params) throws UnsupportedEncodingException {

		String query = "";
		if (params != null) {
			for (String key : params.keySet()) {
				Object val = params.get(key);
				if (val instanceof List) {
					List lVal = (List) val;
					for (Object obj : lVal) {
						query += "&" + URLEncoder.encode(key, "UTF-8") + "="
								+ URLEncoder.encode(String.valueOf(obj), "UTF-8");
					}
				} else {
					if (val instanceof Set) {
						Set sVal = (Set) val;
						for (Object obj : sVal) {
							query += "&" + URLEncoder.encode(key, "UTF-8") + "="
									+ URLEncoder.encode(String.valueOf(obj), "UTF-8");
						}
					} else {
						query += "&" + URLEncoder.encode(key, "UTF-8") + "="
								+ URLEncoder.encode(String.valueOf(val), "UTF-8");
					}
				}
			}
		}
		return query;
	}

}
