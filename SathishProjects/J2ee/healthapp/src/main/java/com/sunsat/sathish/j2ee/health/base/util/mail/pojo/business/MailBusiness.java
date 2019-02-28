package com.sunsat.sathish.j2ee.health.base.util.mail.pojo.business;

import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.model.MailModel;
import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;

import java.util.Date;
import java.util.List;

public class MailBusiness extends AbstractBaseBusiness<MailModel> {


    private Long primaryKeyId;
    private Integer uniqueId;
    private String functionality;
    private String fromAddress;
    private List<String> toAddress;
    private List<String> ccAddress;
    private List<String> bccAddress;
    private String subject;
    private String body;
    private boolean hasAttachement;
    private boolean isMailSent;
    private Date sendDate;
    List<String> attachmentFilePath;

    @Override
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

    public boolean isHasAttachement() {
        return hasAttachement;
    }

    public void setHasAttachement(boolean hasAttachement) {
        this.hasAttachement = hasAttachement;
    }

    public boolean isMailSent() {
        return isMailSent;
    }

    public void setMailSent(boolean mailSent) {
        isMailSent = mailSent;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public List<String> getAttachmentFilePath() {
        return attachmentFilePath;
    }

    public void setAttachmentFilePath(List<String> attachmentFilePath) {
        this.attachmentFilePath = attachmentFilePath;
    }

    @Override
    public Class getType() {
        return MailBusiness.class;
    }

    @Override
    public void populateData(MailModel mailModel) {
        super.populateData(mailModel);
    }

    @Override
    public void getData(MailModel mailModel) {
        super.getData(mailModel);
    }

    @Override
    public void populateDefaultValue(MailModel mailModel) {
        super.populateDefaultValue(mailModel);
    }
}
