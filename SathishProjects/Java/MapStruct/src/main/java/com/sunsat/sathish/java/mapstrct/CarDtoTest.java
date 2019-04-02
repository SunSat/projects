package com.sunsat.sathish.java.mapstrct;

import org.testng.annotations.Test;

public class CarDtoTest {

    public static void main(String[] args) {
        new CarDtoTest().shouldMapCarToDto();
    }

    @Test
    public void shouldMapCarToDto() {
        Car car = new Car( "Morris", 5, "Sadan");
        car.setCarType(CarEnum.HONDA);
        System.out.println("The Original Car : \n" + car + "\n ------------------");
        CarDto carDto = CarMapper.INSTANCE.getCarToCarDto( car );
        System.out.println("The CarDto afterconverted \n" + carDto + "\n =============");
        Car c1 = CarMapper.INSTANCE.getCarToCarDto(carDto);
        System.out.println("The Again Car Objecct from DTO is : \n" + c1 + "\n ..........");
    }
}
