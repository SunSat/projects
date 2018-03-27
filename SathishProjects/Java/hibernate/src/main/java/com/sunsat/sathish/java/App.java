package com.sunsat.sathish.java;

import com.sunsat.sathish.java.hibernate.dao.AbstractDaoIntf;
import com.sunsat.sathish.java.hibernate.dao.factory.DaoFactory;
import com.sunsat.sathish.java.hibernate.dao.impl.AbstractDaoImpl;
import com.sunsat.sathish.java.hibernate.model.PersonalDaoModel;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        PersonalDaoModel stuModel = new PersonalDaoModel();
        stuModel.setFirstName("Anitha");
        stuModel.setLastName("Sathish");
        stuModel.setAddress1("187/52");
        stuModel.setAddress2("HelloGood");
        stuModel.setCity("Chennai");
        stuModel.setDob(new Date());
        stuModel.setGender("male");
        stuModel.setMailId("sundar.sat@gmail.com");
        stuModel.setMobile("8754408431");
        stuModel.setState("Tamil Nadu");

        AbstractDaoIntf<PersonalDaoModel> studentDao = new AbstractDaoImpl<PersonalDaoModel>(DaoFactory.getInstance().getFactory());
        studentDao.add(stuModel);
    }
}
