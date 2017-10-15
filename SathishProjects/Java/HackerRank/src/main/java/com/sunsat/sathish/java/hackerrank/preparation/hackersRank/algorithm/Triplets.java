package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm;

import java.util.Scanner;

/**
 * Created by ssundar2 on 28-01-2017.
 */
public class Triplets {
    public  static void main(String ... args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int a = Integer.compare(a0,b0);
        int b = Integer.compare(a1,b1);
        int c = Integer.compare(a2,b2);
        int ali = 0, bob = 0;
        if(a > 0) {
            ali++;
        } else if(a < 0) {
            bob++;
        }
        if(b > 0) {
            ali++;
        } else if(b < 0) {
            bob++;
        }
        if(c > 0) {
            ali++;
        } else if (c<0){
            bob++;
        }
        System.out.println(ali + " " + bob);
    }
}
