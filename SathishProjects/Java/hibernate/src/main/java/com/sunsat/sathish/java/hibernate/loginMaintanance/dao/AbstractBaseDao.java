package com.sunsat.sathish.java.hibernate.loginMaintanance.dao;

import com.sunsat.sathish.java.hibernate.exception.LoginDaoException;
import com.sunsat.sathish.java.hibernate.exception.LoginException;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel.AbstractBaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by sathishkumar_su on 5/4/2018.
 */
public abstract class AbstractBaseDao<T extends AbstractBaseModel> implements BaseDao<T> {

    protected SessionFactory daoFactory;

    public AbstractBaseDao() {
    }


    public AbstractBaseDao(SessionFactory factory) {
        this.daoFactory = factory;
    }

    public void setDaoFactory(SessionFactory factory) {
        this.daoFactory = factory;
    }


    public SessionFactory getDaoFactory() {
        return daoFactory;
    }


    @Override
    public void add(T t) throws LoginDaoException {
        Session session = daoFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(t);
        tx.commit();
        session.close();
    }

    @Override
    public T getById(T t) throws LoginDaoException {
        Session session = daoFactory.openSession();
        Transaction tx = session.beginTransaction();
        T obj = (T) session.get(t.getClass(),t.getId());
        session.close();
        return obj;
    }

    @Override
    public void updateByid(T t) throws LoginDaoException {
        Session ses = daoFactory.openSession();
        Transaction tx = ses.beginTransaction();
        ses.saveOrUpdate(t);
        tx.commit();
        ses.close();
    }

    @Override
    public void delete(T t) throws LoginException {
        Session ses = daoFactory.openSession();
        Transaction tx = ses.beginTransaction();
        ses.delete(t.getClass().getName(), t);
        tx.commit();
    }
}
