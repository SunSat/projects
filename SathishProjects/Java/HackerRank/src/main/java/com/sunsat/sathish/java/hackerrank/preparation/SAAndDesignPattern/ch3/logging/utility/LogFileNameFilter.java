package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.utility;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFileNameFilter implements FilenameFilter {
	
	String path = "";
	String fileName = "";
	Pattern pattern = null;
	
	public LogFileNameFilter(String filePath, String fileName ) {
		this.path = filePath;
		this.fileName = fileName;
		this.pattern = Pattern.compile(fileName);
	}

	public static void main(String[] args) {

	}	
	
	@Override
	public boolean accept(File logDFile, String name) {
		Matcher m = pattern.matcher(name);
		return m.matches();
	}
}


	