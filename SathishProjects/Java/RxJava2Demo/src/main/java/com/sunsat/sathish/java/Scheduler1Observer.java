package com.sunsat.sathish.java;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class Scheduler1Observer {

    public static void main(String[] args) {

        Scheduler1Observer observer = new Scheduler1Observer();
        observer.observer1();

    }

    public void observer1() {

        Observable<String> myObservable = Observable.just("1","2","3","4","5","6","7","8");
        System.out.println("I am from Main Thread. : " + Thread.currentThread().getName());
        myObservable.subscribeOn(Schedulers.io()).observeOn(Schedulers.newThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("I am onSubscribe. Diff thread : " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(String s) {
                System.out.println("I am onNext: The Current Th is: " + Thread.currentThread().getName() + " : The String is : " + s);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("I am onComplete: The Current Th is: " + Thread.currentThread().getName());
            }
        });
        System.out.println("I am Done. The Main Thread." + Thread.currentThread().getName());
    }

    public void observer2() {
        System.out.println("I am from Main Start." + Thread.currentThread().getName());
        //producer
        Observable<String> observable = Observable.just("how", "to", "do", "in", "java");

        //consumer
        Consumer<? super String> consumer = System.out::println;
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println(s + "The thread Name is : " + Thread.currentThread().getName());
            }
        };

        //Attaching producer to consumer
        observable.subscribe(consumer1);
        System.out.println("I am from Main End." + Thread.currentThread().getName());
    }
}
