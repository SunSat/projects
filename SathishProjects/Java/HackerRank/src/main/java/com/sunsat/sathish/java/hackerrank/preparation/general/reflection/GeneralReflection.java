package com.sunsat.sathish.java.hackerrank.preparation.general.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class GeneralReflection {

	public static void main(String ... args) {
		try {
			Class c = Class.forName("Student");
			Student s = (Student)c.newInstance();
			s.helloStudent(12);
			Class doubleCla = Double.TYPE;
			Constructor<Double> c111 = doubleCla.getConstructor(String.class);
			Double dddddd = c111.newInstance("12");
			System.out.println(dddddd);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
