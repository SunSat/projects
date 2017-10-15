package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.exception.LogException;
import static com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch3.logging.Constant.*;

public class PropertyReader {
	
	private String propretyFilenName = "AniSatlogger.properties";
	private Properties logProperties = null;
	private BufferedReader br = null;
	private DateFormat df = null;
	private String logFileName = "";
	
	public PropertyReader(String fileName) {
		this.propretyFilenName = fileName;
	}
	
	protected void prepareLoggingFiles() throws LogException{
		try {
			br = readPropertyFile(propretyFilenName);
			logProperties = loadProperties(br);
			performCleanUp();
		} catch (Exception e) {
			throw new LogException(e.getMessage(),e);
		} 
	}
	
	protected void performCleanUp() throws LogException {
		String fileLocation = logProperties.getProperty(LOGGER_LOGFILE_LOCATION);
		String fileName = logProperties.getProperty(LOGGER_LOGFILE_NAME);
		String identifier = logProperties.getProperty(LOGGER_LOGFILE_IDENFIFIER);
		String format = logProperties.getProperty(LOGGER_LOGFILE_IDENFIFIER_FORMAT);
		cleanUp(fileLocation, fileName, identifier, format);		
		//cleanUp(logProperties.getProperty(LOGGER_LOGFILE_ERR_LOCATION), logProperties.getProperty(LOGGER_LOGFILE_ERR_NAME));
	}
	
	private void cleanUp(String logFileLocation, String logFileName, String idenfier, String pattern) {
		File logDir = new File(logFileLocation);
		if(!logDir.exists()) {
			logDir.mkdirs();
			return;
		}
		logFileName = logFileName.replace(idenfier, "");
		File existLogFile = new File(logFileLocation+File.separator+logFileName);
		if(existLogFile.exists()) {
			DateFormat df = new SimpleDateFormat(pattern);
			String cuDate = df.format(new Date());
			existLogFile.renameTo(new File(logFileLocation+File.separator+logFileName+"."+cuDate));
			existLogFile.delete();
		}
	}
	
	protected BufferedReader readPropertyFile(String fileName)
			throws LogException {
		BufferedReader br = null;
		if (fileName == null || fileName.trim().length() <= 0) {
			throw new LogException("Property File name error.");
		}
		try {
			InputStream in = ClassLoader.getSystemResourceAsStream(fileName);
			if(null == in) {
				throw new LogException("Property File not found Exception");
			}
			br = new BufferedReader(new InputStreamReader(in));
		} catch (Exception e) {
			throw new LogException(e.getMessage(),e);
		}
		return br;
	}
	
	protected List<String> convertReaderToList(BufferedReader in) throws LogException {
		ArrayList<String> al = new ArrayList<String>();
		if(null == in) {
			throw new LogException("input reader null exception");
		}
		try {
			String line = "";
			while((line  = in.readLine()) != null) {
				al.add(line);
			}		
		}catch(IOException ioe) {
			throw new LogException(ioe.getMessage(),ioe);
		}catch(Exception e) {
			throw new LogException(e.getMessage(),e);
		}
		return al;
	}
	
	protected Map<String,List<String>> buildLogData(List<String> listSt) {
		HashMap<String, List<String>> logMap = new HashMap<String, List<String>>();
		return logMap;
	}
	
	protected Properties loadProperties(Reader propertyReader) throws LogException{
		Properties prop = new Properties();
		try {
			prop.load(propertyReader);
		} catch (IOException e) {
			throw new LogException(e.getMessage(), e);
		}
		return prop;
	}
	
	public String getPropretyFilenName() {
		return propretyFilenName;
	}

	public void setPropretyFilenName(String propretyFilenName) {
		this.propretyFilenName = propretyFilenName;
	}

	public Properties getLogProperties() {
		return logProperties;
	}

	public void setLogProperties(Properties logProperties) {
		this.logProperties = logProperties;
	}

	
	public String getLogFileName() {
		return logFileName;
	}

	public void setLogFileName(String logFileName) {
		this.logFileName = logFileName;
	}

	public static void main(String ... args) {
		PropertyReader propReader = null;
		try {
			propReader = new PropertyReader("AniSatlogger.properties");
			propReader.prepareLoggingFiles();
		} catch (LogException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
