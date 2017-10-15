package com.sunsat.sathish.java.hackerrank.preparation.interview.ganesh;

import java.util.Stack;

/**
 * Created by ssundar2 on 4/27/2017.
 */
public class CandyCrashAlgorithm {

    public static void main(String ... args) {
        String st = "RBBBRRRRBBB";
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<st.length();i++) {
            char c = st.charAt(i);
            if(stack.empty()) {
                stack.push(c);
            } else {
                if(stack.peek().equals(c)) {
                    stack.pop();
                    while(!stack.isEmpty() || stack.peek() == c) {
                        stack.pop();
                    }
                }
                else {
                    stack.push(c);
                }
            }
        }
        for(int i=0;i<stack.size();i++) {
            System.out.print(stack.get(i));
        }
    }
    public static void checkRecursive(Stack<Character> stack,char c) {
        if(stack.isEmpty() || stack.peek() != c) {
            return;
        } else {
            stack.pop();
            checkRecursive(stack,c);
        }
    }
}
