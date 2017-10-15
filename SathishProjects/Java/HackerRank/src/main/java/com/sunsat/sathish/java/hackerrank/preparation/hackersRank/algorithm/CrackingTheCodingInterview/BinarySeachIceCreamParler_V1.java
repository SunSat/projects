package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ssundar2 on 7/2/2017.
 */
public class BinarySeachIceCreamParler_V1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int a[] = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            devide(a,0,a.length-1);
            for(int sorted : a) {
                System.out.print(sorted + " ");
            }
        }
    private static void devide(int[] a, int start, int end) {
        int mid = ((start + end)/2);
        if(start < end) {
            devide(a, start,mid);
            devide(a, mid+1,end);
            conqure(a,start,mid,end);
        }
    }
    private static void conqure(int[] a, int start, int mid, int end) {
        int n1 = mid - start +1;
        int n2 = end - mid;

        int[] n1_arr = new int[n1];
        int[] n2_arr = new int[n2];

        int k = start;
        for(int i=0;i<n1;i++) {
            n1_arr[i] = a[k++];
        }

        k = mid+1;
        for(int j=0;j<n2;j++) {
            n2_arr[j] = a[k++];
        }

        int i=0,j=0;k=start;

        while(i<n1 && j < n2) {
            if(n1_arr[i] <= n2_arr[j]) {
                a[k++] = n1_arr[i++];
            } else {
                a[k++] = n2_arr[j++];
            }
        }

        while(i < n1) {
            a[k++] = n1_arr[i++];
        }
        while(j < n2) {
            a[k++] = n2_arr[j++];
        }
    }
}
