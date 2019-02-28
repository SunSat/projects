package com.sunsat.sathish.j2ee.health.base.util.mail.communicator;

import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.business.MailBusiness;

import java.util.List;

public interface MailCommunicator {
    public boolean sendMail(MailBusiness mb);
    public boolean sendMail(List<MailBusiness> mbs);
}
