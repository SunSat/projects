package com.sunsat.sathish.java.hackerrank.preparation.general.threads;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class ConcurrentHashMapImpl {

    public static void main(String... args) {
        ConcurrentHashMap<String,String> con = new ConcurrentHashMap<>();
        new Thread() {
            public void run() {
                for(int i =0;i<1000000;i++) {
                    con.put(i+"",i+"");
                }
            }
        }.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<25;i++) {
            new Thread(){
                public void run() {
                    for(;;);
                }
            }.start();
        }
        new Thread() {
            public void run() {
                //Iterator

            }
        }.start();
    }
}
