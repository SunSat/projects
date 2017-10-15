package com.sunsat.sathish.java.hackerrank.preparation.ideserv.LinkedList;

/**
 * Created by ssundar2 on 5/29/2017.
 */
public class ReverseKthLinkedList<T> extends SingleLinkedList<T> {

    public void reverseKthNode(T val) {

    }

    public static void main(String[] args) {
        ReverseKthLinkedList<Integer> revList = new ReverseKthLinkedList<>();
        int[] intList = {23,1,3,2};
        for(Integer i : intList) {
            revList.add(i);
        }
        revList.reverseKthNode(3);
        revList.printList();
        revList.add(20);
        revList.add(25);
        revList.printList();
    }
}
