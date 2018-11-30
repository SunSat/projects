package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToOne.bidirection;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "001_e_address_onetoone_fk")
public class E_Address {

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

    @OneToOne(mappedBy = "address")
    protected E_Employee e_employee;

    public E_Address() {}

    public E_Address(String street, String city, String state, String zipcode, E_Employee empl) {
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

    public E_Employee getE_employee() {
        return e_employee;
    }

    public void setE_employee(E_Employee employee) {
        this.e_employee = employee;
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
                Objects.equals(zipcode, e_address.zipcode) &&
                Objects.equals(e_employee, e_address.e_employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, state, zipcode, e_employee);
    }

    @Override
    public String toString() {
        return "E_Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", employee=" + e_employee +
                '}';
    }
}
