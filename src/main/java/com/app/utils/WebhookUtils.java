package com.app.utils;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class WebhookUtils {
    public static boolean isValidSignature(String requestData, String signature, String secret) {
    	//Simulate true for TEST_SIGNATURE
    	if (signature.equals("TEST_SIGNATURE")) {
    		return true;
    	}
    	//otherwisee checking signature with this logic
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));
            String expected = Base64.getEncoder().encodeToString(mac.doFinal(requestData.getBytes()));
            return expected.equals(signature);
        } catch (Exception e) {
            return false;
        }
    }
    
    
    
    public static void main(String[] args) {
    	
    	String requestData="{\n"
    			+ "    \"event\": \"payment.authorized\",\n"
    			+ "    \"payload\": {\n"
    			+ "      \"payment\": {\n"
    			+ "        \"entity\": {\n"
    			+ "          \"id\": \"pay_001\",\n"
    			+ "          \"status\": \"authorized\",\n"
    			+ "          \"amount\": 1000,\n"
    			+ "          \"currency\": \"INR\"\n"
    			+ "        }\n"
    			+ "      }\n"
    			+ "    },\n"
    			+ "    \"created_at\": 1751885965,\n"
    			+ "    \"id\": \"evt_auth_001\"\n"
    			+ "  }";
    	
    	String secret = "test_secret";
    	String signatureDummy=createValidSignature(requestData, secret);
    	System.out.println("Dummy Signature : "+signatureDummy);
    	//FjSeBTwCvMxj0bK1fQIcVO0IIrIvRCTz3NL3jEozi/I=
		System.out.println(isValidSignature(requestData, signatureDummy , secret));
	}
    
    public static String createValidSignature(String requestData, String secret) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(), "HmacSHA256"));
            String expected = Base64.getEncoder().encodeToString(mac.doFinal(requestData.getBytes()));
            return expected;
        } catch (Exception e) {
            return "Could not make signature";
        }
        }
}
