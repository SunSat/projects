package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by ssundar2 on 01-02-2017.
 */
public class MinMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long[] x = new long[5];
        /*x[0] = in.nextLong();
        x[1] = in.nextLong();
        x[2] = in.nextLong();
        x[3] = in.nextLong();
        x[4] = in.nextLong();*/
        String st[] = "256741038 623958417 467905213 714532089 938071625".split(" ");
        for(int y=0; y<5; y++) {
            x[y] = Long.parseLong(st[y]);
        }
        long[] l = new long[5];

        long low = 0,high = 0;
        for(int i=0;i<5;i++) {
            long t = 0;
            for(int j=0;j<5;j++) {
                if(j == i) {
                    continue;
                }
                t += x[j];
            }
            if(i == 0) {
                low = high = t;
            } else {
                if(low > t) low = t;
                if(high < t) high = t;
            }
        }
        System.out.println(low+" " + high);
    }
}
