package com.sunsat.sathish.java.hackerrank.preparation.interview.FabernicNet;

import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/18/2017.
 */
public class SemephoreUsage extends Thread {
    Semaphore semaphore = null;

    public SemephoreUsage(String name, Semaphore semaphore) {
        super(name);
        this.semaphore = semaphore;
    }
    public void run() {
        try {
            for(int i = 0;i<20;i++) {
                semaphore.acquire();
                System.out.println(this.currentThread().getName() + " " + i);
                this.sleep(1000);
                semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Semaphore countSem = new Semaphore(2);
        new SemephoreUsage("1",countSem).start();
        new SemephoreUsage("2",countSem).start();
        new SemephoreUsage("3",countSem).start();
        new SemephoreUsage("4",countSem).start();
    }
}
