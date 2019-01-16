package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.LoginDao;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */
public class LoginDaoPersistorImpl extends AbstractGenericDaoPersistor<LoginDao, LoginBusiness, BaseDataFilter> implements LoginGenericDaoPersistor {

    //private static LoginDaoPersistorImpl loginPersistor;

    public LoginDaoPersistorImpl() {
        super();
    }

    @Override
    public LoginDao createDao() {
        return new LoginDao();
    }

    @Override
    public Class getDaoClass() {
        return LoginDao.class;
    }

    @Override
    public void appendCriteria(List<Criteria> criteriaList, BaseDataFilter filter) {

    }

    @Override
    public LoginBusiness populateData(LoginDao ud, BaseDataFilter baseDataFilter) {
        LoginBusiness userData = new LoginBusiness();
        switch(baseDataFilter.BY_ALL) {

        }
        return userData;
    }
}
