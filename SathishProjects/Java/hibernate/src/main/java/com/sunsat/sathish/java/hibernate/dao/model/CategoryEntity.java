package com.sunsat.sathish.java.hibernate.dao.model;

import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;

import javax.persistence.*;

/**
 * Created by sathishkumar_su on 12/21/2017.
 */
@Entity
@Table(name = "category", schema = "", catalog = "kindle_controller_app")
public class CategoryEntity extends AbstractDaoModel {

    private Integer categoryid;
    private Integer parentcategoryid;
    private String categorytitle;

    @Id
    @Column(name = "categoryid")
    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    @Basic
    @Column(name = "parentcategoryid")
    public Integer getParentcategoryid() {
        return parentcategoryid;
    }

    public void setParentcategoryid(Integer parentcategoryid) {
        this.parentcategoryid = parentcategoryid;
    }

    @Basic
    @Column(name = "categorytitle")
    public String getCategorytitle() {
        return categorytitle;
    }

    public void setCategorytitle(String categorytitle) {
        this.categorytitle = categorytitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryEntity that = (CategoryEntity) o;

        if (categoryid != null ? !categoryid.equals(that.categoryid) : that.categoryid != null) return false;
        if (parentcategoryid != null ? !parentcategoryid.equals(that.parentcategoryid) : that.parentcategoryid != null)
            return false;
        if (categorytitle != null ? !categorytitle.equals(that.categorytitle) : that.categorytitle != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryid != null ? categoryid.hashCode() : 0;
        result = 31 * result + (parentcategoryid != null ? parentcategoryid.hashCode() : 0);
        result = 31 * result + (categorytitle != null ? categorytitle.hashCode() : 0);
        return result;
    }
}
