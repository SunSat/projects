package com.sunsat.sathish.java.hackerrank.preparation.ideserv.dynamic_programming;

/**
 * Created by ssundar2 on 5/12/2017.
 */
public class FindMaximumSubArray {
    public static void main(String[] args) {
        int[] array = {2, -9, 5, 1, -4, 6, 0, -7, 8};
        int max = 0;
        for(int k=0;k<array.length;k++) {
            int total = 0;
            for(int j=k;j<array.length;j++) {
                total += array[j];
            }
            if(total > max) max = total;
        }
        System.out.println("The max is : " + max);
    }

}
