package com.sunsat.sathish.java.hackerrank.preparation.general.eventListenerPublisher.iosocketNewArchitecture;

/**
 * Created by ssundar2 on 07-04-2017.
 */
public class LockObject {

    public volatile int count=0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int increaseCount() {
        return ++this.count;
    }
}
