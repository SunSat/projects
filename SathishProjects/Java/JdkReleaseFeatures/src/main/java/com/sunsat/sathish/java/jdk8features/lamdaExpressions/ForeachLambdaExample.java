package com.sunsat.sathish.java.jdk8features.lamdaExpressions;

import java.util.ArrayList;
import java.util.List;

public class ForeachLambdaExample {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("Rick");
        list.add("Negan");
        list.add("Daryl");
        list.add("Glenn");
        list.add("Carl");
        list.forEach((st)-> System.out.println(st));
    }
    enum sampleEn {
        SIMPLE,GOOD,BAD


    }
}
