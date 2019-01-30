package com.sunsat.sathish.j2ee.health.base.mail.communicator;

import com.sunsat.sathish.j2ee.health.base.mail.pojo.business.MailBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class MailCommunicatorImpl implements MailCommunicator {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Override
    public boolean sendMail(MailBusiness mb) {
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setTo(StringUtils.collectionToCommaDelimitedString(mb.getToAddress()));
        mailMsg.setSubject(mb.getSubject());
        mailMsg.setText(mb.getContent());
        mailMsg.setFrom("sundar.sat84@gmail.com");
        mailSender.send(mailMsg);
        return true;
    }

    @Override
    public boolean sendMail(List<MailBusiness> mbs) {
        return false;
    }
}
