package com.sunsat.sathish.java.hackerrank.preparation.general.javadesignpatterns;

import java.net.URL;

/**
 * Created by ssundar2 on 6/7/2017.
 */
public class CustomClassLoader {
    public static void main(String[] args) {
        URL url = ClassLoader.getSystemClassLoader().getSystemResource("rt.jar");
        System.out.println(url.getPath());
    }
}
