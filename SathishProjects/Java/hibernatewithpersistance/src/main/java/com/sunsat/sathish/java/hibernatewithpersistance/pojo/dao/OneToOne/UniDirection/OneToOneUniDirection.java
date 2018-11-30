package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToOne.UniDirection;

import com.sunsat.sathish.java.hibernatewithpersistance.PersistanceMgr;

import javax.persistence.EntityManager;

public class OneToOneUniDirection {

    public static void main(String[] args) {
        System.out.println("From Unidirection - Start");
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

        mgr.getTransaction().commit();

        PersistanceMgr.closeMgrFactory(mgr);
        System.out.println("From UNIdirection - Start");
    }
}
