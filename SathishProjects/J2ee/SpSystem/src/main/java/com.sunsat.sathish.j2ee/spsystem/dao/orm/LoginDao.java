package com.sunsat.sathish.j2ee.spsystem.dao.orm;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by ssundar2 on 28-03-2017.
 */
@Entity
@Table(name = "login")
public class LoginDao {

    @Id
    @Column(name = "trackingid")
    private int trackingId;

    @Column(name = "logingtime")
    private Date logingTime;

    @Column(name = "loggouttime")
    private Date loggoutTime;

    @Column (name = "status")
    private String sttaus;

    public int getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(int trackingId) {
        this.trackingId = trackingId;
    }

    public Date getLogingTime() {
        return logingTime;
    }

    public void setLogingTime(Date logingTime) {
        this.logingTime = logingTime;
    }

    public Date getLoggoutTime() {
        return loggoutTime;
    }

    public void setLoggoutTime(Date loggoutTime) {
        this.loggoutTime = loggoutTime;
    }

    public String getSttaus() {
        return sttaus;
    }

    public void setSttaus(String sttaus) {
        this.sttaus = sttaus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LoginDao)) return false;

        LoginDao loginDao = (LoginDao) o;

        if (getTrackingId() != loginDao.getTrackingId()) return false;
        if (getLogingTime() != null ? !getLogingTime().equals(loginDao.getLogingTime()) : loginDao.getLogingTime() != null)
            return false;
        if (getLoggoutTime() != null ? !getLoggoutTime().equals(loginDao.getLoggoutTime()) : loginDao.getLoggoutTime() != null)
            return false;
        return !(getSttaus() != null ? !getSttaus().equals(loginDao.getSttaus()) : loginDao.getSttaus() != null);

    }

    @Override
    public int hashCode() {
        int result = getTrackingId();
        result = 31 * result + (getLogingTime() != null ? getLogingTime().hashCode() : 0);
        result = 31 * result + (getLoggoutTime() != null ? getLoggoutTime().hashCode() : 0);
        result = 31 * result + (getSttaus() != null ? getSttaus().hashCode() : 0);
        return result;
    }
}
