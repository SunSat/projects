package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.warnup;

import java.util.Scanner;

/**
 * Created by ssundar2 on 29-01-2017.
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[][] = new int[size][size];
        for(int i=0;i<size;i++) {
            for(int k=0;k<size;k++) {
                arr[i][k] = s.nextInt();
            }
        }
        int finalC = (calculateDiagnal(0,size-1,arr,false))-(calculateDiagnal(0,0,arr,true));
        System.out.println(finalC < 0?finalC*-1:finalC);
        //System.out.println( one-two );
    }
    public static int calculateDiagnal(int row,int col,int[][] arr, boolean forward) {

        if(forward) {
            if(row == arr.length-1 && col == arr.length-1)
                return arr[row][col];
            else {
                return arr[row][col] + calculateDiagnal(++row,++col,arr,true);
            }
        } else {
            if(row == arr.length-1 && col == 0) {
                return arr[row][col];
            } else {
                return arr[row][col] + calculateDiagnal(++row,--col,arr,false);
            }
        }
    }
}
