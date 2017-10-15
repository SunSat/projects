package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.client;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.exception.SalaryExceptions;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.pojo.Employee;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.pojo.Salary;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.salary.SalaryCalculator;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.salary.SalaryCalculatorSeniorTL;
import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.salary.SalaryCalculatorTL;

public class EmployeeClient {
	
	public static void main(String... args) {
		Salary salary = new Salary();
		salary.setHra(5000);
		salary.setDa(5000);
		
		Employee emp = new Employee();
		emp.setId(100);
		emp.setName("Sathish");
		emp.setSalary(salary);
		emp.setDesignation("TL");
		SalaryCalculator cal = null;
		if(emp.getDesignation().equals("TL")) {
			cal = new SalaryCalculatorTL();
		} else {
			cal = new SalaryCalculatorSeniorTL();
		}
		try {
			System.out.println(cal.calculateSalary(emp, 28));
		} catch (SalaryExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
