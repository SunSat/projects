package com.sunsat.sathish.java.geeksforgeeks.palindrom;

public class PalindromLongest1 {
    public static void main(String[] args) {
        String st = "aaaaaaaaaaaaaaaaaaaaaaa";
        int maxSt = findMax(st.toCharArray(), 0, st.length()-1, 0);
        System.out.println(maxSt);
    }

    private static int findMax(char[] st, int i, int j, int count) {
        /*if(st[i] == st[j]) {
            if(i != j) {
                System.out.println("The count is : " + count);
                System.out.println("The I is : " + i + " .The J is " + j);
                findMax(st, i+1, j-1, ++count);
            } else {
                return 0;
            }
        }*/
        if(i == j) {
            return count+= 1;
        } else if(i+1 == j) {
            if(st[i+1] == st[j]) {
                return count += 2;
            } else return count;
        } else if(st[i] == st[j]){
            count = findMax(st, i+1, j-1, count+=2);
        }
        return count;
    }
}
