package com.sunsat.sathish.j2ee.health.base.persistor.dataset;

public enum BaseDataFilter {
    BY_ALL("all"), BY_ID("id"),BY_BUSINESS_KEY("do not load any reference");

    private String filterType;

    BaseDataFilter(String type) {
        this.filterType = type;
    }

}
