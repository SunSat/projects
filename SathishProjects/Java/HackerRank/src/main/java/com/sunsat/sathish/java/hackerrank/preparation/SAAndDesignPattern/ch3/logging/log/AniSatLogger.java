package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log;

import java.util.Collections;
import java.util.List;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.exception.LogException;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.appender.Appender;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.appender.FileAppender;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.dispatcher.Dispatcher;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.logger.LoggerThread;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Log;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Mode;
import static com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.Constant.*;

public final class AniSatLogger {

	private static Object lockObj = new Object(); 
	private static AniSatLogger logger = null;
	private Mode mode = Mode.All;
	private Dispatcher disThread = null;
	private LoggerThread loggerTh = null;
	private Appender appender = null;
	private PropertyReader propReader = null;
	
	private AniSatLogger() {
		loggerTh = LoggerThread.getInstance();
		loggerTh.setName("FinalLoggerThread");
		loggerTh.start();
		disThread = Dispatcher.getInstance();
		disThread.setName("DispatcherThread :");
		disThread.start();
		readProperty();	
	}
	
	public void readProperty() {
		propReader = new PropertyReader("AniSatlogger.properties");
		try {
			propReader.prepareLoggingFiles();
			Appender appender = null;
			String apType = propReader.getLogProperties().getProperty(LOGGER_LOG_APPENDER);
			if(apType.equals(LOGGER_LOG_APPENDER_TYPE_FILE)) {
				appender = new FileAppender(propReader.getLogProperties());
			}
			loggerTh.setAppender(appender);
		} catch (LogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static AniSatLogger getInstance() {
		if(logger == null) {
			synchronized (lockObj) {
				if(logger == null) {
					logger = new AniSatLogger();
				}
			}
		}
		return logger;
	}
	
	public void log(String msg, Mode mode) {
		if(mode.equals(this.mode)) {
			Log log = new Log(msg,mode);	
			addToDispatcher(log);
		}
	}
	
	public void log(String msg, Mode mode, Exception e) {
		if(mode.equals(this.mode)) {
			Log log = new Log(msg,e,mode);
			addToDispatcher(log);
		}
	}
	
	public void fine(String msg) {
		if(this.mode == Mode.Fine) {
			Log log = new Log(msg, Mode.Fine);
			addToDispatcher(log);
		}
	}
	
	public void debug(String msg) {
		if(this.mode == Mode.Debug) {
			Log log = new Log(msg, Mode.Debug);
			addToDispatcher(log);
		}
	}
	
	public void error(String msg, Exception e) {
		Log log = new Log(msg,e,Mode.Error);
		addToDispatcher(log);
	}

	private void addToDispatcher(Log log) {
		disThread.addLog(log);		
	}
	
	public void compareResult(List<String> orginal) {
		List<String> finalLi = disThread.getFilanResult(); 
		System.out.println("I am in compareResult and going to compare :");
		Collections.sort(orginal);
		Collections.sort(finalLi);
		System.out.println(orginal.containsAll(finalLi));
		System.out.println("The Original is : " + orginal);
		System.out.println("The final    is : " + finalLi);
		
	}
	
	public void shutDown() {
		disThread.shutDown(true);
	}

	public Mode getMode() {
		return mode;
	}

	public void setMode(Mode mode) {
		this.mode = mode;
	}

	public PropertyReader getPropReader() {
		return propReader;
	}

	public void setPropReader(PropertyReader propReader) {
		this.propReader = propReader;
	}
}
