package com.sunsat.sathish.java.hibernate.exception;

/**
 * Created by sathishkumar_su on 5/6/2018.
 */
public class LoginException extends RuntimeException {

    String description;
    String cause;
    String action;
    String title;

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(String description, String cause, String action, String title, Throwable e) {
        super(description+"." + action + ". "+cause+ " . ",e);
        this.description = description;
        this.cause = cause;
        this.action = action;
        this.title = title;
    }

    public LoginException(String message, Throwable cause, String title) {
        super(message, cause);
        this.title = title;
    }

}
