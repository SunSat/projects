package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "meterialmanagement", schema = "", catalog = "kindle_controller_app")
public class MeterialmanagementEntity extends AbstractDaoModel {
    private Integer meterialid;
    private String title;
    private String authorids;
    private String edition;
    private String isbnnumber;
    private String price;
    private String img;
    private String categoryids;
    private String meterialtype;
    private String status;
    private Collection<VotingEntity> votingsByMeterialid;

    @Id
    @Column(name = "meterialid")
    public Integer getMeterialid() {
        return meterialid;
    }

    public void setMeterialid(Integer meterialid) {
        this.meterialid = meterialid;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "authorids")
    public String getAuthorids() {
        return authorids;
    }

    public void setAuthorids(String authorids) {
        this.authorids = authorids;
    }

    @Basic
    @Column(name = "edition")
    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    @Basic
    @Column(name = "isbnnumber")
    public String getIsbnnumber() {
        return isbnnumber;
    }

    public void setIsbnnumber(String isbnnumber) {
        this.isbnnumber = isbnnumber;
    }

    @Basic
    @Column(name = "price")
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "img")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "categoryids")
    public String getCategoryids() {
        return categoryids;
    }

    public void setCategoryids(String categoryids) {
        this.categoryids = categoryids;
    }

    @Basic
    @Column(name = "meterialtype")
    public String getMeterialtype() {
        return meterialtype;
    }

    public void setMeterialtype(String meterialtype) {
        this.meterialtype = meterialtype;
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MeterialmanagementEntity that = (MeterialmanagementEntity) o;

        if (meterialid != null ? !meterialid.equals(that.meterialid) : that.meterialid != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (authorids != null ? !authorids.equals(that.authorids) : that.authorids != null) return false;
        if (edition != null ? !edition.equals(that.edition) : that.edition != null) return false;
        if (isbnnumber != null ? !isbnnumber.equals(that.isbnnumber) : that.isbnnumber != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (img != null ? !img.equals(that.img) : that.img != null) return false;
        if (categoryids != null ? !categoryids.equals(that.categoryids) : that.categoryids != null) return false;
        if (meterialtype != null ? !meterialtype.equals(that.meterialtype) : that.meterialtype != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = meterialid != null ? meterialid.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (authorids != null ? authorids.hashCode() : 0);
        result = 31 * result + (edition != null ? edition.hashCode() : 0);
        result = 31 * result + (isbnnumber != null ? isbnnumber.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (img != null ? img.hashCode() : 0);
        result = 31 * result + (categoryids != null ? categoryids.hashCode() : 0);
        result = 31 * result + (meterialtype != null ? meterialtype.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "meterialmanagementByMeterialid")
    public Collection<VotingEntity> getVotingsByMeterialid() {
        return votingsByMeterialid;
    }

    public void setVotingsByMeterialid(Collection<VotingEntity> votingsByMeterialid) {
        this.votingsByMeterialid = votingsByMeterialid;
    }
}
