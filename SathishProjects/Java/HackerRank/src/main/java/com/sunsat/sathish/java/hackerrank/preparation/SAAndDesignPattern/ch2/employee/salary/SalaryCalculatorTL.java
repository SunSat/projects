package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.salary;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.exception.SalaryExceptions;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.pojo.Employee;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.pojo.Salary;

public class SalaryCalculatorTL extends SalaryCalculator {

	int OT = 100;
	
	@Override
	public double calculateSalary(Employee emp, int noOfWorkingDays) throws SalaryExceptions {
		Salary sal = emp.getSalary();
		double d = (sal.getHra() + sal.getOtherAll());
		return d;
	}	
}
