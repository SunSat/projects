package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.PersonalDetailBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.PersonalDetailDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

@Repository(value = "personalDetailDaoPersistor")
public class PersonalDetailDaoPersistorImpl extends AbstractGenericDaoPersistor<PersonalDetailDao, PersonalDetailBusiness, BaseDataFilter> implements PersonalDetailGenericDaoPersistor {

    @Override
    public PersonalDetailDao createDao() {
        return new PersonalDetailDao();
    }

    @Override
    public void appendCriteria(List<Criteria> criteriaList, BaseDataFilter dataFilter) {

    }

    @Override
    public Class getDaoClass() {
        return PersonalDetailDao.class;
    }

    @Override
    public PersonalDetailBusiness populateData(PersonalDetailDao personalDetailDao, BaseDataFilter fd) {
        return null;
    }

    @Override
    public PersonalDetailBusiness getByPrimarykey(PersonalDetailBusiness psb) {
        return getByPrimaryKey(psb).getBusinessValue(BaseDataFilter.BY_ALL,null,null);
    }

    @Override
    public PersonalDetailBusiness createNewPersonalDetail(PersonalDetailBusiness psb) {
        PersonalDetailDao dao = new PersonalDetailDao();
        dao.setBusinessValue(psb);
        persist(dao);
        psb.setPrimaryKeyId(dao.getPrimaryKeyId());
        return psb;
    }

    @Override
    public PersonalDetailBusiness updatePersonalDetail(PersonalDetailBusiness psb) {
        return null;
    }

    @Override
    @Transactional
    public PersonalDetailDao getByPrimaryKeyId(PersonalDetailBusiness ub) {
        return getByPrimaryKey(ub);
    }
}
