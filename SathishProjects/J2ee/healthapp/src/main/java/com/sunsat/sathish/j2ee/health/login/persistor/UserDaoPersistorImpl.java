package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

    @Transactional
    @Override
    public UserBusiness createNewUser(UserBusiness ub) {
        UserDao userDao = new UserDao();
        userDao.setBusinessValue(ub);
        mgr.persist(userDao);
        ub.setPrimarykeyId(userDao.getPrimarykeyId());
        ub.setDescription("successful");
        return ub;
    }

    @Transactional
    @Override
    public UserBusiness getUserDetails(UserBusiness ub) {
        CriteriaBuilder builder = mgr.getCriteriaBuilder();
        CriteriaQuery<UserDao> criteriaQuery = builder.createQuery(UserDao.class);
        Root<UserDao> root =  criteriaQuery.from(UserDao.class);
        criteriaQuery.select(root);
        TypedQuery<UserDao>  query = mgr.createQuery(criteriaQuery);
        List<UserDao> resultList = query.getResultList();
        if(null == resultList || resultList.size() == 0) return new UserBusiness();
        UserDao dao = resultList.get(0);
        return dao.getBusinessValue(BaseDataFilter.BY_ALL,null);
    }

    @Override
    public UserBusiness updateUserDetails(UserBusiness ub) {
        return null;
    }

    @Override
    public UserBusiness getUserByUserName(String un) {
        CriteriaBuilder builder = mgr.getCriteriaBuilder();
        CriteriaQuery<UserDao> criQuery = builder.createQuery(UserDao.class);
        Root<UserDao> rootQuery = criQuery.from(UserDao.class);
        criQuery.select(rootQuery);
        criQuery.where(builder.equal(rootQuery.get("userName"),un));
        TypedQuery<UserDao> query = mgr.createQuery(criQuery);
        List<UserDao> resultList = query.getResultList();
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
