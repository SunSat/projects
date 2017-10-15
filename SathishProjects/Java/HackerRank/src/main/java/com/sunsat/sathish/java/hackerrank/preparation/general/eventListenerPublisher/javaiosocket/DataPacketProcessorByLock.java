package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.javaiosocket;

import java.net.DatagramPacket;
import java.util.Queue;
import java.util.concurrent.locks.Lock;

/**
 * Created by ssundar2 on 05-04-2017.
 */
class DataPacketProcessorByLock extends Thread {

    Queue<DatagramPacket> queue = null;
    boolean isShutdown = false;
    Lock lock = null;

    int count = 0;

    DataPacketProcessorByLock(Queue<DatagramPacket> queue, Lock lock) {
        this.queue = queue;
        this.lock = lock;
    }

    public void run() {

        while (!isShutdown) {
            DatagramPacket db = this.queue.peek();
            byte[] packets = db.getData();
            count++;
        }
    }

    public void setShutdown(boolean shut) {
        this.isShutdown = shut;
    }

    public int getProcessedCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}