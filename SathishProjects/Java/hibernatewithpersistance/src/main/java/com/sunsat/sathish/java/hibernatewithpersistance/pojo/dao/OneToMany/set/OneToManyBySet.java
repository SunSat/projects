package com.sunsat.sathish.java.hibernatewithpersistance.pojo.dao.OneToMany.set;

import com.sunsat.sathish.java.hibernatewithpersistance.PersistanceMgr;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class OneToManyBySet {

    public static void main(String[] args) {
        EntityManager mgr = PersistanceMgr.getManager();

        mgr.getTransaction().begin();
        City city = new City();
        city.setName("London");
        mgr.persist(city);

/*        List<Street> allStreet = new ArrayList<Street>(4);

        Street st1 = new Street();
        st1.setStreetName("Sample1");
        st1.setCity(city);
        mgr.persist(st1);
        allStreet.add(st1);

        Street st2 = new Street();
        st2.setStreetName("Sample2");
        st2.setCity(city);
        mgr.persist(st2);
        allStreet.add(st2);


        Street st3 = new Street();
        st3.setStreetName("Sample3");
        st3.setCity(city);
        mgr.persist(st3);
        allStreet.add(st3);


        Street st4 = new Street();
        st4.setStreetName("Sample4");
        st4.setCity(city);
        mgr.persist(st4);
        allStreet.add(st4);

        city.setStreetList(allStreet);

        */
        mgr.getTransaction().commit();

        City cityfound = mgr.find(City.class,city.getId());
        System.out.println("Hello List : 11111" + cityfound);

        List<String> stFoundList = cityfound.getStreetList();
        for(String street : stFoundList) {
            System.out.println(street);
        }
        PersistanceMgr.closeEntityManager(mgr);
    }
}
