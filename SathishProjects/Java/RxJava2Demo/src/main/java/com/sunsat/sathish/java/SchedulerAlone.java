package com.sunsat.sathish.java;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class SchedulerAlone {
    public static void main(String[] args) {
        System.out.println("I am main start name is : " + Thread.currentThread().getName());
        /*Scheduler scheduler = Schedulers.io();
        Scheduler.Worker worker = scheduler.createWorker();
        worker.schedule(() -> System.out.println("I am new Thread : " + Thread.currentThread().getName() +" : action"));*/


        Flowable.just(1)
                .observeOn(Schedulers.io())
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer v) throws Exception {
                        System.out.println("Current Thread is : " + Thread.currentThread().getName() + " : "+ (v * v));
                        return v * v;
                    }
                })
                .blockingSubscribe();



        System.out.println("I am main end name is : " + Thread.currentThread().getName());


    }
}
