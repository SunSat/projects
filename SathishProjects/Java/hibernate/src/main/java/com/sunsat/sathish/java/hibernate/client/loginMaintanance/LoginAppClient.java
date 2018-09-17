package com.sunsat.sathish.java.hibernate.client.loginMaintanance;

import com.sunsat.sathish.java.hibernate.loginMaintanance.dao.LoginSoruceDao;
import com.sunsat.sathish.java.hibernate.loginMaintanance.dao.UserNameDao;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel.LoginSourceModel;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.daoModel.UserNameModel;
import com.sunsat.sathish.java.hibernate.loginMaintanance.pojo.serviceModel.UserNameService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

/**
 * Created by sathishkumar_su on 5/4/2018.
 */
public class LoginAppClient {

    public static void main(String[] args) {
        Properties prop = System.getProperties();
        for(String st : prop.stringPropertyNames()) {
            System.out.println(st + "  - " + prop.getProperty(st));
        }
        Configuration cfg = new Configuration();
        cfg.configure("loginMaintanance.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        UserNameDao dao = new UserNameDao(factory);
        UserNameService uNameService = new UserNameService("sathish2","kumar1");
        dao.add(uNameService);

        UserNameModel unameModel = dao.getByName(new UserNameService("sathish1",""));
        System.out.println("The Uname first 11 -- "+unameModel);

        uNameService.setId(unameModel.getId());
        unameModel = dao.getById(uNameService);

        System.out.println("The new Uname is : 22--" + unameModel);

        LoginSourceModel loginModel = new LoginSourceModel();

        loginModel.setLoginSource("twitter");
        loginModel.setDelete(0);
        loginModel.setSourceUserName("saathis_sat");
        loginModel.setUserModel(unameModel);

        LoginSoruceDao loginDao = new LoginSoruceDao(factory);
        loginDao.add(loginModel);

        System.out.println("The Login Model is 333 -" +loginDao.get(loginModel));

    }
}
