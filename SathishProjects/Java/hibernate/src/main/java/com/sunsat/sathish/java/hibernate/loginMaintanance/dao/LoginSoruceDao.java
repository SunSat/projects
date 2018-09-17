package com.sunsat.sathish.java.hibernate.loginMaintanance.dao;

import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel.LoginSourceModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Created by sathishkumar_su on 5/4/2018.
 */
public class LoginSoruceDao {

    SessionFactory factory;

    public LoginSoruceDao(SessionFactory factory) {
        this.factory = factory;
    }

    public void add(LoginSourceModel lm) {
        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();
        ses.save(lm);
        tx.commit();
    }

    public LoginSourceModel get(LoginSourceModel lm) {
        Session ses = factory.openSession();
        ses.beginTransaction();
        return ses.get(LoginSourceModel.class,lm.getId());
    }
}
