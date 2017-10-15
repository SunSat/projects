package com.sunsat.sathish.java.hackerrank.preparation.interview.FabernicNet.producerConsumerBySemaphore;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class ProducerTh extends Thread {
    Semaphore consumerSema = null;
    Semaphore producerSema = null;
    List li = null;

    public ProducerTh(String name,Semaphore consumerSema,Semaphore producerSema,List<String> li) {
        super(name);
        this.consumerSema = consumerSema;
        this.producerSema = producerSema;
        this.li = li;
    }

    public void run() {
        int i = 0;
        while (true) {
            try {
                producerSema.acquire();
            }catch (InterruptedException ioe) {

            }
            System.out.println("Produced" + ++i);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            li.add(0,i);
            consumerSema.release();
        }
    }
}
