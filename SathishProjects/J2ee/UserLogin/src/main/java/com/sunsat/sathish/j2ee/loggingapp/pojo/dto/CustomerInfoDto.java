package com.sunsat.sathish.j2ee.loggingapp.pojo.dto;

import java.util.Date;

/**
 * Created by ssundar2 on 15-03-2017.
 */
public class CustomerInfoDto {

    private int id;
    private String name;
    private String gender;
    private Date dateOfBirth;

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
