package com.sunsat.sathish.java.hibernate.dao.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by sathishkumar_su on 12/18/2017.
 */
public class DaoFactory {

    private static DaoFactory daoFactory = null;
    private SessionFactory factory = null;

    private DaoFactory() {
        init();
    }

    private void init() {
        try {
            Configuration cfg = new Configuration();
            cfg.configure("database/hibernate.cfg.xml");
            factory = cfg.buildSessionFactory();
        }catch (Exception e) {
            System.err.println("Error while configurating the Dao Factory" + e.getMessage());
        }
    }

    public static DaoFactory getInstance() {
        if(daoFactory == null) {
            synchronized (DaoFactory.class) {
                if(daoFactory == null) {
                    daoFactory = new DaoFactory();
                }
            }
        }
        return daoFactory;
    }

    public SessionFactory getFactory() {
        return factory;
    }
}
