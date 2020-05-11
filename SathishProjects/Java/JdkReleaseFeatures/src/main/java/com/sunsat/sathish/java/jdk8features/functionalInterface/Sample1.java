package com.sunsat.sathish.java.jdk8features.functionalInterface;

public class Sample1 {

    public String getAllFuncation(FunctionalInterface f, int i) {
        System.out.println("inside"+i);
        return f.theOne(i);
    }

    public static void main(String[] args) {
        Sample1 sample1 = new Sample1();
        sample1.getAllFuncation((i) -> ""+ i,1);
    }
}
