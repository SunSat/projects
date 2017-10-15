package com.sunsat.sathish.java.hackerrank.preparation.general;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainClass {
	 public static void main(String[] args){
	        PrintNumbers p = new PrintNumbers();
	        ThreadA a= new ThreadA(p);
	        ThreadB b= new ThreadB(p);
	        /*Thread t = new Thread(a);
	        t.start();
	        Thread t2= new Thread(b);
	        t2.start();*/

	        ExecutorService e = Executors.newFixedThreadPool(2);
	        e.execute(a);
	        e.execute(b);
	        //e.shutdown();
	    }
}
