package com.sunsat.sathish.java.hackerrank.preparation.interview.citi;

/**
 * Created by ssundar2 on 6/16/2017.
 */

//import com.sunsat.sathish.java.hackerrank.preparation.interview.citi.A;

import java.net.MalformedURLException;
import java.net.URL;

public class HelloWorldFromTwoJars {
    public static void main(String[] args) {
        //A a = new A();
        //a.helloA();



        URL[] url = new URL[2];
        try {
            url[0] = new URL("file:/C:/personal/Sample/jar2.jar");
            CustomizedClassLoader loader = new CustomizedClassLoader();
            Class<?> aClass = loader.findClass("preparation/interview/citi/A.class");
            //Class<?> c = loader.loadClass("preparation.interview.citi.A");
           // c.getDeclaredConstructor();
            Object obj = aClass.newInstance();

        }catch (MalformedURLException mfe) {
            System.err.println(mfe.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        //System.out.println(uri.getPath());
        //URLClassLoader loader = new URLClassLoader()
    }
}
