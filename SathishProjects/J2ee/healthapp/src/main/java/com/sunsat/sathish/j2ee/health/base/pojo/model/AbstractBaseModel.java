package com.sunsat.sathish.j2ee.health.base.pojo.model;

import java.util.Date;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public abstract class AbstractBaseModel implements BaseModel {

    private String type;
    private Long primarykeyId;
    private Long createdById;
    private Long modifiedById;
    private Date createdByDate;
    private Date modifiedByDate;
    private boolean isDeleted;
    private String description;


    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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


