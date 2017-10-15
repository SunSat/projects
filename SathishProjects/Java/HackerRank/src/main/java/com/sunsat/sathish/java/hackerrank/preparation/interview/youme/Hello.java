package com.sunsat.sathish.java.hackerrank.preparation.interview.youme;

import com.sunsat.sathish.java.hackerrank.preparation.interview.FabernicNet.SemephoreUsage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 6/19/2017.
 */
public class Hello {
    int id;
    String name;

    Hello() {

    }
    Hello(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void goodOne(Object st) {
        System.out.println("0999999999" + st);
    }
    public void goodOne(Integer obj) {
        System.out.println("10101010101" + obj);
    }

    public static void main(String[] args) {
        Map<Hello,Integer> keyVal = new ConcurrentHashMap<>(10);
        Hello h1 = new Hello(1,"sat");
        h1.goodOne(null);
        Hello h2 = new Hello(1,"hom");
        keyVal.put(h1,1);
        keyVal.put(h1,10);
        keyVal.put(h2,2);

        for(Hello h : keyVal.keySet()) {
            System.out.println(h.getId()+ " : " + h.getName());
        }

        System.out.println("  :  "+ keyVal.get(new Hello(1,"sat")));
        System.out.println("  :  "+ keyVal.get(h2));

        /*ArrayList al = new ArrayList();
        al.add(1);
        al.add(1);
        al.add("dg");
        System.out.println(al.get(0).equals(al.get(2)));
        //Collections.sort(al);
        Integer i = new Integer(5);
        Integer j = new Integer(5);
        System.out.println("hlkjsdflkjds : "+( i == j));

        String s  = new String("5");
        String s1  = new String("5");
        System.out.println(s1 == s);*/
        Semaphore semapho = new Semaphore(0);
        Thread t = new Thread(){
            public void run() {
                try {
                    System.out.println("Hello I am started now.");
                    semapho.acquire();
                    System.out.println("Hello I am release now.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t1 = new Thread(){
            public void run() {
                try {
                    semapho.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am parent continue running.");

    }
}
