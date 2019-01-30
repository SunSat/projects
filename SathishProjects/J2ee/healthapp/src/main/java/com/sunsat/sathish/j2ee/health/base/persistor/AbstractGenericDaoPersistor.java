package com.sunsat.sathish.j2ee.health.base.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.UserDao;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.criteria.Predicate;

/**
 * Created by sathishkumar_su on 4/16/2018.
 */

public abstract class AbstractGenericDaoPersistor<BD extends AbstractBaseDao,BB extends AbstractBaseBusiness, DF extends BaseDataFilter> implements BaseDaoPersistor<BD,BB, DF> {


    @PersistenceContext(unitName="healthapp")
    protected EntityManager entityManager;

    public abstract BD createDao();
    public abstract void appendCriteria(List<Criteria> criteriaList, DF dataFilter);
    public abstract Class getDaoClass();
    public abstract BB populateData(BD bd, DF fd);

    @Override
    @Transactional
    public BD persist(BB bb) {
        BD bd = createDao();
        bd.setBusinessValue(bb);
        entityManager.persist(bd);
        return bd;
    }

    @Override
    @Transactional
    public BD getByPrimaryKey(BB bb) {
        return (BD) entityManager.find(getDaoClass(),bb.getPrimaryKeyId());
    }

    @Transactional
    @Override
    public List<BD> getByBusinessKey(BB bb, List<Predicate> predicateList) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        Class daoClass = getDaoClass();
        CriteriaQuery<BD> criQuery = builder.createQuery(daoClass);
        Root<BD> rootQuery = criQuery.from(daoClass);
        criQuery.select(rootQuery);
        if(null != predicateList && predicateList.size() > 0) {
            criQuery.where(predicateList.toArray(new Predicate[]{}));
        }
        TypedQuery<BD> query = entityManager.createQuery(criQuery);
        if(query == null) {
            return null;
        }
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<BD> getByBusinessKey(Root<BD> root,CriteriaQuery<BD> criQuery, List<Predicate> preList) {
        criQuery.select(root);
        if(null != preList && preList.size() > 0) {
            criQuery.where(preList.toArray(new Predicate[]{}));
        }
        TypedQuery<BD> query = entityManager.createQuery(criQuery);
        return null == query ? Collections.emptyList() : query.getResultList();
    }
    @Transactional
    @Override
    public BD update(BB bb) {
        return null;
    }

    @Override
    public BD deleteByPrimaryKey(BB bb) {
        return null;
    }

    @Override
    public BD getMaxNumber(BB bb) {
        return null;
    }

    @Override
    public List<BD> getByQuery(Class type, String queryst) {
        return entityManager.createQuery(queryst,type).getResultList();
    }

    @Override
    public List<BD> getByQuery(String queryst) {
        return null;
    }

    @Override
    public EntityManager getManager() {
        return entityManager;
    }
}
