package com.sunsat.sathish.j2ee.loginapp.login.pojo.formModel;

import com.sunsat.sathish.j2ee.loginapp.pojo.model.AbstractModel;

public class FormModel extends AbstractModel {

    @Override
    public Class getModelClassName() {
        return FormModel.class;
    }

    private String sessionId;
    private String formAction;
    private String formSubAction;
    private String message;

    public String getFormAction() {
        return formAction;
    }

    public void setFormAction(String formAction) {
        this.formAction = formAction;
    }

    public String getFormSubAction() {
        return formSubAction;
    }

    public void setFormSubAction(String formSubAction) {
        this.formSubAction = formSubAction;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSessionId() {
        return sessionId;
    }
}
