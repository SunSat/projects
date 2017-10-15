package com.sunsat.sathish.java.hackerrank.preparation.general.threads.concurrentPackage;

import com.sun.org.apache.xalan.internal.utils.FeatureManager;

import java.util.concurrent.*;

/**
 * Created by ssundar2 on 4/20/2017.
 */
public class Count100 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int j = 0;
        for(int i=0;i<10;i++) {
            Thread.currentThread().sleep(100);
            j +=i;
        }
        return j;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Count100 c  = new Count100();
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future<Integer> counter = pool.submit(c);
        System.out.println(counter.get());
        Count100 c1  = new Count100();
        FutureTask<Integer> featureTask = new FutureTask<Integer>(c1);
        pool.execute(featureTask);
        while(!featureTask.isDone()) {
            if(featureTask.isDone()) {
                System.out.println(featureTask.get());
                break;
            }
        }
        pool.shutdown();
        pool.shutdownNow();
    }
}
