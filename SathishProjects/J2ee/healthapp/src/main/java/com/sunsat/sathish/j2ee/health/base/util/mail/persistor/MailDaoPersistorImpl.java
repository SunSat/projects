package com.sunsat.sathish.j2ee.health.base.util.mail.persistor;

import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.business.MailBusiness;
import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.dao.MailTrackerDao;
import com.sunsat.sathish.j2ee.health.base.persistor.AbstractGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import org.hibernate.Criteria;

import java.util.List;

public class MailDaoPersistorImpl extends AbstractGenericDaoPersistor<MailTrackerDao, MailBusiness, BaseDataFilter> implements MailDaoPersistor{

    @Override
    public MailTrackerDao createDao() {
        return new MailTrackerDao();
    }

    @Override
    public void appendCriteria(List<Criteria> criteriaList, BaseDataFilter dataFilter) {

    }

    @Override
    public Class getDaoClass() {
        return MailTrackerDao.class;
    }

    @Override
    public MailBusiness createNewMail(MailBusiness mb) {
        MailTrackerDao dao = new MailTrackerDao();
        dao.setBusinessValue(mb);
        dao = persist(mb);
        mb.setPrimaryKeyId(dao.getPrimaryKeyId());
        return mb;
    }

    @Override
    public MailBusiness updateMail(MailBusiness mb) {
        return null;
    }

    @Override
    public MailBusiness deleteMail(MailBusiness mb) {
        return null;
    }

    @Override
    public MailBusiness getByPrimarykey(MailBusiness mb) {
        return null;
    }

    @Override
    public MailTrackerDao getByPrimaryKeyId(MailBusiness mb) {
        return null;
    }

    @Override
    public MailBusiness populateData(MailTrackerDao mailTrackerDao, BaseDataFilter fd) {
        return null;
    }
}
