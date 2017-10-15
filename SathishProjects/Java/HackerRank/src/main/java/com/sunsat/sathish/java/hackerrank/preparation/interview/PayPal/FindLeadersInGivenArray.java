package com.sunsat.sathish.java.hackerrank.preparation.interview.PayPal;

import java.util.Stack;

/**
 * Created by ssundar2 on 5/25/2017.
 */
public class FindLeadersInGivenArray {

    public static void main(String[] args) {
        int[]  array = {16,17,5,4,3,6,2,1,3,2,1,9};
        Stack<Integer> stack = new Stack<>();
        int max = array[0];
        int min = array[0];
        int count = 0;
        for(int i=1;i<array.length;i++) {
            if(max <= array[i]) {
                max = array[i];
                min = array[i];
                stack.clear();
                count++;
                //stack.push(max);
            } else {
                if(min >= array[i]) {
                    stack.push(min);
                    min = array[i];
                    count++;
                } else {
                    while(stack.peek() <= array[i]) {
                        stack.pop();
                        count++;
                    }
                    //stack.push(array[i]);
                    min = array[i];
                }

            }
        }
        System.out.println("      ---  "+ count);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
