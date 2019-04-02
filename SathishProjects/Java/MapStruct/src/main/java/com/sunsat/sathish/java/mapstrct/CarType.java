package com.sunsat.sathish.java.mapstrct;

public class CarType {
    String seater;
    String type;

    public CarType() {
    }

    public CarType(String seater, String type) {
        this.seater = seater;
        this.type = type;
    }

    public String getSeater() {
        return seater;
    }

    public void setSeater(String seater) {
        this.seater = seater;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
