package com.sunsat.sathish.java.hackerrank.preparation.ideserv.LinkedList;

import java.io.Closeable;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by ssundar2 on 5/28/2017.
 */
public class SingleLinkedList<T> implements Cloneable {

    protected  class Node<T> {
        protected T val;
        protected Node<T> next;
        Node(T v) {
            this.val = v;
        }

        public T getVal() {
            return val;
        }

        public void setVal(T val) {
            this.val = val;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    protected Node<T> head = null;
    protected Node<T> tail = null;
    protected Comparator<T> comprator = null;

    protected int compare(T t1,T t2) {
        return comprator == null ? ((Comparable)t1).compareTo(t2) : comprator.compare(t1,t2);
    }

    public void add(T val) {
        Node<T> temp = new Node<>(val);
        if(head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
    }

    public  boolean addAfter(T val,T after) {
        boolean isInserted = false;
        Node<T> temp = head;
        while (temp != null) {
            if(compare(temp.val,after) == 0) {
                Node<T> newNode = new Node<>(val);
                newNode.next = temp.next;
                temp.next = newNode;
                isInserted = true;
                break;
            }
        }
        return isInserted;
    }

    public void addFirst(T val) {
        Node temp1 = new Node(val);
        if(head == null) {
            head = tail = temp1;
        }
        else {
            temp1.next = head;
            head = temp1;
        }
    }

    public void addLast(T val) {
       add(val);
    }

    public T deleteFirst() {
        T t = null;
        if(head == null) {
            throw new NoSuchElementException();
        }
            if(head == tail) {
                t = head.val;
                head.val = null;
                head = tail = null;
            } else {
                t = head.val;
                head.val = null;
                head = head.next;
            }
        return t;
    }

    public T deleteLast() {
        T t = null;
        if(head == null) {
            throw new NoSuchElementException();
        }
        if(head == tail) {
            t = head.val;
            head = tail = null;
        } else {
            Node<T> temp1 = head;
            while(temp1.next != tail) {
                temp1 = temp1.next;
            }
            t = temp1.val;
            tail.val = null;
            tail = temp1;
            tail.next = null;
        }
        return t;
    }
    public boolean delete(T val) {
        boolean isDeleted = false;
        if(head == null) {
            throw new NoSuchElementException();
        } else if(head == tail) {
            if(compare(val, head.val) == 0) {
                head.val = null;
                head = tail = null;
                isDeleted = true;
            } else {
                isDeleted = false;
            }
        } else {
            if(compare(val,head.val) == 0) {
                head.val = null;
                head = head.next;
            } else {
                Node<T> temp = head;
                while(temp.next != null) {
                    if(compare(val,temp.next.val) == 0) {
                        temp = temp.next.next;
                        isDeleted = true;
                        break;
                    }
                }
            }
        }
        return isDeleted;
    }

    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.val+ " ");
            temp = temp.next;
        }
        System.out.println();
    }



    public static void main(String[] args) throws CloneNotSupportedException {
        SingleLinkedList<Integer> siLi = new SingleLinkedList<>();
        siLi.add(10);
        siLi.add(20);
        siLi.clone();
    }
}
