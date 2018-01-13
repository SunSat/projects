package com.sunsat.sathish.j2ee.store.dao.model;

/**
 * Created by sathishkumar_su on 1/12/2018.
 */
public class CategoryDaoModel {
    int categoryid;
    int parentCategoryId;
    String name;

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
