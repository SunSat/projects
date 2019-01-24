package com.sunsat.sathish.j2ee.health.base.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by sathishkumar_su on 4/16/2018.
 */

public abstract class AbstractGenericDaoPersistor<BD extends AbstractBaseDao,BB extends AbstractBaseBusiness, DF extends BaseDataFilter> implements BaseDaoPersistor<BD,BB, DF> {


    @PersistenceContext(unitName="healthapp")
    protected EntityManager mgr;

    public abstract BD createDao();
    public abstract void appendCriteria(List<Criteria> criteriaList, DF dataFilter);
    public abstract Class getDaoClass();
    public abstract BB populateData(BD bd, DF fd);

    @Override
    @Transactional(readOnly = true)
    public BD persist(BB bb) {
        BD bd = createDao();
        //bd.setBusinessValue(bb);
        mgr.persist(bd);
        return bd;
    }

    @Override
    public BD getByPrimaryKey(BB bb) {
        return (BD)mgr.find(bb.getType(),bb.getPrimarykeyId());
    }

    @Override
    public List<BD> getByBusinessKey(BB bb, List<Criteria> criteriaList) {
        return null;
    }

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
        return mgr.createQuery(queryst,type).getResultList();
    }

    @Override
    public List<BD> getByQuery(String queryst) {
        return null;
    }
}
