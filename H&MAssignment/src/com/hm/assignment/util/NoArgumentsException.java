package com.hm.assignment.util;

public class NoArgumentsException extends Exception {
	private String message;

	public NoArgumentsException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
