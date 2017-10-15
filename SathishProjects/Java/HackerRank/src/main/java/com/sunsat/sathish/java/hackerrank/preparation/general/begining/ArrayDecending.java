package com.sunsat.sathish.java.hackerrank.preparation.general.begining;

import java.util.concurrent.Callable;

public class ArrayDecending {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x, y;

		int[] arr = { 20, 10, 30 };
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1; j++) {
				x = arr[j];
				y = arr[j + 1];
				if (x < y) {
					arr[j] = y;
					arr[j + 1] = x;
				}	
			}
		}
		for(int k=0;k<arr.length;k++)
		{
			System.out.println(arr[k]);
		}
	}

	//class threads implements Callable
}
