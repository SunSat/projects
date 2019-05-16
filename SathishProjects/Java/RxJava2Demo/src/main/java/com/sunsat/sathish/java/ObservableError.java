package com.sunsat.sathish.java;

import io.reactivex.Flowable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.NoSuchElementException;

public class ObservableError {
    public static void main(String[] args) {
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(Long.MAX_VALUE);
            }

            public void onNext(Integer t) {
                if (t == 1) {
                    throw new IllegalArgumentException();
                }
            }

            public void onError(Throwable e) {
                System.out.println("I am on Error : -----------");
                if (e instanceof IllegalArgumentException) {
                    throw new UnsupportedOperationException();
                }
            }

            public void onComplete() {
                System.out.println("_____going to completed : ");
                throw new NoSuchElementException();
            }
        };

        Flowable.just(1).subscribe(subscriber);
    }
}
