package com.sunsat.sathish.java.hibernate.loginMaintanance.dao;

import com.sunsat.sathish.java.hibernate.exception.LoginDaoException;
import com.sunsat.sathish.java.hibernate.exception.LoginException;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel.AbstractBaseModel;

/**
 * Created by sathishkumar_su on 5/6/2018.
 */
public interface BaseDao<T extends AbstractBaseModel> {

    public void add(T t) throws LoginDaoException;
    public T getById(T t)throws LoginDaoException;
    public void updateByid(T t) throws LoginDaoException;
    public void delete(T t) throws LoginException;

}
