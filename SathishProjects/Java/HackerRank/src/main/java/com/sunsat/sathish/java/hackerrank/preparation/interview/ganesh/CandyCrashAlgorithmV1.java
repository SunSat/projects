package com.sunsat.sathish.java.hackerrank.preparation.interview.ganesh;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by ssundar2 on 4/27/2017.
 */
public class CandyCrashAlgorithmV1 {

    public static void main(String ... args) {
        String st = "RBBBRRRRBBB";
        Stack<Character> stack = new Stack<>();

        int index=-1,cuIndex = -1, length = st.length();
        char lastChar = '0';


        for(int i=0;i<length;i++) {
            char c = st.charAt(i);
            if(stack.isEmpty()) {
                stack.push(c);
                index++;
                cuIndex++;
                lastChar = c;
            } else {
                if((i+1) >= length) {
                    if(lastChar == c) {

                    } else {

                    }
                } else {
                    if(lastChar == c) {
                        stack.push(c);
                        index++;
                    } else {
                        //checck
                    }
                }

            }
        }
        for(int i=0;i<stack.size();i++) {
            System.out.print(stack.get(i));
        }
    }
}
