package com.sunsat.sathish.java.hackerrank.preparation.interview.FabernicNet.producerConsumerBySemaphoreV1;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class ConsumerTh extends Thread {
    Semaphore consumerSema = null;
    Semaphore producerSema = null;
    List li = null;

    public ConsumerTh(String name,Semaphore consumerSema,Semaphore producerSema,List<String> li) {
        super(name);
        this.consumerSema = consumerSema;
        this.producerSema = producerSema;
        this.li = li;
    }

    public void run() {
        while (true) {
            try {
                consumerSema.acquire();
            }catch (InterruptedException ioe) {
                ioe.printStackTrace();
            }
            System.out.println("Consumed : " + li.remove(0));
            producerSema.release();
        }
    }
}
