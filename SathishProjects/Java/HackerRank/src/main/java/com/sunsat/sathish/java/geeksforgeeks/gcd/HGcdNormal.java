package com.sunsat.sathish.java.geeksforgeeks.gcd;

public class HGcdNormal {
    public static void main(String[] args) {
        int a = 100, b = 30;
        int min = Math.min(a,b);
        if(a % min == 0 && b % min == 0) {
            System.out.println(b);
            return;
        }
        for(int i=min/2;i > 0;i--) {
            if(a % i == 0 && b % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
