package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.exception;

public class LogException extends Exception {
	
	String message = "";
	Exception ex = null;
	
		
	public LogException() {
		super();
	}

	public LogException(String message) {
		super();
		this.message = message;
	}

	public LogException(String message, Exception ex) {
		super();
		this.message = message;
		this.ex = ex;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Exception getEx() {
		return ex;
	}
	public void setEx(Exception ex) {
		this.ex = ex;
	}	
	
}
