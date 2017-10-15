package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.designPatterns;

import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 6/2/2017.
 */
public class SingleTonDesignPattern {

    private SingleTonDesignPattern() {
        System.out.println("Hello I am sathihs");
    }

    public static SingleTonDesignPattern getInstance() {
        return EnsureOneInstance.ensureSingle;
    }

    private static class EnsureOneInstance {
        private static final SingleTonDesignPattern ensureSingle = new SingleTonDesignPattern();

    }

    public static void main(String[] args) {
        SingleTonDesignPattern.getInstance();
    }

}
