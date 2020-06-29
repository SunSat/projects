package com.sunsat.sathish.java.hackerrank.preparation.trees;

public class TreesSample {
    Node root;

    public void add(int i) {
        if(root == null) {
            root = new Node(i);
        } else {
            insert(root, new Node(i));
        }
    }

    public void insert(Node root, Node insert) {
        if(root.key > insert.key) {
            
        }
    }

    public void remove(int i) {

    }

    public static void main(String[] args) {
        TreesSample sample = new TreesSample();
        sample.add(10);
    }

}

class Node {
    int key;
    Node left = null, right = null;
    Node(int key) {
        this.key = key;
    }
}


