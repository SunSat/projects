package com.sunsat.sathish.j2ee.store.dao.model;

import java.util.Date;

/**
 * Created by sathishkumar_su on 1/8/2018.
 */
public class ItemDaoModel {
    private int itemId;
    private String name;
    private String description;
    private float initial_price;
    private float reserved_price;
    private Date start_date;
    private Date end_date;
    private int quantity;
    private String state;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getInitial_price() {
        return initial_price;
    }

    public void setInitial_price(float initial_price) {
        this.initial_price = initial_price;
    }

    public float getReserved_price() {
        return reserved_price;
    }

    public void setReserved_price(float reserved_price) {
        this.reserved_price = reserved_price;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
