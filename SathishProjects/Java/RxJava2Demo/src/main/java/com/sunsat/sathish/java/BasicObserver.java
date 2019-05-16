package com.sunsat.sathish.java;

import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class BasicObserver {
    public static void main(String[] args) {
        System.out.println("Th Start : " + Thread.currentThread().getName());
        /*Flowable.just(1).subscribeOn(Schedulers.io()).subscribe(new Observer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("The Cu Th is : " + Thread.currentThread().getName() + "The Int"  + integer);
            }
        });*/

        Flowable.just(1).subscribeOn(Schedulers.io()).map(new Function<Integer, Object>() {
            @Override
            public Object apply(Integer integer) throws Exception {
                System.out.println("Thread main : " + Thread.currentThread().getName());
                return integer;
            }
        }).blockingSubscribe();

        System.out.println("Th End." + Thread.currentThread().getName());
    }
}
