package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao;

import javax.persistence.*;

@Entity
@Table(name = "u_address")
public class U_Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "street")
    String street;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
