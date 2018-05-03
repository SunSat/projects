package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.model.BaseModel;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
public interface LoginService {
    public void validateLogin();
    public void createNewUser();
    public void updateUser();
    public void deleteUser();
}
