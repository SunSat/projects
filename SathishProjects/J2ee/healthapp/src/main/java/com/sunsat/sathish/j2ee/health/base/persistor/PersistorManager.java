package com.sunsat.sathish.j2ee.health.base.persistor;


import com.sunsat.sathish.j2ee.health.login.persistor.CommunicationGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.persistor.UserGenericDaoPersistor;
import org.springframework.beans.factory.annotation.Autowired;


public class PersistorManager {

    public static PersistorManager pmanager;

    public static PersistorManager getInstance() {
        if(pmanager == null) {
            pmanager = new PersistorManager();
        }
        return pmanager;
    }

    private PersistorManager() {

    }

    @Autowired
    UserGenericDaoPersistor userDaoPersistor;

    @Autowired
    CommunicationGenericDaoPersistor commDaoPersistor;

    public UserGenericDaoPersistor getUserPersistor() {
        return userDaoPersistor;
    }

    public CommunicationGenericDaoPersistor getCommPersistor() {
        return commDaoPersistor;
    }
}
