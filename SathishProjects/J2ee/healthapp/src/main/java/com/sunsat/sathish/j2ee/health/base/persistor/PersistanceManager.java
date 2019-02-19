package com.sunsat.sathish.j2ee.health.base.persistor;


import com.sunsat.sathish.j2ee.health.login.persistor.CommunicationGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.persistor.UserGenericDaoPersistor;
import org.springframework.beans.factory.annotation.Autowired;


public class PersistanceManager {

    private static PersistanceManager pmanager;

    public static PersistanceManager getInstance() {
        if (pmanager == null) {
            pmanager = new PersistanceManager();
        }
        return pmanager;
    }

    private PersistanceManager() {

    }
}
