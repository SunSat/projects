package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.javaioSocketBlockingQueue;

import java.net.DatagramPacket;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ssundar2 on 05-04-2017.
 */
class DataPacketProcessor extends Thread {

    LinkedBlockingQueue<DatagramPacket> queue = null;
    boolean isShutdown = false;

    int count = 0;

    DataPacketProcessor(LinkedBlockingQueue<DatagramPacket> queue) {
        this.queue = queue;
    }

    public void run() {

        while (!isShutdown) {
            try {
                DatagramPacket db = this.queue.take();
                byte[] packets = db.getData();
                for(byte b : packets) {
                    System.out.print((char)b);
                }
                System.out.println();
                count++;
            } catch (InterruptedException ies) {
                ies.printStackTrace();
            }
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