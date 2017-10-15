package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.algorithm.tutorial;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ssundar2 on 31-01-2017.
 */
public class LinkedListsDetectACycle {
    class Node {
        int data;
        Node next;
    }
    public static void main(String args[]) {

    }

    boolean hasCycle(Node head) {
        Set<Integer> nodes = new HashSet<Integer>();
        while(head != null) {
            int hascode = head.hashCode();
            if(nodes.contains(hascode)) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
