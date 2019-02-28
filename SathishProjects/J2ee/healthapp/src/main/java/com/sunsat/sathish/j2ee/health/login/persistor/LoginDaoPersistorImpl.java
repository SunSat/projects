package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.LoginBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.LoginDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sathishkumar_su on 4/18/2018.
 */

@Repository(value = "loginDaoPersistor")
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

    @Override
    @Transactional
    public LoginBusiness createNewLogin(LoginBusiness cmb) {
        LoginDao dao = new LoginDao();
        dao.setBusinessValue(cmb);
        dao = persist(dao);
        cmb.setPrimaryKeyId(dao.getPrimaryKeyId());
        return cmb;
    }

    @Override
    @Transactional
    public LoginBusiness updateLogin(LoginBusiness cmb) {
        LoginDao dao = getByPrimaryKey(cmb);
        dao.setBusinessValue(cmb);
        return cmb;
    }

    @Override
    public LoginBusiness deleteLogin(LoginBusiness cmb) {
        return null;
    }

    public LoginBusiness getByPrimarykey(LoginBusiness lb) {
        return getByPrimaryKey(lb).getBusinessValue(BaseDataFilter.BY_ALL,null,null);
    }

    @Override
    @Transactional
    public LoginDao getByPrimaryKeyId(LoginBusiness ub) {
        return getByPrimaryKey(ub);
    }

    @Transactional
    @Override
    public LoginBusiness getAllLoginByUserId(LoginBusiness lb) {
        Long loginPrimaryKey = lb.getPrimaryKeyId();
        Long userPrimaryKey = lb.getUserBusiness().getPrimaryKeyId();

        CriteriaBuilder loginBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<LoginDao> loginCriQuery = loginBuilder.createQuery(LoginDao.class);
        Root<LoginDao> loginRoot = loginCriQuery.from(LoginDao.class);
        List<Predicate> loginPredicate = new ArrayList<Predicate>(2);
        loginPredicate.add(loginBuilder.and(loginBuilder.equal(loginRoot.get("id"),loginPrimaryKey),
                loginBuilder.equal(loginRoot.get("user_id"),userPrimaryKey),
                loginBuilder.equal(loginRoot.get("delete"),0)));
        List<LoginDao> loginResultList = getByBusinessKey(loginRoot,loginCriQuery,loginPredicate);
        if(null == loginResultList || loginResultList.size() == 0) return null;
        return loginResultList.get(0).getBusinessValue(BaseDataFilter.BY_ALL,null,null);
    }
}
