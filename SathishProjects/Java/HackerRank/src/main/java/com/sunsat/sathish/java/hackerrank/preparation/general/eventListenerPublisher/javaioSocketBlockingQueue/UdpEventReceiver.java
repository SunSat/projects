package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.javaioSocketBlockingQueue;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by ssundar2 on 05-04-2017.
 */
public class UdpEventReceiver extends Thread {

    DatagramSocket socket = null;
    int full = 0;
    LinkedBlockingQueue<DatagramPacket> queue;

    UdpEventReceiver(DatagramSocket socket, LinkedBlockingQueue<DatagramPacket> queue) {
        this.socket = socket;
        this.queue = queue;
    }

    public void run() {

        try {
            while (!socket.isClosed()) {
                try {
                    int size = 1024;
                    byte[] buffer = new byte[size];
                    DatagramPacket db = new DatagramPacket(buffer, size);
                    socket.receive(db);
                    queue.offer(db);
                    full++;
                } catch (SocketException e) {
                    //e.printStackTrace();
                } catch (IOException e) {
                    //e.printStackTrace();
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
            LinkedBlockingQueue<DatagramPacket> queue = new LinkedBlockingQueue<DatagramPacket>();

            DataPacketProcessor processor = new DataPacketProcessor(queue);
            processor.start();

            DatagramSocket receiver = new DatagramSocket(10000,InetAddress.getLocalHost());
            UdpEventReceiver eveRe1 = new UdpEventReceiver(receiver,queue);
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
