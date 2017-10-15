package com.sunsat.sathish.java.hackerrank.preparation.interview.youme;

import java.util.ArrayList;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class Client {
   //static ArrayList number=new ArrayList();
   static volatile boolean number=false;
    public  static void main(String... args) {
        //Object obj = new Object();
       // boolean number=false;
        ProdConsHelper obj= new ProdConsHelper();
        ProducerTh pro = new ProducerTh(obj,number);
        ConsumerTh con = new ConsumerTh(obj,number);

        for(int i=0;i<25;i++) {
            new Thread() {
                public void run() {
                    while(true) {
                        ;;
                    }
                }
            }.start();
        }

        pro.start();
        con.start();
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
    }
}
