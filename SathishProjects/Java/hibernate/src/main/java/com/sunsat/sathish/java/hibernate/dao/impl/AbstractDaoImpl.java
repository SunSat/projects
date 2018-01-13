package com.sunsat.sathish.java.hibernate.dao.impl;

import com.sunsat.sathish.java.hibernate.dao.AbstractDaoIntf;
import com.sunsat.sathish.java.hibernate.dao.factory.DaoFactory;
import com.sunsat.sathish.java.hibernate.model.AbstractDaoModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by sathishkumar_su on 12/18/2017.
 */
public class AbstractDaoImpl<T> implements AbstractDaoIntf<T> {

    SessionFactory factory = null;

    public AbstractDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }

    public AbstractDaoImpl() {
        this.factory = DaoFactory.getInstance().getFactory();
    }

    @Override
    public int add(T t) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Integer id = (Integer) session.save((AbstractDaoModel) t);
        tx.commit();
        return id;
    }

    @Override
    public List<Integer> add(List<T> liObj) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List<Integer> al =  new ArrayList<Integer>();
        for(T t : liObj) {
            al.add((Integer)session.save((AbstractDaoModel)t));
        }
        tx.commit();
        return al;
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
