package com.sunsat.sathish.java.hackerrank.preparation.interview.FabernicNet;

import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/18/2017.
 */
public class SemaphoreGaurded extends Thread {

    Semaphore semaphore = null;
    CountObject obj = null;

    public SemaphoreGaurded(String name, Semaphore semaphore,CountObject obj) {
        super(name);
        this.semaphore = semaphore;
        this.obj = obj;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                semaphore.acquire();
                obj.incrementCount();
                System.out.println(Thread.currentThread().getName() + "   " + obj.getCount());
                Thread.sleep(10);
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1,true);
        CountObject obj = new CountObject();
        new SemaphoreGaurded("1", semaphore,obj).start();
        new SemaphoreGaurded("2", semaphore,obj).start();
        new SemaphoreGaurded("3", semaphore,obj).start();
        new SemaphoreGaurded("4", semaphore,obj).start();
        new SemaphoreGaurded("5", semaphore,obj).start();
    }
}

