package com.sunsat.sathish.java.hackerrank.preparation.ideserv.dynamic_programming;

/**
 * Created by ssundar2 on 5/12/2017.
 */
public class FindMaximumSubArray_Optimized {
    public static void main(String[] args) {
        int[] array = {-2, -9, -5, -1};
        int max = 0;
        int cuSum = 0;
        int maxNegativeNumber = Integer.MIN_VALUE;
        boolean hasAllNegativeNu = true;
        for(int k=0;k<array.length;k++) {
            if(hasAllNegativeNu && array[k] >= 0) {
                hasAllNegativeNu = false;
            }
            if(hasAllNegativeNu && array[k] < 0 && maxNegativeNumber < array[k]) {
                maxNegativeNumber = array[k];
            }
            cuSum += array[k];
            if(cuSum < 0) {
                cuSum = 0;
            }
            if(max < cuSum) {
                max = cuSum;
            }
        }
        System.out.println("The max is : " + (hasAllNegativeNu ? maxNegativeNumber : max));
    }
}
