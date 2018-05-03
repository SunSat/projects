package com.sunsat.sathish.j2ee.health.base.exceptionHandler;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
public abstract class AbstractHealthAppException extends RuntimeException implements BaseHealthAppException {

    private String message;
    private String cause;
    private String action;
    private Throwable exception;

    public AbstractHealthAppException() {

    }

    public AbstractHealthAppException(String message, String cause, String action) {
        this.message = message;
        this.cause = cause;
        this.action = action;
    }

    public AbstractHealthAppException(String message, String cause, String action, Throwable exception) {
        this.message = message;
        this.cause = cause;
        this.action = action;
        this.exception = exception;
    }
}
