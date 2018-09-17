package com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel;

/**
 * Created by sathishkumar_su on 5/11/2018.
 */
public abstract class AbstractBaseService {

    private int id;

    public AbstractBaseService() {

    }

    public AbstractBaseService(int id) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
