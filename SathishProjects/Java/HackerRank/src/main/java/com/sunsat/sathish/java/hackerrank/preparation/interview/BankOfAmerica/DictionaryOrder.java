package com.sunsat.sathish.java.hackerrank.preparation.interview.BankOfAmerica;

/**
 * Created by ssundar2 on 5/13/2017.
 */

import com.sunsat.sathish.java.hackerrank.preparation.concurrencyInPractice.Ch1Introduction;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Arrange the arrays of strings as per the dictionary order given below.
 * Sample Inputs.
 * char[] dictOrder = {'x','y','z','m','j','n','i','c','a','b','g','d','f','k','h','e','u','l','r','q','p','o','t', 'v','s','w'};
 * String[] stArray = {"iderserve","login","temple","people"}
 *
 * Sample Output is :
 * iderserve login people temple
 *
 * Arranged as per the dictOrder
 */
public class DictionaryOrder {
    public static void main(String[] args) {
        char[] arr = {'x','y','z','m','j','n','i','c','a','b','g','d','f','k','h','e','u','l','r','q','p','o','t',
                'v','s','w'};
        String[] strings = {"temple","people","iderserve","login"};

        TreeMap<Character,Integer> chVsInt = new TreeMap<Character,Integer>();
        int[] orderDisArr = new int[strings.length];

        for(int i=0;i<arr.length;i++) {
            chVsInt.put(arr[i],i);
        }

        for(int i=0;i<strings.length;i++) {
            orderDisArr[i] = chVsInt.get(strings[i].charAt(0));
        }

        /*Used Bubble Sort for simplicity. We can use any sorting algorithm*/
        for(int i=0,j=orderDisArr.length-1;i<orderDisArr.length;i++,j--) {
            for(int k=0;k<j;k++) {
                if(orderDisArr[k] > orderDisArr[k+1]) {
                    int temp = orderDisArr[k+1];
                    orderDisArr[k+1] = orderDisArr[k];
                    orderDisArr[k] = temp;

                    String stTemp = strings[k+1];
                    strings[k+1] = strings[k];
                    strings[k] = stTemp;
                }
            }
        }
        for(String st : strings) {
            System.out.print(st + " ");
        }
        int a = 5;
        String a1 = "";
        ArrayList al = new ArrayList<>();
        Integer[] a2 = new Integer[10];
        al.add(a2);
    }
}
