package com.sunsat.sathish.j2ee.health.base.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.PersistanceManager;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public interface BaseDao<BB extends BaseBusiness,DF extends Enum> extends Serializable,Cloneable {

    public Class getType();

    public Long getPrimaryKeyId();
    public void setPrimaryKeyId(Long primarykeyId);

    public Long getCreatedById();
    public void setCreatedById(Long createdById);

    public Long getModifiedById();
    public void setModifiedById(Long modifiedById);

    public Date getCreatedByDate();
    public void setCreatedByDate(Date createdByDate);

    public Date getModifiedByDate();
    public void setModifiedByDate(Date modifiedByDate);

    public Integer isDeleted();
    public void setIsDeleted(Integer deleted);

    public String getMessage();
    public void setMessage(String message);

    public BB getBusinessValue(DF df, BB businessValue, List<Class> parentClasses);
    public void setBusinessValue(BB businessValue);

    public PersistanceManager getPersistenceManager();
}
