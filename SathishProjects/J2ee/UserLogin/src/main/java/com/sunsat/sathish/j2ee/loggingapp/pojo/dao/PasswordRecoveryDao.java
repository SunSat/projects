package com.sunsat.sathish.j2ee.loggingapp.pojo.dao;

import java.util.Date;

/**
 * Created by ssundar2 on 24-02-2017.
 */
public class PasswordRecoveryDao {

    private int id;
    private String link;
    private String code;
    private Date expiryDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PasswordRecoveryDao)) return false;

        PasswordRecoveryDao that = (PasswordRecoveryDao) o;

        if (getId() != that.getId()) return false;
        if (getLink() != null ? !getLink().equals(that.getLink()) : that.getLink() != null) return false;
        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) return false;
        return !(getExpiryDate() != null ? !getExpiryDate().equals(that.getExpiryDate()) : that.getExpiryDate() != null);

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getLink() != null ? getLink().hashCode() : 0);
        result = 31 * result + (getCode() != null ? getCode().hashCode() : 0);
        result = 31 * result + (getExpiryDate() != null ? getExpiryDate().hashCode() : 0);
        return result;
    }
}
