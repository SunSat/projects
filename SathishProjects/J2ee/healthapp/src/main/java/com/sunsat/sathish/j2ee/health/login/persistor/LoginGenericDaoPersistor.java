package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.BaseDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.LoginDao;

public interface LoginGenericDaoPersistor extends BaseDaoPersistor<LoginDao, LoginBusiness, BaseDataFilter> {

    public LoginBusiness createNewLogin(LoginBusiness cmb);
    public LoginBusiness updateLogin(LoginBusiness cmb);
    public LoginBusiness deleteLogin(LoginBusiness cmb);
    public LoginBusiness getByPrimarykey(LoginBusiness lb);
    public LoginBusiness getAllLoginByUserId(LoginBusiness lb);
    public LoginDao getByPrimaryKeyId(LoginBusiness ub);

}
