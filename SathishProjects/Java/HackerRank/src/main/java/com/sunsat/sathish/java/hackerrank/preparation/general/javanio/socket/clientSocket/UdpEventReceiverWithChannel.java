package com.sunsat.sathish.java.hackerrank.preparation.general.javanio.socket.clientSocket;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

/**
 * Created by ssundar2 on 05-04-2017.
 */
public class UdpEventReceiverWithChannel extends Thread {

    DatagramChannel socket = null;
    int full = 0;
    LinkedBlockingQueue<ByteBuffer> queue;

    UdpEventReceiverWithChannel(DatagramChannel socket, LinkedBlockingQueue<ByteBuffer> queue) {
        this.socket = socket;
        this.queue = queue;
    }

    public void run() {

        try {
            ByteBuffer buffer = null;
            while (socket.isOpen()) {
                try {
                    buffer = ByteBuffer.allocateDirect(1024);
                    socket.read(buffer);
                    queue.offer(buffer);
                    full++;
                } catch (SocketException e) {
                    //e.printStackTrace();
                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
            System.out.println("The received count is : " + full);

        } catch (Exception soe) {
            soe.printStackTrace();
        }
    }

    public int getCount() {
        return full;
    }

    public static void main(String ... args) {

        try {
            LinkedBlockingQueue<ByteBuffer> queue = new LinkedBlockingQueue<ByteBuffer>();

            DataPacketProcessorWithChannel processor = new DataPacketProcessorWithChannel(queue);
            processor.start();

            //DatagramSocket receiver = new DatagramSocket(9999,InetAddress.getLocalHost());
            SocketAddress socketAdd = new InetSocketAddress(InetAddress.getLocalHost(),9999);
            DatagramChannel channel = DatagramChannel.open();
            channel.setOption(StandardSocketOptions.SO_RCVBUF, 4 * 1024);
            DatagramSocket socket = channel.socket();
            socket.connect(socketAdd);
            //channel.configureBlocking(false);


            UdpEventReceiverWithChannel eveRe1 = new UdpEventReceiverWithChannel(channel,queue);
            eveRe1.setName("I am receiver");
            eveRe1.start();

            Scanner sc = new Scanner(System.in);
            if(sc.nextLine().equals("exit"))  {
                channel.close();
                eveRe1.interrupt();
                System.out.println("The total Count is : " + eveRe1.getCount());
                processor.setShutdown(true);
                processor.interrupt();
                System.out.println("The total Count is : " + processor.getProcessedCount());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }
}
