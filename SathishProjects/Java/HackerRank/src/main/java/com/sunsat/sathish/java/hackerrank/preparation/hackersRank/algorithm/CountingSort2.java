package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm;

import java.util.Scanner;

/**
 * Created by ssundar2 on 28-01-2017.
 */
public class CountingSort2 {

    public static void main(String ... args) {
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        int arr[] = new int[100];
        for (int k = 0; k < size; k++) {
            int val = in.nextInt();
            arr[val] = ++arr[val];
        }

        System.out.println();
        for (int k = 0; k < size; k++) {
            if (arr[k] > 0) {
                for (int oriPrint = 0; oriPrint < arr[k]; oriPrint++) {
                    System.out.print(k + " ");
                }
            }
        }
    }
}
