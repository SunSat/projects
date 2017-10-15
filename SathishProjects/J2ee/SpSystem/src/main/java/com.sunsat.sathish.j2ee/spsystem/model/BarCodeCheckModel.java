package com.sunsat.sathish.j2ee.spsystem.model;

import org.springframework.context.annotation.Scope;

/**
 * Created by ssundar2 on 29-03-2017.
 */
@Scope("prototype")
public class BarCodeCheckModel {

    private String barcodeid;
    private String type;

    public String getBarcodeid() {
        return barcodeid;
    }

    public void setBarcodeid(String barcodeid) {
        this.barcodeid = barcodeid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
