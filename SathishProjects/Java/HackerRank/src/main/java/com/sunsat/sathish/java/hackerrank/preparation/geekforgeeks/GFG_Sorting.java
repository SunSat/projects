package com.sunsat.sathish.java.hackerrank.preparation.geekforgeeks;

import java.util.Scanner;

/**
 * Created by ssundar2 on 5/11/2017.
 */
public class GFG_Sorting {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int no = sc.nextInt();
        int[][] cases = new int[no][2];
        for(int i=0;i<no;i++) {
            cases[i][0]=sc.nextInt();
            cases[i][1]=sc.nextInt();
        }
        for(int i=0;i<no;i++) {
		    int refil = cases[i][0];
		    for(int k=1;k<cases[i][1];k++) {
                refil = refil >> 2;
            }
            System.out.println(refil);
        }
    }
}
