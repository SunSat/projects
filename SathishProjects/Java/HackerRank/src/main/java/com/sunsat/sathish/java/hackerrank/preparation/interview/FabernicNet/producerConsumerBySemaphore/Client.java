package com.sunsat.sathish.java.hackerrank.preparation.interview.FabernicNet.producerConsumerBySemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class Client {


    public static void main(String[] args) {
        Semaphore consumerSema = new Semaphore(0);
        Semaphore producerSema = new Semaphore(1);
        List<String> li = new ArrayList<>(1);
        ConsumerTh cth = new ConsumerTh("Consuer",consumerSema,producerSema,li);
        ProducerTh pth = new ProducerTh("Producer",consumerSema,producerSema,li);
        cth.start();
        pth.start();

    }

}
