package com.sunsat.sathish.java.hackerrank.preparation.jbc;

/**
 * Created by ssundar2 on 6/14/2017.
 */
public class Foo {

    native int bar(String s);
    static {
        System.loadLibrary("foo_bar");
    }
}
