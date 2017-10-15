package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.warnup;

import java.util.Scanner;

/**
 * Created by ssundar2 on 29-01-2017.
 */
public class VeryBigSum {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sca = new Scanner(System.in);
        int num = sca.nextInt();
        long[] arr = new long[num];
        long total = 0;
        for(int i=0;i< num;i++) {
            arr[i] = sca.nextLong();
            total += arr[i];
        }
        System.out.println(total);

    }
}
