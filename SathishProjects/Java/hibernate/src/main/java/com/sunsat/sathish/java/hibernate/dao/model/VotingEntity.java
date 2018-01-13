package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "voting", schema = "", catalog = "kindle_controller_app")
public class VotingEntity extends AbstractDaoModel {
    private Integer votingid;
    private Integer meterialid;
    private Integer userid;
    private String comments;
    private Integer starrating;
    private MeterialmanagementEntity meterialmanagementByMeterialid;

    @Id
    @Column(name = "votingid")
    public Integer getVotingid() {
        return votingid;
    }

    public void setVotingid(Integer votingid) {
        this.votingid = votingid;
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
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Basic
    @Column(name = "starrating")
    public Integer getStarrating() {
        return starrating;
    }

    public void setStarrating(Integer starrating) {
        this.starrating = starrating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VotingEntity that = (VotingEntity) o;

        if (votingid != null ? !votingid.equals(that.votingid) : that.votingid != null) return false;
        if (meterialid != null ? !meterialid.equals(that.meterialid) : that.meterialid != null) return false;
        if (userid != null ? !userid.equals(that.userid) : that.userid != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (starrating != null ? !starrating.equals(that.starrating) : that.starrating != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = votingid != null ? votingid.hashCode() : 0;
        result = 31 * result + (meterialid != null ? meterialid.hashCode() : 0);
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (starrating != null ? starrating.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "meterialid", referencedColumnName = "meterialid")
    public MeterialmanagementEntity getMeterialmanagementByMeterialid() {
        return meterialmanagementByMeterialid;
    }

    public void setMeterialmanagementByMeterialid(MeterialmanagementEntity meterialmanagementByMeterialid) {
        this.meterialmanagementByMeterialid = meterialmanagementByMeterialid;
    }
}
