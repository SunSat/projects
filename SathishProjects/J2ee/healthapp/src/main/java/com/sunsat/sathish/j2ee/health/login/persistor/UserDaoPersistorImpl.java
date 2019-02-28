package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.RoleDao;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.annotations.Persister;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */

@Repository(value = "userDaoPersistor")
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
        UserDao userDao = getByPrimaryKey(ub);
        return userDao.getBusinessValue(BaseDataFilter.BY_ALL,null,null);
    }

    @Transactional
    @Override
    public UserBusiness updateUserDetails(UserBusiness ub) {
        UserDao dao = getByPrimaryKeyId(ub);
        dao.setBusinessValue(ub);
        return ub;
    }

    @Override
    public UserBusiness getUserByUserName(String un) {
        UserBusiness ub = null;
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserDao> userCriQuery = builder.createQuery(UserDao.class);
        Root<UserDao> userRoot = userCriQuery.from(UserDao.class);
        List<Predicate> userPredicate = new ArrayList<Predicate>(2);
        userPredicate.add(builder.and(builder.equal(userRoot.get("userName"),un),builder.equal(userRoot.get("deleted"),0)));
        List<UserDao> resultList = getByBusinessKey(userRoot,userCriQuery,userPredicate);
        if(CollectionUtils.isEmpty(resultList)) {
            ub = new UserBusiness();
        } else {
            ub = resultList.get(0).getBusinessValue(BaseDataFilter.BY_ALL,null,null);
        }
        return ub;
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

    @Override
    @Transactional
    public UserBusiness performLogin(UserBusiness ub) {
        StoredProcedureQuery query = entityManager.createNamedStoredProcedureQuery("verify_login");
        query.setParameter("user", ub.getUserName());
        query.setParameter("pass", ub.getPassword());
        query.execute();

        String result = (String)query.getOutputParameterValue("message");
        if(result.equalsIgnoreCase("successful")) {
            Long userid = Long.parseLong((String)query.getOutputParameterValue("userid"));
            ub.setPrimaryKeyId(userid);
        }
        ub.setMessage(result);
        ub.setPassword("");
        return ub;
    }

    @Override
    @Transactional
    public UserDao getByPrimaryKeyId(UserBusiness ub) {
        return getByPrimaryKey(ub);
    }

    @Override
    @Transactional
    public Long getLikeCount() {
        Query query = entityManager.createNativeQuery("select count from likecount");
        return ((BigInteger)query.getSingleResult()).longValue();
    }

    @Override
    @Transactional
    public Long updateLikeCount(Long count) {
        Query query = entityManager.createNativeQuery("update likecount set count= :updateCount");
        query.setParameter("updateCount",count);
        query.executeUpdate();
        return count;
    }
}
