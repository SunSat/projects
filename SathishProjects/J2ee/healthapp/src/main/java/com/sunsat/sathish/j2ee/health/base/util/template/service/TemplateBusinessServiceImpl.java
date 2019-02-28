package com.sunsat.sathish.j2ee.health.base.util.template.service;

import com.sunsat.sathish.j2ee.health.base.businessService.AbstractBusinessService;
import com.sunsat.sathish.j2ee.health.base.util.GeneralAppUtil;
import com.sunsat.sathish.j2ee.health.base.util.template.persistor.TemplateDaoPersistor;
import com.sunsat.sathish.j2ee.health.base.util.template.pojo.TemplateBusiness;
import com.sunsat.sathish.j2ee.health.base.util.template.pojo.TemplateModel;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;

@Service("templateBusinessService")
public class TemplateBusinessServiceImpl extends AbstractBusinessService<TemplateModel> implements TemplateBusinessService {

    @Autowired
    TemplateDaoPersistor templateDaoPersistor;

    @Autowired
    VelocityEngine velocityEngine;
    @Override
    public TemplateModel createNewTemplate(TemplateModel model) {
        TemplateBusiness tm = new TemplateBusiness();
        tm.setTemplateName(model.getTemplateName());
        tm.setLocationPath(model.getLocationPath());
        tm.setFileName(model.getFileName());
        tm.setPrimaryKeyId(model.getPrimaryKeyId());
        tm.setCreatedByDate(GeneralAppUtil.getCurrentTime());
        tm.setCreatedById(GeneralAppUtil.getLoggedUserId());
        tm.setModifiedByDate(GeneralAppUtil.getCurrentTime());
        tm.setModifiedById(GeneralAppUtil.getLoggedUserId());
        tm.setIsDeleted(0);
        tm = templateDaoPersistor.createNewTemplate(tm);
        model.setPrimaryKeyId(tm.getPrimaryKeyId());
        return model;
    }

    @Override
    public TemplateModel getByAllPrimaryKey(TemplateModel model) {
        return null;
    }

    @Override
    public TemplateModel updatetemplate(TemplateModel model) {
        return null;
    }

    @Override
    public TemplateModel getByTemplateName(TemplateModel model) {
        TemplateBusiness tm = new TemplateBusiness();
        tm.setTemplateName(model.getTemplateName());
        tm.setIsDeleted(0);
        tm = templateDaoPersistor.getByTemplateName(tm);
        model.setFileName(tm.getFileName());
        model.setPrimaryKeyId(tm.getPrimaryKeyId());
        model.setLocationPath(tm.getLocationPath());
        model.setTemplateName(tm.getTemplateName());
        tm.populateData(model);
        return model;
    }

    public String mergeTemplate(TemplateModel model) {
        Template template = velocityEngine.getTemplate(model.getLocationPath()+model.getFileName());
        VelocityContext context = new VelocityContext();
        for(String st : model.getModelObject().keySet()) {
            context.put(st,model.getModelObject().get(st));
        }
        StringWriter writer = new StringWriter();
        template.merge(context,writer);
        return writer.toString();
    }
}
