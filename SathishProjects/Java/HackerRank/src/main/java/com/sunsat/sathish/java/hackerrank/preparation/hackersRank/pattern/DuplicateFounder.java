package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.pattern;

import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class DuplicateFounder {

    public static void main(String[] args) {

        String str = "12 1212 21 2121 212";
        String regex = "(\\d\\d)\\1";
        Pattern p = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher  m = p.matcher(str);

        while(m.find()) {
            String s1 = m.group();
            System.out.println(s1);
        }
/*
        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(),m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
        }

        in.close();
*/
    }
}


