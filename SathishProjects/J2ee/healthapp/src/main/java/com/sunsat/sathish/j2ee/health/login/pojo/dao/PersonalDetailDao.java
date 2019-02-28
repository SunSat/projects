package com.sunsat.sathish.j2ee.health.login.pojo.dao;

import com.sunsat.sathish.j2ee.health.base.persistor.dataset.BaseDataFilter;
import com.sunsat.sathish.j2ee.health.base.pojo.dao.AbstractBaseDao;
import com.sunsat.sathish.j2ee.health.login.persistor.UserPersistanceManager;
import com.sunsat.sathish.j2ee.health.login.pojo.business.PersonalDetailBusiness;
import sun.font.Decoration;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "personaldetail")
public class PersonalDetailDao extends AbstractBaseDao<PersonalDetailBusiness, BaseDataFilter> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long primaryKeyId;

    @OneToOne(fetch = FetchType.LAZY,cascade = {CascadeType.ALL})
    @JoinColumn(name = "user_id")
    private UserDao userDao;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "pincode")
    private Integer pincode;

    @Override
    public Class getType() {
        return PersonalDetailDao.class;
    }

    @Override
    public Long getPrimaryKeyId() {
        return primaryKeyId;
    }

    @Override
    public void setPrimaryKeyId(Long primarykeyId) {
        this.primaryKeyId = primarykeyId;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPincode() {
        return pincode;
    }

    public void setPincode(Integer pincode) {
        this.pincode = pincode;
    }

    @Override
    public PersonalDetailBusiness getBusinessValue(BaseDataFilter baseDataFilter, PersonalDetailBusiness businessValue, List<Class> parentClasses) {
        if(businessValue == null) businessValue = new PersonalDetailBusiness();
        if(null == parentClasses) {
            parentClasses = new ArrayList<>();
        }
        parentClasses.add(this.getClass());
        switch (baseDataFilter) {
            case BY_ALL:
                businessValue.setPrimaryKeyId(this.getPrimaryKeyId());
                businessValue.setFirstName(this.getFirstName());
                businessValue.setLastName(this.getLastName());
                businessValue.setGender(this.getGender());
                businessValue.setDob(this.getDob());
                businessValue.setAddress1(this.getAddress1());
                businessValue.setAddress2(this.getAddress2());
                businessValue.setCity(this.getCity());
                businessValue.setDistrict(this.getDistrict());
                businessValue.setState(this.getState());
                businessValue.setCountry(this.getCountry());
                businessValue.setPincode(this.getPincode());
                if(this.getUserDao() != null && !parentClasses.contains(this.getUserDao().getClass())) {
                    parentClasses.add(this.getUserDao().getClass());
                    businessValue.setUserBusiness(this.getUserDao().getBusinessValue(baseDataFilter,null,parentClasses));
                }
                break;
            case BY_BUSINESS_KEY:
                break;
        }
        return super.getBusinessValue(baseDataFilter, businessValue,parentClasses);
    }

    @Override
    public void setBusinessValue(PersonalDetailBusiness businessValue) {
        this.setPrimaryKeyId(businessValue.getPrimaryKeyId());
        this.setFirstName(businessValue.getFirstName());
        this.setLastName(businessValue.getLastName());
        this.setGender(businessValue.getGender());
        this.setDob(businessValue.getDob());
        this.setAddress1(businessValue.getAddress1());
        this.setAddress2(businessValue.getAddress2());
        this.setCity(businessValue.getCity());
        this.setDistrict(businessValue.getDistrict());
        this.setState(businessValue.getState());
        this.setCountry(businessValue.getCountry());
        this.setPincode(businessValue.getPincode());
        super.setBusinessValue(businessValue);
        UserPersistanceManager userMgr = UserPersistanceManager.getInstance();
        if(businessValue.getUserBusiness() != null) {
            this.setUserDao(userMgr.getUserDaoPersistor().getByPrimaryKeyId(businessValue.getUserBusiness()));
        }
    }
}
