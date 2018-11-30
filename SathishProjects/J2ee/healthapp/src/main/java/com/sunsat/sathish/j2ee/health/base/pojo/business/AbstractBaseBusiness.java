package com.sunsat.sathish.j2ee.health.base.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;

import java.util.Date;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
public abstract class AbstractBaseBusiness<BM extends AbstractBaseModel> implements BaseBusiness<BM> {

    private Class type;
    private Long primarykeyId;
    private Long createdById;
    private Long modifiedById;
    private Date createdByDate;
    private Date modifiedByDate;
    private boolean isDeleted;
    private String description;

    public AbstractBaseBusiness() {

    }

    public AbstractBaseBusiness(BM model) {
        this.primarykeyId = model.getPrimarykeyId();
        this.createdById = model.getCreatedById();
        this.modifiedById = model.getModifiedById();
    }


    @Override
    public Long getPrimarykeyId() {
        return primarykeyId;
    }

    public void setPrimarykeyId(Long primarykeyId) {
        this.primarykeyId = primarykeyId;
    }

    @Override
    public Long getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Long createdById) {
        this.createdById = createdById;
    }

    @Override
    public Long getModifiedById() {
        return modifiedById;
    }

    public void setModifiedById(Long modifiedById) {
        this.modifiedById = modifiedById;
    }

    @Override
    public Date getCreatedByDate() {
        return createdByDate;
    }

    public void setCreatedByDate(Date createdByDate) {
        this.createdByDate = createdByDate;
    }

    @Override
    public Date getModifiedByDate() {
        return modifiedByDate;
    }

    public void setModifiedByDate(Date modifiedByDate) {
        this.modifiedByDate = modifiedByDate;
    }

    @Override
    public boolean isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
