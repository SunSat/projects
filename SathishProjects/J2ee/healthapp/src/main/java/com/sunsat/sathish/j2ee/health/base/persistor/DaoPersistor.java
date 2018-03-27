package com.sunsat.sathish.j2ee.health.base.persistor;

import com.sunsat.sathish.j2ee.health.base.BaseConstants;
import com.sunsat.sathish.j2ee.health.base.exceptionHandler.PersistorException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
//Todo: This approch will not help to write junit test cases. Need to change the loadProperties and Init to take parameters. So that it will easy to wirte Junit test cases.

public class DaoPersistor {

    private Properties prop = new Properties();
    private static DaoPersistor conUtil;
    private Connection con;
    private FileReader fr = null;

    private DaoPersistor() {
        loadProperties();
        init();
    }

    private void loadProperties() throws PersistorException{
        try {
            fr = new FileReader(BaseConstants.daoPropPath);
            prop.load(fr);
        } catch (FileNotFoundException fe) {
            throw new PersistorException(fe.getMessage(),"Property file not available","Check JDBC.properties file");
        } catch (IOException ioe) {
            throw new PersistorException(ioe.getMessage(),"Property file not available","Check JDBC.properties file");
        }
    }

    private void init() throws PersistorException {
        try {
            Class.forName(prop.getProperty("jdbc.driver"));
            con = DriverManager.getConnection(prop.getProperty("jdbc.url"),
                    prop.getProperty("jdbc.username"),
                    prop.getProperty("jdbc.password"));

        } catch (ClassNotFoundException ce) {
            throw new PersistorException(ce.getMessage(),"Could not load JDBC driver","Please check JDBC driver available in the path.", ce);
        } catch (SQLException sqe) {
            throw new PersistorException(sqe.getMessage(),"Could not get JDBC connection","Please check JDBC server is up or reachable.", sqe);
        }
    }

    public static DaoPersistor getInstance() {
        if(conUtil == null) {
            synchronized (DaoPersistor.class) {
                if(conUtil == null) {
                    conUtil = new DaoPersistor();
                }
            }
        }
        return conUtil;
    }

    public Connection getCon() {
        return con;
    }
}
