package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.iosocketNewArchitecture;

import java.nio.ByteBuffer;

/**
 * Created by ssundar2 on 07-04-2017.
 */
public class UdpEventProcessorByNewArchi extends Thread {
    LockObject lockObj = null;
    int maxCount = 0;
    ByteBuffer[] buffers = null;
    public UdpEventProcessorByNewArchi(LockObject obj, int maxCount, ByteBuffer[] buffers) {
        this.lockObj = obj;
        this.maxCount = maxCount;
        this.buffers = buffers;
    }

    public void run() {

        int handleCount = 0;
        while(true) {
            if(handleCount <= lockObj.getCount()) {
                ByteBuffer buffer = this.buffers[handleCount];
                buffer.flip();
                buffer.get();
                buffer.clear();
                handleCount++;
            } else {
                synchronized (lockObj) {
                    try {
                        lockObj.wait(1000*5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(handleCount == maxCount) {
                handleCount = 0;
            }
        }
    }
    public void setCount(int count) {

    }
}
