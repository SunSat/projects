package com.sunsat.sathish.j2ee.health.login.pojo.business;

import com.sunsat.sathish.j2ee.health.base.pojo.business.AbstractBaseBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.model.UserFormModel;

public class RoleBusiness extends AbstractBaseBusiness<UserFormModel> {
    Long primaryKeyId;
    String roleName;
    UserBusiness userBusiness;

    @Override
    public Class getType() {
        return null;
    }

    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(Long primaryKeyId) {
        this.primaryKeyId = primaryKeyId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public void populateData(UserFormModel userFormModel) {
        super.populateData(userFormModel);
    }

    @Override
    public void getData(UserFormModel userFormModel) {
        super.getData(userFormModel);
    }

    public UserBusiness getUserBusiness() {
        return userBusiness;
    }

    public void setUserBusiness(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }
}
