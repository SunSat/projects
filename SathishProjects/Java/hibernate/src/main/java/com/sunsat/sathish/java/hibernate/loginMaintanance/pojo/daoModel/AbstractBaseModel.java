package com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel;

import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel.AbstractBaseService;

import javax.persistence.Transient;

/**
 * Created by sathishkumar_su on 5/6/2018.
 */
public abstract class AbstractBaseModel {

    @Transient
    private transient String modelType;

    public AbstractBaseModel(String modelType) {
        this.modelType = modelType;
    }

    public AbstractBaseModel(String modelType, Integer primaryKeyId) {
        this.modelType = modelType;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public abstract Integer getId();
    public abstract void setId(Integer key);
    public abstract void getValuesAsService(AbstractBaseService ab);
}
