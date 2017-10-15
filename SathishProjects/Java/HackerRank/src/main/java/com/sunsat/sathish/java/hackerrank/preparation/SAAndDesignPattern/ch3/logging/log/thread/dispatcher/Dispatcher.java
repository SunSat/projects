package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.dispatcher;

import java.util.ArrayList;
import java.util.List;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.AniSatThread;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.logger.LoggerThread;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Log;

public class Dispatcher extends AniSatThread {

	private static Dispatcher disTh = null;
	private static Object disLockObj = new Object();
	private ArrayList<String> finalList = new ArrayList<String>();
	private static LoggerThread loggerTh = null;
	
	private Dispatcher() {
		loggerTh = LoggerThread.getInstance();
	}

	public static Dispatcher getInstance() {
		if(null == disTh) {
			synchronized (disLockObj) {
				disTh = new Dispatcher();
			}
		}
		return disTh;
	}
	
	public void addLog(Log log) {
		synchronized (lockObj) {
			try {
				logsLi.add(log);
				lockObj.notifyAll();
			}catch(Exception e) {
				System.err.println("Error while adding log object" + log.getMsg() 
						+ ": The orignal Error is : " + e.getMessage());
			}
		}
	}
	
	public void run() {
		while(!shutDown) {
			try {
				Log log = null;
				if(logsLi.size() > 0) {
					synchronized (lockObj) {
						if(logsLi.size() > 0) {
							log = logsLi.remove(0);
							//finalList.add(log.getMsg());
						}else {
							lockObj.wait();
						}
					}
				}
				else {
					synchronized (lockObj) {
						lockObj.wait();						
					}
				}
				if(null != log) {
					loggerTh.passToAppender(log);					
				}
			} catch(Exception e) {
				System.err.println("Erroe while getting the lock obj in dispatch thread" + e.getMessage());
			}
		}
		System.out.println("I am going to shutdown : " + Thread.currentThread().getName());
	}
	
	public List<String> getFilanResult() {
		return finalList;
	}
}
