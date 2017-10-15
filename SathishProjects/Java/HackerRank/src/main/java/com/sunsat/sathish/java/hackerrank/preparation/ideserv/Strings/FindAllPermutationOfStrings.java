package com.sunsat.sathish.java.hackerrank.preparation.ideserv.Strings;

import java.util.HashSet;

/**
 * Created by ssundar2 on 5/22/2017.
 */
public class FindAllPermutationOfStrings {

    public static HashSet<String> getAllPermutations(String str) {
        // Create a hash set to prevent any duplicate entries
        HashSet<String> permutations = new HashSet<String>();

        if(str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char first = str.charAt(0);
        String remainingString = str.substring(1);
        HashSet<String> words = getAllPermutations(remainingString);
        for(String word: words) {
            for(int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                permutations.add(prefix + first + suffix);
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        String str = "abc";
        HashSet<String> permutations = getAllPermutations(str);
        System.out.println(permutations.toString());
    }

}
