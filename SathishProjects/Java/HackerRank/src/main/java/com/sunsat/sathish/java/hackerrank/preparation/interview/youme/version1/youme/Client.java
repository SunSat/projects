package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.version1.youme;

/**
 * Created by ssundar2 on 04-04-2017.
 */
public class Client {
   static volatile boolean number=false;
    public  static void main(String... args) {
        ProdConsHelper obj= new ProdConsHelper();
        ProducerTh pro = new ProducerTh(obj,true);
        ProducerTh con = new ProducerTh(obj,false);
        pro.start();
        con.start();
    }
}
