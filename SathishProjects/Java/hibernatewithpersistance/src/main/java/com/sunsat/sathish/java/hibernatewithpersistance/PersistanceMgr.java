package com.sunsat.sathish.java.hibernatewithpersistance;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistanceMgr {

    private static EntityManagerFactory factory = null;

    public static EntityManager getManager() {
        factory = Persistence.createEntityManagerFactory("persistanceWithHibernate");
        return factory.createEntityManager();
    }

    public static void closeEntityManager(EntityManager mgr) {
        mgr.clear();
        mgr.close();
    }

    public  static void closeMgrFactory(EntityManager mgr) {
        mgr.close();
        factory.close();
    }

}
