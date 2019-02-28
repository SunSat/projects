package com.sunsat.sathish.j2ee.health.base.util.template.pojo;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;

public class TemplateBusiness extends AbstractBaseBusiness<TemplateModel> {

    private Long primaryKeyId;

    String templateName;

    String fileName;

    String locationPath;


    @Override
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

    @Override
    public Class getType() {
        return null;
    }
}
