package com.sunsat.sathish.j2ee.loginapp.login.pojo.model;

/**
 * Created by anitha on 5/1/2018.
 */
/*
  `id` INT NOT NULL,
  `userid` INT NULL,
  `first_name` VARCHAR(25) NULL,
  `last_name` VARCHAR(25) NULL,
  `gender` VARCHAR(10) NULL,
  `dob` VARCHAR(25) NULL,
  `mobile` VARCHAR(15) NULL,
  `mail` VARCHAR(45) NULL,

 */
public class PersonalDetailsModel {
    int id;
    int userId;
    String firstName;
    String lastName;
    String gender;
    String dob;
    String mobile;
    String mail;
}
