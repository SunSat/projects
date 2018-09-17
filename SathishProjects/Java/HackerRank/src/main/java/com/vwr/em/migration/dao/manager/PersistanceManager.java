package com.vwr.em.migration.dao.manager;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import static com.vwr.em.migration.util.MigrationConstants.HIBERNATE_PROPERTYPATH;

/**
 * Created by sathishkumar_su on 7/12/2018.
 */
public class PersistanceManager {

    private static PersistanceManager pManager;
    private static Logger logger = Logger.getLogger(PersistanceManager.class);
    private SessionFactory factory = null;

    private PersistanceManager() {
        init();
    }

    public static PersistanceManager getInstance() {
        if(pManager == null) {
            pManager = new PersistanceManager();
        }
        return pManager;
    }

    private void init() throws HibernateException {
        logger.debug("Initiating Hibernate ORM");
        Configuration cfg = new Configuration();
        cfg.configure(HIBERNATE_PROPERTYPATH);
        factory = cfg.buildSessionFactory();
        logger.debug("Initied Hibernate ORM successfully");
    }

    public SessionFactory getFactory() {
        return factory;
    }

    public void closeFactory() {
        try {
            if(factory != null) {
                factory.close();
            }
        }catch (Exception e) {
            logger.error("Error while closing DB connection factory. : ", e);
        }
    }
}
