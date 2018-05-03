package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.LoginDao;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
public class UserPersistor extends AbstractDaoPersistor<LoginDao,LoginBusiness> {

    @Override
    public LoginDao save(LoginBusiness loginBusiness) {
        return null;
    }

    @Override
    public LoginDao get(LoginBusiness loginBusiness) {
        return null;
    }

    @Override
    public LoginDao update(LoginBusiness loginBusiness) {
        return null;
    }

    @Override
    public LoginDao load(LoginBusiness loginBusiness) {
        return null;
    }

    @Override
    public LoginDao getById(LoginBusiness loginBusiness) {
        return null;
    }

    @Override
    public LoginDao getByName(LoginBusiness loginBusiness) {
        return null;
    }

    @Override
    public LoginBusiness getMaxNumber(LoginBusiness loginBusiness) {
        return null;
    }
}
