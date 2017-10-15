package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.version2;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class ConsumerTh extends Thread {

    Object lockObj = null;
    public ConsumerTh(Object obj) {
        this.lockObj = obj;
    }
    public void run() {
        for(int i = 1;i<100;i+=2) {
            synchronized (lockObj) {
                try {
                    lockObj.notifyAll();
                    System.out.println(i);
                    if(i==99)
                        break;
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
