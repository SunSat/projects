package com.sunsat.sathish.java.hackerrank.preparation.ideserv.Strings;

/**
 * Created by ssundar2 on 5/21/2017.
 */
/*
Given a string, find the longest substring with non-repeating characters.
Example:
Input : ABCDABDEFGCABD
Output: ABDEFGC
 */
public class LongestSubstringWithNonRepeatingCharacters {
    public static void main(String[] args) {
        String st = "ABCDA";
        char[] chArr = st.toCharArray();
        char[] alphabetsArr = new char[58];
        int count = 0;
        int maxCount = 0;
        int startIndex = 0;
        for(int i=0;i<chArr.length;i++) {
            int c = chArr[i] - 'A';
             if(alphabetsArr[c] == 0) {
                 alphabetsArr[c]++;
                 count++;
             }else {
                 if(maxCount < count) {
                     startIndex = i - count;
                     maxCount = count;
                 }
                 alphabetsArr = new char[58];
                 count = 0;
             }
        }
        if(maxCount == 0) {
            System.out.println(st);
        } else {
            System.out.println(st.substring(startIndex,startIndex+maxCount));
        }
    }
}
