package com.sunsat.sathish.java.mapstrct.lombok;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDTO {
    private int id;
    private String name;

    public CarDTO() {

    }

    public CarDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CarDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
