package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "author", schema = "", catalog = "kindle_controller_app")
public class AuthorEntity extends AbstractDaoModel {
    private Integer authorid;
    private String authorname;

    @Id
    @Column(name = "authorid")
    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    @Basic
    @Column(name = "authorname")
    public String getAuthorname() {
        return authorname;
    }

    public void setAuthorname(String authorname) {
        this.authorname = authorname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorEntity that = (AuthorEntity) o;

        if (authorid != null ? !authorid.equals(that.authorid) : that.authorid != null) return false;
        if (authorname != null ? !authorname.equals(that.authorname) : that.authorname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authorid != null ? authorid.hashCode() : 0;
        result = 31 * result + (authorname != null ? authorname.hashCode() : 0);
        return result;
    }
}
