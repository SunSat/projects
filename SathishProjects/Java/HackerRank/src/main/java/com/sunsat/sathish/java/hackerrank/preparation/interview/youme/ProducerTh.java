package com.sunsat.sathish.java.hackerrank.preparation.interview.youme;

import java.util.ArrayList;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class ProducerTh extends Thread {

    //public Object lockObj = null;
    //volatile boolean number;
    ProdConsHelper lockObj;

    public ProducerTh(ProdConsHelper obj, boolean number) {
        this.lockObj = obj;
        //this.number=number;
    }

    public void run() {
        for(int i = 0;i<100;i+=2) {
            synchronized (lockObj) {
                try {
                    while (lockObj.isFlag())
                    lockObj.wait();
                    System.out.println(i);
                   // number.add(i);
                    lockObj.setFlag(true);
                    lockObj.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

