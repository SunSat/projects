package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.iosocketNewArchitecture;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

/**
 * Created by ssundar2 on 05-04-2017.
 */

/**
 * This way is receiveing the datagram packets is not even scaled.
 */
public class UdpEventReceiverByNewArchi extends Thread {

    DatagramChannel socket = null;
    int full = 0;
    int maxCount = 10000;
    ByteBuffer[] buffs = new ByteBuffer[10000];
    LockObject obj = null;



    UdpEventReceiverByNewArchi(DatagramChannel socket,ByteBuffer[] buffs,int maxCount,LockObject obj) {
        this.socket = socket;
        this.maxCount = maxCount;
        this.buffs = buffs;
        this.obj = obj;
    }

    public void run() {

        try {
            int count = 0;
            while (socket.isOpen()) {
                socket.receive(buffs[count]);
                synchronized (obj) {
                    obj.setCount(++count);
                }
                if(maxCount == count) {
                    count = 0;
                }
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

            int maxCount = 10000;
            ByteBuffer[] buffs = new ByteBuffer[10000];
            for(int i = 0;i<10000;i++) {
                buffs[i] = ByteBuffer.allocate(1024);
            }

            DatagramChannel receiverCh = DatagramChannel.open();
            receiverCh.setOption(StandardSocketOptions.SO_RCVBUF,4*1024);
            receiverCh.setOption(StandardSocketOptions.SO_REUSEADDR,true);
            int port = 10000;
            receiverCh.bind(new InetSocketAddress(InetAddress.getLocalHost(),port));

            LockObject obj = new LockObject();

            UdpEventReceiverByNewArchi eveRe1 = new UdpEventReceiverByNewArchi(receiverCh,buffs,maxCount,obj);
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
