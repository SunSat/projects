package com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.externalInterfaces;

import com.sunsat.sathish.java.hackerrank.preparation.SAAndDesignPattern.proxyDesignPattern.proxy.APIFiltter;

import java.lang.reflect.Proxy;

/**
 * Created by ssundar2 on 20-03-2017.
 */
public class VmsRegistor {
    public static Object getInterface(Object obj) {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),new APIFiltter(obj));
    }
}
