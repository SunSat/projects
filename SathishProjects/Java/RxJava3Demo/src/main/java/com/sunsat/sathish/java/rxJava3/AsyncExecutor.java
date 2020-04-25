package com.sunsat.sathish.java.rxJava3;
import com.sun.tools.javac.comp.Flow;
import io.reactivex.rxjava3.core.*;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class AsyncExecutor {
    public static void main(String[] args) {
       Flowable<Integer> flow = Flowable.range(1, 10)
                .map((v) -> {
                    System.out.println("=============" + v);
                    return v;
                });
        flow.subscribe(System.out::println);

        Random random = new Random();
        Flowable<Integer> flowable = Flowable.range(1,10);
        Flowable<Integer> background = flowable.subscribeOn(Schedulers.io());
        Flowable<Integer> flowable1 = background.map((a) -> {
            if(random.nextInt(10) % 2 == 0)
                Thread.sleep(4000);
            else
                Thread.sleep(1000);
            System.out.println("I am background---------------a" + a + " : " + Thread.currentThread().getName());
            return a;
        });
        Flowable<Integer> showForeground = flowable1.observeOn(Schedulers.single());

        showForeground.blockingSubscribe((v)-> {
            System.out.println("I am blocking Subscripe : "+ Thread.currentThread().getName() + " -------- " + v);
        });

        Flowable.range(1, 10)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(System.out::println);
    }
}
