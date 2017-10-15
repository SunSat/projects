package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.Version4;

import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class OddThread extends  Thread {
    Semaphore oddSemaphore = null;
    Semaphore evenSemaphore = null;
    OddThread(Semaphore oddSemaphore, Semaphore evenSemaphore) {
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
    }

    public static void main(String[] args) {

        Semaphore oddSemaphore = new Semaphore(0);
        Semaphore evenSemaphore = new Semaphore(1);
        new OddThread(oddSemaphore,evenSemaphore).start();
        new EvenTh(oddSemaphore,evenSemaphore).start();
    }
    public void run() {

        for(int i = 1;i < 20; i+=2) {
            try {
                oddSemaphore.acquire();
            }catch (InterruptedException ioe) {
                ioe.printStackTrace();
            }
            System.out.println(i);
            evenSemaphore.release();
        }

    }
}
