package com.sunsat.sathish.java.jdk8features;

import java.util.*;
import java.util.function.Consumer;

public class ForEachExample {
    public static void main(String[] args) {

        List<Integer> myList = new ArrayList<Integer>();
        Set<Integer> mySet = new HashSet<>();
        mySet.add(1);
        mySet.add(2);

        for(int i=0; i<10; i++) myList.add(i);

        Iterator<Integer> it = myList.iterator();
        while(it.hasNext()){
            Integer i = it.next();
        }

        //traversing through forEach method of Iterable with anonymous class
        myList.forEach(new Consumer<Integer>() {
            public void accept(Integer t) {
                System.out.println(this);
               // System.out.println("forEach anonymous class Value::"+t);
            }
        });
        myList.forEach(i -> {
            if(i == 5) {
                System.out.println(10);
            }
        });

        mySet.forEach(j -> {
            if(j == 1) {
                System.out.println("Ping me please..." + j);
            }
        });

        //traversing with Consumer interface implementation
        MyConsumer action = new MyConsumer();
        myList.forEach(action);

    }

}

//Consumer implementation that can be reused
class MyConsumer implements Consumer<Integer>{
    public void accept(Integer t) {
       // System.out.println("Consumer impl Value::"+t);
    }
}