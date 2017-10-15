package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ssundar2 on 30-01-2017.
 */
public class tutorials {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        HashMap<String,Integer> magazineMap = new HashMap<String,Integer>();
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
            if(magazineMap.containsKey(magazine[magazine_i])) {
                magazineMap.put(magazine[magazine_i],magazineMap.get(magazine[magazine_i])+1);
            } else {
                magazineMap.put(magazine[magazine_i],1);
            }
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        boolean isRanson = true;
        for(String st : ransom) {
            if(!magazineMap.containsKey(st)) {
                isRanson = false;
                break;
            } else {
                int val = magazineMap.get(st);
                if(val == 0) {
                    isRanson = false;
                    break;
                } else {
                    magazineMap.put(st,(magazineMap.get(st))-1);
                }
            }
        }
        System.out.println(isRanson?"Yes":"No");
    }
}
