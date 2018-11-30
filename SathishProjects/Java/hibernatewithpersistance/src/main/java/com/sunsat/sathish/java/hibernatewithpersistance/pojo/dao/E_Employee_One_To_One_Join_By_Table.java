package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "e_employee_one_to_one_join_by_table")
public class E_Employee_One_To_One_Join_By_Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="salary")
    private int salary;

    @OneToOne(mappedBy = "e_employee", fetch = FetchType.LAZY)
    E_Address_One_To_One_Join_By_Table address;

    public E_Address_One_To_One_Join_By_Table getAddress() {
        return address;
    }

    public void setAddress(E_Address_One_To_One_Join_By_Table address) {
        this.address = address;
    }

    public E_Employee_One_To_One_Join_By_Table() {}

    public E_Employee_One_To_One_Join_By_Table(String fname, String lname, int salary, E_Address_One_To_One_Join_By_Table address) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String first_name ) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String last_name ) {
        this.lastName = last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary( int salary ) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        E_Employee_One_To_One_Join_By_Table that = (E_Employee_One_To_One_Join_By_Table) o;
        return id == that.id &&
                salary == that.salary &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, salary);
    }

    @Override
    public String toString() {
        return "E_Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}