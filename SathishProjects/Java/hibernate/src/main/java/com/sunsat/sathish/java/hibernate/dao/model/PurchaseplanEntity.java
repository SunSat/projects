package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "purchaseplan", schema = "", catalog = "kindle_controller_app")
public class PurchaseplanEntity extends AbstractDaoModel {
    private Integer purchaseplanid;
    private Integer meterialid;
    private Integer userid;
    private String buyingoption;
    private Integer willinggroupid;

    @Id
    @Column(name = "purchaseplanid")
    public Integer getPurchaseplanid() {
        return purchaseplanid;
    }

    public void setPurchaseplanid(Integer purchaseplanid) {
        this.purchaseplanid = purchaseplanid;
    }

    @Basic
    @Column(name = "meterialid")
    public Integer getMeterialid() {
        return meterialid;
    }

    public void setMeterialid(Integer meterialid) {
        this.meterialid = meterialid;
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
    @Column(name = "buyingoption")
    public String getBuyingoption() {
        return buyingoption;
    }

    public void setBuyingoption(String buyingoption) {
        this.buyingoption = buyingoption;
    }

    @Basic
    @Column(name = "willinggroupid")
    public Integer getWillinggroupid() {
        return willinggroupid;
    }

    public void setWillinggroupid(Integer willinggroupid) {
        this.willinggroupid = willinggroupid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseplanEntity that = (PurchaseplanEntity) o;

        if (purchaseplanid != null ? !purchaseplanid.equals(that.purchaseplanid) : that.purchaseplanid != null)
            return false;
        if (meterialid != null ? !meterialid.equals(that.meterialid) : that.meterialid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (buyingoption != null ? !buyingoption.equals(that.buyingoption) : that.buyingoption != null) return false;
        if (willinggroupid != null ? !willinggroupid.equals(that.willinggroupid) : that.willinggroupid != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = purchaseplanid != null ? purchaseplanid.hashCode() : 0;
        result = 31 * result + (meterialid != null ? meterialid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (buyingoption != null ? buyingoption.hashCode() : 0);
        result = 31 * result + (willinggroupid != null ? willinggroupid.hashCode() : 0);
        return result;
    }
}
