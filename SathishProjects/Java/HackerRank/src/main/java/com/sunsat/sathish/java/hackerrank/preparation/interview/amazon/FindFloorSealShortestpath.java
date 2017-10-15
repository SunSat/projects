package com.sunsat.sathish.java.hackerrank.preparation.interview.amazon;

import com.sunsat.sathish.java.hackerrank.preparation.ideserv.LinkedList.SingleLinkedList;

/**
 * Created by ssundar2 on 5/30/2017.
 */


public class FindFloorSealShortestpath<T> extends SingleLinkedList<T> {

    private  class Result {
        Node<T> node;
        T value;
    }

    public <T> T findTheShortestDistance(T val) {
        T t = null;
        Result res = new Result();
        res.node = head;
        res.value = head.getVal();




        return  t;
    }


    public static void main(String[] args) {

        FindFloorSealShortestpath<Integer> findDis = new FindFloorSealShortestpath<>();
        int[] values = {23,12,24,5,2,9,7};
        for(Integer i : values) {
            findDis.add(i);
        }
        System.out.println(findDis.findTheShortestDistance(12));
    }
}
