package com.sunsat.sathish.java.hackerrank.preparation.ideserv.Strings;

import java.util.Scanner;

public class Anagram1 {

    static boolean isAnagram(String a, String b) {
        int[] a1 = new int[26];
        int[] b1 = new int[26];
        a = a.trim().toLowerCase();
        b = b.trim().toLowerCase();

        if(a.length() != b.length()) return false;

        for(int i = 0;i<a.length();i++) {
            System.out.println(((int)a.charAt(i))-97);
            int t1 = ((int)(a.charAt(i)) - 97);
            a1[t1] = ++a1[t1];
        }
        for(int j=0;j<b.length();j++) {
            int t2 = ((int)(b.charAt(j)) - 97);
            b1[t2] = ++b1[t2];
        }
        for(int k = 0;k<26;k++) {
            if(a1[k] != b1[k]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
