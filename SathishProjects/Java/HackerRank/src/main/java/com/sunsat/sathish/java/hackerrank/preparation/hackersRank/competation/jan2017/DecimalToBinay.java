package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.competation.jan2017;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ssundar2 on 22-02-2017.
 */
public class DecimalToBinay {
    public static void main(String args[]) {
        String st = Integer.toBinaryString(439);
        System.out.println(st);
        Pattern p = Pattern.compile("1+");
        Matcher m = p.matcher(st);
        System.out.println();
        int size = 0;
        while(m.find()) {
            int len = m.group().length();
            if(size < len) {
                size = len;
            }
        }
        System.out.println(size);
    }
}
