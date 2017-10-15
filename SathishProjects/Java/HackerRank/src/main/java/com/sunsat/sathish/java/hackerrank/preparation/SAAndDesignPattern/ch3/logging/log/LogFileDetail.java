package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log;

import java.text.SimpleDateFormat;

public class LogFileDetail {
	
	private String name = "";
	private String identifier = "";
	private SimpleDateFormat identifierFormat = null;
	private String location = "";
	private int size = 0;
	
	public LogFileDetail() {
		
	}
	
	public LogFileDetail(String name, String identifier, SimpleDateFormat format, String location, int size) {
		this.name = name;
		this.identifier = identifier;
		this.identifierFormat = format;
		this.location = location;
		this.size = size;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public SimpleDateFormat getIdentifierFormat() {
		return identifierFormat;
	}
	public void setIdentifierFormat(SimpleDateFormat identifierFormat) {
		this.identifierFormat = identifierFormat;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	
	
}
