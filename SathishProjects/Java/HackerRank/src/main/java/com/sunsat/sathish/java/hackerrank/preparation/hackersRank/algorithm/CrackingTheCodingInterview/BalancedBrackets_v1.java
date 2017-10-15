package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.CrackingTheCodingInterview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by ssundar2 on 04-02-2017.
 */
public class BalancedBrackets_v1 {
        public static boolean isBalanced(String expression) {
            Stack<Character>  opStack = new Stack<Character>();
            for(char ch : expression.toCharArray()) {
                if(ch=='[' || ch ==  '{' || ch=='(') {
                    opStack.push(ch);
                } else {
                    if(opStack.isEmpty()) {
                        return false;
                    }
                    char c = opStack.pop();
                    if(!((ch == ']' && c=='[') || (ch=='}' && c=='{') || (ch==')' && c=='('))) {
                        return false;
                    }
                }
            }
            if(opStack.isEmpty()) return  true;
            return false;
        }

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for (int a0 = 0; a0 < t; a0++) {
                String expression = in.next();
                System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
            }
        }
}
