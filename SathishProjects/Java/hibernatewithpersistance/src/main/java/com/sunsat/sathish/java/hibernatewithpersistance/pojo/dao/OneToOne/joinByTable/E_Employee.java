package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToOne.joinByTable;

import javax.persistence.*;
import java.util.Objects;

/**
 CREATE TABLE `003_e_employee_onetoone_join_by_table`
 (
 `id`         int(11) NOT NULL AUTO_INCREMENT,
 `first_name` varchar(20) DEFAULT NULL,
 `last_name`  varchar(20) DEFAULT NULL,
 `salary`     int(11)     DEFAULT NULL,
 PRIMARY KEY (`id`)
 ) ENGINE = InnoDB
 AUTO_INCREMENT = 27
 DEFAULT CHARSET = utf8

 CREATE TABLE `003_employee_address_link_onetoone_join_by_table` (
 `id` int(10) NOT NULL AUTO_INCREMENT,
 `e_employee_id` int(10) DEFAULT NULL,
 `e_address_id` int(10) DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `003_employee_address_link_onetoone_to_003_e_address_fk` (`e_address_id`),
 KEY `003_employee_address_link_to_003_e_employee` (`e_employee_id`),
 CONSTRAINT `003_employee_address_link_onetoone_to_003_e_address_fk` FOREIGN KEY (`e_address_id`) REFERENCES `003_e_address_onetoone_join_by_table` (`id`),
 CONSTRAINT `003_employee_address_link_to_003_e_employee` FOREIGN KEY (`e_employee_id`) REFERENCES `003_e_employee_onetoone_join_by_table` (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8


 */
@Entity
@Table(name = "003_e_employee_onetoone_join_by_table")
public class E_Employee{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="salary")
    private int salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "003_employee_address_link_onetoone_join_by_table",
    joinColumns = @JoinColumn(name = "e_employee_id") ,
    inverseJoinColumns = @JoinColumn(name = "e_address_id"))
   private E_Address address;

    public E_Address getAddress() {
        return address;
    }

    public void setAddress(E_Address address) {
        this.address = address;
    }

    public E_Employee() {}

    public E_Employee(String fname, String lname, int salary) {
        this.firstName = fname;
        this.lastName = lname;
        this.salary = salary;
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
        E_Employee that = (E_Employee) o;
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