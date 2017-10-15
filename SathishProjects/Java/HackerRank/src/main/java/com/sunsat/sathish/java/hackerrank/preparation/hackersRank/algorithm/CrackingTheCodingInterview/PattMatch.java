package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.CrackingTheCodingInterview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ssundar2 on 7/5/2017.
 */
public class PattMatch {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\$\\{(\\w)*(\\.)*(\\w)*(\\.*)\\}");
        Pattern p1 = Pattern.compile("\\w");
        String st = "hello hello ${how} lkjsdf ${good.one}";
        Matcher m = p.matcher(st);
        while(m.find()) {
            String st1 = m.group();
            //st1.replace()
        }

    }
}
