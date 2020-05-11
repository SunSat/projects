package com.sunsat.sathish.java.jdk8features;

public interface Interface1 {

    public static String printLen(String st) {
        System.out.println(st);
        return st+" my dear";
    }

    default String logString(String st) {
        System.out.println(st);
        return st;
    }
}

class String1 implements Interface1 {

    public static void main(String[] st1) {
       String1 st = new String1();
       st.logString("hello");
    }
}
