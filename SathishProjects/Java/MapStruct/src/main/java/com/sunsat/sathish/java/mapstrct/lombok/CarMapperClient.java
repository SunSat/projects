package com.sunsat.sathish.java.mapstrct.lombok;

public class CarMapperClient {
    public static void main(String[] args) {
        Car car = new Car(1,"Sathish");
        CarDTO dto = CarMapper.INSTANCE.carToCarDTO(car);

        System.out.println(" 1: " + dto);
        System.out.println(" 2: " +CarMapper.INSTANCE.carDtoToCar(dto));
    }
}
