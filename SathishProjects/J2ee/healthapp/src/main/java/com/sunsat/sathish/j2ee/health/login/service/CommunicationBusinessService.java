package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

public interface CommunicationBusinessService {
    public UserFormModel createNewCommunication(UserFormModel model);
    public UserFormModel getByAllPrimaryKey(UserFormModel model);
    public UserFormModel updateCommunication(UserFormModel model);
}
