package com.sunsat.sathish.j2ee.health.base.pojo.model;

public class FormModel extends AbstractBaseModel {

    String operationType;
    String subOperationType;
    String sessionid;
    String formAction;
    String formSubAction;

    public FormModel() {
        setType(FormModel.class);
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getSubOperationType() {
        return subOperationType;
    }

    public void setSubOperationType(String subOperationType) {
        this.subOperationType = subOperationType;
    }

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
    }

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
}
