package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.Strings;

import java.util.Scanner;

/**
 * Created by ssundar2 on 5/21/2017.
 */

/*
String always consists of two distinct alternating characters. For example, if string 's two distinct characters are x and y, then t could be xyxyx or yxyxy but not xxyy or xyyx.
You can convert some string to string by deleting characters from . When you delete a character from , you must delete all occurrences of it in . For example, if abaacdabd and you delete the character a, then the string becomes bcdbd.
Given , convert it to the longest possible string . Then print the length of string on a new line; if no string can be formed from , print instead.

Input Format

The first line contains a single integer denoting the length of .
The second line contains string .
Constraints
    only contains lowercase English alphabetic letters (i.e., a to z).
Output Format
Print a single integer denoting the maximum length of for the given ; if it is not possible to form string , print instead.
Sample Input
10
beabeefeab

Sample Output
5
Explanation
The characters present in are a, b, e, and f. This means that must consist of two of those characters.
If we delete e and f, the resulting string is babab. This is a valid as there are only two distinct characters (a and b), and they are alternating within the string.
If we delete a and f, the resulting string is bebeeeb. This is not a valid string because there are three consecutive e's present.
If we delete only e, the resulting string is babfab. This is not a valid string because it contains three distinct characters.
Thus, we print the length of babab, which is , as our answer.
 */
public class TwoCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        String temp = s;

        temp = removeDuplicate(temp);


        int newCh[] = new int[26];
        /*for(int i=0;i<newCh.length;i++) {
            //newCh[i] = 0;
        }*/


        char[] tempAr = temp.toCharArray();
        for(int k=0;k<tempAr.length;k++) {
            newCh[tempAr[k] - 'a']++;
        }

        int[] finalIndex = new int[26];
        int one = 0;
        for(int z = 0;z < newCh.length-1;z++) {
            if(newCh[z] != 0) {
                int temp1 = newCh[z+1];
                if(temp1 == newCh[z]+1 || temp1 == newCh[z]-1 ) {
                   finalIndex[one++] = z;
                }
            }
        }
        for(int i=0;i<finalIndex.length-1;i++) {
            if(finalIndex[i] != 0) {
                char c = (char) (64+finalIndex[i]);
                char d = (char) (64+finalIndex[i] + 1);
            }

        }
        if(temp != null && temp.length() > 0) {
            System.out.println(temp.length());
        } else {
            System.out.println(0);
        }
    }
    public static String removeDuplicate(String temp) {
        while(temp != null && temp.length() > 0) {
            char[] chArr = temp.toCharArray();
            char lastChar = chArr[0];
            boolean isGood = true;
            for(int i = 1;i<chArr.length;i++) {
                if(lastChar == chArr[i]) {
                    isGood = false;
                    temp = remove(temp,lastChar);
                    break;
                } else {
                    lastChar = chArr[i];
                }
            }
            if(isGood) {
                break;
            }
        }
        return temp;
    }
    public static String remove(String s,char c) {
        char[] chArr = s.toCharArray();
        StringBuilder sb = new StringBuilder(chArr.length);
        for(int i = 0;i<chArr.length;i++) {
            if(chArr[i] != c) {
                sb.append(chArr[i]);
            }
        }
        return sb.toString();
    }
}
