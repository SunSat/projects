package com.sunsat.sathish.j2ee.health.base.exceptionHandler;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
public abstract class HealthAppException extends RuntimeException {

    private String message;
    private String cause;
    private String action;
    private Throwable exception;

    public HealthAppException() {
    }

    public HealthAppException(String message,String cause,String action) {
        this.message = message;
        this.cause = cause;
        this.action = action;
    }

    public HealthAppException(String message,String cause,String action, Throwable exception) {
        this.message = message;
        this.cause = cause;
        this.action = action;
        this.exception = exception;
    }
}
