package com.sunsat.sathish.java.hackerrank.preparation.general.threads.concurrentPackage;

import java.util.concurrent.*;

/**
 * Created by ssundar2 on 5/11/2017.
 */
public class SampleFeatureTask {
    public static void main(String[] args) {
        FutureTask<Integer> v = new FutureTask(new SampleFeature());
        ExecutorService service = Executors.newFixedThreadPool(1);
        //v.run();
        try {
            System.out.println("submitting now ");
            Future f = service.submit(v);
            //System.out.println("111111111 : " + v.get());
            System.out.println("222222222 : " + f.get());
            service.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}


class SampleFeature implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("Hello Feaure : " + this.getClass().getName());
        Thread.sleep(5000);
        System.out.println("Hello Feaure I am done.");
        return 1;
    }

}
