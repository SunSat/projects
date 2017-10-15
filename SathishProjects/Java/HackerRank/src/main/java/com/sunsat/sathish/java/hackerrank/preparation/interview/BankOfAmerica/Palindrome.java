package com.sunsat.sathish.java.hackerrank.preparation.interview.BankOfAmerica;

/**
 * Created by ssundar2 on 5/13/2017.
 */
public class Palindrome {

    public static void main(String[] args) {
        String st = "mmmmmmmmmmmmmmadammmmmmmmmmmmmm";
        char[] arr = st.toCharArray();
        boolean isPalin = true;
        int i=0,j=arr.length-1;
        while(i != j) {
            if(arr[i++] != arr[j--]) {
                isPalin = false;
                break;
            }
        }
        if(isPalin) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

}
