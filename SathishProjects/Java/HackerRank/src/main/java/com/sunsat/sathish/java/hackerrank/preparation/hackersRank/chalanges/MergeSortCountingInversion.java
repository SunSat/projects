package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.chalanges;

import javax.xml.soap.Node;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by ssundar2 on 5/15/2017.
 */
public class MergeSortCountingInversion {

    static class Node {
        int n;
        void incrementCount() {
            n++;
        }
        int getCount() {
            return n;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] arr = new int[t];
        Node node =new Node();
        for(int i = 0;i<t;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(merge(arr,0,arr.length-1,node));
        for(int z = 0; z< arr.length;z++) {
            //System.out.println(arr[z]);
        }
        //System.out.println(c);
    }
    public static  int merge(int[] arr,int start,int end,Node count) {
        int c = 0;
        if(start < end) {
            int mid = (start + end ) /2;
            c += merge(arr,start,mid,count);
            c += merge(arr,mid+1,end,count);
            c += compare(arr,start,mid,end,count);
        }
        return c;
    }
    public static int compare(int[] arr,int start,int mid,int end,Node count) {

        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] t1 = new int[n1];
        int[] t2 = new int[n2];

        int c = 0;

        for(int i=0;i<n1;i++) {
            t1[i] = arr[start + i];
        }

        for(int j=0;j<n2;j++) {
            t2[j] = arr[mid + j + 1];
        }

        int i=0,j=0,k = start;
        while((i < n1) && (j < n2)) {
            if(t1[i] > t2[j]) {
                arr[k++] = t2[j++];
                c += mid - i + 1;
            } else {
                arr[k++] = t1[i++];
            }
        }
        while(i < n1) {
            arr[k++] = t1[i++];
        }
        while (j < n2) {
            arr[k++] = t2[j++];
        }
        return c;
    }
}
