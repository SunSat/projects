package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.chalanges;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ssundar2 on 5/26/2017.
 */
public class BeautifulBinaryString {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = in.nextInt();
        //String B = in.next();
        String B = "010101010";
        System.out.println((B.length() - B.replaceAll("010", "").length())/3);
        Pattern p = Pattern.compile("010");
        Matcher m = p.matcher(B);
        int count = 0;
        while (m.find()) {
            count++;
        }
        System.out.println(count);
    }
}
