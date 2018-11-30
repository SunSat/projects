package com.sunsat.sathish.j2ee.health.base.pojo.helper;

public enum RestrictionType {
    GT("gt"),LT("lt"),LIKE("like"),ILIKE("ilike"),BETWEEN("between"),ISNULL("isNull"),ISNOTNULL("isNotNull"),ISEMPTY("isEmpty"),ISNOTEMPTY("isNotEmpty"),AND("and"),OR("or");

    private String name;

    public String getName() {
        return name;
    }

    RestrictionType(String name) {
        this.name = name;
    }
}
