package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.list;

import com.sunsat.sathish.java.hackerrank.preparation.dataStructure.exceptions.GeneralExceptions;

import java.util.Objects;

/**
 * Created by ssundar2 on 30-01-2017.
 */
public class CustomLinkedList {
    class Node {

        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Node() {

        }
        public Node(Node node, Objects obj) {
            this.next = node;
            this.data = obj;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    public CustomLinkedList() {

    }
    public void purge() {
        head = null;
        tail = null;
    }

    public Node getHead() { return head;}
    public Node getTail() { return tail;}

    public boolean isEmpty() {
        return head == null;
    }

    public Object getFirst() throws GeneralExceptions{
        if(head == null) throw new GeneralExceptions("List is empty");
        return head.data;
    }
    public Object getLast() throws GeneralExceptions{
        if(tail == null) throw new GeneralExceptions("List is empty");
        return tail.data;
    }

    public void prepand(Object data) {
        Node newNode = new Node(data);
        if(head == null) {
            tail = newNode;
        }
        head = newNode;
    }
    public void append(Object data) {
        Node newNode = new Node(data);
        //if(tail = null)
    }
}

