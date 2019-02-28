package com.sunsat.sathish.j2ee.health.base.util.mail.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.util.mail.pojo.business.MailBusiness;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mail_tracker")
public class MailTrackerDao extends AbstractBaseDao<MailBusiness, BaseDataFilter> {

    @Override
    public Class getType() {
        return MailTrackerDao.class;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long primaryKeyId;

    @Column(name = "uniqueid")
    private Integer uniqueId;

    @Column(name = "functionality")
    private String functionality;

    @Column(name = "fromaddress")
    private String fromAddress;

    @Column(name = "toaddress")
    private String toAddress;

    @Column(name = "ccaddress")
    private String ccAddress;

    @Column(name = "bccaddress")
    private String bccAddress;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    @Column(name = "hasattachment")
    private Boolean hasAttachment;

    @Column(name = "attachmentfilepath")
    private String attachmentFilePath;

    @Column(name = "ismailsent")
    private Boolean isMailSent;

    @Column(name = "senddate")
    private Date sendDate;

    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    @Override
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

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public String getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String getBccAddress() {
        return bccAddress;
    }

    public void setBccAddress(String bccAddress) {
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

    public Boolean getHasAttachment() {
        return hasAttachment;
    }

    public void setHasAttachment(Boolean hasAttachment) {
        this.hasAttachment = hasAttachment;
    }

    public String getAttachmentFilePath() {
        return attachmentFilePath;
    }

    public void setAttachmentFilePath(String attachmentFilePath) {
        this.attachmentFilePath = attachmentFilePath;
    }

    public Boolean getMailSent() {
        return isMailSent;
    }

    public void setMailSent(Boolean mailSent) {
        isMailSent = mailSent;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    @Override
    public MailBusiness getBusinessValue(BaseDataFilter baseDataFilter, MailBusiness businessValue, List<Class> parentClasses) {
        if(businessValue == null) businessValue = new MailBusiness();
        switch (baseDataFilter) {
            case BY_ALL:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                businessValue.setUniqueId(this.getUniqueId());
                businessValue.setFunctionality(this.getFunctionality());
                businessValue.setFromAddress(this.getFromAddress());
                businessValue.setToAddress(Arrays.asList(this.getToAddress().split(",")));
                if(this.getCcAddress() != null && this.getCcAddress().trim().length() > 0)
                    businessValue.setCcAddress(Arrays.asList(this.getCcAddress().split(",")));
                if(this.getBccAddress() != null && this.getBccAddress().trim().length() > 0)
                    businessValue.setBccAddress(Arrays.asList(this.getBccAddress().split(",")));
                businessValue.setSubject(this.getSubject());
                businessValue.setBody(this.getBody());
                businessValue.setHasAttachement(this.getHasAttachment());
                if(this.getHasAttachment())
                    businessValue.setAttachmentFilePath(Arrays.asList(this.getAttachmentFilePath().split(",")));
                businessValue.setMailSent(this.getMailSent());
                businessValue.setSendDate(this.getSendDate());
                break;
            case BY_ID:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                break;
        }
        return super.getBusinessValue(baseDataFilter, businessValue, parentClasses);
    }

    @Override
    public void setBusinessValue(MailBusiness businessValue) {
        this.setUniqueId(businessValue.getUniqueId());
        this.setFunctionality(businessValue.getFunctionality());
        this.setFromAddress(businessValue.getFromAddress());
        this.setToAddress(StringUtils.collectionToCommaDelimitedString(businessValue.getToAddress()));
        List<String> addList = businessValue.getCcAddress();
        if(!CollectionUtils.isEmpty(addList))
            this.setCcAddress(StringUtils.collectionToCommaDelimitedString(addList));

        addList = businessValue.getBccAddress();
        if(!CollectionUtils.isEmpty(addList)) {
            this.setBccAddress(StringUtils.collectionToCommaDelimitedString(addList));
        }
        this.setSubject(businessValue.getSubject());
        this.setBody(businessValue.getBody());
        this.setHasAttachment(businessValue.isHasAttachement());
        if(businessValue.isHasAttachement()) {
            this.setAttachmentFilePath(StringUtils.collectionToCommaDelimitedString(businessValue.getAttachmentFilePath()));
        }
        this.setMailSent(businessValue.isMailSent());
        this.setSendDate(businessValue.getSendDate());
        super.setBusinessValue(businessValue);
    }
}
