package com.sunsat.sathish.j2ee.health.base.persistor;

import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.BaseDao;

/**
 * Created by sathishkumar_su on 4/16/2018.
 */
public interface BaseDaoPersistor<BD extends BaseDao,BB extends BaseBusiness> {

    public BD save(BB bb);
    public BD get(BB bb);
    public BD update(BB bb);
    public BD load(BB bb);
    public BD getById(BB bb);
    public BD getByName(BB bb);
    public BB getMaxNumber(BB bb);

}
