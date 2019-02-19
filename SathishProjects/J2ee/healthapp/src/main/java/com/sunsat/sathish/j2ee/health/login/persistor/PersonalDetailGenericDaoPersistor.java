package com.sunsat.sathish.j2ee.health.login.persistor;

import com.sunsat.sathish.j2ee.health.login.pojo.business.PersonalDetailBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.dao.PersonalDetailDao;

public interface PersonalDetailGenericDaoPersistor {
    public PersonalDetailBusiness getByPrimarykey(PersonalDetailBusiness psb);
    public PersonalDetailBusiness createNewPersonalDetail(PersonalDetailBusiness psb);
    public PersonalDetailBusiness updatePersonalDetail(PersonalDetailBusiness psb);
    public PersonalDetailDao getByPrimaryKeyId(PersonalDetailBusiness ub);

}
