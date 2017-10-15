package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm;

import java.util.Scanner;

/**
 * Created by ssundar2 on 28-01-2017.
 */
public class CountingSort1 {
    public static void main(String... args) {
        while(true) {
            Scanner in = new Scanner(System.in);
            int size = in.nextInt();
            int arr[] = new int[100];
            for(int k = 0;k<size;k++) {
                int val = in.nextInt();
                arr[val] = ++arr[val];
            }
            System.out.println();
            for(int k = 0;k<size;k++) {
                System.out.print((arr[k]) + " ");
            }
        }
    }

}
