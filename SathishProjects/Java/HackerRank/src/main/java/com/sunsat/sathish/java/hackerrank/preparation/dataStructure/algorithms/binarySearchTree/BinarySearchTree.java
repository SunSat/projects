package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.binarySearchTree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Created by ssundar2 on 5/9/2017.
 */
public class BinarySearchTree<T> {

    private Comparator<T> comparator;

    private class BSTNode<T> {
        T t;
        BSTNode left;
        BSTNode right;

        BSTNode(T t,BSTNode left,BSTNode right) {
            this.t = t;
            this.left = left;
            this.right = right;
        }
    }
    private BSTNode<T> root;

    public BinarySearchTree() {

    }

    public void add(T t) {
        if(root == null) {
            root = new BSTNode<>(t,null,null);
        } else {
            insertNode(t,root);
        }
    }

    private void insertNode(T t,BSTNode<T> temp) {
        BSTNode<T> parent = null;
        int cmp = 0;
            do {
                parent = temp;
                cmp = compare(temp.t,t);
                if(cmp > 0) {
                    temp = temp.left;
                } else {
                    temp = temp.right;
                }
            }while (temp != null);
            BSTNode<T> node = new BSTNode<>(t,null,null);
            if(cmp > 0) {
                parent.left = node;
            } else {
                parent.right = node;
            }
    }

    private int compare(Object o1, Object o2) {
        return null == comparator ? ((Comparable<T>) o1).compareTo((T)o2) : comparator.compare((T)o1,(T)o2);
    }

    public boolean delete(T t) {
        if(root == null) return false;
        BSTNode<T> temp = root;
        BSTNode<T> parent = null;
        boolean find =false;
        if(temp.t.equals(t)) {
            //root
        } else {
            do {
                parent = temp;
                int cmp = compare(temp.t,t);
                if(cmp > 0) {
                    if(temp.left == null) {
                        find = false;
                        break;
                    }
                    if(temp.left.t.equals(t)) {
                        temp = temp.left;
                        find = true;
                        break;
                    }
                    temp =temp.left;
                } else if(cmp < 0) {
                    if(temp.right == null) {
                        find = false;
                        break;
                    }
                    if(temp.right.t.equals(t)) {
                        temp = temp.right;
                        find = true;
                        break;
                    }
                    temp = temp.right;
                }
            } while (temp != null);
            if(find) {
                //parent.right = temp.right != null ? temp.right :
            }
        }
        return true;
    }

    public void search(T t) {

    }

    public static void main(String[] args) {
        new TreeMap().put("","");
        BinarySearchTree<Integer> bsTree = new BinarySearchTree<Integer>();
        bsTree.add(5);
        bsTree.add(3);
        bsTree.add(4);
        bsTree.add(2);
        bsTree.add(3);
        bsTree.add(10);
        bsTree.add(8);
        bsTree.add(11);
        bsTree.add(7);

        bsTree.delete(3);

    }
}
