package com.sunsat.sathish.j2ee.spsystem.dao.orm;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by ssundar2 on 28-03-2017.
 */

@Entity
@Table(name = "user")
public class UserDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trackingid")
    private int trackingId;

    @Column(name = "userid")
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "dateofbirth")
    private Date dateofbirth;

    @Column (name = "gender")
    private String gender;

    @Column (name = "mobile")
    private String mobile;

    @Column (name = "isAdmin")
    private String isAdmin;

    @Column (name = "Address")
    private String address;

    @Column (name= "dateofjoin")
    private Date dateofjoin;

    @Column (name = "dateoflevae")
    private Date dateofleave;

    @Column (name = "status")
    private String status;

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateofjoin() {
        return dateofjoin;
    }

    public void setDateofjoin(Date dateofjoin) {
        this.dateofjoin = dateofjoin;
    }

    public Date getDateofleave() {
        return dateofleave;
    }

    public void setDateofleave(Date dateofleave) {
        this.dateofleave = dateofleave;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDao)) return false;

        UserDao userDao = (UserDao) o;

        if (getTrackingId() != userDao.getTrackingId()) return false;
        if (getUserId() != userDao.getUserId()) return false;
        if (getName() != null ? !getName().equals(userDao.getName()) : userDao.getName() != null) return false;
        if (getPassword() != null ? !getPassword().equals(userDao.getPassword()) : userDao.getPassword() != null)
            return false;
        if (getDateofbirth() != null ? !getDateofbirth().equals(userDao.getDateofbirth()) : userDao.getDateofbirth() != null)
            return false;
        if (getGender() != null ? !getGender().equals(userDao.getGender()) : userDao.getGender() != null) return false;
        if (getMobile() != null ? !getMobile().equals(userDao.getMobile()) : userDao.getMobile() != null) return false;
        if (getIsAdmin() != null ? !getIsAdmin().equals(userDao.getIsAdmin()) : userDao.getIsAdmin() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(userDao.getAddress()) : userDao.getAddress() != null)
            return false;
        if (getDateofjoin() != null ? !getDateofjoin().equals(userDao.getDateofjoin()) : userDao.getDateofjoin() != null)
            return false;
        if (getDateofleave() != null ? !getDateofleave().equals(userDao.getDateofleave()) : userDao.getDateofleave() != null)
            return false;
        return !(getStatus() != null ? !getStatus().equals(userDao.getStatus()) : userDao.getStatus() != null);

    }

    @Override
    public int hashCode() {
        int result = getTrackingId();
        result = 31 * result + getUserId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getDateofbirth() != null ? getDateofbirth().hashCode() : 0);
        result = 31 * result + (getGender() != null ? getGender().hashCode() : 0);
        result = 31 * result + (getMobile() != null ? getMobile().hashCode() : 0);
        result = 31 * result + (getIsAdmin() != null ? getIsAdmin().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getDateofjoin() != null ? getDateofjoin().hashCode() : 0);
        result = 31 * result + (getDateofleave() != null ? getDateofleave().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        return result;
    }
}
