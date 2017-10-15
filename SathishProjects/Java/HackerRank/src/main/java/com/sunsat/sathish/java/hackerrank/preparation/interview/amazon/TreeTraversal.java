package com.sunsat.sathish.java.hackerrank.preparation.interview.amazon;

import java.util.ArrayList;

/**
 * Created by Sathish on 5/25/2017.
 */

/**
 * Algorithm.
 * Step 1 : Traver each node in the tree.
 * Step 2 : node.value < given Value move right
 * Step 3 : store or replace right value and distance between (given value and right value) in temp memory.
 * Step 4 : node.value > given Value move left
 * Step 5 : Store or replace left value and distance between (given value and left value) in temp memory.
 * Step 6 : end print the node and distance.
 *
 * Assumptions :
 * 1. Root is not eqaual to null.
 * 2. if distance is same then taking the first distance as per the order.
 *
 * Total No of test case executed 10
 * Result : Passed 10. Fail 0.
 *
 * As per my understanding
 * algorithm's time complexity is O(log n)
 * algorithm's Space complexity is O(1)O(n) = O(n)
 */
public class TreeTraversal {

    private class Node {
        Node(double d) {
            value = d;
        }
        double value;
        Node left;
        Node right;
    }

    private  class Result {
        Node node;
        double value;
    }

    private double[] treeValues = null;
    private Node root = null;

    TreeTraversal(double[] values) {
        this.treeValues = values;
        constructTree();
    }

    private void constructTree() {
        if(root == null) {
            root = new Node(treeValues[0]);
        }
        for(int i=1;i<treeValues.length;i++) {
            insert(root,treeValues[i]);
        }
    }

    private Node insert(Node node, double value) {
        if(node == null) {
            node = new Node(value);
        }
        if(node.value < value) {
            node.right = insert(node.right,value);
        } else if(node.value > value) {
            node.left = insert(node.left,value);
        }
        return node;
    }

    private void findNearest(double key) {
        Result res = new Result();
        find(root,res,key);
        System.out.println("Nearest Node value is: " + res.node.value);
        System.out.println("Nearest Distance is : " + res.value);
    }

    private void find(Node tempNode,Result res,double key) {
        if(res.node == null) {
            res.node = tempNode;
            res.value = tempNode.value - key < 0 ? -(tempNode.value - key) : tempNode.value - key;
        }
        while(tempNode != null) {
            if(tempNode.value == key) {
                res.node = tempNode;
                res.value = tempNode.value - key < 0 ? -(tempNode.value - key) : tempNode.value - key;
                break;
            }
            if(tempNode.value < key) {
                tempNode = tempNode.right;

            } else if(tempNode.value > key) {
                tempNode = tempNode.left;
            }
            if(tempNode != null) {
                double value = (tempNode.value - key) <0 ? -(tempNode.value-key) : (tempNode.value-key);
                if(res.value > value) {
                    res.node = tempNode;
                    res.value = value;
                }
            }
        }
    }
    public static void main(String[] args) {

        //double[] set1TestCase = {15.5,19.2,18.4,14.1,14.4,20.1,25.1};
        //Test 1 :
        //double floorValue = 25.5;
        //Test 2 :
        //double floorValue = 13.2;
        //Test 3 :
        //double floorValue = 17.1;
        //Test 4 :
        //double floorValue = -20.3;
        //Test 5 :
        //double floorValue = 0;
        //Test 6:
        //double floorValue = 1000000000;
        //Test 7 :

        double[] set2TestCase = {-15,-19,-16,-18,-14,-20,-25};
        //double floorValue = -25;
        //Test 8 :
        //double floorValue = -5;
        //Test 9 :
        //double floorValue = -0;
        //Test 10 :
        //double floorValue = -17;

        //double[] set3TestCase = {10,5,15,2,9,6};
        //double[] set3TestCase = {10,10,10,10,10,10,10,10,10};
        TreeTraversal tree = new TreeTraversal(set2TestCase);
        tree.findNearest(Math.round(-15));
    }
}
