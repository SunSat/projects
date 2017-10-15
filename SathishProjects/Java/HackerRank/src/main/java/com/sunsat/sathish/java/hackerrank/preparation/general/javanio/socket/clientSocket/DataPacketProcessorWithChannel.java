package com.sunsat.sathish.java.hackerrank.preparation.general.javanio.socket.clientSocket;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by ssundar2 on 05-04-2017.
 */
class DataPacketProcessorWithChannel extends Thread {

    LinkedBlockingQueue<ByteBuffer> queue = null;
    boolean isShutdown = false;

    int count = 0;

    DataPacketProcessorWithChannel(LinkedBlockingQueue<ByteBuffer> queue) {
        this.queue = queue;
    }

    public void run() {

        while (!isShutdown) {
            try {
                ByteBuffer db = this.queue.take();
                db.flip();
                System.out.print("Client Says : ");
                while(db.hasRemaining()) {
                    System.out.print((byte)db.get());
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
}