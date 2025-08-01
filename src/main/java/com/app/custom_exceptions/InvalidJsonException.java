package com.app.custom_exceptions;

@SuppressWarnings("serial")
public class InvalidJsonException extends RuntimeException {
	public InvalidJsonException(String mesg) {
		super(mesg);
	}
}
