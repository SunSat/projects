package com.sunsat.sathish.java.rxJava3;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.parallel.ParallelFlowable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelRxJavaExecutor {

    private static final Random rand = new Random();

    public static void main(String[] args) {


        List<RecipeAllDtoList> recipeList = new ArrayList<>();
        final ArrayList<RecipeInfoDto> recipeInfoDtoList;
        for(int i = 0;i<30;i++) {
            recipeList.add(new RecipeAllDtoList(i+"",""+i));
        }

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);

        /*Flowable<RecipeAllDtoList> recipeAllDtoListFlowable = Flowable.fromIterable(recipeList);
        recipeAllDtoListFlowable.parallel().runOn(Schedulers.from(fixedThreadPool)).map(recipeAllDtoList -> {
            System.out.println("Converted as int Id ------- : " + Integer.parseInt(recipeAllDtoList.id) + " : " + Thread.currentThread().getName());
             return intenseCalculation(Integer.parseInt(recipeAllDtoList.id));
        }).runOn(Schedulers.from(fixedThreadPool)).map(val -> {
            RecipeInfoDto re = new RecipeInfoDto((val)+"" );
            System.out.println("+=====+=======+" + val + " : " + Thread.currentThread().getName());
            return re;
        }).sequential().toList().blockingSubscribe(li  -> {
            System.out.println(li);
        });*/

        ParallelFlowable<RecipeAllDtoList> recipeAllDtoListParallelFlowable = (Flowable.fromIterable(recipeList)).parallel();
        ParallelFlowable<RecipeAllDtoList> backgroundWork = recipeAllDtoListParallelFlowable.runOn(Schedulers.from(fixedThreadPool));
        ParallelFlowable<Integer> backgroundIdReceived = backgroundWork.map(recipeAllDtoList -> {
            try {
                if(Integer.parseInt(recipeAllDtoList.id) ==5) {
                    throw new Exception();
                }
            }catch (Exception e) {
                e.printStackTrace();
                Flowable.error(e);
                throw new RuntimeException();
            }
            return intenseCalculation(Integer.parseInt(recipeAllDtoList.id));
        });
        ParallelFlowable<Integer> anotherBackground = backgroundIdReceived.doOnError(sat -> {
            //doNothing.
        }).runOn(Schedulers.from(fixedThreadPool));
        ParallelFlowable<RecipeInfoDto> recipeInfoDtoFlowable = anotherBackground.map(id -> {
            System.out.println("--------------- :" + id + ": ---------" + Thread.currentThread().getName());
            return new RecipeInfoDto(id+"");
        });

        List<RecipeInfoDto> dtos = recipeInfoDtoFlowable.sequential().toList().blockingGet();

        System.out.println("The final response of all observable is : " + dtos);


        //recipeAllDtoListFlowable.subscribe(val -> System.out.println("" + val));

        //Flowable.just("1","2","3").map(st -> Integer.parseInt(st)).subscribe(System.out::println);

        //Observable<Integer> source = Observable.range(0,10);
       // source.filter(i-> i%2==0).map(i-> i*i).subscribe(System.out::println);


        /*Observable<Integer> vals = Observable.range(1,100);

        vals.flatMap(val -> Observable.just(val)
                .subscribeOn(Schedulers.from(fixedThreadPool))
                .map(i -> intenseCalculation(i))
        ).toList().blockingSubscribe(val -> System.out.println("Subscriber received "
                + val + " on "
                + Thread.currentThread().getName()));*/
        fixedThreadPool.shutdown();
    }
    public static void waitSleep() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static int intenseCalculation(int i) {
        try {
            if(i == 5) {
                //throw new RuntimeException();
            }
            System.out.println("Intensive Calculating " + i + " on " + Thread.currentThread().getName());
            Thread.sleep(randInt(1000,5000));
            return i;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int randInt(int min, int max) {
        return rand.nextInt((max - min) + 1) + min;
    }
}


class RecipeAllDtoList {

    public RecipeAllDtoList(String url, String id) {
        this.url = url;
        this.id = id;
    }

    String url;
    String id;

    @Override
    public String toString() {
        return "RecipeAllDtoList{" +
                "url='" + url + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

class RecipeInfoDto {
    public RecipeInfoDto() {
    }

    public RecipeInfoDto(String url, String id) {
        this.url = url;
        this.id = id;
    }

    public RecipeInfoDto(String id) {
        this.id = id;
    }

    String url;
    String id;

    @Override
    public String toString() {
        return "RecipeInfoDto{" +
                "url='" + url + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}