package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.competation.jan2017;

import java.util.Scanner;

/**
 * Created by ssundar2 on 28-01-2017.
 */
public class Day0HelloWorld {
    public static void main(String[] args) {
        // Create a Scanner object to read input from stdin.
        Scanner scan = new Scanner(System.in);

        // Read a full line of input from stdin and save it to our variable, inputString.
        System.out.println(scan.nextDouble());
        String inputString = scan.nextLine();
        String otherString = scan.nextLine();

        // Close the scanner object, because we've finished reading
        // all of the input from stdin needed for this challenge.
        scan.close();

        // Print a string literal saying "Hello, World." to stdout.
        System.out.println(inputString);
        System.out.println(otherString);

        // TODO: Write a line of code here that prints the contents of inputString to stdout.
    }
}
