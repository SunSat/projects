package com.sunsat.sathish.java.hackerrank.preparation.ideserv.LinkedList;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 * Created by ssundar2 on 5/28/2017.
 */
public class ReverseASingleLinkedList<T> extends SingleLinkedList<T> {

    public void reverseArrayList() {
        Node<T> prev = null;
        Node<T> curr = head;
        Node<T> next = head.next;
        Node<T> tailTemp = head;
        while(curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
        }
        curr.next = prev;
        head = curr;
        tail = tailTemp;
    }

    public static void main(String[] args) {
        ReverseASingleLinkedList<Integer> revList = new ReverseASingleLinkedList<>();
        int[] intList = {23,1,3,2};
        for(Integer i : intList) {
            revList.add(i);
        }
        revList.reverseArrayList();
        revList.printList();
        revList.add(20);
        revList.add(25);
        revList.printList();
    }
}
