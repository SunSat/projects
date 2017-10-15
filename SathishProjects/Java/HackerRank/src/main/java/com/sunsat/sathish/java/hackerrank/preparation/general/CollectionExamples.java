package com.sunsat.sathish.java.hackerrank.preparation.general;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ssundar2 on 24-03-2017.
 */
public class CollectionExamples {
    public static void main(String ... args) {
        List li = new LinkedList();
        li.add("sat");
        li.add("sat1");
        li.get(0);
        li.add("sat3");
        li.contains("sat3");
        li.toArray();
        //Arrays
        ConcurrentHashMap map = new ConcurrentHashMap(100);
        map.put("sat","sat");
        map.get("sat");
        map.clear();

        HashMap hmap =  new HashMap();
        hmap.put("a","b");
    }
}
