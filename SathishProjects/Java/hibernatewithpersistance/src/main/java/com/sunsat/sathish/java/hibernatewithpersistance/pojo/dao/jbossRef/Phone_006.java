package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.jbossRef;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity(name = "006_PHONE")
public class Phone_006 {
    @Id
    private Integer id;
    private String numb;

    @Enumerated(EnumType.ORDINAL)
    private PhoneType phType;
}

enum PhoneType {
    LAN_LINE,MOBILE
}
