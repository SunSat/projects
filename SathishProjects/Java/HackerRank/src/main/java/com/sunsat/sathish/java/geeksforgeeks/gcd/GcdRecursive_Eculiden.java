package com.sunsat.sathish.java.geeksforgeeks.gcd;

public class GcdRecursive_Eculiden {
    public static void main(String[] args) {
        int a = 1500, b = 10;
        System.out.println(findGcd(a, b));
    }

    public static int findGcd(int a, int b) {
        if(a == 0) return b;
        return findGcd(b%a, a);
    }
}
