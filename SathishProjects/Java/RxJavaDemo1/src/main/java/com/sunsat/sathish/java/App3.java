package com.sunsat.sathish.java;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

public class App3 {

    public static void main(String[] args) {
        Flowable.fromArray(args).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("Hello World " + s);
            }
        });
    }
}
