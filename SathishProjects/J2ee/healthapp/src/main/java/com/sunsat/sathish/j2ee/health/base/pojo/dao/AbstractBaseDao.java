package com.sunsat.sathish.j2ee.health.base.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.PersistanceManager;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
@MappedSuperclass
public abstract class AbstractBaseDao<BB extends AbstractBaseBusiness,DF extends BaseDataFilter> implements BaseDao<BB,DF> {

    @Column(name = "created_by")
    private Long createdById;

    @Column(name = "modified_by")
    private Long modifiedById;

    @Column(name = "created_date")
    private Date createdByDate;

    @Column(name = "modified_date")
    private Date modifiedByDate;

    @Column(name = "deleted")
    private Integer deleted = 0;

    @Column(name = "message")
    private String message;

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
        return deleted;
    }

    @Override
    public void setIsDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public BB getBusinessValue(DF df, BB businessValue, List<Class> parentClasses) {
        businessValue.setCreatedByDate(this.getCreatedByDate());
        businessValue.setCreatedById(this.getCreatedById());
        businessValue.setMessage(this.getMessage());
        businessValue.setIsDeleted(this.isDeleted());
        businessValue.setModifiedByDate(this.getModifiedByDate());
        businessValue.setModifiedById(this.getModifiedById());
        return businessValue;
    }

    @Override
    public void setBusinessValue(BB businessValue) {
        this.setCreatedByDate(businessValue.getCreatedByDate());
        this.setCreatedById(businessValue.getCreatedById());
        this.setIsDeleted(businessValue.isDeleted());
        this.setMessage(businessValue.getMessage());
        this.setModifiedByDate(businessValue.getModifiedByDate());
        this.setModifiedById(businessValue.getModifiedById());
    }

    public PersistanceManager getPersistenceManager() {
        return PersistanceManager.getInstance();
    }
}
