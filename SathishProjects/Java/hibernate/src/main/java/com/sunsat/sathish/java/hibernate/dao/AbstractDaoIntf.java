package com.sunsat.sathish.java.hibernate.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by sathishkumar_su on 12/18/2017.
 */
public interface AbstractDaoIntf<T> {
    int add(T t);
    List<Integer> add(List<T> liObj);
    int update(T t);
    Map<Integer,Boolean> update(List<T> liObj);
    boolean delete(T t);
    Map<Integer,Boolean> delete(List<T> liObj);
}
