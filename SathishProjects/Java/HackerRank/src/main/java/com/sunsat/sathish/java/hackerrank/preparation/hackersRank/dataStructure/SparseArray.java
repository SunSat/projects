package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.dataStructure;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by ssundar2 on 5/15/2017.
 */
public class SparseArray {
    public static void main(String[] args) {
/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        Integer nSt = sc.nextInt();
        sc.nextLine();
        Map<String,Integer> hMap = new HashMap(nSt);
        for(int i=0;i<nSt;i++) {
            String dictionaySt = sc.nextLine();
            Integer count = hMap.get(dictionaySt);
            if(count == null) count=0;
            hMap.put(dictionaySt,++count);
        }
        Integer quries = sc.nextInt();
        sc.nextLine();
        String[] queryArr = new String[quries];
        for(int k=0;k<quries;k++) {
            queryArr[k] = sc.nextLine();
        }

        for(int k=0;k<quries;k++) {
            Integer count = hMap.get(queryArr[k]);
            if(count == null) count = 0;
            System.out.println(count);
        }
    }
}
