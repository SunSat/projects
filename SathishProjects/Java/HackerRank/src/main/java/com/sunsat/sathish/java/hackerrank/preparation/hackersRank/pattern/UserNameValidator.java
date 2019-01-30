package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserNameValidator {
    public static void main(String[] args) {
        String pattern = "(^[a-zA-Z])*";
        String str = "1Sat";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pattern);
        System.out.println(m.find());
        System.out.println("Group is : " + m.group());
    }
}
