package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.PersistanceManager;
import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.persistor.UserPersistanceManager;
import com.sunsat.sathish.j2ee.health.login.pojo.business.RoleBusiness;
import com.sunsat.sathish.j2ee.health.login.pojo.business.UserBusiness;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.*;

/**
 * Created by sathishkumar_su on 2/24/2018.
 */

@Entity
@Table(name = "user")
@NamedStoredProcedureQueries(
        @NamedStoredProcedureQuery(name = "verify_login",procedureName ="sp_verify_login",parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "user",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN,name = "pass",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT,name = "message",type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT,name = "userid",type = String.class)
        })
)
public class UserDao extends AbstractBaseDao<UserBusiness, BaseDataFilter> {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primaryKeyId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "creation_time")
    private Date creationTime;

    @Column(name = "expiry_time")
    private Date expiryTime;

    @Column(name = "account_status")
    private String accountStatus;

    @OneToOne(mappedBy = "userDao", fetch = FetchType.LAZY)
    private CommunicationDao comDao;

    @OneToOne(mappedBy = "userDao", fetch = FetchType.LAZY)
    private LoginDao loginDao;

    @OneToOne(mappedBy = "userDao", fetch = FetchType.LAZY)
    private PersonalDetailDao personalDetailDao;

    @OneToMany(mappedBy = "userDao", fetch = FetchType.LAZY)
    private List<RoleDao> roleDao;

    @Column(name = "likeuser")
    private boolean isUserLike;

    @Override
    public Class getType() {
        return UserDao.class;
    }

    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    public void setPrimaryKeyId(Long primarykeyId) {
        this.primaryKeyId = primarykeyId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }


    public CommunicationDao getComDao() {
        return comDao;
    }

    public void setComDao(CommunicationDao comDao) {
        this.comDao = comDao;
    }

    public LoginDao getLoginDao() {
        return loginDao;
    }

    public void setLoginDao(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    public PersonalDetailDao getPersonalDetailDao() {
        return personalDetailDao;
    }

    public void setPersonalDetailDao(PersonalDetailDao personalDetailDao) {
        this.personalDetailDao = personalDetailDao;
    }

    public List<RoleDao> getRoleDao() {
        return roleDao;
    }

    public void setRoleDao(List<RoleDao> roleDao) {
        this.roleDao = roleDao;
    }

    public boolean isUserLike() {
        return isUserLike;
    }

    public void setUserLike(boolean userLike) {
        isUserLike = userLike;
    }

    @Override
    public UserBusiness getBusinessValue(BaseDataFilter filter, UserBusiness businessValue, List<Class> parentClasses) {
        if(null == businessValue)
            businessValue = new UserBusiness();
        if(null == parentClasses) {
            parentClasses = new ArrayList<>();
        }
        parentClasses.add(this.getClass());
        switch (filter) {
            case BY_ID:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                break;
            case BY_ALL:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                businessValue.setUserName(this.getUserName());
                businessValue.setCreationTime(this.getCreationTime());
                businessValue.setExpiryTime(this.getExpiryTime());
                businessValue.setAccountStatus(this.getAccountStatus());
                businessValue.setUserLike(this.isUserLike()+"");
                businessValue.setPassword(this.getPassword());
                businessValue.setPasswordHash(this.getPasswordHash());
                super.getBusinessValue(filter,businessValue,parentClasses);
                if(this.getComDao() != null && !parentClasses.contains(this.getComDao().getClass())) {
                    parentClasses.add(this.getComDao().getClass());
                    businessValue.setComBusiness(this.getComDao().getBusinessValue(filter,null,parentClasses));
                }
                if(this.getLoginDao() != null && !parentClasses.contains(this.getLoginDao().getClass())) {
                    parentClasses.add(this.getLoginDao().getClass());
                    businessValue.setLoginBusiness(this.getLoginDao().getBusinessValue(filter,null,parentClasses));
                }
                if(this.getPersonalDetailDao() != null && !parentClasses.contains(this.getPersonalDetailDao().getClass())) {
                    parentClasses.add(this.getPersonalDetailDao().getClass());
                    businessValue.setPersonalDetailBusiness(this.getPersonalDetailDao().getBusinessValue(filter,null,parentClasses));
                }
                if(this.getRoleDao() != null && !parentClasses.contains(this.getRoleDao().getClass())) {
                    List<RoleBusiness> roleBusiLi = new ArrayList<>(this.getRoleDao().size());
                    parentClasses.add(RoleDao.class);
                    for(RoleDao role : this.getRoleDao()) {
                        roleBusiLi.add(role.getBusinessValue(filter,null,parentClasses));
                    }
                    businessValue.setRoleBusinesses(roleBusiLi);
                }
                break;
            case BY_BUSINESS_KEY:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                businessValue.setUserName(this.getUserName());
                businessValue.setCreationTime(this.getCreationTime());
                businessValue.setExpiryTime(this.getExpiryTime());
                businessValue.setAccountStatus(this.getAccountStatus());
                businessValue.setUserLike(this.isUserLike()+"");
                super.getBusinessValue(filter,businessValue,parentClasses);
                break;
        }
        return businessValue;
    }

    @Override
    public void setBusinessValue(UserBusiness businessValue) {
        this.setPrimaryKeyId(businessValue.getPrimaryKeyId());
        this.setUserName(businessValue.getUserName());
        this.setPassword(businessValue.getPassword());
        this.setPasswordHash(businessValue.getPasswordHash());
        this.setAccountStatus(businessValue.getAccountStatus());
        this.setCreationTime(businessValue.getCreationTime());
        this.setExpiryTime(businessValue.getExpiryTime());
        this.setUserLike(Boolean.parseBoolean(businessValue.isUserLike()));
        this.setPassword(businessValue.getPassword());
        this.setPasswordHash(businessValue.getPasswordHash());
        super.setBusinessValue(businessValue);
        UserPersistanceManager mgr = UserPersistanceManager.getInstance();

        if(businessValue.getComBusiness() != null) {
            CommunicationDao comDao = mgr.getCommDaoPersistor().getByPrimaryKeyId(businessValue.getComBusiness());
            this.setComDao(comDao);
        }
        if(businessValue.getLoginBusiness() != null) {
            LoginDao loginDao = mgr.getLoginDaoPersistor().getByPrimaryKeyId(businessValue.getLoginBusiness());
            this.setLoginDao(loginDao);
        }
        if(businessValue.getPersonalDetailBusiness() != null) {
            this.setPersonalDetailDao(mgr.getPersonalDetailDaoPersistor().getByPrimaryKeyId(businessValue.getPersonalDetailBusiness()));
        }
        if(businessValue.getRoleBusinesses() != null) {
            List<RoleDao> roleDaoList = new ArrayList<>(businessValue.getRoleBusinesses().size());
            for(RoleBusiness roleBusinesses : businessValue.getRoleBusinesses()) {
                roleDaoList.add(mgr.getRoleDaoPersistor().getByPrimaryKeyId(roleBusinesses));
            }
            if(roleDaoList.size() > 0) {
                this.setRoleDao(roleDaoList);
            }
        }
    }
}
