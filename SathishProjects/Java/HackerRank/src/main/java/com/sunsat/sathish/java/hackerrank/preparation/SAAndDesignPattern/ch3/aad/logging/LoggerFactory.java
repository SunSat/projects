package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.aad.logging;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class LoggerFactory {
	
	static Properties prop = new Properties();
	static Logger log = null;
	
	public static void readProperty() {
		try {
			prop.load(LoggerFactory.class.getResourceAsStream("logger.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public static Logger getLogger() {
		if(log == null) {
			readProperty();
		}
		if(prop.getProperty("Type").equals("File")) {
			log = new FileLogger(new File(""));
		} else {
			log = new ConsoleLogger();
		}
		return log;
	}

}
