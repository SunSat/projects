package com.sunsat.sathish.j2ee.health.base.util.mail.communicator;

import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.business.MailBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class MailCommunicatorImpl implements MailCommunicator {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Override
    public boolean sendMail(MailBusiness mb) {

        boolean isMailSent = true;
        MimeMessage msg = null;
        MimeMessageHelper helper = null;

        try {
            msg = mailSender.createMimeMessage();
            helper =  new MimeMessageHelper(msg,false);
            helper.setTo(StringUtils.collectionToCommaDelimitedString(mb.getToAddress()));
            helper.setSubject(mb.getSubject());
            helper.setText(mb.getBody(),true);
            helper.setSentDate(mb.getSendDate());
            helper.setFrom("sundar.sat84@gmail.com");
            mailSender.send(msg);
        } catch (MessagingException e) {
            isMailSent = false;
        }
        return isMailSent;
    }

    @Override
    public boolean sendMail(List<MailBusiness> mbs) {
        return false;
    }
}
