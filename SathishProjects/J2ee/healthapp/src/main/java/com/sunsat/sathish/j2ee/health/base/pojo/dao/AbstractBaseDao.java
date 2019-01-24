package com.sunsat.sathish.j2ee.health.base.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */
public abstract class AbstractBaseDao<BB extends AbstractBaseBusiness,DF extends BaseDataFilter> implements BaseDao<BB,DF> {

   /* public abstract Class<BB> getType();
    public abstract BB getBusinessValue(DF df);
    public abstract void setBusinessValue(BB businessValue);*/



}
