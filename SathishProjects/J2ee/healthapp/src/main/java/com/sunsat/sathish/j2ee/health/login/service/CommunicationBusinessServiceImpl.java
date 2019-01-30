package com.sunsat.sathish.j2ee.health.login.service;

import com.sunsat.sathish.j2ee.health.base.businessService.AbstractBusinessService;
import com.sunsat.sathish.j2ee.health.login.persistor.CommunicationDaoPersistorImpl;
import com.sunsat.sathish.j2ee.health.login.persistor.CommunicationGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.persistor.UserGenericDaoPersistor;
import com.sunsat.sathish.j2ee.health.login.pojo.business.CommunicationBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.CommunicationDao;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("communicationService")
public class CommunicationBusinessServiceImpl extends AbstractBusinessService<UserFormModel> implements CommunicationBusinessService {

    @Autowired
    CommunicationGenericDaoPersistor commDaoPersistor;

    @Autowired
    UserGenericDaoPersistor userDaoPersistor;

    @Override
    @Transactional
    public UserFormModel createNewCommunication(UserFormModel model) {
        CommunicationBusiness cb = new CommunicationBusiness();
        UserBusiness ub = new UserBusiness();
        ub.setPrimaryKeyId(model.getPrimarykeyId());
        cb.setUserBusiness(ub);
        cb.setEmail1(model.getMailId());
        if(model.getMailId() != null && model.getMailId().trim().length() > 0) {
            cb.setEmail1Verified(false);
            cb.setEmail1CnfToken(1234);
            cb.setEmail1CnfTokenExpiryDate(new Date());
        }
        cb.setMobile1(model.getMobileNo());
        cb.populateData(model);
        commDaoPersistor.createNewComm(cb);
        return null;
    }

    @Override
    public UserFormModel getByAllPrimaryKey(UserFormModel model) {
        return null;
    }

    @Override
    public UserFormModel updateCommunication(UserFormModel model) {
        return null;
    }
}
