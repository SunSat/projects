package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.list;

/**
 * Created by ssundar2 on 5/2/2017.
 */
public interface CustomizedList<T> {
    public void add(T t);
    public void add(int index, T t);
    public T get(int index);
    public T getOrDefault(int index, T t);
    public T delete(int index);
    public int delete(T t);
    public T replace(int index, T t);
    public int findPosition(T t);
    public boolean contains(T t);
    public void clear();
    public int length();
}
