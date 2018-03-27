package com.sunsat.sathish.j2ee.health.base.exceptionHandler;

/**
 * Created by sathishkumar_su on 2/26/2018.
 */
public class PersistorException extends HealthAppException {

    public PersistorException() {
    }

    public PersistorException(String message, String cause, String action) {
        super(message, cause, action);
    }

    public PersistorException(String message, String cause, String action, Throwable exception) {
        super(message, cause, action, exception);
    }

}
