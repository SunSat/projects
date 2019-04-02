package com.sunsat.sathish.java.mapstrct.sample;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

public class Client {

    public static void main(String[] args) {
        SimpleSoruceDestinationMapper mapper = Mappers.getMapper(SimpleSoruceDestinationMapper.class);
        SimpleSource src = new SimpleSource();
        src.setDescription("hello");
        src.setName("Good");
        SimpleDestination dest = mapper.sourceToDestination(src);
        System.out.println(dest);
    }
}
