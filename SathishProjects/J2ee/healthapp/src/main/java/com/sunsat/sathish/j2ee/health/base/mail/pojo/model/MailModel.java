package com.sunsat.sathish.j2ee.health.base.mail.pojo.model;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;

import java.util.List;

public class MailModel extends AbstractBaseModel {

    List<String> toAddress;
    String subject;
    String content;
    Integer hasAttachement;
    List<String> attachmentsFilePath;


    public List<String> getToAddress() {
        return toAddress;
    }

    public void setToAddress(List<String> toAddress) {
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getHasAttachement() {
        return hasAttachement;
    }

    public void setHasAttachement(Integer hasAttachement) {
        this.hasAttachement = hasAttachement;
    }

    public List<String> getAttachmentsFilePath() {
        return attachmentsFilePath;
    }

    public void setAttachmentsFilePath(List<String> attachmentsFilePath) {
        this.attachmentsFilePath = attachmentsFilePath;
    }
}
