package com.sunsat.sathish.java.hackerrank.preparation.interview.UrjaNet;

import java.util.*;

/**
 * Created by ssundar2 on 5/11/2017.
 */
public class RangeBucket {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        for(int k = 0; k<n; k++) {
            String st = (k*10) + "-" + ((k*10) + 9);
            nodes[k] = new Node(st,null);
        }

        System.out.println("Enter the number of vlaues to store in the bucket");
        int n1 = scanner.nextInt();
        for(int n2 = 0;n2<n1;n2++) {
            System.out.println("Enter value to store in bucket");
            int n3 = scanner.nextInt();
            int n4 = n3/10;
            Node root = nodes[n4];
            Node newNode = new Node(n3,null);
            Node temp = root;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        for(int n5=0;n5<n1;n5++) {
            Node root = nodes[n5];
            Node temp = root;
            while(temp != null) {
                System.out.print(temp.t + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    static  class Node {
        Object t;
        Node next;

        Node() {
        }

        Node(Object t, Node next) {
            this.t = t;
            this.next = next;
        }
    }
}
