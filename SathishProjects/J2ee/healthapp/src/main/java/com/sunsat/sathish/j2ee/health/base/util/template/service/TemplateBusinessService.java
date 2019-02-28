package com.sunsat.sathish.j2ee.health.base.util.template.service;

import com.sunsat.sathish.j2ee.health.base.util.template.pojo.TemplateModel;

public interface TemplateBusinessService {

    public TemplateModel createNewTemplate(TemplateModel model);
    public TemplateModel getByAllPrimaryKey(TemplateModel model);
    public TemplateModel updatetemplate(TemplateModel model);
    public TemplateModel getByTemplateName(TemplateModel model);
    public String mergeTemplate(TemplateModel  model);
}
