package com.sunsat.sathish.java.hibernate.model;

/**
 * Created by sathishkumar_su on 12/21/2017.
 CEATE TABLE `category` (
 `categoryid` int(11) NOT NULL,
 `categorytitle` varchar(45) DEFAULT NULL,
 `parentcategoryid` int(11) NOT NULL,
 PRIMARY KEY (`categoryid`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */
public class Category {

    private int parentCategoryId;
    private String categoryTitle;

    public int getParentCategoryId() {
        return parentCategoryId;
    }

    public void setParentCategoryId(int parentCategoryId) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
}
