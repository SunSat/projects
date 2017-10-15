package com.sunsat.sathish.java.hackerrank.preparation.interview;

/**
 * Created by ssundar2 on 6/15/2017.
 */
public class Altimatrics {

    static {
        System.out.println("A");
    }
    Altimatrics() {
        System.out.println("A Con");
    }
    public void methodA(int i) {
        System.out.println("Hell Int");
    }
    public void methodA(String i) {
        System.out.println("Hell String");
    }


}
class HelloAlti extends Altimatrics {
    static {
        System.out.println("B");
    }
    HelloAlti() {
        System.out.println("B con");
    }
    public static void main(String[] args) {
        HelloAlti mat = new HelloAlti();
        //mat.methodA(null);
    }

}
