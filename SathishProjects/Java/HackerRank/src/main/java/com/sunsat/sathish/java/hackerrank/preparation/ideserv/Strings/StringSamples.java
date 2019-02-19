package com.sunsat.sathish.java.hackerrank.preparation.ideserv.Strings;

import java.util.HashSet;
import java.util.Scanner;

public class StringSamples {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        sc.close();
        System.out.println(A.length() + B.length());
        int res = A.compareTo(B);
        if(res >= 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        System.out.println(A.replaceFirst(A.charAt(0)+"",Character.toUpperCase(A.charAt(0))+"") + " "+B.replaceFirst(B.charAt(0)+"",Character.toUpperCase(B.charAt(0))+""));
    }
}
