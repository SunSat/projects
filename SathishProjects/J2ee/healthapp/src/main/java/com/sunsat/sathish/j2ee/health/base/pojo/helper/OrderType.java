package com.sunsat.sathish.j2ee.health.base.pojo.helper;

public enum OrderType {
    ASC("asc"),DESC("desc");

    private String name;
    public String getName() {
        return name;
    }

    OrderType(String orderName) {
        this.name = orderName;
    }
}
