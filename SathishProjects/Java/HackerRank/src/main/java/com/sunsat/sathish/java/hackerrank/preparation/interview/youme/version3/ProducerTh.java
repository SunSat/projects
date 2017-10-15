package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.version3;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class ProducerTh extends Thread {

    public Object lockObj = null;
    int  i1=0;
    volatile ArrayList list;
    CountDownLatch latch = null;
    public ProducerTh(Object obj,ArrayList list) {
        this.lockObj = obj;
        this.list=list;
    }
    public ProducerTh(Object obj,ArrayList list,boolean flag,CountDownLatch latch) {
        this.lockObj = obj;
        this.list=list;
        i1=flag?0:1;
        this.latch  = latch;
    }

    public void run() {
        for(int i = i1;i<100;i+=2) {
            synchronized (lockObj) {
                try {
                    lockObj.notifyAll();
                    System.out.println(i);
                    list.add(i);
                    if(98 <= i) {
                        latch.countDown();
                    }
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

