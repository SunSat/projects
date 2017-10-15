package com.sunsat.sathish.java.hackerrank.preparation.general;

public class ThreadB implements Runnable {
    PrintNumbers p;
    ThreadB(PrintNumbers p){
        this.p=p;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
        	synchronized (p) {
        		while (!p.isPrintOdd()) {

                    try {
                       p.wait();
                    } catch (InterruptedException e) {

                    }

            }

                System.out.println(p.number);
                p.setPrintOdd(false);
                p.notifyAll();
			}

            

        }
    }
}
