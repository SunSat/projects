package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * Created by ssundar2 on 29-01-2017.
 */
public class MakingAnagrams {
    public static int numberNeeded(String first, String second) {
        int[] firstIn = convertInt(first);
        int[] secondIn = convertInt(second);
        int total = 0;
        for(int i=0;i<27;i++) {
            if(firstIn[i] > secondIn[i]) {
                total = total + firstIn[i]-secondIn[i];
            } else if(firstIn[i] < secondIn[i]) {
                total = total + secondIn[i]-firstIn[i];
            }
        }
        return total;
    }
    public static int[] convertInt(String str) {
        int[] intArr = new int[27];
        char[] charArr = str.toCharArray();
        for(int i = 0;i<charArr.length;i++) {
            int charInt = ((int)charArr[i])-97;
            intArr[charInt] = ++intArr[charInt];
        }
        return intArr;
    }

    public static void printIntArr(int[] printingArr) {
        System.out.println();
        for(int i:printingArr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        while(true) {
            Scanner in = new Scanner(System.in);
            String a = in.next();
            String b = in.next();
            //in.close();
            System.out.println(numberNeeded(a, b));
        }
    }
}
