package com.sunsat.sathish.java.hackerrank.preparation.concurrencyInPractice;

/**
 * Created by sathishkumar_su on 11/17/2017.
 */
public class ConcurrentThread extends Thread {

    public void run() {
        for(int i=0;i<10000000;i++) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        ConcurrentThread c = new ConcurrentThread();
        c.start();
        try {
            Thread.currentThread().sleep(1000);
            c.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
