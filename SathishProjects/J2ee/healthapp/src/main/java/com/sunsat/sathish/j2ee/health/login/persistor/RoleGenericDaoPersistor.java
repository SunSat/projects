package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.RoleDao;

public interface RoleGenericDaoPersistor {

    public RoleBusiness getByPrimarykey(RoleBusiness rb);
    public RoleBusiness createNewRole(RoleBusiness rb);
    public RoleBusiness updateRole(RoleBusiness rb);
    public RoleDao getByPrimaryKeyId(RoleBusiness ub);

}
