package com.sunsat.sathish.java.hackerrank.preparation.jvmArchitecture.reflection;

import java.util.Date;

public class Student {

	String name;
	int id;
	Date dob;
	String gender;
	
	
	public String getName() {
		System.out.println("This is getName");
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
}
