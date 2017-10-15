package com.sunsat.sathish.java.hackerrank.preparation.general.threads.philosopherProblem;

/**
 * Created by ssundar2 on 4/19/2017.
 */
public class PhilosopherThread extends Thread {

    Forks forks = null;
    int name= -1;
    PhilosopherThread(int name,Forks forks) {
        this.forks = forks;
        this.name = name;
    }

    public void run() {
        while(true) {
            try {
                think();
                forks.getForks(name);
                eat();
                forks.putForks(name);
            }catch (InterruptedException ioe) {
                ioe.printStackTrace();
            }
        }
    }
    private void think() {
        System.out.println("The PhilosopherThread is going to sleep " + name);
        try {
            this.currentThread().sleep(((int)Math.random()) * 10000);
        }catch (InterruptedException ioe) {

        }
        System.out.println("The PhilosopherThread sleep done " + name);
    }
    private void eat() {
        System.out.println("The PhilosopherThread is going to eat " + name);
        try {
            this.currentThread().sleep(((int)Math.random()) * 20000);
        }catch (InterruptedException ioe) {

        }
        System.out.println("The PhilosopherThread eat done " + name);
    }

    public static void main(String[] args) {
        Boolean[] boolArray  = new Boolean[5];
        for(int i=0;i<5;i++) {
            boolArray[i] = false;
        }
        Forks forks = new Forks(boolArray);
        new PhilosopherThread(1, forks).start();
    }
}
