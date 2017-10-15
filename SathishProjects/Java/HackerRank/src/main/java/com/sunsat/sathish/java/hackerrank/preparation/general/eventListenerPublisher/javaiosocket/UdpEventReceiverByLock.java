package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.javaiosocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
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
public class UdpEventReceiverByLock extends Thread {

    DatagramSocket socket = null;
    int full = 0;
    Queue<DatagramPacket> queue;
    Lock lock = null;

    UdpEventReceiverByLock(DatagramSocket socket, Queue<DatagramPacket> queue,Lock lock) {
        this.socket = socket;
        this.queue = queue;
        this.lock = lock;
    }

    public void run() {

        try {
            while (!socket.isClosed()) {
                try {
                    int size = 1024;
                    byte[] buffer = new byte[size];
                    DatagramPacket db = new DatagramPacket(buffer, size);
                    socket.receive(db);
                    //queue.offer(db);
                    full++;
                } catch (SocketException e) {
                    //e.printStackTrace();
                } catch (IOException e) {
                    //e.printStackTrace();
                } finally {

                }
            }
            //System.out.println("The received count is : " + full);

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
            Queue<DatagramPacket> queue = new ConcurrentLinkedQueue<DatagramPacket>();
            Lock lock = new ReentrantLock();

            DataPacketProcessorByLock processor = new DataPacketProcessorByLock(queue,lock);
            //processor.start();

            DatagramSocket receiver = new DatagramSocket(9999,InetAddress.getLocalHost());
            UdpEventReceiverByLock eveRe1 = new UdpEventReceiverByLock(receiver,queue,lock);
            eveRe1.setName("I am receiver");
            eveRe1.start();

            Scanner sc = new Scanner(System.in);
            while(true) {
                String st = sc.nextLine();
                if(null != st && st.equals("exit"))  {
                    receiver.close();
                    eveRe1.interrupt();
                    System.out.println("The total Count is : " + eveRe1.getCount());
                    processor.setShutdown(true);
                    processor.interrupt();
                    System.out.println("The total Count is : " + processor.getProcessedCount());
                    break;
                } else if (null != st && st.equals("show")){
                    System.out.println("The total Count is : " + eveRe1.getCount());
                    System.out.println("The total Count is : " + processor.getProcessedCount());
                } else if (null != st && st.equals("cl")){
                    System.out.println("The total Count is : " + eveRe1.getCount());
                    System.out.println("The total Count is : " + processor.getProcessedCount());
                    eveRe1.setCount(0);
                    processor.setCount(0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

    }
}
