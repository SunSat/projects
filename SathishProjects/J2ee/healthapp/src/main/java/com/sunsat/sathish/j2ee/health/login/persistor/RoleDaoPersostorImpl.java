package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.RoleDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository(value = "roleDaoPersistor")
public class RoleDaoPersostorImpl extends AbstractGenericDaoPersistor<RoleDao, RoleBusiness, BaseDataFilter> implements RoleGenericDaoPersistor{
    @Override
    public RoleDao createDao() {
        return new RoleDao();
    }

    @Override
    public void appendCriteria(List<Criteria> criteriaList, BaseDataFilter dataFilter) {

    }

    @Override
    public Class getDaoClass() {
        return RoleDao.class;
    }

    @Override
    public RoleBusiness populateData(RoleDao roleDao, BaseDataFilter fd) {
        return null;
    }

    @Override
    public RoleBusiness getByPrimarykey(RoleBusiness rb) {
        return getByPrimaryKey(rb).getBusinessValue(BaseDataFilter.BY_ALL,null,null);
    }

    @Override
    public RoleBusiness createNewRole(RoleBusiness rb) {
        RoleDao dao = new RoleDao();
        dao.setBusinessValue(rb);
        persist(dao);
        return dao.getBusinessValue(BaseDataFilter.BY_ALL,null,null);
    }

    @Override
    public RoleBusiness updateRole(RoleBusiness rb) {
        return null;
    }

    @Override
    @Transactional
    public RoleDao getByPrimaryKeyId(RoleBusiness ub) {
        return getByPrimaryKey(ub);
    }
}
