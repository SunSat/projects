package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "balancedetail", schema = "", catalog = "kindle_controller_app")
public class BalancedetailEntity extends AbstractDaoModel {

    private Integer balanceid;
    private Integer groupid;
    private Integer userid;
    private String amountpaid;
    private Date amountpaiddate;
    private String amountreturned;
    private Date amountreturneddate;
    private String currentbalance;

    @Id
    @Column(name = "balanceid")
    public Integer getBalanceid() {
        return balanceid;
    }

    public void setBalanceid(Integer balanceid) {
        this.balanceid = balanceid;
    }

    @Basic
    @Column(name = "groupid")
    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    @Basic
    @Column(name = "userid")
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "amountpaid")
    public String getAmountpaid() {
        return amountpaid;
    }

    public void setAmountpaid(String amountpaid) {
        this.amountpaid = amountpaid;
    }

    @Basic
    @Column(name = "amountpaiddate")
    public Date getAmountpaiddate() {
        return amountpaiddate;
    }

    public void setAmountpaiddate(Date amountpaiddate) {
        this.amountpaiddate = amountpaiddate;
    }

    @Basic
    @Column(name = "amountreturned")
    public String getAmountreturned() {
        return amountreturned;
    }

    public void setAmountreturned(String amountreturned) {
        this.amountreturned = amountreturned;
    }

    @Basic
    @Column(name = "amountreturneddate")
    public Date getAmountreturneddate() {
        return amountreturneddate;
    }

    public void setAmountreturneddate(Date amountreturneddate) {
        this.amountreturneddate = amountreturneddate;
    }

    @Basic
    @Column(name = "currentbalance")
    public String getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(String currentbalance) {
        this.currentbalance = currentbalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BalancedetailEntity that = (BalancedetailEntity) o;

        if (balanceid != null ? !balanceid.equals(that.balanceid) : that.balanceid != null) return false;
        if (groupid != null ? !groupid.equals(that.groupid) : that.groupid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (amountpaid != null ? !amountpaid.equals(that.amountpaid) : that.amountpaid != null) return false;
        if (amountpaiddate != null ? !amountpaiddate.equals(that.amountpaiddate) : that.amountpaiddate != null)
            return false;
        if (amountreturned != null ? !amountreturned.equals(that.amountreturned) : that.amountreturned != null)
            return false;
        if (amountreturneddate != null ? !amountreturneddate.equals(that.amountreturneddate) : that.amountreturneddate != null)
            return false;
        if (currentbalance != null ? !currentbalance.equals(that.currentbalance) : that.currentbalance != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = balanceid != null ? balanceid.hashCode() : 0;
        result = 31 * result + (groupid != null ? groupid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (amountpaid != null ? amountpaid.hashCode() : 0);
        result = 31 * result + (amountpaiddate != null ? amountpaiddate.hashCode() : 0);
        result = 31 * result + (amountreturned != null ? amountreturned.hashCode() : 0);
        result = 31 * result + (amountreturneddate != null ? amountreturneddate.hashCode() : 0);
        result = 31 * result + (currentbalance != null ? currentbalance.hashCode() : 0);
        return result;
    }
}
