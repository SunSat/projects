package com.sunsat.sathish.java.mapstrct.employee;

import org.mapstruct.factory.Mappers;

import java.util.Date;

public class EmployeeClient {
    public static void main(String[] args) {
        EmployeeMapper empMapper = Mappers.getMapper(EmployeeMapper.class);
        Employee emp = new Employee(1,"Sathish",new Date());
        EmployeeDTO dto = empMapper.employeeToEmployeeDto(emp);
        System.out.println("Emp --> DTO : " + dto);

        System.out.println("DTO --> EMP" + empMapper.employeeDtoToEmployee(dto));
    }
}
