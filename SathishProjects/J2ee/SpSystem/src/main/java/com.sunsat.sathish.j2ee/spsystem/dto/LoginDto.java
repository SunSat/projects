package com.sunsat.sathish.j2ee.spsystem.dto;

import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by ssundar2 on 28-03-2017.
 */
@Scope("prototype")
public class LoginDto {

    private int trackingId;
    private Date logingTime;
    private Date loggoutTime;
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
        if (!(o instanceof LoginDto)) return false;

        LoginDto loginDto = (LoginDto) o;

        if (getTrackingId() != loginDto.getTrackingId()) return false;
        if (getLogingTime() != null ? !getLogingTime().equals(loginDto.getLogingTime()) : loginDto.getLogingTime() != null)
            return false;
        if (getLoggoutTime() != null ? !getLoggoutTime().equals(loginDto.getLoggoutTime()) : loginDto.getLoggoutTime() != null)
            return false;
        return !(getSttaus() != null ? !getSttaus().equals(loginDto.getSttaus()) : loginDto.getSttaus() != null);

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
