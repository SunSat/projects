package com.sunsat.sathish.java.mapstrct;

public enum CarEnum {
    HONDA("honda"),ZEN("zen");

    private String value;

    CarEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
