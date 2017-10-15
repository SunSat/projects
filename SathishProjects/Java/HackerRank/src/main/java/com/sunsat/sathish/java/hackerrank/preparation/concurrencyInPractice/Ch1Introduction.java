package com.sunsat.sathish.java.hackerrank.preparation.concurrencyInPractice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ssundar2 on 22-03-2017.
 */
public class Ch1Introduction extends  Thread {

    Ch1Introduction(String name) {
        super(name);
    }

    public static void main(String ... args) {

        Ch1Introduction t1 = new Ch1Introduction("Anitha");
        t1.start();
       // Ch1Introduction t2 = new Ch1Introduction("Sathish");
        //t2.start();

    }

    private final AtomicInteger atInt = new AtomicInteger(9);

    public void run(){

        System.out.println(atInt.getAndIncrement());
        System.out.println(atInt.getAndIncrement());
        System.out.println(atInt.getAndAdd(20));
        System.out.println(atInt.get());
       // System.out.println(atInt.weakCompareAndSet());
        for(int i=0;i<100;i++) {
            //System.out.println(this.getName() + " : " + i);
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
