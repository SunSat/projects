package com.sunsat.sathish.j2ee.loginapp.pojo.model;

import java.io.Serializable;

/**
 * Created by anitha on 5/1/2018.
 */
public abstract class AbstractModel<T> implements Serializable {

    public abstract Class<T> getModelClassName();

}
