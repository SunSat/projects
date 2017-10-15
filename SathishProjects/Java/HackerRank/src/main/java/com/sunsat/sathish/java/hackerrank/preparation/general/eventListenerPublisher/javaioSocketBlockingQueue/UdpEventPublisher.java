package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.javaioSocketBlockingQueue;

import java.net.*;

/**
 * Created by ssundar2 on 24-03-2017.
 */
public class UdpEventPublisher extends  Thread {

    DatagramSocket socket = null;
    public UdpEventPublisher(DatagramSocket socket) {
        this.socket = socket;
    }
    public static void main(String ... args) {

        try {
            DatagramSocket s1 = new DatagramSocket();
            UdpEventPublisher pub1 = new UdpEventPublisher(s1);
            pub1.setName("Publisher1 :");
            pub1.start();

            /*DatagramSocket s2 = new DatagramSocket();
            UdpEventPublisherByLock pub2 = new UdpEventPublisherByLock(s2);
            pub2.setName("Publisher2 :");
            pub2.start();

            DatagramSocket s3 = new DatagramSocket();
            UdpEventPublisherByLock pub3 = new UdpEventPublisherByLock(s3);
            pub3.setName("Publisher3 :");
            pub3.start();*/

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }

   }

   public void run() {

       try {

           InetAddress add = InetAddress.getLocalHost();
           long cuTime = System.currentTimeMillis();
           for(int i=0;i<10;i++) {
               byte[] buffer = ("Hello World My First" + i).getBytes();
               DatagramPacket db = new DatagramPacket(buffer,buffer.length,add,9999);
               socket.send(db);
           }
           long cuTime1 = System.currentTimeMillis();
           System.out.println("The complete time is : " + (cuTime1 - cuTime));
       } catch (Exception ioe) {
           ioe.printStackTrace();
           if(socket != null) {
               socket.close();
           }
       }
       System.out.println("I am done");
   }
}

