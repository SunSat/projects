package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToOne.joinByTable;

import com.sunsat.sathish.java.hibernatewithpersistance.PersistanceMgr;

import javax.persistence.EntityManager;

public class OneToOneSharedPkUniDirection {

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
        mgr.persist(add);

        add.setEmployee(emp);
        emp.setAddress(add);

        System.out.println("The new Address Id is : " + emp.getId());

        E_Employee emp1 =  mgr.find(E_Employee.class,emp.getId());
        System.out.println("THe 344444 : " + emp1);
        System.out.println("The 555555 : "+emp1.getAddress());
        System.out.println("The 666666 : " + emp1.getAddress().getEmployee());

        mgr.getTransaction().commit();

        PersistanceMgr.closeMgrFactory(mgr);
        System.out.println("From UNIdirection - Start");
    }
}
