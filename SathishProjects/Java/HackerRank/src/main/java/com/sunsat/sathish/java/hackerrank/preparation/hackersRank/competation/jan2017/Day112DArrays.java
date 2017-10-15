package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.competation.jan2017;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by ssundar2 on 23-02-2017.
 */
public class Day112DArrays {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr1[][] = {
                {1,0,2,0,0,0},
                {0,3,0,0,0,0},
                {0,4,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
        };
        int arr[][] = {
                {0, -4, -6, 0, -7, -6},
                {-1, -2, -6, -8, -3, -1},
                {-8, -4, -2, -8, -8, -6},
                {-3, -1, -2, -5, -7, -4},
                {-3, -5, -3, -6, -6, -6},
                {-3, -6, 0, -8, -6, -7}
        };
        boolean first = false;
        int max = Integer.MIN_VALUE;
        /*The size of hourglass is 7.
            a b c
              d
            e f g
         */
        for(int i=0;i<arr.length-2;i++) {
            for (int j = 0; j < arr.length-2; j++) {
                int hourGlassSum = 0;
                //Internal loop for calculating the sum of hour glass.
                int a = i, b = j;
                for (int k = 0; k < 7; k++) {
                    if(k < 3) {
                        hourGlassSum += arr[a][b++];
                    }else if(k == 3) {
                        a++;
                        hourGlassSum += arr[a++][b-2];
                        b = j;
                    } else {
                        hourGlassSum += arr[a][b++];
                    }
                }
                if(hourGlassSum > max) max = hourGlassSum;
            }
        }
        System.out.println(max);
    }
}
