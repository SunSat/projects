package com.sunsat.sathish.java.mapstrct.lombok;

import org.mapstruct.factory.Mappers;

public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    CarDTO carToCarDTO(Car car);
    Car carDtoToCar(CarDTO dto);

}
