package com.sunsat.sathish.j2ee.loggingapp.pojo.dao;

import java.util.Date;

/**
 * Created by ssundar2 on 24-02-2017.
 */
public class CustomerInfoDao {

    private int id;
    private String name;
    private Date dateOfBirth;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
