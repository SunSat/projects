package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log.thread.appender;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.exception.LogException;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.pojo.Log;
import static com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.Constant.*;

public class FileAppender implements Appender {
	
	Properties prop = null;
	int size = 0;
	File logFile = null;
	DateFormat df = null;
	BufferedWriter brOut = null;
	
		
	public FileAppender(Properties fileProp) throws LogException {
		this.prop = fileProp;
		prepareAppender();
	}
	
	private void prepareAppender() throws LogException {
		String logFileLoca = prop.getProperty(LOGGER_LOGFILE_LOCATION);
		String logFileName = prop.getProperty(LOGGER_LOGFILE_NAME);
		String logFileIden = prop.getProperty(LOGGER_LOGFILE_IDENFIFIER);
		String logFileFormat = prop.getProperty(LOGGER_LOGFILE_IDENFIFIER_FORMAT);
		String finalLogName = logFileLoca+File.separator+logFileName.replace(logFileIden, "");
		df = new SimpleDateFormat(logFileFormat);
		logFile = new File(finalLogName);
			try {
				if(logFile.exists()) {
					logFile.renameTo(new File(finalLogName+"."+df.format(new Date())));
					logFile.delete();
				}
				logFile.createNewFile();
				brOut = new BufferedWriter(new FileWriter(logFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new LogException(e.getMessage(),e);
			}
	}
	
	@Override
	public void append(Log log) throws LogException {
		StringBuilder stBu = new StringBuilder("[" + df.format(log.getDate()) + " : " + log.getClassName() + " : " + log.getMode().toString()+ "]" + log.getMsg() + "\n");
		String logSt = stBu.toString();
		size += logSt.length();
		try {
			brOut.write(logSt);
			brOut.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
