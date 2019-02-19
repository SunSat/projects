package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.persistor.UserPersistanceManager;
import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
public class RoleDao extends AbstractBaseDao<RoleBusiness, BaseDataFilter> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    Long primaryKeyId;

    @Column(name = "rolename")
    String roleName;

    @ManyToOne(targetEntity = UserDao.class)
    @Cascade(value = CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "userrolelink",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Class getType() {
        return RoleDao.class;
    }

    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    @Override
    public void setPrimaryKeyId(Long primarykeyId) {
        this.primaryKeyId = primarykeyId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public RoleBusiness getBusinessValue(BaseDataFilter baseDataFilter, RoleBusiness businessValue, List<Class> parentClasses) {
        if(null == businessValue) businessValue = new RoleBusiness();
        if(null == parentClasses) {
            parentClasses = new ArrayList<>();
        }
        parentClasses.add(this.getClass());
        switch (baseDataFilter) {
            case BY_ALL:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                businessValue.setRoleName(this.getRoleName());
                super.getBusinessValue(baseDataFilter, businessValue,parentClasses);
                if(!parentClasses.contains(this.getUserDao().getClass())) {
                    parentClasses.add(this.getUserDao().getClass());
                    businessValue.setUserBusiness(this.getUserDao().getBusinessValue(baseDataFilter,null,parentClasses));
                }
                break;
        }
        return businessValue;
    }

    @Override
    public void setBusinessValue(RoleBusiness businessValue) {
        super.setBusinessValue(businessValue);
        this.setPrimaryKeyId(businessValue.getPrimaryKeyId());
        this.setRoleName(businessValue.getRoleName());
        UserPersistanceManager userMgr = UserPersistanceManager.getInstance();
        if(businessValue.getUserBusiness() != null) {
            UserDao dao = userMgr.getUserDaoPersistor().getByPrimaryKeyId(businessValue.getUserBusiness());
            this.setUserDao(dao);
        }
    }
}
