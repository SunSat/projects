package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.chalanges;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ssundar2 on 5/6/2017.
 */
public class DynamicArray {

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String[] firstLine = sc.nextLine().split(" ");
        Integer n = Integer.parseInt(firstLine[0]);
        Integer q = Integer.parseInt(firstLine[1]);
        Integer lastAns = 0;
        ArrayList[] seqList = new ArrayList[n];
        for(int i=0;i<n;i++) {
            seqList[i] = new ArrayList<Integer>(2);
        }
        for(int i=0; i<q; i++) {
            String[] secLine = sc.nextLine().split(" ");
            Integer q1 = Integer.parseInt(secLine[0]);
            Integer x = Integer.parseInt(secLine[1]);
            Integer y = Integer.parseInt(secLine[2]);
            switch (q1) {
                case 1 :
                    int index = ((x ^ lastAns) % n);
                    seqList[index].add(y);
                    break;
                case 2 :
                    index = ((x ^ lastAns) % n);
                    lastAns = y % seqList[index].size();
                    lastAns = (Integer) seqList[index].get(lastAns);
                    System.out.println(lastAns);
                    break;
            }
        }
    }
}
