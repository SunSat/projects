package com.yapstone.rxjava2;


import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import net.bytebuddy.implementation.bytecode.Throw;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class LoginController {

    @RequestMapping(value = {"/","/index"})
    public String homePage() {
        return "index";
    }

    @RequestMapping("/login.an")
    public String loginRequestHandler(HttpServletRequest request) {

        System.out.println("The Thread Name  Start: " + Thread.currentThread().getName());

        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println(throwable.toString());
                Throwable throwable1  = throwable.getCause();
                try {
                    System.out.println("Before Sleep thread Name is : "+ Thread.currentThread().getName());
                    Thread.sleep(7000);
                    System.out.println("After sleep thread Name is : "+ Thread.currentThread().getName());
                }catch (Exception e) {
                    //e.printStackTrace();
                }
                //throw new RuntimeException(throwable1);

            }
        });

        Flowable.range(1, 10).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer t) {
                if(t == 5) {
                    throw new RuntimeException("I am half done. Error.");
                }
                System.out.println("The OnNext ThName : " +Thread.currentThread().getName() + " : THe value is : " + t);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });
        System.out.println("The Thread Name  End: " + Thread.currentThread().getName());
        return "home";
    }

    @RequestMapping("/home.an")
    public String getAllStudentRequestHandler() {
        /*Flowable.range(1, 10).onErrorReturn(new Function<Throwable, Integer>() {
            @Override
            public Integer apply(Throwable throwable) throws Exception {
                throwable.printStackTrace();
                return 1;
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer t) {
                if(t == 5) {
                    throw new RuntimeException("I am half done. Error.");
                }
                System.out.println("The OnNext ThName : " +Thread.currentThread().getName() + " : THe value is : " + t);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done");
            }
        });*/
        return "allStudent";
    }

}
