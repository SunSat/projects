package com.sunsat.sathish.java.hackerrank.preparation.general.threads.philosopherProblem;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class Forks {

    Boolean[] forks = null;

    public Forks(Boolean[] forks) {
        this.forks = forks;
    }

    public synchronized void getForks( int i) throws InterruptedException {
        while(forks[i] != false || forks[i+1] != false) {
            this.wait();
        }
        forks[i] = true;
        forks[i+1] = true;
    }
    public synchronized void putForks(int i) throws InterruptedException {
        forks[i] = false;
        forks[i+1] = false;
        notifyAll();
    }
}
