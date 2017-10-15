package com.sunsat.sathish.java.hackerrank.preparation.ideserv.dynamic_programming;

import java.util.Scanner;

/**
 * Created by ssundar2 on 5/12/2017.
 */
public class FibonasicLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long count = sc.nextLong();
        if(count < 0) throw new IllegalArgumentException("N is less then 0");
        long f1 = 0,f2 = 1;
        System.out.print(f1 + " " + f2);
        long now  = System.currentTimeMillis();
        for(long i=0;i<count-2;i++) {
            f2 = f1 + f2;
            f1 = f2 - f1;
            //System.out.print(" " + f2);
        }
        long later = System.currentTimeMillis();
        System.out.println("First Iteration time in sec : " + ((later-now)/1000));

        long result = 0;
        f1 = 0;f2 = 1;
        now  = System.currentTimeMillis();
        for(long i=1;i<count;i++) {
            result = f1 + f2;
            f1 = f2;
            f2 = result;
            //System.out.print(" " + f2);
        }
        later = System.currentTimeMillis();
        System.out.println("Second Iteration time in sec : " + ((later-now)/1000));
    }
}
