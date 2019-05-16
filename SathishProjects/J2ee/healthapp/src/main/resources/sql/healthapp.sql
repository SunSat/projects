

USE DATABASE 'healthapp';

drop procedure if exists `sp_verify_login`;
delimiter $$;
create procedure sp_verify_login(IN user varchar(50),
                                 IN pass varchar(500),
                                 OUT message varchar(100),
                                 OUT userid bigint(10))
BEGIN
  DECLARE existUname varchar(250);
  DECLARE existPass varchar(550);
  DECLARE existId bigint(10);
  DECLARE accCount TINYINT;
  SELECT ID,USERNAME,PASSWORD,count(USERNAME) INTO existId,existUname,existPass,accCount FROM USER WHERE USERNAME = user;
  IF accCount <= 0 THEN
    SET message = "Invalid username Or username not available.";
  ELSEIF existPass = pass THEN
    SET userid = existId;
    SET message = "successful";
  ELSE
    SET message = "invalid username or password.";
  END IF;
END $$;
DELIMITER ;

CREATE TABLE `user` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(500) DEFAULT NULL,
  `password_hash` varchar(500) DEFAULT NULL,
  `creation_time` datetime DEFAULT NULL,
  `expiry_time` datetime DEFAULT NULL,
  `account_status` varchar(20) DEFAULT NULL,
  `deleted` tinyint(1) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` bigint(10) DEFAULT NULL,
  `modified_date` datetime DEFAULT NULL,
  `modified_by` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

CREATE TABLE `communication` (
 `id` bigint(10) NOT NULL AUTO_INCREMENT,
 `user_id` bigint(10) NOT NULL,
 `mob1` varchar(15) DEFAULT NULL,
 `is_mob1_verified` tinyint(1) DEFAULT NULL,
 `mob1_cnf_token` int(11) DEFAULT NULL,
 `mob1_cnf_token_expiry_date` datetime DEFAULT NULL,
 `email1` varchar(50) DEFAULT NULL,
 `is_email1_verified` tinyint(1) DEFAULT NULL,
 `email1_cnf_token` int(11) DEFAULT NULL,
 `email1_cnf_token_expiry_date` datetime DEFAULT NULL,
 `created_date` date DEFAULT NULL,
 `created_by` mediumtext,
 `modified_date` date DEFAULT NULL,
 `modified_by` mediumtext,
 `deleted` tinyint(1) DEFAULT NULL,
 `message` varchar(100) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `communication_id_uindex` (`user_id`),
 CONSTRAINT `communication_To_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `login` (
 `id` bigint(10) NOT NULL AUTO_INCREMENT,
 `user_id` bigint(10) NOT NULL,
 `login_time` varchar(30) DEFAULT NULL,
 `logout_time` varchar(30) DEFAULT NULL,
 `status` varchar(50) DEFAULT NULL,
 `message` varchar(255) DEFAULT NULL,
 `created_date` timestamp NULL DEFAULT NULL,
 `created_by` bigint(10) DEFAULT NULL,
 `modified_date` timestamp NULL DEFAULT NULL,
 `modified_by` bigint(10) DEFAULT NULL,
 `deleted` tinyint(1) DEFAULT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY `login_id_uindex` (`user_id`),
 CONSTRAINT `login_to_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `personaldetail` (
 `id` bigint(10) NOT NULL AUTO_INCREMENT,
 `user_id` bigint(10) DEFAULT NULL,
 `firstname` varchar(50) DEFAULT NULL,
 `lastname` varchar(50) DEFAULT NULL,
 `gender` tinyint(4) DEFAULT NULL,
 `dob` date DEFAULT NULL,
 `address1` varchar(250) DEFAULT NULL,
 `address2` varchar(250) DEFAULT NULL,
 `city` varchar(200) DEFAULT NULL,
 `district` varchar(100) DEFAULT NULL,
 `state` varchar(250) DEFAULT NULL,
 `country` varchar(100) DEFAULT NULL,
 `pincode` int(11) DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `personaldetail_user_id_fk` (`user_id`),
 CONSTRAINT `personaldetail_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
 `id` bigint(10) NOT NULL AUTO_INCREMENT,
 `rolename` varchar(100) DEFAULT NULL,
 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `userrolelink` (
 `id` bigint(10) NOT NULL AUTO_INCREMENT,
 `user_id` bigint(10) DEFAULT NULL,
 `role_id` bigint(10) DEFAULT NULL,
 PRIMARY KEY (`id`),
 KEY `userrolelink_roles_id_fk` (`role_id`),
 KEY `userrolelink_user_id_fk` (`user_id`),
 CONSTRAINT `userrolelink_roles_id_fk` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
 CONSTRAINT `userrolelink_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;