package com.sunsat.sathish.java.hackerrank.preparation.general.recursion;

import java.util.Scanner;

public class CountACharInRecursionV1 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		String st = in.nextLine();
		char a = (in.nextLine()).charAt(0);
		if(st == null || st.trim().length() == 0) throw new Exception("Invalid String ");
		System.out.println(countACharInRecur(st,a));
	}
	
	public static int countACharInRecur(String st,char a) {
		int count = 0;
		if(st != null && st.length() <= 1) {
			if(st.indexOf(a) > 0) {
				return ++count;
			}
			return count;
		}
		if(st.indexOf(a) > 0) {
			count++;
		} 
		//return countACharInRecur(st.substring(st.indexOf(a)) + count;
		return 0;
	}	
}
