package com.sunsat.sathish.java.hibernatewithpersistance.client;

import com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.*;
import org.hibernate.internal.build.AllowSysOut;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Properties;

public class HelloWorldJPA {

    public static void main(String[] args) {
        Properties prop = System.getProperties();
        for(Object st : prop.keySet()) {
            System.out.println(st + " : " + prop.getProperty((String)st));
        }

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistanceWithHibernate");
        EntityManager mgr = emf.createEntityManager();
        mgr.getTransaction().begin();

        /*String sqlCountQuery  = "select count(*) from message m";
        BigInteger countOfMsg = (BigInteger)mgr.createNativeQuery(sqlCountQuery).getSingleResult();

        System.out.println(countOfMsg);
        Message msg = new Message();
        msg.setMessage("Hello WOrld I am " + (1));
        mgr.getTransaction().begin();
        mgr.persist(msg);
        mgr.getTransaction().commit();
        String sqlQuery  = "select * from message m";
        List<Message> listMsg = mgr.createNativeQuery(sqlQuery, Message.class).getResultList();

        for(Message msg1 : listMsg) {
            System.out.println(msg1);
        }

        mgr.getTransaction().begin();
        Message m12 = listMsg.get(3);
        m12.setMessage("I am going to replace this one.");
        mgr.getTransaction().commit();
        */

        /*Billing bil = new Billing();
        mgr.getTransaction().begin();
        bil.setOwner("Sathish");
        mgr.persist(bil);

        BankAccount acc = new BankAccount();
        acc.setAccount(1);
        acc.setBankName("HDFC");
        acc.setShift("monring");
        acc.setBill(bil);
        mgr.persist(acc);
        mgr.getTransaction().commit();*/


        /****************************************************************************/
        /**
         * This Section for E_Employee Join Columns by forigen key relationship.
         * @JoinColumn(name="column_name") is enough.
         */

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

        System.out.println("The new Address Id is : " + add.getId());

        E_Address address =  mgr.find(E_Address.class,15);
        System.out.println(address);
        System.out.println(address.getE_employee());

        E_Employee emp1 = address.getE_employee();
        emp1.setSalary(5000);

        /**************************************************************************/

        /***************************************************************************/
        /**
         * This section is for Join By Table. Employee & Address Table has EMP_ID, ADD_ID as prikary key respectively.
         * Not introducing new table called E_EMPLOYEE_ADDRESS_ONE_ONE_TO_JOIN_BY_TABLE.
         */

/*
        E_Employee_One_To_One_Join_By_Table emp = new E_Employee_One_To_One_Join_By_Table("sathish","kumar",1000,null);
        E_Address_One_To_One_Join_By_Table add = new E_Address_One_To_One_Join_By_Table("chennai","tamil","hello","999",emp);
        emp.setAddress(add);

        mgr.persist(add);
        mgr.persist(emp);

        E_Employee_One_To_One_Join_By_Table emp1 = mgr.find(E_Employee_One_To_One_Join_By_Table.class,4);

        System.out.println("The Employee is :::: " + emp1);
        System.out.println("The Address is :::: " + emp1.getAddress());
*/
        mgr.getTransaction().commit();
        mgr.clear();
        emf.close();
    }
}
