package com.sunsat.sathish.j2ee.store.dao.model;

/**
 * Created by sathishkumar_su on 1/13/2018.
 */
public class UserOrderDaoModel {
    int id;
    int userId;
    int orderId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
