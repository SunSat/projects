package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.CrackingTheCodingInterview;

/**
 * Created by ssundar2 on 29-01-2017.
 */
public class BinarySearchTree {
    class Node {
        int data;
        Node left;
        Node right;
    }
    boolean checkBST(Node root) {
        try {
            compareBST(root);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    void compareBST(Node node) throws Exception {
       if(node.left != null) {
            if(node.data < node.left.data) {
                throw new Exception();
            }
           compareBST(node.left);
       }
       if(node.right != null) {
            if(node.data > node.right.data){
                throw new Exception();
            }
           compareBST(node.right);
       }
    }
}
