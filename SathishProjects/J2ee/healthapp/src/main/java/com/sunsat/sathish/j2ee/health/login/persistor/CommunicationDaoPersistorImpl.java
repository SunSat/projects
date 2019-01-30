package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.CommunicationDao;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("commDaoPersistor")
public class CommunicationDaoPersistorImpl extends AbstractGenericDaoPersistor<CommunicationDao, CommunicationBusiness, BaseDataFilter> implements CommunicationGenericDaoPersistor{


    @Override
    public CommunicationDao createDao() {
        return new CommunicationDao();
    }

    @Override
    public void appendCriteria(List<Criteria> criteriaList, BaseDataFilter dataFilter) {

    }

    @Override
    public Class getDaoClass() {
        return CommunicationDao.class;
    }

    @Override
    public CommunicationBusiness populateData(CommunicationDao communicationDao, BaseDataFilter fd) {
        return null;
    }

    @Override
    @Transactional
    public CommunicationBusiness createNewComm(CommunicationBusiness cmb) {
        CommunicationDao dao = super.persist(cmb);
        cmb.setPrimaryKeyId(dao.getPrimaryKeyId());
        return cmb;
    }

    @Override
    public CommunicationBusiness updateNewComm(CommunicationBusiness cmb) {
        return null;
    }

    @Override
    public CommunicationBusiness deleteComm(CommunicationBusiness cmb) {
        return null;
    }
}
