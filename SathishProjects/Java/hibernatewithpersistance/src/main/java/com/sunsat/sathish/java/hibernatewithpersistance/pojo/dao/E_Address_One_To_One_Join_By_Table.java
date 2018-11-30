package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "e_address_one_to_one_join_by_table")
public class E_Address_One_To_One_Join_By_Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "street_name")
    private String street;

    @Column(name = "city_name")
    private String city;

    @Column(name = "state_name")
    private String state;

    @Column(name = "zipcode")
    private String zipcode;

    @OneToOne(fetch = FetchType.LAZY, orphanRemoval =false, optional = true)
    @Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "E_EMPLOYEE_ADDRESS_ONE_TO_ONE_JOIN_BY_TABLE",
            joinColumns = @JoinColumn(name = "address_id",nullable = true),
            inverseJoinColumns = @JoinColumn(name = "emp_id",nullable = true))
    protected E_Employee_One_To_One_Join_By_Table e_employee;

    public E_Address_One_To_One_Join_By_Table() {}

    public E_Address_One_To_One_Join_By_Table(String street, String city, String state, String zipcode, E_Employee_One_To_One_Join_By_Table empl) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.e_employee = empl;
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

    public E_Employee_One_To_One_Join_By_Table getE_employee() {
        return e_employee;
    }

    public void setE_employee(E_Employee_One_To_One_Join_By_Table e_employee) {
        this.e_employee = e_employee;
    }

    @Override
    public String toString() {
        return "E_Address_One_To_One_Join_By_Table{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", e_employee=" + e_employee +
                '}';
    }
}
