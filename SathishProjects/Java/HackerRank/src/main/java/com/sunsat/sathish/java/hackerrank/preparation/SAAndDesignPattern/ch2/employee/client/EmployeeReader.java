package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.pojo.Employee;



public class EmployeeReader implements Reader {

	int noofrecord=0,id=0,record=0;
	String name="",designation="";
	
	List emplist=new ArrayList();
	Scanner in=new Scanner(System.in);
	
	public void readdata()
	{
		System.out.println("Enter No of Records: ");
		noofrecord=in.nextInt();
		for(int i=0;i<=noofrecord-1;i++)
		{
			System.out.println("Enter ID: ");
			id=in.nextInt();
			System.out.println("Enter Name: ");
			name=in.next();
			System.out.println("Enter Designation: ");
			designation=in.next();
			Employee e=new Employee();
			e.setId(id);
			e.setName(name);
			e.setDesignation(designation);
			emplist.add(e);
		}
		
	}
	
	public void printdata()
	{
		Employee e;
		System.out.println("List Of Records ");	
		for(int i=0;i<=emplist.size()-1;i++)
		{
			e=(Employee) emplist.get(i);
			System.out.println(e.getId() + " " + e.getName() + " " + e.getDesignation());
		}
		
		System.out.println("Enter Record No : ");
		record=in.nextInt();
		e=(Employee) emplist.get(record-1);
		System.out.println(e.getId() + " " + e.getName() + " " + e.getDesignation());
	}
	
	public static void main(String[] args) {
		
		EmployeeReader empreader=new EmployeeReader();
		empreader.readdata();
		empreader.printdata();

	}

}
