package com.sunsat.sathish.java.hackerrank.preparation.general.javanio.socket.clientSocket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by ssundar2 on 05-04-2017.
 */
public class StandAloneEventPublisher extends Thread {

    DatagramSocket socket = null;
    public StandAloneEventPublisher(DatagramSocket socket) {

        this.socket = socket;
    }

    public static void main(String... args) {

        try {
            DatagramSocket s1 = new DatagramSocket();
            new StandAloneEventPublisher(s1).start();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        try {

            //InetAddress add = InetAddress.getByName("10.197.112.187");
            InetAddress add = InetAddress.getLocalHost();
            System.out.println("Started to sending the events");
            long cuTime = System.currentTimeMillis();
            for(int i=0;i<40000;i++) {
                byte[] buffer = ("Hello World My First" + i).getBytes();
                DatagramPacket db = new DatagramPacket(buffer,buffer.length,add,9999);
                socket.send(db);
            }
            long cuTime1 = System.currentTimeMillis();
            System.out.println("The complete time is : " + ((cuTime1 - cuTime)/1000) + " sec");
        } catch (Exception ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if(socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("I am done");
    }
}
