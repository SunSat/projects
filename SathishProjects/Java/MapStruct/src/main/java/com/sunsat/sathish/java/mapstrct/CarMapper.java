package com.sunsat.sathish.java.mapstrct;

import lombok.Value;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper<T extends Enum> {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    /*@Mapping(source = "numberOfSeats",target = "seatCount")*/
    //@ValueMapping(source = MappingConstants.ANY_REMAINING, target = MappingConstants.NULL)
    CarDto getCarToCarDto(Car car);
    Car getCarToCarDto(CarDto carDto);

    default String getStringFromEnum(T enum1) {
        return enum1.name();
    }

    default CarEnum getEnumFromString(String st) {
        for(CarEnum carEnum : CarEnum.values()) {
            if(carEnum.getValue().equals(st)) {
                return carEnum;
            }
        }
        throw new RuntimeException();
    }
}
