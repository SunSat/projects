package com.sunsat.sathish.j2ee.loggingapp.pojo.dto;

import java.util.Date;

/**
 * Created by ssundar2 on 27-02-2017.
 */
public class UserDto {

    private int id;
    private String uesrName;
    private String password;
    private Date creationTime;
    private Date expiryTime;
    private String stauts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUesrName() {
        return uesrName;
    }

    public void setUesrName(String uesrName) {
        this.uesrName = uesrName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Date expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto)) return false;

        UserDto that = (UserDto) o;

        if (getId() != that.getId()) return false;
        if (getUesrName() != null ? !getUesrName().equals(that.getUesrName()) : that.getUesrName() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(that.getPassword()) : that.getPassword() != null)
            return false;
        if (getCreationTime() != null ? !getCreationTime().equals(that.getCreationTime()) : that.getCreationTime() != null)
            return false;
        if (getExpiryTime() != null ? !getExpiryTime().equals(that.getExpiryTime()) : that.getExpiryTime() != null)
            return false;
        return !(getStauts() != null ? !getStauts().equals(that.getStauts()) : that.getStauts() != null);

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getUesrName() != null ? getUesrName().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getCreationTime() != null ? getCreationTime().hashCode() : 0);
        result = 31 * result + (getExpiryTime() != null ? getExpiryTime().hashCode() : 0);
        result = 31 * result + (getStauts() != null ? getStauts().hashCode() : 0);
        return result;
    }
}
