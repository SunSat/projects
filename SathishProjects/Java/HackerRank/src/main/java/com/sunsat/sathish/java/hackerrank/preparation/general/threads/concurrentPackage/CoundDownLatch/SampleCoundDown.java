package com.sunsat.sathish.java.hackerrank.preparation.general.threads.concurrentPackage.CoundDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by ssundar2 on 6/20/2017.
 */
public class SampleCoundDown {

    public static void main(String[] args) {
        CountDownLatch cut = new CountDownLatch(2);
        Thread t = new Thread() {
            public void run() {
                try {
                    System.out.println("I am from Th before");
                    cut.await();
                    System.out.println("I am from Th after");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();


        Thread t1 = new Thread() {
            public void run() {
                System.out.println("I am from Th1 before");
                try {
                    cut.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("I am from Th1 after");
            }
        };
        t1.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am from c1 done");
        cut.countDown();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("I am from c2 done");
        cut.countDown();

    }
}
