package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity(name = "item")
@DynamicInsert
@DynamicUpdate
@Immutable
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
