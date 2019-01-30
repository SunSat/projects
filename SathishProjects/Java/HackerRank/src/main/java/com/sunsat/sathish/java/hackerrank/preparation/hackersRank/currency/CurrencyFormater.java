package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.currency;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormater {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        Double payment = scn.nextDouble();
        scn.close();

        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println(NumberFormat.getCurrencyInstance(new Locale("en","in")).format(payment));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));

/*
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
*/
    }
}
