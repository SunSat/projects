package com.sunsat.sathish.java;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class BasicMultiObserver {
    public static void main(String[] args) {
        BasicMultiObserver observer = new BasicMultiObserver();
        observer.singleObserver();

    }

    public void singleObserver() {
        System.out.println("The main thread start.");
        Observable<String> myObservable = Observable.just("Hello World I am Sathish.exception");

        Observer<String> myObserver = new Observer<String>() {
            Disposable myDisposable = null;
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("I am onSubscribe.");
                myDisposable = disposable;
            }

            @Override
            public void onNext(String s) {
                try {
                    if (s.toLowerCase().contains("exception")) {
                        throw new RuntimeException("Sorry dude. I am error.");
                    }

                }catch (Exception e) {
                    onError(e);
                }
                if (s.toLowerCase().contains("exception")) {
                    throw new RuntimeException("Sorry dude. I am error.");
                }
                System.out.println("onNext. Here is the data you have emitted." + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Wow........I got the exception.....");

            }

            @Override
            public void onComplete() {
                System.out.println("I am done. onComplete");
            }
        };

        myObservable.subscribe(myObserver);
        System.out.println("The main thread done.");
    }

    public void multiObserver() {
        System.out.println("The main thread start.");
        Observable<String> myObservable = Observable.just("Hello World I am Sathish");

        Observer<String> myObserver = new Observer<String>() {
            Disposable myDisposable = null;
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("I am onSubscribe.");
                myDisposable = disposable;
            }

            @Override
            public void onNext(String s) {
                try {
                    if (s.toLowerCase().contains("exception")) {
                        throw new RuntimeException("Sorry dude. I am error.");
                    }

                }catch (Exception e) {
                    onError(e);
                }
                System.out.println("onNext. Here is the data you have emitted." + s);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("Wow........I got the exception.....");

            }

            @Override
            public void onComplete() {
                System.out.println("I am done. onComplete");
            }
        };

        Observer<String> myObserver2 = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("1111- onSubscribe");
            }

            @Override
            public void onNext(String s) {
                System.out.println("1111-onNext : The string is : " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("111-onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("111-onComplete : " );
            }
        };

        myObservable.subscribe(myObserver);
        myObservable.subscribe(myObserver2);
        System.out.println("The main thread done.");
    }

    public void disposableObservable() {
        System.out.println("2222 start --- " + Thread.currentThread().getName());
        Disposable disposable = Observable.just("HelloWorld").
                subscribeWith(
                        new DisposableObserver<String>() {
                            @Override
                            protected void onStart() {
                                super.onStart();
                            }

                            @Override
                            public void onNext(String s) {
                                System.out.println("The String is : " + s + " : The thred Name is : " + Thread.currentThread().getName());
                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        }
                );

        System.out.println("2222 end --- " + Thread.currentThread().getName());
    }
    public void simpleObserver() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g"};
        Observable<String> observable = Observable.fromArray(letters);

    }
}
