package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.list;

/**
 * Created by ssundar2 on 5/2/2017.
 */
public class Client {
    public static void main(String[] args) {
        CustomizedList<Integer> al = new CustomizedAList<>(2);
        al.add(5);
        al.add(2);
        al.add(3);

        CustomizedLinkedList<Integer> linkLi = new CustomizedLinkedList<Integer>();
        linkLi.add(5);
        linkLi.add(6);
        linkLi.add(7);
        System.out.println(linkLi.contains(6));

        CustomizedLinkedList<String> linkLi1 = new CustomizedLinkedList<String>();
        linkLi1.add("sat");
        linkLi1.add("kum");
        linkLi1.add("sat");
        System.out.println(linkLi1.contains("kum"));

    }
}
