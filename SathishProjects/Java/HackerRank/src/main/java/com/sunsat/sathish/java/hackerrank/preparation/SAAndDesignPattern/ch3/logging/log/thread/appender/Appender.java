package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.appender;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.exception.LogException;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Log;

public interface Appender {

	public abstract void append(Log log) throws LogException;
	
}
