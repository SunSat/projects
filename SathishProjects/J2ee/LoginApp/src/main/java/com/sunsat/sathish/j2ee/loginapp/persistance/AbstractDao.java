package com.sunsat.sathish.j2ee.loginapp.persistance;

import com.sunsat.sathish.j2ee.loginapp.pojo.model.AbstractModel;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by anitha on 5/1/2018.
 */
public class AbstractDao<pk extends AbstractModel, T> {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public T getByKey(pk key) {
        return (T)getSession().get(key.getModelClassName(),key);
    }

}
