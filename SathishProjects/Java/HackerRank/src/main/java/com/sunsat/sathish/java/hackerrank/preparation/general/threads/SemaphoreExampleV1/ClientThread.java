package com.sunsat.sathish.java.hackerrank.preparation.general.threads.SemaphoreExampleV1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class ClientThread {
    public static void main(String[] args) {

        Semaphore[] semaphores = new Semaphore[6];
        for(int i=0;i<semaphores.length;i++) {
            semaphores[i] = new Semaphore(0);
        }
        ExecutorService service = Executors.newFixedThreadPool(6);
        service.submit(new ThreadT5("T5",semaphores));
        service.submit(new ThreadT4("T4",semaphores));
        service.submit(new ThreadT3("T3",semaphores));
        service.submit(new ThreadT2("T2",semaphores));
        service.submit(new ThreadT1("T1",semaphores));

    }
}
class ThreadT1 extends Thread {
    Semaphore[] semaphores = null;
    public ThreadT1(String name, Semaphore[] semaphores) {
        super(name);
        this.semaphores = semaphores;
    }
    public void run() {
        //critical section
        System.out.println(this.getName() + " : I am done.");
        semaphores[0].release();
        semaphores[1].release();
        semaphores[2].release();
    }
}
class ThreadT2 extends Thread {
    Semaphore[] semaphores = null;
    public ThreadT2(String name, Semaphore[] semaphores) {
        super(name);
        this.semaphores = semaphores;
    }
    public void run() {
        //critical section
        try {
            semaphores[0].acquire();
            System.out.println(this.getName() + " : I am done.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        semaphores[3].release();
    }
}
class ThreadT3 extends Thread {
    Semaphore[] semaphores = null;
    public ThreadT3(String name, Semaphore[] semaphores) {
        super(name);
        this.semaphores = semaphores;
    }
    public void run() {
        //critical section
        try {
            semaphores[1].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " : I am done.");
        semaphores[4].release();
    }
}
class ThreadT4 extends Thread {
    Semaphore[] semaphores = null;
    public ThreadT4(String name, Semaphore[] semaphores) {
        super(name);
        this.semaphores = semaphores;
    }
    public void run() {
        //critical section
        try {
            semaphores[2].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " : I am done.");
        semaphores[5].release();
    }
}
class ThreadT5 extends Thread {
    Semaphore[] semaphores = null;
    public ThreadT5(String name, Semaphore[] semaphores) {
        super(name);
        this.semaphores = semaphores;
    }
    public void run() {
        //critical section
        try {
            semaphores[3].acquire();
            semaphores[4].acquire();
            semaphores[5].acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " : I am done.");
    }
}
