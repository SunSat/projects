package com.sunsat.sathish.java.hackerrank.preparation.interview.photon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OddCharacter {

    public static void main(String[] args) {
        String[] a = new String[]{"one","tWo","Threetwo","four","FourOne","One"};
        List<String> li = Arrays.asList(a);
        Set<String> st = new HashSet(li);
        int count;
        for(String temp1:st){
            count = 0;
            for(String temp2:li){
                if(temp2.toLowerCase().contains(temp1.toLowerCase())){
                    count++;
                }

            }
            System.out.println(temp1+"::::"+count);
        }
    }
}