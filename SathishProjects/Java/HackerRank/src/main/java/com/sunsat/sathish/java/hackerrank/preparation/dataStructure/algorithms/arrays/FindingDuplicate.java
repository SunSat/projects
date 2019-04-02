package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.arrays;

public class FindingDuplicate {
    public static void main(String[] args) {
        int[] ele = {2,3,4,5,5,7};
        int xOr = 0;
        for(int i : ele) {
            xOr = xOr ^ i;
        }
        System.out.println("Initial XOr : "  + xOr);
        int someXor = 0;
        for(int i = 2;i<=7;i++) {
            someXor = someXor ^ i;
        }
        System.out.println("someXor XOr : "  + someXor);

        System.out.println("final xor is :" + (xOr ^ someXor ));
    }
}
