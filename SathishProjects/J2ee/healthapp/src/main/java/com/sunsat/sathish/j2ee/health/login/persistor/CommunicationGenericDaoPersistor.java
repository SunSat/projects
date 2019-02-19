package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.base.persistor.BaseDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.CommunicationDao;

public interface CommunicationGenericDaoPersistor {

    public CommunicationBusiness createNewComm(CommunicationBusiness cmb);
    public CommunicationBusiness updateNewComm(CommunicationBusiness cmb);
    public CommunicationBusiness deleteComm(CommunicationBusiness cmb);
    public CommunicationBusiness getByPrimarykey(CommunicationBusiness cmb);
    public CommunicationDao getByPrimaryKeyId(CommunicationBusiness ub);

}
