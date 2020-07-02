package com.sunsat.sathish.java.calculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        HashMap<String,String> hm =new HashMap<String,String>(10,0.5f);
        hm.put("hello","hello");
        System.out.println("apple".compareTo("banana"));
        int a[] = {1,2,3,4};
        List li = new ArrayList();
        li.add("helo");
        li.add(1);
        System.out.println(li.get(0) instanceof Object);
        System.out.println(li.get(1) instanceof Integer);
    }
}
