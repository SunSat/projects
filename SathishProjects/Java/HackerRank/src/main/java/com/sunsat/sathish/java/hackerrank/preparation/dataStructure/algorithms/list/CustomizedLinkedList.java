package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.list;

/**
 * Created by ssundar2 on 5/3/2017.
 */
public class CustomizedLinkedList<T> implements CustomizedLinkList<T> {

    protected class Node<T> {
        T t;
        Node<T> next = null;
        Node(T t)
        {
            this.t = t;
        }
    }

    protected Node<T> head;
    protected Node<T> tail;

    public CustomizedLinkedList() {

    }

    @Override
    public void add(T t) {
        Node<T> n = new Node<T>(t);
        if(head == null) {
            head = tail = n;
        }
        tail.next = n;
        tail = n;
    }

    @Override
    public void add(int index, T t) {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getOrDefault(int index, T t) {
        return null;
    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public int delete(T t) {
        return 0;
    }

    @Override
    public T replace(int index, T t) {
        return null;
    }

    @Override
    public int findPosition(T t) {
        return 0;
    }

    @Override
    public boolean contains(T t) {
        boolean contains = false;
        Node<T> traverseNode = head;
        if(traverseNode == null) return  contains;
        do {
            if(traverseNode.t.equals(t)) {
                contains = true;
                break;
            }
            traverseNode = traverseNode.next;
        } while(traverseNode != null);
        return contains;
    }

    @Override
    public void clear() {

    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public void addToHead(T t) {
        Node<T> node = new Node<>(t);
        if(head == null) head = tail = node;
        node.next = head;
        head = node;
    }

    @Override
    public void addToTail(T t) {

    }
}
