package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo;

import java.util.Date;

public class Log {

	String msg;
	Exception ex;
	Mode mode;
	Date date;
	String className;
	String methodName;
	
	public Log() {
		msg = "";
		ex = new Exception();
		mode = Mode.All;
		date = new Date();
	}
	public Log(String msg,Mode mode) {
		this.mode = mode;
		this.msg = msg;
		this.date = new Date();
	}
	
	public Log(String msg, Exception ex, Mode mode) {
		this.msg = msg;
		this.ex = ex;
		this.mode = mode;
		this.date = new Date();
	}
	
	public Log(Exception ex, Mode mode) {
		this.ex = ex;
		this.mode = mode;
		this.date = new Date();		
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public Exception getEx() {
		return ex;
	}
	
	public void setEx(Exception ex) {
		this.ex = ex;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}	
	
	
}
