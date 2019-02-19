package com.sunsat.sathish.java.hackerrank.preparation.ideserv.Strings;

import java.util.*;

public class GetSmallestAndLargestLexographical {
    public static void main(String[] args) {
        //System.out.println(getSmallestAndLargest("wel",3));
        String A = "maddam";
        boolean isEqual = true;
        for(int i=0,j=A.length()-1;i<A.length()/2;i++,j--) {
            if(A.charAt(i) != A.charAt(j)) {
                isEqual = false;
                break;
            }
        }
        System.out.println(isEqual);

    }

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        List<String> li = new ArrayList<>();
        for(int i = 0;i<=s.length()-k;i++) {
           li.add(s.substring(i,i+k));
        }
        Collections.sort(li);
        return li.get(0) + "\n" + li.get(li.size()-1);
    }
}
