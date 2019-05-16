package com.sunsat.sathish.java;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

import java.io.IOException;

public class SchedulerError {
    public static void main(String[] args) {
        SchedulerError error  =new SchedulerError();
        error.sampleError1();
    }
    public void sampleError() {
        Observable.fromArray(1,2,3,4).onErrorReturn(throwable -> 1).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("I am onSubscribe : ");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("I am onNext : " + integer/0);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("I am onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("I am onComplete : ");
            }
        });
    }
    public void sampleError1() {
        Single.just("2A")
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String v) throws Exception {
                        return Integer.parseInt(v, 10);
                    }
                })
                .onErrorReturn(new Function<Throwable, Integer>() {
                    @Override
                    public Integer apply(Throwable error) throws Exception {
                        if (error instanceof NumberFormatException) return 0;
                        else throw new IllegalArgumentException();
                    }
                })
                .subscribe(new Consumer<Integer>() {
                               @Override
                               public void accept(Integer x) throws Exception {
                                   System.out.println(x);
                               }
                           },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable error) throws Exception {
                                System.err.println("onError should not be printed!");
                            }
                        });
    }
}
