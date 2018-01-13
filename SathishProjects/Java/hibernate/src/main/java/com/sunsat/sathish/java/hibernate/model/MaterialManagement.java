package com.sunsat.sathish.java.hibernate.model;

import java.util.Set;

/**
 * Created by sathishkumar_su on 12/21/2017.
 *
 CREATE TABLE `meterialmanagement` (
 `meterialid` int(11) NOT NULL,
 `title` varchar(500) DEFAULT NULL,
 `authorids` text,
 `edition` varchar(15) DEFAULT NULL,
 `isbnnumber` varchar(45) DEFAULT NULL,
 `price` varchar(45) DEFAULT NULL,
 `img` varchar(45) DEFAULT NULL,
 `categoryids` text,
 `meterialtype` varchar(15) DEFAULT NULL,
 `status` varchar(15) DEFAULT NULL,
 PRIMARY KEY (`meterialid`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

 */
public class MaterialManagement extends AbstractDaoModel {
    private String title;
    private Set<Author> authors;
    private String edition;
    private String isbnNumber;
    private String price;
    private String img;
    private Set<Category> categories;
    private String materialType;
    private String status;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
