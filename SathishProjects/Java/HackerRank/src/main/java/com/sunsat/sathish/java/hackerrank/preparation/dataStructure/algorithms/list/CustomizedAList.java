package com.sunsat.sathish.java.hackerrank.preparation.dataStructure.algorithms.list;

/**
 * Created by ssundar2 on 5/2/2017.
 */
public class CustomizedAList<T> implements CustomizedList<T> {

    Object[] elementData = null;
    Object[] defaultEmptyArray = {};
    int position = -1;
    int currentLength = -1;
    int defaultSize = 10;
    int maxLength = Integer.MAX_VALUE - 8;

    public CustomizedAList(int size) throws RuntimeException {
        if(size < 0 || size > maxLength) {
            throw new IllegalArgumentException("Not a valid Size");
        }
        if(size > 0) {
            elementData = new Object[size];
            currentLength = size;
        } else if(size == 0) {
            elementData = new Object[defaultSize];
            currentLength = defaultSize;
        }
    }

    public CustomizedAList() {
        elementData = defaultEmptyArray;
        currentLength = defaultEmptyArray.length;
    }

    @Override
    public void add(T t) {
        ensureInternalCapasity();
        elementData[++position] = t;
    }

    @Override
    public void add(int index, T t) {
        ensureInternalCapasity();
        System.arraycopy(elementData,index,elementData,index+1,elementData.length - index);
        elementData[index] = t;
        ++position;
    }

    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        if(index < -1 && index > elementData.length ) {
            throw new IndexOutOfBoundsException();
        }
        return (T)elementData[index];
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
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int length() {
        return 0;
    }

    protected void ensureInternalCapasity() {
        if(position >= currentLength-1) {
            int newLength = elementData.length * 2;
            if(newLength > maxLength) {
                if(elementData.length >= maxLength) {
                    throw new RuntimeException("List cannot be grow more then max length of " + maxLength);
                }
                newLength = maxLength;
            }
            Object[] newElement = new Object[newLength];
            System.arraycopy(elementData,0,newElement,0,elementData.length);
            currentLength = newLength;
            elementData = newElement;
        }
    }
}
