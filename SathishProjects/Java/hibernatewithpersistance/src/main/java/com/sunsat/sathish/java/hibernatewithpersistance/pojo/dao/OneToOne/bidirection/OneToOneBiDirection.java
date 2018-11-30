package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToOne.bidirection;

import com.sunsat.sathish.java.hibernatewithpersistance.PersistanceMgr;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class OneToOneBiDirection {

    public static void main(String[] args) {
        System.out.println("From bidirection - Start");
        EntityManager mgr = PersistanceMgr.getManager();

        mgr.getTransaction().begin();
        E_Employee emp = new E_Employee("sathish","kumar",1000);
        mgr.persist(emp);

        System.out.println("The new Emplyee Id is : " + emp.getId());

        E_Address add = new E_Address();
        add.setState("TN");
        add.setStreet("Chennai");
        add.setZipcode("632601");
        add.setCity("chennai");
        add.setE_employee(emp);
        mgr.persist(add);

        add.setE_employee(emp);

        System.out.println("The new Address Id is : " + add.getId());

        E_Address address =  mgr.find(E_Address.class,15);
        System.out.println(address);
        System.out.println(address.getE_employee());
        E_Employee emp1 = address.getE_employee();
        emp1.setSalary(5000);

        System.out.println("The Bidirection is Address From EMP : " + emp1.getAddress());
        System.out.println("The Bidirection is Emp From Address: " + emp1.getAddress().getE_employee());

        mgr.getTransaction().commit();

        PersistanceMgr.closeMgrFactory(mgr);
        System.out.println("From bidirection - Start");
    }
}
