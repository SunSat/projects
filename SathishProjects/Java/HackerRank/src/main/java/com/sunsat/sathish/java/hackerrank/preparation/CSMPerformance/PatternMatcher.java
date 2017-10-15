package com.sunsat.sathish.java.hackerrank.preparation.CSMPerformance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ssundar2 on 22-03-2017.
 */
public class PatternMatcher {

    public static void main(String ... args) {
        Pattern p = Pattern.compile("Hello");
        Matcher m = p.matcher("Hello");
        while(m.find()) {
            m.group();
        }
    }
}
