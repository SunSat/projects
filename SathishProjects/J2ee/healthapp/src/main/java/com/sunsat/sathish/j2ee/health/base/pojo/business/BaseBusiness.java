package com.sunsat.sathish.j2ee.health.base.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.dao.BaseDao;
import com.sunsat.sathish.j2ee.health.base.pojo.model.BaseModel;

import java.util.Date;

/**
 * Created by sathishkumar_su on 4/17/2018.
 */
public interface BaseBusiness<BM extends BaseModel> {
    public Class getType() ;
    public Long getPrimarykeyId();
    public Long getCreatedById();
    public Long getModifiedById();
    public Date getCreatedByDate();
    public Date getModifiedByDate();
    public Integer isDeleted();
    public String getDescription();
    public void populateData(BM bm);
    public BM getData();
}
