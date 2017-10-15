package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.implementation;

import java.util.Scanner;

/**
 * Created by ssundar2 on 01-02-2017.
 */
public class DisignPDF {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int h[] = new int[n];
        h[0]=in.nextInt();
        int max=h[0];
        for(int h_i=1; h_i < n; h_i++){
            h[h_i] = in.nextInt();
            max=Math.max(max,h[h_i]);
        }
        String word = in.next();
        int mMax=0;
        for(char ch:word.toCharArray()){
            if(h[(int)(ch-'a')] > mMax)
                mMax=Math.max(mMax,h[ch-'a']);
            if(mMax==max)
                break;
        }
        System.out.println(mMax*word.length());
    }
}
