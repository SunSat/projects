package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.LoginDao;
import org.springframework.stereotype.Repository;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
@Repository("loginDaoPersistor")
public class LoginDaoPersistorImpl extends AbstractDaoPersistor<LoginDao,UserBusiness> {

    @Override
    public LoginDao createDao() {
        return new LoginDao();
    }

    @Override
    public Class getDaoClass() {
        return LoginDao.class;
    }
}
