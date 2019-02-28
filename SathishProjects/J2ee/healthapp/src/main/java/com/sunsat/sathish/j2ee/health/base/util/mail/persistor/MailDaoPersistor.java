package com.sunsat.sathish.j2ee.health.base.util.mail.persistor;

import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.business.MailBusiness;
import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.dao.MailTrackerDao;

public interface MailDaoPersistor {
    public MailBusiness createNewMail(MailBusiness mb);
    public MailBusiness updateMail(MailBusiness mb);
    public MailBusiness deleteMail(MailBusiness mb);
    public MailBusiness getByPrimarykey(MailBusiness mb);
    public MailTrackerDao getByPrimaryKeyId(MailBusiness mb);
}
