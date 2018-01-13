package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "controllergroupdetail", schema = "", catalog = "kindle_controller_app")
public class ControllergroupdetailEntity extends AbstractDaoModel {

    private Integer groupid;
    private String groupname;
    private String controllerid;
    private String controllerpassword;
    private String meterialids;
    private String userids;
    private String sharedamount;
    private Integer memberscount;

    @Id
    @Column(name = "groupid")
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    @Basic
    @Column(name = "groupname")
    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    @Basic
    @Column(name = "controllerid")
    public String getControllerid() {
        return controllerid;
    }

    public void setControllerid(String controllerid) {
        this.controllerid = controllerid;
    }

    @Basic
    @Column(name = "controllerpassword")
    public String getControllerpassword() {
        return controllerpassword;
    }

    public void setControllerpassword(String controllerpassword) {
        this.controllerpassword = controllerpassword;
    }

    @Basic
    @Column(name = "meterialids")
    public String getMeterialids() {
        return meterialids;
    }

    public void setMeterialids(String meterialids) {
        this.meterialids = meterialids;
    }

    @Basic
    @Column(name = "userids")
    public String getUserids() {
        return userids;
    }

    public void setUserids(String userids) {
        this.userids = userids;
    }

    @Basic
    @Column(name = "sharedamount")
    public String getSharedamount() {
        return sharedamount;
    }

    public void setSharedamount(String sharedamount) {
        this.sharedamount = sharedamount;
    }

    @Basic
    @Column(name = "memberscount")
    public Integer getMemberscount() {
        return memberscount;
    }

    public void setMemberscount(Integer memberscount) {
        this.memberscount = memberscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ControllergroupdetailEntity that = (ControllergroupdetailEntity) o;

        if (groupid != null ? !groupid.equals(that.groupid) : that.groupid != null) return false;
        if (groupname != null ? !groupname.equals(that.groupname) : that.groupname != null) return false;
        if (controllerid != null ? !controllerid.equals(that.controllerid) : that.controllerid != null) return false;
        if (controllerpassword != null ? !controllerpassword.equals(that.controllerpassword) : that.controllerpassword != null)
            return false;
        if (meterialids != null ? !meterialids.equals(that.meterialids) : that.meterialids != null) return false;
        if (userids != null ? !userids.equals(that.userids) : that.userids != null) return false;
        if (sharedamount != null ? !sharedamount.equals(that.sharedamount) : that.sharedamount != null) return false;
        if (memberscount != null ? !memberscount.equals(that.memberscount) : that.memberscount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groupid != null ? groupid.hashCode() : 0;
        result = 31 * result + (groupname != null ? groupname.hashCode() : 0);
        result = 31 * result + (controllerid != null ? controllerid.hashCode() : 0);
        result = 31 * result + (controllerpassword != null ? controllerpassword.hashCode() : 0);
        result = 31 * result + (meterialids != null ? meterialids.hashCode() : 0);
        result = 31 * result + (userids != null ? userids.hashCode() : 0);
        result = 31 * result + (sharedamount != null ? sharedamount.hashCode() : 0);
        result = 31 * result + (memberscount != null ? memberscount.hashCode() : 0);
        return result;
    }
}
