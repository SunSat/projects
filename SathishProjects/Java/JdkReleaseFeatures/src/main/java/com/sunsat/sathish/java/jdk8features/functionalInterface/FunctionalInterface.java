package com.sunsat.sathish.java.jdk8features.functionalInterface;

@java.lang.FunctionalInterface
public interface FunctionalInterface {
    public String theOne(int i);
    default void helloWorld() {
        System.out.println("Sample");
    }
}
