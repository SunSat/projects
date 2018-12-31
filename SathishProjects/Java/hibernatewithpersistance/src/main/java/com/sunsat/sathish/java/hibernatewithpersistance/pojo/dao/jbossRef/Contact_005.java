package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.jbossRef;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.net.URL;

@Entity(name = "005_contact")
public class Contact_005 {

    @Id
    private Integer id;
    private Name name;
    private String notes;
    private URL website;
    private Boolean starred;

}

@Embeddable
class Name {
    private String first;
    private String last;
    private String middle;
}
