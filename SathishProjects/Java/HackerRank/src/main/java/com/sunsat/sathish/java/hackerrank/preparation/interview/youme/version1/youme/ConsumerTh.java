package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.version1.youme;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class ConsumerTh extends Thread {

    volatile boolean number;
    ProdConsHelper lockObj;
    public ConsumerTh(ProdConsHelper obj, boolean number) {
        this.lockObj = obj;
        this.number=number;
    }
    public void run() {
       /* for(int i = 1;i<100;i+=2) {
            synchronized (lockObj) {
                try {
                    while(!lockObj.isFlag()) {
                        lockObj.wait();
                    }

                    System.out.println(i);
                    //number.add(i);
                    lockObj.setFlag(false);
                    lockObj.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
