package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import org.hibernate.Criteria;
import org.hibernate.annotations.Persister;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */

public class UserDaoPersistorImpl extends AbstractGenericDaoPersistor<UserDao,UserBusiness,BaseDataFilter> implements UserGenericDaoPersistor {

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

    @Transactional
    @Override
    public UserBusiness createNewUser(UserBusiness ub) {
        UserDao userDao = persist(ub);
        ub.setPrimaryKeyId(userDao.getPrimaryKeyId());
        return ub;
    }

    @Transactional
    @Override
    public UserBusiness getUserDetails(UserBusiness ub) {
/*
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDao> criteriaQuery = builder.createQuery(UserDao.class);
        Root<UserDao> root =  criteriaQuery.from(UserDao.class);
        criteriaQuery.select(root);
        TypedQuery<UserDao>  query = entityManager.createQuery(criteriaQuery);
        List<UserDao> resultList = query.getResultList();
        if(null == resultList || resultList.size() == 0) return new UserBusiness();
        UserDao dao = resultList.get(0);
        return dao.getBusinessValue(BaseDataFilter.BY_ALL,null);
*/
        UserDao userDao = getByPrimaryKey(ub);
        return userDao.getBusinessValue(BaseDataFilter.BY_ALL,null);
    }

    @Override
    public UserBusiness updateUserDetails(UserBusiness ub) {
        return null;
    }

    @Override
    public UserBusiness getUserByUserName(String un) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDao> userCriQuery = builder.createQuery(UserDao.class);
        Root<UserDao> userRoot = userCriQuery.from(UserDao.class);
        List<Predicate> userPredicate = new ArrayList<Predicate>(2);
        userPredicate.add(builder.and(builder.equal(userRoot.get("userName"),un),builder.equal(userRoot.get("deleted"),0)));
        List<UserDao> resultList = getByBusinessKey(userRoot,userCriQuery,userPredicate);
        if(null == resultList || resultList.size() == 0) return null;
        UserDao dao = resultList.get(0);
        return dao.getBusinessValue(BaseDataFilter.BY_ALL,null);
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
