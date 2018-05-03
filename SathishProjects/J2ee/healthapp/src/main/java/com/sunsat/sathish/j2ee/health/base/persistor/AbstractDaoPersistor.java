package com.sunsat.sathish.j2ee.health.base.persistor;

import com.sunsat.sathish.j2ee.health.base.pojo.business.BaseBusiness;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.BaseDao;

/**
 * Created by sathishkumar_su on 4/16/2018.
 */
public abstract class  AbstractDaoPersistor<BD extends BaseDao,BB extends BaseBusiness> implements BaseDaoPersistor<BD,BB> {

    @Override
    public BD save(BB bb) {
        return null;
    }

    @Override
    public BD get(BB bb) {
        return null;
    }

    @Override
    public BD update(BB bb) {
        return null;
    }

    @Override
    public BD load(BB bb) {
        return null;
    }

    @Override
    public BD getById(BB bb) {
        return null;
    }

    @Override
    public BD getByName(BB bb) {
        return null;
    }

    @Override
    public BB getMaxNumber(BB bb) {
        return null;
    }

}
