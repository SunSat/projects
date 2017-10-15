package com.sunsat.sathish.java.hackerrank.preparation.ideserv.LinkedList;

import java.util.LinkedList;

/**
 * Created by ssundar2 on 5/27/2017.
 */
public class TwoSortedLinkedList {

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        list1.add(4);
        list1.add(6);
        list1.add(7);
        list1.add(9);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(8);

        LinkedList<Integer> finalLi = new LinkedList<>();
        int n1 = list1.size();
        int n2 = list2.size();
        int i=0;
        int j=0;
        while(i < n1 && j <n2) {
            int li1 = list1.peek();
            int li2 = list2.peek();
            if(li1 <= li2) {
                finalLi.add(list1.pollFirst());
                i++;
            } else if(li1 > li2) {
                finalLi.add(list2.pollFirst());
                j++;
            }
        }
        while (i < n1) {
            finalLi.add(list1.pollFirst());
            i++;
        }
        while (j < n2) {
            finalLi.add(list2.pollFirst());
            j++;
        }
        for(Integer intOut : finalLi) {
            System.out.println(intOut);
        }
    }
}
