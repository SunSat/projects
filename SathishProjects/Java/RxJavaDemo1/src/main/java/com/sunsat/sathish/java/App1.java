package com.sunsat.sathish.java;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

public class App1 {

    public static void main(String[] args) {

        List<String> words = Arrays.asList(
                "the",
                "quick",
                "brown",
                "fox",
                "jumped",
                "over",
                "the",
                "lazy",
                "dog"
        );

        Subscriber<Integer> mySubscribe = new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

                System.out.println("I am done Dude....");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable);

            }

            @Override
            public void onNext(Integer s) {

                System.out.println("Hello World " + s);
            }
        };

        Observable<Integer> myOb = Observable.from(words).map(new Func1<String,Integer>() {
            @Override
            public Integer call(String s) {
                return Integer.parseInt(s);
            }
        });
        myOb.subscribe(mySubscribe);

        //Observable.just("").subscribe(mySubscribe);
    }
}
