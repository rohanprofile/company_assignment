package com.app.utils;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component
public class JsonConverterUtility {

	private final ObjectMapper mapper = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
			.registerModule(new JavaTimeModule());
			//setDateFormat(new SimpleDateFormat())
	
	public <T> T convertStringToObject(String jsonStringValue, Class<T> type) {
		System.out.println("json string value="+jsonStringValue);
		if(jsonStringValue == null) {
			System.err.println("jsonStringValue is null");
			return null;
		}
		try {
			return (T)mapper.readValue(jsonStringValue, type);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.err.println("excetption in mappping"+e);
			return null;
		}
	}
	
}
