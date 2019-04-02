package com.sunsat.sathish.java.mapstrct.employee;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "employeeId",source = "id"),
            @Mapping(target = "employeeName",source = "name"),
            @Mapping(target = "date",source = "date",dateFormat = "dd-MM-yyyy")
    })
    EmployeeDTO employeeToEmployeeDto(Employee emp);

    @Mappings({
            @Mapping(target = "name",source = "employeeName"),
            @Mapping(target = "id",source = "employeeId"),
            @Mapping(target = "date",source = "date",dateFormat = "dd-MM-yyyy")
    })

    Employee employeeDtoToEmployee(EmployeeDTO empDto);

}
