package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.version1.youme;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class ProducerTh extends Thread {

        ProdConsHelper lockObj;
        int i1;
        boolean flag;

    public ProducerTh(ProdConsHelper obj, boolean number) {
        this.lockObj = obj;
        this.flag=number;
        this.i1=number==true?0:1;
    }

    public void run() {

        for(int i = i1;i<100;i+=2) {
            synchronized (lockObj) {
                try {
                    while (lockObj.isFlag()==flag)
                    lockObj.wait();
                    System.out.println(i);
                    lockObj.setFlag(flag);
                    lockObj.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

