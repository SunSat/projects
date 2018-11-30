package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */

@Repository("userDaoPersistor")
public class UserDaoPersistorImpl extends AbstractDaoPersistor<UserDao, UserBusiness> {


    @Override
    public UserDao createDao() {
        return new UserDao();
    }

    @Override
    public Class getDaoClass() {
        return UserDao.class;
    }
}
