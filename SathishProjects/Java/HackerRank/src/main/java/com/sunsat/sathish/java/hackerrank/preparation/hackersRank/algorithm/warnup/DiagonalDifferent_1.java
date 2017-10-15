package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.warnup;

import java.util.Scanner;

/**
 * Created by ssundar2 on 29-01-2017.
 */
public class DiagonalDifferent_1 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        String st = "6 6 7 -10 9 -3 8 9 -1 9 7 -10 6 4 1 6 1 1 -1 -2 4 -6 1 -4 -6 3 9 -8 7 6 -1 -6 -6 6 -7 2 -10 -4 9 1 -7 8 -5 3 -5 -8 -3 -4 2 -3 7 -5 1 -5 -2 -7 -4 8 3 -1 8 2 3 -3 4 6 -7 -7 -8 -3 9 -6 -2 0 5 4 4 4 -3 3 0";
        String[] stArr = st.split(" ");
        int count = 0;
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int arr[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int k = 0; k < size; k++) {
                arr[i][k] = Integer.parseInt(stArr[count++]);
            }
        }
        int one = calculateDiagnal(0, 0, arr, true);
        int two = calculateDiagnal(0, size - 1, arr, false);
        System.out.println(((two) - (one)) > 0);
        //System.out.println( one-two );
    }

    public static int calculateDiagnal(int row, int col, int[][] arr, boolean forward) {

        if (forward) {
            if (row == arr.length - 1 && col == arr.length - 1)
                return arr[row][col];
            else {
                return arr[row][col] + calculateDiagnal(++row, ++col, arr, true);
            }
        } else {
            if (row == arr.length - 1 && col == 0) {
                return arr[row][col];
            } else {
                return arr[row][col] + calculateDiagnal(++row, --col, arr, false);
            }
        }
    }
}