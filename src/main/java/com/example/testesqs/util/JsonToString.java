package com.example.testesqs.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonToString {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	public static String convert(Object obj) {
		try {
			String string;

			string = objectMapper.writeValueAsString(obj);
			return string;
		} catch (JsonProcessingException e) {
			throw new IllegalArgumentException();
		}

	}
}
