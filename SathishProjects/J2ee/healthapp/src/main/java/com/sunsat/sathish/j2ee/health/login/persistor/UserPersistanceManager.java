package com.sunsat.sathish.j2ee.health.login.persistor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserPersistanceManager {

    private static UserPersistanceManager userPersistanceManager;

    public static UserPersistanceManager getInstance() {
        if(userPersistanceManager == null) {
            userPersistanceManager = new UserPersistanceManager();
        }
        return userPersistanceManager;
    }

    private UserPersistanceManager() {

    }

    @Autowired
    CommunicationGenericDaoPersistor commDaoPersistor;

    @Autowired
    LoginGenericDaoPersistor loginDaoPersistor;

    @Autowired
    PersonalDetailGenericDaoPersistor personalDetailDaoPersistor;

    @Autowired
    RoleGenericDaoPersistor roleDaoPersistor;

    @Autowired
    UserGenericDaoPersistor userDaoPersistor;

    public CommunicationGenericDaoPersistor getCommDaoPersistor() {
        return commDaoPersistor;
    }

    public LoginGenericDaoPersistor getLoginDaoPersistor() {
        return loginDaoPersistor;
    }

    public PersonalDetailGenericDaoPersistor getPersonalDetailDaoPersistor() {
        return personalDetailDaoPersistor;
    }

    public RoleGenericDaoPersistor getRoleDaoPersistor() {
        return roleDaoPersistor;
    }

    public UserGenericDaoPersistor getUserDaoPersistor() {
        return userDaoPersistor;
    }
}
