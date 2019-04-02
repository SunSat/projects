package com.sunsat.sathish.java.mapstrct;

public class Car {

    private String make;
    private int numberOfSeats;
    private String type;
    private CarEnum carType;

    public Car(String make, int numberOfSeats, String type) {
        this.make = make;
        this.numberOfSeats = numberOfSeats;
        this.type = type;
    }

    public Car() {
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

    public CarEnum getCarType() {
        return carType;
    }

    public void setCarType(CarEnum carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", type='" + type + '\'' +
                ", carType=" + carType +
                '}';
    }
}
