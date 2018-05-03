package com.sunsat.sathish.j2ee.health.base.pojo.business;

import java.util.Date;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
public interface BaseBusiness {
    public String getType() ;
    public Long getPrimarykeyId();
    public Long getCreatedById();
    public Long getModifiedById();
    public Date getCreatedByDate();
    public Date getModifiedByDate();
    public boolean isDeleted();
    public String getDescription();
}
