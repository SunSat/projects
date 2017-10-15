package com.sunsat.sathish.java.hackerrank.preparation.general;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by ssundar2 on 10-03-2017.
 */
public class CollectionAnalysis {

    public  static void main(String... args ) {
        TreeMap map = new TreeMap();
        //map.put("Hello","World");
        map.put("0","0");
        map.put("1","1");
        map.put("2","2");
        map.put("-5","-5");
        map.put("3","3");
        map.put("7","7");
        map.put("4","4");
        map.put("8","8");
        map.put("9","9");
        map.put("6","6");
        map.put("10","10");
        map.put("13","13");
        map.put("5","5");
        map.put("14","14");
        map.put("15","15");
        map.put("16","16");
        map.get("Hello");
        Set s = map.keySet();
        map.containsKey("");
        map.containsValue("Kumar");
       // map.clear();
       // map.clone();
        //map.compute("Hello")
        System.out.println(map);
        try(FileReader fr = new FileReader("")) {
            fr.read();
        }catch(Exception e) {

        }
    }
}
