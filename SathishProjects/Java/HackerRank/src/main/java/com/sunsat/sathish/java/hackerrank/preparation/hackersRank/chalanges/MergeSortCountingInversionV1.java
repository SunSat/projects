package com.sunsat.sathish.java.hackerrank.preparation.hackersRank.chalanges;

import java.util.Comparator;
import java.util.Scanner;
import java.util.PriorityQueue;

/**
 * Created by ssundar2 on 5/15/2017.
 */
public class MergeSortCountingInversionV1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println(merge(arr,0,n-1));
        }
    }
    public static  long merge(int[] arr,int start,int end) {
        long c = 0;
        if(start < end) {
            int mid = (start + end ) /2;
            c += merge(arr,start,mid);
            c += merge(arr,mid+1,end);
            c += compare(arr,start,mid,end);
        }
        return c;
    }
    public static long compare(int[] arr,int start,int mid,int end) {

        int n1 = mid - start + 1;
        int n2 = end - mid;

        int[] t1 = new int[n1];
        int[] t2 = new int[n2];

        long c = 0;

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
                c += ((long)(mid+j+1) - k);
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
        String st = "";
        char[] x = st.toCharArray();
        x.toString();
        return c;
    }
}
