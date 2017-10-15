package com.sunsat.sathish.java.hackerrank.preparation.ideserv.dynamic_programming;

import com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.binarySearchTree.BinarySearchTree;

import java.util.Arrays;

/**
 * Created by ssundar2 on 5/16/2017.
 */
public class BinarySearchTreeCount<T> {

    /**
     * Finding the Count of the Binay Tree with normal calculation.
     * @param size
     * @param res
     * @return
     */

    public static void main(String[] args) {
        int n = 1000000;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        //System.out.println(compute(1000000000));
        System.out.println(compute(n,res));
    }
    static int compute(int size) {
        if(size <= 1) return 1;
        int allPosiblity = 0;
        for(int i=0;i<size;i++) {
            allPosiblity += (compute(i) * compute(size -i-1));
        }
        return allPosiblity;
    }

    /**
     * Finding the Count of the Binay Tree wit otinmized. That is storing result in the Tree.
     * @param size
     * @param res
     * @return
     */
    static int compute(int size,int[] res) {

        if(size <= 1) {
            return 1;
        }
        int allPosib = 0;
        for(int i=0;i<size;i++) {
            if(res[i] ==  -1) {
                res[i] = compute(i,res);
            }
            if(res[size-i-1] == -1) {
                res[size-i-1] = compute(size-i-1,res);
            }
            allPosib += (res[i]*res[size-i-1]);
        }
        return allPosib;
    }
}
