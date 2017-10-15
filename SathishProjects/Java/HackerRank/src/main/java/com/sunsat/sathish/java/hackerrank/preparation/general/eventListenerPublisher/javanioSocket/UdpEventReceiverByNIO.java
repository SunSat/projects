package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.javanioSocket;

import java.io.IOException;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ssundar2 on 05-04-2017.
 */

/**
 * This way is receiveing the datagram packets is not even scaled.
 */
public class UdpEventReceiverByNIO extends Thread {

    DatagramChannel socket = null;
    int full = 0;
    ByteBuffer[] buffs = new ByteBuffer[10000];


    UdpEventReceiverByNIO(DatagramChannel socket) {
        this.socket = socket;
        for(int i = 0;i<10000;i++) {
            buffs[i] = ByteBuffer.allocate(1024);
        }
    }

    public void run() {

        try {
            while (socket.isOpen()) {
                socket.receive(buffs[full++]);
            }

        } catch (Exception soe) {
            soe.printStackTrace();
        }
    }

    public int getCount() {
        return full;
    }
    public void setCount(int count) {
        this.full = count;
    }

    public static void main(String ... args) {

        try {

            DatagramChannel receiverCh = DatagramChannel.open();
            receiverCh.setOption(StandardSocketOptions.SO_RCVBUF,4*1024);
            receiverCh.setOption(StandardSocketOptions.SO_REUSEADDR,true);
            int port = 10000;
            receiverCh.bind(new InetSocketAddress(InetAddress.getLocalHost(),port));

            UdpEventReceiverByNIO eveRe1 = new UdpEventReceiverByNIO(receiverCh);
            eveRe1.setName("I am receiver");
            eveRe1.start();

            Scanner sc = new Scanner(System.in);
            while(true) {
                String st = sc.nextLine();
                if(null != st && st.equals("exit"))  {
                    eveRe1.interrupt();
                    System.out.println("The total Count is : " + eveRe1.getCount());
                    break;
                } else if (null != st && st.equals("show")){
                    System.out.println("The total Count is : " + eveRe1.getCount());
                } else if (null != st && st.equals("cl")){
                    System.out.println("The total Count is : " + eveRe1.getCount());
                    eveRe1.setCount(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }
}
