package com.sunsat.sathish.j2ee.health.base.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.BaseDao;
import org.hibernate.Criteria;

import java.util.List;

/**
 * Created by sathishkumar_su on 4/16/2018.
 */
public interface BaseDaoPersistor<BD extends BaseDao,BB extends BaseBusiness, DF extends BaseDataFilter> {

    public BD createDao();
    public Class getDaoClass();
    public BD getByPrimaryKey(BB bb);
    public List<BD> getByBusinessKey(BB bb, List<Criteria> criteriaList);
    public void appendCriteria(List<Criteria> criteriaList,DF df);
    public BD persist(BB bb);
    public BD update(BB bb);
    public BD deleteByPrimaryKey(BB bb);
    public BD getMaxNumber(BB bb);
    public List<BD> getByQuery(Class type,String query);
    public List<BD> getByQuery(String query);
    public BB populateData(BD bd, DF df);
}
