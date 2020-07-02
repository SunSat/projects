package com.sunsat.sathish.java.geeksforgeeks.palindrom;

public class NumberPalindrom {
    public static void main(String[] args) {
        int n = 1000;
        if( n < 10) {
            System.out.println("Yes. " + n + " is Palindrom");
        } else {
            int dupn=  n;
            if(isNumPal(n, dupn)) {
                System.out.println("Yes. " + n + " is Palindrom");
            } else {
                System.out.println(n + " is Not a Palindrom");
            }
        }
    }
    public static boolean isNumPal(int n, int dupn) {
        if(n < 10) {
            return true;
        } else {
            if(n % 10 == dupn % 10) {
                isNumPal(n / 10, dupn /10);
            } else {
                throw new RuntimeException();
            }
        }
        return true;
    }
}
