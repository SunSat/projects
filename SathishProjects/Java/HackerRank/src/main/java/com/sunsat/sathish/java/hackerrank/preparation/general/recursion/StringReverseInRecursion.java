package com.sunsat.sathish.java.hackerrank.preparation.general.recursion;

import java.util.Scanner;

public class StringReverseInRecursion {
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String st = in.nextLine();
		if(st == null || st.trim().length() == 0) throw new Exception("Invalid String ");
		System.out.println(reverseString(st));
	}
	
	public static String reverseString(String st) {
		if(st != null && st.length() <= 1) {
			return st;
		}
		return reverseString(st.substring(1)) + st.charAt(0);
	}

}
