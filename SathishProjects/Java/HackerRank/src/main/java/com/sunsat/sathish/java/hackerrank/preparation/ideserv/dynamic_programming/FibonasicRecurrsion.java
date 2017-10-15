package com.sunsat.sathish.java.hackerrank.preparation.ideserv.dynamic_programming;

import java.util.Scanner;

/**
 * Created by ssundar2 on 5/12/2017.
 */
public class FibonasicRecurrsion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        System.out.println(countFibonaic(count));
    }
    public static int countFibonaic(int count) {
        if(count == 0) return 0;
        if(count == 1) return 1;
        return countFibonaic(count-1) + countFibonaic(count-2);
    }
}
