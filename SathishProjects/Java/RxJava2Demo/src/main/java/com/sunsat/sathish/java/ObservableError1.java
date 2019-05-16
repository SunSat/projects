package com.sunsat.sathish.java;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

import java.io.IOException;

public class ObservableError1 {
    public static void main(String[] args) {
    ObservableError1 error1  = new ObservableError1();
    error1.sampleError1();
    }

    public void sampleError1() {
        Observable.error(new IOException("Something went wrong"))
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable error) throws Exception {
                        System.err.println("------The error message is: " + error.getMessage());
                        Thread.currentThread().getUncaughtExceptionHandler().uncaughtException(Thread.currentThread(),error);
                    }
                })
                .subscribe(
                        x -> System.out.println("onNext should never be printed!"),
                        Throwable::printStackTrace,
                        () -> System.out.println("onComplete should never be printed!"));

    }
}
