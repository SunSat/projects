package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.chalanges;

import java.util.Scanner;

/**
 * Created by ssundar2 on 5/9/2017.
 */
public class BubbleSortReducedVersion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int toalExec = 0;
        int numSwap=0;
        int size = n;
        for(int k = 0;k<n;k++) {
            for(int l = 0; l<size-1 ;l++) {
                toalExec++;
                if(a[l] > a[l+1]) {
                    int temp = a[l];
                    a[l] = a[l+1];
                    a[l+1] = temp;
                    numSwap++;
                }
            }
            size--;
        }
        System.out.println("Array is sorted in "+numSwap+" swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: "+ a[n-1]);
        System.out.println("Total Execution is : "+ toalExec);
    }
}
