package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.version3;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class Client {
   static volatile ArrayList number=new ArrayList();

   //static volatile boolean number=false;
    public  static void main(String... args) {
        CountDownLatch latch = new CountDownLatch(2);
        Object obj = new Object();
        ProducerTh pro = new ProducerTh(obj,number,true,latch);
        ProducerTh con = new ProducerTh(obj,number,false,latch);

        /*for(int i=0;i<25;i++) {
            new Thread() {
                public void run() {
                    while(true) {
                        ;;
                    }
                }
            }.start();
        }*/

        pro.start();
        con.start();
        try {
            latch.await();
            synchronized (obj){
                obj.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*while (true){
            if(number.size()==100) {
                synchronized (obj) {
                    obj.notifyAll();
                }
                break;
            }
        }*/


        //.notifyAll();
       // pro.interrupt();
       // con.interrupt();
        //ConcurrentHashMap
    }
}
