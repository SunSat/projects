package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.version3;

import java.util.ArrayList;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class ConsumerTh extends Thread {

    Object lockObj = null;
    ArrayList list;
    public ConsumerTh(Object obj, ArrayList list) {
        this.lockObj = obj;
        this.list=list;
    }
    public void run() {
        for(int i = 1;i<100;i+=2) {
            synchronized (lockObj) {
                try {
                    lockObj.notifyAll();
                    System.out.println(i);
                    list.add(i);
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
