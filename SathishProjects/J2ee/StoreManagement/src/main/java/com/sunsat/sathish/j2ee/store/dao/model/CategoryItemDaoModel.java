package com.sunsat.sathish.j2ee.store.dao.model;

/**
 * Created by sathishkumar_su on 1/12/2018.
 */
public class CategoryItemDaoModel {
    int id;
    int categoryId;
    int itemId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }
}
