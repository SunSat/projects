package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.sorting;

/**
 * Created by ssundar2 on 06-04-2017.
 */
public class BubbleSort {

    public static void main(String ... args) {
        int a[] = {5,4,3,2,10};
        int fullC = 0;
        for(int i = 0;i<a.length-1;i++) {
            for(int j = 0;j<a.length-1;j++) {
                if(a[j] > a[j+1]) {
                    fullC++;
                    int temp = a[j];
                    a[j]=a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        for(int k : a) {
            System.out.print(k + " ");
        }
        System.out.println("\n"+fullC + " ");
    }
}
