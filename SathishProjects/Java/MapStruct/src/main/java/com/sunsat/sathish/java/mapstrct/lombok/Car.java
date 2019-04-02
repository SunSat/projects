package com.sunsat.sathish.java.mapstrct.lombok;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
    private int id;
    private String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}