package com.sunsat.sathish.java.hibernate.dao.impl;

import com.sunsat.sathish.java.hibernate.dao.StudentDaoIntf;

import java.util.List;
import java.util.Map;

/**
 * Created by sathishkumar_su on 12/18/2017.
 */
public class StudentDaoImpl<T> implements StudentDaoIntf<T> {

    @Override
    public int add(T t) {
        return 0;
    }

    @Override
    public List<Integer> add(List<T> liObj) {
        return null;
    }

    @Override
    public int update(T t) {
        return 0;
    }

    @Override
    public Map<Integer, Boolean> update(List<T> liObj) {
        return null;
    }

    @Override
    public boolean delete(T t) {
        return false;
    }

    @Override
    public Map<Integer, Boolean> delete(List<T> liObj) {
        return null;
    }
}
