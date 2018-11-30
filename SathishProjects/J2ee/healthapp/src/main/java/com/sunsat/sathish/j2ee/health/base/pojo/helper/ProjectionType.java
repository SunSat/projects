package com.sunsat.sathish.j2ee.health.base.pojo.helper;

public enum ProjectionType {
    ROWCOUNT("rowCount"),AVG("avg"),COUNTDISTINCT("countDistinct"),MIN("min"),MAX("max"),SUM("sum");
    private String name;

    ProjectionType(String proName) {
        this.name = proName;
    }

    public String getName() {
        return name;
    }
}
