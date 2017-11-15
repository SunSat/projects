package com.sunsat.sathish.java.hackerrank.preparation.interview.symentac;

import java.util.concurrent.*;

/**
 * Created by ssundar2 on 7/6/2017.
 */
public class StaticContext {
    static ExecutorService pool = null;

    public StaticContext() {
        pool = Executors.newFixedThreadPool(10);

    }
    static int i = 10;
    public static void main(String[] args) {
        StaticContext st = new StaticContext();
        st.addShutdownHook();
        st.i = 12;
        System.out.println(st.i);
        st.submitTask(() -> {
           for(int i = 0;i<10;i++) {
               try {
                   System.out.println("Going for sleep :" + 1);
                  Thread.sleep(1000);
               }catch (InterruptedException ie) {

               }
           }
           return "I am done";
        });
        System.out.println("I am main going to End Now.");
    }

    public void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("I am going to shutdown");
            pool.shutdownNow();
            System.out.println("I Completed");
        }
        ));
    }

    public Future<String> submitTask(Callable<String> thread) {
        return pool.submit(thread);
    }
}
