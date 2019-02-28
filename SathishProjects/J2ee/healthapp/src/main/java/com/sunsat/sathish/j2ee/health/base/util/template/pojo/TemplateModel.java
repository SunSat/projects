package com.sunsat.sathish.j2ee.health.base.util.template.pojo;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;

import java.util.Map;

public class TemplateModel extends AbstractBaseModel {

    private Long primaryKeyId;

    String templateName;

    String fileName;

    String locationPath;

    Map<String,Object> modelObject;

    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(Long primaryKeyId) {
        this.primaryKeyId = primaryKeyId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getLocationPath() {
        return locationPath;
    }

    public void setLocationPath(String locationPath) {
        this.locationPath = locationPath;
    }

    public Map<String, Object> getModelObject() {
        return modelObject;
    }

    public void setModelObject(Map<String, Object> modelObject) {
        this.modelObject = modelObject;
    }
}
