package com.sunsat.sathish.java.hackerrank.preparation.photontest;

import java.util.Arrays;
import java.util.Comparator;

public class Sample1 {

    public int multiple(int val) {
        final int mulTi;
        mulTi = 2;
        new Thread(new Runnable() {
            @Override
            public void run() {
                int result = val * mulTi;
            }
        });
        return val;
    }

    public static void main(String[] args) {
        String[] cities = {"Bangalore","Pune","San Francisco","New York City"};
        Arrays.sort(cities, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //System.out.println(o2.compareTo(o1));
                return o2.compareTo(o1);
            }
        });
        for(String st : cities) {
            System.out.println(st);
        }
        System.out.println(Arrays.binarySearch(cities,"New York City"));
    }
}

