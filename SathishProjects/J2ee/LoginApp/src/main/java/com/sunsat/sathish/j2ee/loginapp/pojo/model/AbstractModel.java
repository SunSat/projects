package com.sunsat.sathish.j2ee.loginapp.pojo.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by anitha on 5/1/2018.
 */
public abstract class AbstractModel<T> implements Serializable {

    public abstract Class<T> getModelClassName();

    private Long uniqueId = 0l;
    private Date createdDt;
    private String createdBy;
    private Date modifiedDt;
    private String modifiedBy;


    public Long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(Long uniqueId) {
        this.uniqueId = uniqueId;
    }
}
