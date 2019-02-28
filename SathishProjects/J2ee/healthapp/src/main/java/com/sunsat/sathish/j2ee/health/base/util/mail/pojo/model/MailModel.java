package com.sunsat.sathish.j2ee.health.base.util.mail.pojo.model;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;

import java.util.Date;
import java.util.List;

public class MailModel extends AbstractBaseModel {

    Long primaryKeyId;
    Integer uniqueId;
    String functionality;
    String fromAddress;
    List<String> toAddress;
    List<String> ccAddress;
    List<String> bccAddress;
    String subject;
    String body;
    Integer hasAttachement;
    List<String> attachmentFilePath;
    Boolean isMailSent;
    Date senddate;

    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(Long primaryKeyId) {
        this.primaryKeyId = primaryKeyId;
    }

    public Integer getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Integer uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getFunctionality() {
        return functionality;
    }

    public void setFunctionality(String functionality) {
        this.functionality = functionality;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public List<String> getToAddress() {
        return toAddress;
    }

    public void setToAddress(List<String> toAddress) {
        this.toAddress = toAddress;
    }

    public List<String> getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(List<String> ccAddress) {
        this.ccAddress = ccAddress;
    }

    public List<String> getBccAddress() {
        return bccAddress;
    }

    public void setBccAddress(List<String> bccAddress) {
        this.bccAddress = bccAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Integer getHasAttachement() {
        return hasAttachement;
    }

    public void setHasAttachement(Integer hasAttachement) {
        this.hasAttachement = hasAttachement;
    }

    public List<String> getAttachmentFilePath() {
        return attachmentFilePath;
    }

    public void setAttachmentFilePath(List<String> attachmentFilePath) {
        this.attachmentFilePath = attachmentFilePath;
    }

    public Boolean getMailSent() {
        return isMailSent;
    }

    public void setMailSent(Boolean mailSent) {
        isMailSent = mailSent;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }


}
