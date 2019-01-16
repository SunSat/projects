package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */

public class UserDaoPersistorImpl extends AbstractGenericDaoPersistor<UserDao,UserBusiness,BaseDataFilter> implements UserGenericDaoPersistor {

    @Autowired
    @PersistenceContext
    EntityManager entityManager;

    public UserDao createDao() {
        return new UserDao();
    }

    public Class getDaoClass() {
        return UserDao.class;
    }

    public void appendCriteria(List<Criteria> criteriaList, BaseDataFilter dataFilter) {

    }

    public UserBusiness populateData(UserDao userDao, BaseDataFilter fd) {
        return null;
    }

    public List<UserBusiness> getAllByCriteria(String query) {
        return null;
    }

    @Override
    public UserBusiness createNewUser(UserBusiness ub) {
        return null;
    }

    @Override
    public UserBusiness getUserDetails(UserBusiness ub) {
        return null;
    }

    @Override
    public UserBusiness updateUserDetails(UserBusiness ub) {
        return null;
    }

    @Override
    public UserBusiness getUserByUserName(String ub) {
        return null;
    }

    @Override
    public UserBusiness deleteUserById(UserBusiness ub) {
        return null;
    }

    @Override
    public String validateUser(UserBusiness ub) {
        return null;
    }

    @Override
    public String validateUserMailId(UserBusiness ub) {
        return null;
    }

    @Override
    public String validateUserMobNo(UserBusiness ub) {
        return null;
    }
}
