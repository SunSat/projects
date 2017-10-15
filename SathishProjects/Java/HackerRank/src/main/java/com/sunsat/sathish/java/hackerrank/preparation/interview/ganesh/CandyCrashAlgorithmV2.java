package com.sunsat.sathish.java.hackerrank.preparation.interview.ganesh;

import java.util.Stack;

/**
 * Created by ssundar2 on 5/11/2017.
 */
public class CandyCrashAlgorithmV2 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String st="RGBBBGGGRRRRG";
        int repeat = 0;
        for(int i=0;i<st.length();i++) {
            char s = st.charAt(i);
            if(stack.empty()) {
                stack.push(s);
            } else {
                Character c = stack.peek();
                if(c != s) {
                    if(repeat != 0) {
                        stack.pop();
                        repeat = 0;
                        if(stack.empty()) {
                            stack.push(s);
                        } else if(stack.peek() != s) {
                            repeat++;
                        }else {
                            repeat++;
                        }
                    } else {
                        stack.push(s);
                    }
                } else {
                    repeat++;
                }
            }
        }
        if(repeat != 0) stack.pop();

        while(!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
}
