package com.sunsat.sathish.j2ee.store.dao.factory;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by sathishkumar_su on 1/4/2018.
 */
public class DaoConnectionFactory {
    private static DaoConnectionFactory daoFactory = null;
    Connection con;

    private DaoConnectionFactory() {
        //initProperties();
        loadDriver();
        createConnection();
    }

    public static DaoConnectionFactory getInstance() {
        if(daoFactory == null) {
            synchronized (DaoConnectionFactory.class) {
                if(daoFactory == null) {
                    daoFactory = new DaoConnectionFactory();
                }
            }
        }
        return daoFactory;
    }

    private void loadDriver() {

    }

    private void initProperties() {
        Properties prop = new Properties();
        try {
            prop.load(this.getClass().getResourceAsStream("databaes.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createConnection() {

    }

}
