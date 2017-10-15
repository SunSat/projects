package com.sunsat.sathish.java.hackerrank.preparation.interview.youme.Version4;

import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class EvenTh extends  Thread {

    Semaphore oddSemaphore = null;
    Semaphore evenSemaphore = null;
    EvenTh(Semaphore oddSemaphore, Semaphore evenSemaphore) {
        this.oddSemaphore = oddSemaphore;
        this.evenSemaphore = evenSemaphore;
    }

    public void run() {

        for(int i = 0;i < 20; i+=2) {
            try {
                evenSemaphore.acquire();
            }catch (InterruptedException ioe) {
                ioe.printStackTrace();
            }
            System.out.println(i);
            oddSemaphore.release();
        }
    }

}
