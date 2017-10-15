package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.competation.jan2017;

import java.util.Scanner;

/**
 * Created by ssundar2 on 29-01-2017.
 */
public class Day02_DataTyps {
    public static void main(String... args) {
        int i = 4;
        double d = 4.0;
        String s = "sathish";

        Scanner scan = new Scanner(System.in);
                /* Declare second integer, double, and String variables. */
        int k = 0;
        double l = 0.0;
        String m = "";

        k = scan.nextInt();
        l = scan.nextDouble();
        m = scan.next();
        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i+k);
        /* Print the sum of the double variables on a new line. */
        System.out.println(d+l);
        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */
        System.out.println(s.concat(m));
        scan.close();

    }
}
