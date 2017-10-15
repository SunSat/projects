package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.CrackingTheCodingInterview;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ssundar2 on 7/2/2017.
 */
public class BinarySeachIceCreamParler {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            for(int a_i = 0;a_i <n;a_i++)
            {
                map.put(a[a_i],a_i);
            }
            int value = 0;
            for(int a_i = 0; a_i < n;a_i++) {
                value = m - a[a_i];
                if(map.containsKey(value) && a_i != map.get(value)) {
                    System.out.println((a_i +1)+ " " + (map.get(value)+1));
                    break;
                }
            }
        }
    }
}
