package com.sunsat.sathish.java;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Observable createObservable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {

                System.out.println("---1---1 IncreateObservable going to call onNext---.");
                subscriber.onNext("Hello World");
                System.out.println("---1---2 Called On Next---.");
                subscriber.onCompleted();
                System.out.println("---1---3 After Completed.---.");

            }
        });

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                System.out.println("+++10+++1 My Subsciber inside completed");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("+++10+++2 My Subsciber inside Error");
            }

            @Override
            public void onNext(String s) {
                System.out.println("+++10+++3 My Subsciber inside OnNext" + s);
            }
        };
        Observer<String> myObserver = new Observer<String>() {
            @Override
            public void onCompleted() {
                System.out.println("####20###1 My Observer inside completed.");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("####20###2 My Observer inside error.");
            }

            @Override
            public void onNext(String s) {
                System.out.println("####20###3 My Observer inside onNext." + s);
            }
        };

        createObservable.subscribe(myObserver);
        createObservable.subscribe(mySubscriber);


    }
}
