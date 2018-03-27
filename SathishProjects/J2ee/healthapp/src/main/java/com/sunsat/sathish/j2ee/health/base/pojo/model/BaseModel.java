package com.sunsat.sathish.j2ee.health.base.pojo.model;

import java.util.Date;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public interface BaseModel {
    public String getType() ;
    public Long getPrimarykeyId();
    public Long getCreatedById();
    public Long getModifiedById();
    public Date getCreatedByDate();
    public Date getModifiedByDate();
    public boolean isDeleted();
}
