package com.sunsat.sathish.java.hackerrank.preparation.general.begining;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(1 << 0 );
		System.out.println(1 << 2 );
		System.out.println(1 << 3 );
		System.out.println(1 << 4 );
		System.out.println(1 << 5 );
		System.out.println(1 << 6 );
		System.out.println(1 << 7 );
		System.out.println(1 << 8 );
		System.out.println(1 << 9 );
		System.out.println(1 << 10 );
		System.out.println(1 << 11 );
		
		System.out.println(8 | 16);

		System.out.println(0 >> 1 );
		System.out.println(1 >> 1 );
		System.out.println(3 >> 1 );
		System.out.println(4 >> 1 );
		System.out.println(5 >> 1 );

		int[] a = {1,2,3,4,5};
		System.arraycopy(a,1,a,2,3);
		for(int i : a) {
			System.out.print(i + " ");
		}
	}

}
