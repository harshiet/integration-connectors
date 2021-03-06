package com.aurotech.integration.common;

import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CommonUtils {
	private static final Logger logger = LogManager.getLogger(CommonUtils.class.getName());
	private static SecureRandom random = new SecureRandom();
	private static ObjectMapper mapper = new ObjectMapper();

	public static String objectToJsonString(Object obj) throws JsonProcessingException {
		return mapper.writeValueAsString(obj);
	}

	public static JsonNode stringToJsonNode(String str) throws JsonProcessingException, IOException {
		return mapper.readTree(str);
	}

	public static List<JsonNode> stringToJsonList(String str) throws JsonProcessingException, IOException {
		JsonNode jsonNode = mapper.readTree(str);
		List<JsonNode> out = new ArrayList<JsonNode>();
		if (jsonNode.isArray()) {
			addAll(out, jsonNode.elements());
		} else {
			out.add(jsonNode);
		}
		return out;
	}

	public static List<JsonNode> iteratorToList(Iterator<JsonNode> elements) throws JsonProcessingException,
			IOException {
		List<JsonNode> out = new ArrayList<JsonNode>();
		addAll(out, elements);
		return out;
	}

	public static void addAll(List<JsonNode> results, Iterator<JsonNode> elements) {
		while (elements.hasNext()) {
			results.add(elements.next());
		}

	}

	public static void print(Object obj) {
		logger.debug(obj);
	}

	public static void print(String str) {
		logger.debug(str);
	}

	public static void print(JsonNode jsonNode) {
		logger.debug(jsonNode);
	}

	public static Date toDate(String str) throws ParseException {
		// logger.debug("in date toDate: " + str);
		Date out = null;
		if (StringUtils.isNotBlank(str) && (StringUtils.indexOf(str, "null") == -1)) {
			SimpleDateFormat sdf = new SimpleDateFormat();
			sdf.applyPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
			try {
				out = sdf.parse(str);
			} catch (ParseException e) {
				sdf.applyPattern("yyyy-MM-dd");
				try {
					out = sdf.parse(str);
				} catch (ParseException ex) {
					sdf.applyPattern("EEE MMM d HH:mm:ss z yyyy");
					out = sdf.parse(str);
				}
			}
		}
		// logger.debug("out date toDate: " + out);
		return out;
	}

	public static java.sql.Date toSQLDate(Date date) {
		java.sql.Date out = null;
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			out = new java.sql.Date(cal.getTime().getTime());
		}
		// logger.debug("out date toSQLDate: " + out);
		return out;
	}

	public static List<Date> allDatesBetween(Date fromDate, Date toDate) {

		List<Date> dates = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromDate);
		dates.add(fromDate);
		while (cal.getTime().before(toDate)) {
			cal.add(Calendar.DATE, 1);
			dates.add(cal.getTime());
		}
		return dates;
	}

	public static String randomAlphaNumericCode() {
		return new BigInteger(130, random).toString(32);
	}

	public static String formatDate(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-YYYY HH:mm:ss");
		return sdf.format(date);
	}

	public static String toJiraDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sdf.format(date);
	}

	public static <T extends Object> T stringToObject(String json, Class<T> objClass) throws IOException {
		ObjectMapper localMapper = new ObjectMapper();
		localMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return localMapper.readValue(json, objClass);
	}

	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		if (o instanceof List) {
			return ((List) o).size() == 0;
		}
		if (o.equals("null")) {
			return true;
		}
		return false;
	}

}
