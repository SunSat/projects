package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

public interface UserBusinessService {
    public abstract UserFormModel createNewUser(UserFormModel model);
    public abstract  UserFormModel getExistingUser(UserFormModel model);
    public abstract UserFormModel updateUser(UserFormModel model);

}
