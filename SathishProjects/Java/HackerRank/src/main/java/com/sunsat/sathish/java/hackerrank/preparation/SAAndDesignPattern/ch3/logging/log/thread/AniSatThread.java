package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread;

import java.util.ArrayList;
import java.util.List;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Log;

public class AniSatThread extends Thread {
	
	protected Object lockObj = null;
	protected boolean shutDown = false;	
	protected List<Log> logsLi = null;
	
	public AniSatThread() {
		lockObj = new Object();
		shutDown = false;
		logsLi = new ArrayList<Log>();
	}
	
	public void run() {
		//this default method there should not be any implementation.
	}
	
	public void shutDown(boolean st) {
		this.shutDown = st;
		try {
			synchronized (lockObj) {
				lockObj.notifyAll();	
			}
		}catch(Exception e) {
			System.err.println("Error while shutdowing down " + e.getMessage());
		}
	}
}
