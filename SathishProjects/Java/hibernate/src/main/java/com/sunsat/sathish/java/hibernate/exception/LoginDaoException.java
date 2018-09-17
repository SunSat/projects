package com.sunsat.sathish.java.hibernate.exception;

import com.sunsat.sathish.java.hibernate.loginMaintanance.dao.LoginSoruceDao;

/**
 * Created by sathishkumar_su on 5/6/2018.
 */
public class LoginDaoException extends LoginException {

    public LoginDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginDaoException(String description, String cause, String action, String title, Throwable e) {
        super(description, cause, action, title, e);
    }

    public LoginDaoException(String message, Throwable cause, String title) {
        super(message, cause, title);
    }


}
