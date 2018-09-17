package com.sunsat.sathish.j2ee.loginapp.login.pojo.formModel;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by sathishkumar_su on 6/1/2018.
 */

@XmlRootElement(name = "LoggedUser")
public class LoggedUserFormModel implements Serializable {

    Integer userId;
    String userName;
    Date loggedTime;
    String message;
    String fullUserName;
    String mailId;

    public LoggedUserFormModel(Integer userId, String userName, Date loggedTime) {
        this.userId = userId;
        this.userName = userName;
        this.loggedTime = loggedTime;
    }

    public LoggedUserFormModel() {

    }


    @XmlAttribute
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @XmlElement
    public Date getLoggedTime() {
        return loggedTime;
    }

    public void setLoggedTime(Date loggedTime) {
        this.loggedTime = loggedTime;
    }

    @XmlElement
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @XmlElement
    public String getFullUserName() {
        return fullUserName;
    }

    public void setFullUserName(String fullUserName) {
        this.fullUserName = fullUserName;
    }

    @XmlElement
    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
}
