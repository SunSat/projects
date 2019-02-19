package com.sunsat.sathish.j2ee.health.base.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.model.AbstractBaseModel;

import java.util.Date;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
public abstract class AbstractBaseBusiness<BM extends AbstractBaseModel> implements BaseBusiness<BM> {

    private Long createdById;
    private Long modifiedById;
    private Date createdByDate;
    private Date modifiedByDate;
    private Integer isDeleted = 0;
    private String message;

    public AbstractBaseBusiness() {

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
    public Integer isDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public void populateData(BM bm) {
        this.setModifiedById(bm.getModifiedById());
        this.setModifiedByDate(bm.getModifiedByDate());
        this.setIsDeleted(bm.isDeleted());
        this.setCreatedById(bm.getCreatedById());
        this.setCreatedByDate(bm.getCreatedByDate());
        this.setMessage(bm.getMessage());
    }

    @Override
    public void getData(BM bm) {
        bm.setCreatedByDate(this.getCreatedByDate());
        bm.setCreatedById(this.getCreatedById());
        bm.setMessage(this.getMessage());
        bm.setIsDeleted(this.isDeleted());
        bm.setModifiedByDate(this.getModifiedByDate());
        bm.setModifiedById(this.getModifiedById());
    }
    public void populateDefaultValue(BM bm) {

    }
}
