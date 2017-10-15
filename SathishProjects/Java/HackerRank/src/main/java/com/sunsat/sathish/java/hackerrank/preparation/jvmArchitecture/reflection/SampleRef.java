package com.sunsat.sathish.java.hackerrank.preparation.jvmArchitecture.reflection;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SampleRef {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Class stu = Class.forName("com.anisat.jvmArchitecture.reflection.Student");
		Method[] mths = stu.getDeclaredMethods();
		for(Method m: mths) {
			System.out.println(m);
		}
		System.out.println(String.class.getClassLoader());
		System.out.println(Object.class.getClassLoader());
		System.out.println(File.class.getClassLoader());
		System.out.println(Student.class.getClassLoader());
	}

}
