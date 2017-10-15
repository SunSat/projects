package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Objects;

/**
 * Created by ssundar2 on 20-03-2017.
 */
public class APIFiltter implements InvocationHandler {

    Object obj;

    public APIFiltter(Object obj) {
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        Object result;
        try {
            System.out.println("before method " + m.getName());
            String oriClass = obj.getClass().getName().replace("Proxy","Impl");
            Class c = Class.forName(oriClass);
            Class[] p = new Class[args.length];
            for(int i=0;i<args.length;i++) {
                p[i] = args[i].getClass();
            }
            Method oriMe = c.getDeclaredMethod(m.getName(),p);
            Method oriM = c.getMethod(m.getName(),p);

            result = m.invoke(obj, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                    e.getMessage());
        } finally {
            System.out.println("after method " + m.getName());
        }
        return result;
    }
}
