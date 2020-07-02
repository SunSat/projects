package com.sunsat.sathish.java.geeksforgeeks.palindrom;

public class GFG {
    static int max(int x, int y) {
        return (x > y) ? x : y;
    }
    // Returns the length of the longest palindromic subsequence in seq

    static int lps(char seq[], int i, int j,int total) {
        // Base Case 1: If there is only 1 character
        if (i == j) {
            total++;
            return 1;
        }

        // Base Case 2: If there are only 2 characters and both are same
        if (seq[i] == seq[j] && i + 1 == j) {
            total++;
            return 2;
        }

        // If the first and last characters match
        if (seq[i] == seq[j]) {
            return lps(seq, i + 1, j - 1,++total) + 2;
        }

        // If the first and last characters do not match
        System.out.println(++total);
        return max(lps(seq, i, j - 1,total ), lps(seq, i + 1, j, total));
    }


    /* Driver program to test above function */
    public static void main(String[] args) {
        String seq = "123AAABBAAA321AAA";
        int n = seq.length();
        System.out.printf("The length of the LPS is %d", lps(seq.toCharArray(), 0, n - 1,0));

    }
}
