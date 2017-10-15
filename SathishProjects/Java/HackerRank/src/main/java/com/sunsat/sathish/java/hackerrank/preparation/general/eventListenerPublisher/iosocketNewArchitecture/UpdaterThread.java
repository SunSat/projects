package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.iosocketNewArchitecture;

import java.util.Locale;

/**
 * Created by ssundar2 on 07-04-2017.
 */
public class UpdaterThread extends Thread {

    LockObject lockObj = null;

    public UpdaterThread(LockObject lockOj) {
        this.lockObj = lockOj;
    }
    public void run() {

        int previousCount = 0;
        while(true) {
            int cuCount = 0;
            synchronized (lockObj) {
                cuCount = lockObj.getCount();
            }
            if(cuCount != previousCount) {
                previousCount = cuCount;

            }
            synchronized (lockObj) {
                try {
                    lockObj.wait(1000*2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
