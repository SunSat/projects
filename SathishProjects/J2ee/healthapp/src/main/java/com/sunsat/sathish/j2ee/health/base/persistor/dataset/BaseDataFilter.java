package com.sunsat.sathish.j2ee.health.base.persistor.dataset;

public enum BaseDataFilter {
    BY_ALL("all"), BY_BUSINESS_KEY("businesskey");

    private String filterType;

    BaseDataFilter(String type) {
        this.filterType = type;
    }

}
