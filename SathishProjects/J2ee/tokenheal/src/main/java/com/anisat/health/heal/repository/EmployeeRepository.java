package com.anisat.health.heal.repository;

import com.anisat.health.heal.repository.dao.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}