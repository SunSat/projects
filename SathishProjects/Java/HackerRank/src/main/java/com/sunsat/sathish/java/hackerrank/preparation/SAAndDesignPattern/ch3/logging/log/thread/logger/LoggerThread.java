package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.logger;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.exception.LogException;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.AniSatThread;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.appender.Appender;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Log;

public class LoggerThread extends AniSatThread {
	
	private Appender appender = null;
	private static Object singleTonLockObj = new Object();
	private static LoggerThread loggerTh = null;
	private Object isLoggerInProgress = new Object();
	
	public LoggerThread() {
		
	}
	
	public Appender getAppender() {
		return appender;
	}

	public void setAppender(Appender appender) throws LogException {
		try {
			synchronized (isLoggerInProgress) {
				this.appender = appender;
			}
		} catch(Exception e) {
			throw new LogException(e.getMessage(),e);
		}

	}
	
	public static LoggerThread getInstance() {
		if(loggerTh == null) {
			synchronized (singleTonLockObj) {
				if(loggerTh == null) {
					loggerTh = new LoggerThread();
				}
			}
		}
		return loggerTh;
	}
	
	public void passToAppender(Log log) {
		synchronized (lockObj) {
			logsLi.add(log);
			lockObj.notifyAll();
		}
	}
	
	public void run() {
		while (!shutDown) {
			try {
				Log log = null;
				if (logsLi.size() > 0) {
					synchronized (lockObj) {
						if (logsLi.size() > 0) {
							log = logsLi.remove(0);
						} else {
							lockObj.wait();
						}
					}
				} else {
					synchronized (lockObj) {
						lockObj.wait();
					}
				}
				if(null != log) {
					processLogger(log);
				}
				Thread.sleep(2);
			} catch (InterruptedException ie) {
				System.err.println(ie.getMessage());
			}
		}
	}
	
	private void processLogger(Log log) {
		if(null != appender) {
			synchronized (isLoggerInProgress) {
				try {
					appender.append(log);
				} catch (LogException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
