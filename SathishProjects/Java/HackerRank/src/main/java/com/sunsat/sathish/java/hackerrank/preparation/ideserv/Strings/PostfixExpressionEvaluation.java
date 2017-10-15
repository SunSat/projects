package com.sunsat.sathish.java.hackerrank.preparation.ideserv.Strings;

import java.util.Stack;

/**
 * Created by ssundar2 on 5/21/2017.
 */
public class PostfixExpressionEvaluation {
    public static void main(String[] args) {
        String st = "5 4 3 + 4 * -";
        String[] input = st.split(" ");
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<input.length;i++) {
            String c = input[i];
            switch (c) {
                case "+" : {
                    stack.push(stack.pop() + stack.pop());
                    break;
                }
                case "-" : {
                    stack.push(stack.pop() - stack.pop());
                    break;
                }
                case "*" : {
                    stack.push(stack.pop() * stack.pop());
                    break;
                }
                case "/" : {
                    stack.push(stack.pop() / stack.pop());
                } default: {
                    stack.push(Integer.parseInt(c));
                }
            }
        }
        System.out.println(stack.pop());
    }
}
