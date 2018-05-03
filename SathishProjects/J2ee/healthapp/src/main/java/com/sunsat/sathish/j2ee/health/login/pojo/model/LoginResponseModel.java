package com.sunsat.sathish.j2ee.health.login.pojo.model;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
public class LoginResponseModel extends AbstractBaseModel {

    String userName;
    String formOperation;
    String signInSource;
    String passwordResetOperaiton;
    String token;
    String mailId;

}
