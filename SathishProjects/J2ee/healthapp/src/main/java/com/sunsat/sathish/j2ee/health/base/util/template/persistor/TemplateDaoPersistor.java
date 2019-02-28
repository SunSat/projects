package com.sunsat.sathish.j2ee.health.base.util.template.persistor;

import com.sunsat.sathish.j2ee.health.base.util.template.pojo.TemplateBusiness;

public interface TemplateDaoPersistor {
    public TemplateBusiness createNewTemplate(TemplateBusiness tm);
    public TemplateBusiness getByTemplateName(TemplateBusiness tm);
    public TemplateBusiness getByPrimaryKeyId(TemplateBusiness tm);

}
