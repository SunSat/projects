package com.sunsat.sathish.java.hackerrank.preparation.jbc;

import java.io.Console;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Created by ssundar2 on 6/14/2017.
 */
public class SampleImpl implements SampleInterface {
    @Override
    public void hello() {
        System.out.println("SampleImpl");
    }

    public static void main(String[] args) throws Exception {
        SampleImpl impl = new SampleImpl();
        impl.hello();
        char c1 = '9';
        int a = '\u0008';
        c1 = (char) a;
        System.out.println("lkjsdf : " + c1);
        System.out.println("lksdjflksjf   : " + Character.forDigit(22,36));
    }
}
