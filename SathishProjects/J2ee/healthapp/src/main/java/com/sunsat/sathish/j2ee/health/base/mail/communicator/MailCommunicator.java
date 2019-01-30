package com.sunsat.sathish.j2ee.health.base.mail.communicator;

import com.sunsat.sathish.j2ee.health.base.mail.pojo.business.MailBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;

import java.util.List;

public interface MailCommunicator {
    public boolean sendMail(MailBusiness mb);
    public boolean sendMail(List<MailBusiness> mbs);
}
