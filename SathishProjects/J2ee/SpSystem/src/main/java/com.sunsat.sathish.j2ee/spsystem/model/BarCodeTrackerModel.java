package com.sunsat.sathish.j2ee.spsystem.model;

import org.springframework.context.annotation.Scope;

import java.util.Date;

/**
 * Created by ssundar2 on 28-03-2017.
 */

@Scope("prototype")
public class BarCodeTrackerModel {

    private int barcodeId;
    private String type;
    private Date createdDate;
    private String status;
    private String isRejected;
    private int count;
    private String message;


}
