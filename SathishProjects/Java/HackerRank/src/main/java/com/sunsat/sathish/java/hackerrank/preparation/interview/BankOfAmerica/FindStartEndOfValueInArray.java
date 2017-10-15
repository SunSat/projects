package com.sunsat.sathish.java.hackerrank.preparation.interview.BankOfAmerica;

/**
 * Created by ssundar2 on 5/13/2017.
 */

import java.util.Stack;

/**
 * In the given order array with duplicate elements find the start and end of a particular integer value.
 */
public class FindStartEndOfValueInArray {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,5,5,6,7,8,9,9,9,9,10};
        Stack<Integer> intStack = new Stack<>();
        int index = 0,startIndex = 0, endIndex = 0,findInt = 5;
        for(int i=0;i<arr.length;i++) {
            int val = arr[i];
            if(intStack.isEmpty()) {
                intStack.push(val);
            } else {
                index++;
                if(val == findInt) {
                    if(intStack.peek() == val) {
                        endIndex++;
                    } else {
                        intStack.push(val);
                        startIndex = endIndex = index;
                    }
                } else {
                    intStack.push(val);
                }
            }
        }
        System.out.println("The Start Index = " + startIndex + " & End Index is : " + endIndex);
    }
}
