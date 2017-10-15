package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm;

import java.util.Scanner;

/**
 * Created by ssundar2 on 28-01-2017.
 */
public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int[] arr = new int[a];
        int total = 0;
        for(int i = 0;i<a;i++) {
            arr[i]=in.nextInt();
            total = total + arr[i];
        }
        System.out.println(total);
    }
}
