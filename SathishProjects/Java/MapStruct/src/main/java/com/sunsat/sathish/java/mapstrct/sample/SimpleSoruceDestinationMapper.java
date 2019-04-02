package com.sunsat.sathish.java.mapstrct.sample;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SimpleSoruceDestinationMapper {

    SimpleDestination sourceToDestination(SimpleSource source);
    SimpleSource destinationToSource(SimpleDestination destination);

}
