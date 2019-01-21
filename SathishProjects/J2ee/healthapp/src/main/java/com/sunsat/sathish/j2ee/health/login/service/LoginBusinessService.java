package com.sunsat.sathish.j2ee.health.login.service;


import com.sunsat.sathish.j2ee.health.base.businessService.AbstractBusinessService;
import com.sunsat.sathish.j2ee.health.base.businessService.BaseBusinessService;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

public interface LoginBusinessService extends BaseBusinessService<UserFormModel> {

    public abstract UserFormModel createNewUser(UserFormModel model);
    public abstract  UserFormModel getExistingUser(UserFormModel model);
    public abstract UserFormModel updateUser(UserFormModel model);
}
