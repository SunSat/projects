package com.sunsat.sathish.j2ee.loginapp.login.pojo.model;

/**
 * Created by anitha on 5/1/2018.
 */

/*
  `id` INT NOT NULL,
  `userid` INT NULL,
  `login_source` VARCHAR(20) NULL,
  `source_user_name` VARCHAR(50) NULL,
  `delete` TINYINT(1) NULL,
 */
public class LoginSourceModel {
    int id;
    int userId;
    String loginSource;
    String sourceUserName;
}
