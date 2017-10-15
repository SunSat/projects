package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.salary;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.exception.SalaryExceptions;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.pojo.Employee;

public abstract class SalaryCalculator {
	
	public abstract double calculateSalary(Employee emp, int noOfWorkingDays) throws SalaryExceptions;

}
