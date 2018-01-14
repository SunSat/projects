package com.sunsat.sathish.j2ee.store.dao.model;

/**
 * Created by sathishkumar_su on 1/13/2018.
 */
public class OrderItemDaoModel {
    int id;
    int orderId;
    int itemId;
    int quantity;
    float eachItemCost;
    float totalCost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getEachItemCost() {
        return eachItemCost;
    }

    public void setEachItemCost(float eachItemCost) {
        this.eachItemCost = eachItemCost;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

}
