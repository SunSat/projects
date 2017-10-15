package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.ch2.employee.pojo;

public class Salary {
	
	double pa;
	double da;
	double hra;
	double cityAll;
	double otherAll;
	
	public double getPa() {
		return pa;
	}
	public void setPa(double pa) {
		this.pa = pa;
	}
	public double getDa() {
		return da;
	}
	public void setDa(double da) {
		this.da = da;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getCityAll() {
		return cityAll;
	}
	public void setCityAll(double cityAll) {
		this.cityAll = cityAll;
	}
	public double getOtherAll() {
		return otherAll;
	}
	public void setOtherAll(double otherAll) {
		this.otherAll = otherAll;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(cityAll);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(da);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(otherAll);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(pa);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (Double.doubleToLongBits(cityAll) != Double
				.doubleToLongBits(other.cityAll))
			return false;
		if (Double.doubleToLongBits(da) != Double.doubleToLongBits(other.da))
			return false;
		if (Double.doubleToLongBits(hra) != Double.doubleToLongBits(other.hra))
			return false;
		if (Double.doubleToLongBits(otherAll) != Double
				.doubleToLongBits(other.otherAll))
			return false;
		if (Double.doubleToLongBits(pa) != Double.doubleToLongBits(other.pa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Salary [pa=" + pa + ", da=" + da + ", hra=" + hra
				+ ", cityAll=" + cityAll + ", otherAll=" + otherAll + "]";
	}
	
	

}
