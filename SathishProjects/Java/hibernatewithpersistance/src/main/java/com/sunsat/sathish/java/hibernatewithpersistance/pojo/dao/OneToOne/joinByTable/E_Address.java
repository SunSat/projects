package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToOne.joinByTable;

import javax.persistence.*;
import java.util.Objects;

/**
 CREATE TABLE `003_e_address_onetoone_join_by_table`
 (
 `id`          int(11) NOT NULL AUTO_INCREMENT,
 `street_name` varchar(40) DEFAULT NULL,
 `city_name`   varchar(40) DEFAULT NULL,
 `state_name`  varchar(40) DEFAULT NULL,
 `zipcode`     varchar(10) DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE = InnoDB
 DEFAULT CHARSET = utf8

 */
@Entity
@Table(name = "003_e_address_onetoone_join_by_table")
public class E_Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "street_name")
    private String street;

    @Column(name = "city_name")
    private String city;

    @Column(name = "state_name")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private E_Employee employee;

    public E_Employee getEmployee() {
        return employee;
    }

    public void setEmployee(E_Employee employee) {
        this.employee = employee;
    }

    public E_Address() {}

    public E_Address(String street, String city, String state, String zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet( String street ) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity( String city ) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState( String state ) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode( String zipcode ) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_Address e_address = (E_Address) o;
        return id == e_address.id &&
                Objects.equals(street, e_address.street) &&
                Objects.equals(city, e_address.city) &&
                Objects.equals(state, e_address.state) &&
                Objects.equals(zipcode, e_address.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, state, zipcode);
    }

    @Override
    public String toString() {
        return "E_Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}
