package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.Strings;


import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
public class TwoCharactersV1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //int len = in.nextInt();
        String s = "bababab";
        HashSet<String> hashStSet = new HashSet<>();
        //"uyetuppelecblwipdsqabzsvyfaezeqhpnalahnpkdbhzjglcuqfjnzpmbwprelbayyzovkhacgrglrdpmvaexkgertilnfooeazvulykxypsxicofnbyivkthovpjzhpohdhuebazlukfhaavfsssuupbyjqdxwwqlicbjirirspqhxomjdzswtsogugmbnslcalcfaxqmionsxdgpkotffycphsewyqvhqcwlufekxwoiudxjixchfqlavjwhaennkmfsdhigyeifnoskjbzgzggsmshdhzagpznkbahixqgrdnmlzogprctjggsujmqzqknvcuvdinesbwpirfasnvfjqceyrkknyvdritcfyowsgfrevzon";//in.next();
        s = removeDuplicate(s);
        int stLength = s.length();
        char[] ch = s.toCharArray();
        int max = 0;
        String maxPattern = "";
        for(int i=0;i<stLength-1;i++) {
            String subSt = ""+ch[i]+ch[i+1];
            if(hashStSet.contains(subSt)) continue;
            Pattern P = Pattern.compile(subSt);
            Matcher m = P.matcher(s);
            StringBuilder sb = new StringBuilder(stLength);
            while(m.find()) {
                sb.append(m.group());
            }
            if(max < sb.length()) {
                max = sb.length();
                maxPattern = subSt;
            }
            hashStSet.add(subSt);
        }
        System.out.println(maxPattern.equals(s));
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
