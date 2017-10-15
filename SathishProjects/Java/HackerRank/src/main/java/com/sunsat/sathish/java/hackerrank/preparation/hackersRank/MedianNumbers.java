package com.sunsat.sathish.java.hackerrank.preparation.hackersRank;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by ssundar2 on 5/15/2017.
 */
public class MedianNumbers {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        int n= scanner.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++)
            arr[i]=scanner.nextInt();
        calculateMedian(arr);
    }
    static void calculateMedian(int[] arr){

        PriorityQueue<Integer> low= new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1<o2?1:-1;
            }
        });
        PriorityQueue<Integer> high= new PriorityQueue<>();
        for(int j=0;j<arr.length;j++) {
            int i=arr[j];
            if (low.size() == 0) {
                low.offer(i);
            } else {
                if (low.peek() > i) {
                    if (low.size() <= high.size()) {
                        low.offer(i);
                    } else {
                        high.offer(low.poll());
                        low.offer(i);
                    }
                } else {
                    if (low.size() > high.size()) {
                        high.offer(i);
                    } else {
                        //low.offer(high.poll());
                        high.offer(i);
                        low.offer(high.poll());
                    }
                }
            }
            double median;
            if (low.size() == high.size()) {
                median = (low.peek() + high.peek()) / 2.0;
            } else {
                median = low.size() > high.size() ? low.peek() : high.peek();
            }
            System.out.println(median);
        }
    }
}
