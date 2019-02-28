package com.sunsat.sathish.j2ee.health.base.util.template.pojo;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "template")
public class TemplateDao extends AbstractBaseDao<TemplateBusiness, BaseDataFilter> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long primaryKeyId;

    @Column(name = "templatename")
    String templateName;

    @Column(name = "filename")
    String fileName;

    @Column(name = "locationpath")
    String locationPath;


    @Override
    public Class getType() {
        return TemplateDao.class;
    }

    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    @Override
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
    public TemplateBusiness getBusinessValue(BaseDataFilter baseDataFilter, TemplateBusiness businessValue, List<Class> parentClasses) {
        if(businessValue == null) businessValue = new TemplateBusiness();
        switch (baseDataFilter) {
            case BY_ALL:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                businessValue.setFileName(this.getFileName());
                businessValue.setTemplateName(this.getTemplateName());
                businessValue.setLocationPath(this.getLocationPath());
                break;
            case BY_ID:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                break;
        }
        return super.getBusinessValue(baseDataFilter, businessValue, parentClasses);
    }

    @Override
    public void setBusinessValue(TemplateBusiness businessValue) {
        this.setPrimaryKeyId(businessValue.getPrimaryKeyId());
        this.setFileName(businessValue.getFileName());
        this.setLocationPath(businessValue.getLocationPath());
        this.setTemplateName(businessValue.getTemplateName());
        super.setBusinessValue(businessValue);
    }
}
