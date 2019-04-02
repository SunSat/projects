package com.sunsat.sathish.java.mapstrct;

public class CarDto {

    private String make;
    private int numberOfSeats;
    private String type;
    private String carType;

    public CarDto() {
    }

    public CarDto(String make, int numberOfSeats, String type) {
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "make='" + make + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", type='" + type + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }
}