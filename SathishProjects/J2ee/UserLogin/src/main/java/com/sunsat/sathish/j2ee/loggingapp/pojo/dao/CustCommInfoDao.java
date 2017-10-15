package com.sunsat.sathish.j2ee.loggingapp.pojo.dao;

import org.springframework.context.annotation.Bean;

/**
 * Created by ssundar2 on 24-02-2017.
 */


public class CustCommInfoDao {

    private int id;
    private String mailId1;
    private String mailId1Verified;
    private String mailId2;
    private String mailId2Verified;
    private String mobileNo1;
    private String mobileNo1Verified;
    private String mobileNo2;
    private String mobileNo2Verified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMailId1() {
        return mailId1;
    }

    public void setMailId1(String mailId1) {
        this.mailId1 = mailId1;
    }

    public String getMailId1Verified() {
        return mailId1Verified;
    }

    public void setMailId1Verified(String mailId1Verified) {
        this.mailId1Verified = mailId1Verified;
    }

    public String getMailId2() {
        return mailId2;
    }

    public void setMailId2(String mailId2) {
        this.mailId2 = mailId2;
    }

    public String getMailId2Verified() {
        return mailId2Verified;
    }

    public void setMailId2Verified(String mailId2Verified) {
        this.mailId2Verified = mailId2Verified;
    }

    public String getMobileNo1() {
        return mobileNo1;
    }

    public void setMobileNo1(String mobileNo1) {
        this.mobileNo1 = mobileNo1;
    }

    public String getMobileNo1Verified() {
        return mobileNo1Verified;
    }

    public void setMobileNo1Verified(String mobileNo1Verified) {
        this.mobileNo1Verified = mobileNo1Verified;
    }

    public String getMobileNo2() {
        return mobileNo2;
    }

    public void setMobileNo2(String mobileNo2) {
        this.mobileNo2 = mobileNo2;
    }

    public String getMobileNo2Verified() {
        return mobileNo2Verified;
    }

    public void setMobileNo2Verified(String mobileNo2Verified) {
        this.mobileNo2Verified = mobileNo2Verified;
    }


}
