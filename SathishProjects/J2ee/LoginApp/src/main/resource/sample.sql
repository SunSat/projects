create database `loginmaintanance`;
CREATE TABLE `loginmaintanance`.`username` (
  `id` INT NOT NULL,
  `username` VARCHAR(100) NULL,
  `passwod` VARCHAR(100) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

CREATE TABLE `loginmaintanance`.`login_source` (
  `id` INT NOT NULL,
  `userid` INT NULL,
  `login_source` VARCHAR(20) NULL,
  `source_user_name` VARCHAR(50) NULL,
  `delete` TINYINT(1) NULL,
  PRIMARY KEY (`id`),
  INDEX `loginSource_to_UserName_idx` (`userid` ASC),
  CONSTRAINT `loginSource_to_UserName`
    FOREIGN KEY (`userid`)
    REFERENCES `loginmaintanance`.`username` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `loginmaintanance`.`login` (
  `id` INT NOT NULL,
  `userid` INT NULL,
  `loginsourceid` INT NULL,
  `logintime` VARCHAR(25) NULL,
  `logouttime` VARCHAR(25) NULL,
  `status` VARCHAR(25) NULL,
  PRIMARY KEY (`id`),
  INDEX `login_to_username_idx` (`userid` ASC),
  INDEX `login_to_loginSource_idx` (`loginsourceid` ASC),
  CONSTRAINT `login_to_username`
  FOREIGN KEY (`userid`)
  REFERENCES `loginmaintanance`.`username` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `login_to_loginSource`
  FOREIGN KEY (`loginsourceid`)
  REFERENCES `loginmaintanance`.`login_source` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `loginmaintanance`.`personal` (
  `id` INT NOT NULL,
  `userid` INT NULL,
  `first_name` VARCHAR(25) NULL,
  `last_name` VARCHAR(25) NULL,
  `gender` VARCHAR(10) NULL,
  `dob` VARCHAR(25) NULL,
  `mobile` VARCHAR(15) NULL,
  `mail` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `personal_to_username_idx` (`userid` ASC),
  CONSTRAINT `personal_to_username`
  FOREIGN KEY (`userid`)
  REFERENCES `loginmaintanance`.`username` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `loginmaintanance`.`validation` (
  `id` INT NOT NULL,
  `userid` INT NULL,
  `otp_id` INT NULL,
  `otp_password` INT NULL,
  `creation_time` VARCHAR(25) NULL,
  `expiry_time` VARCHAR(25) NULL,
  `status` VARCHAR(10) NULL,
  PRIMARY KEY (`id`),
  INDEX `validation_to_username_idx` (`userid` ASC),
  CONSTRAINT `validation_to_username`
  FOREIGN KEY (`userid`)
  REFERENCES `loginmaintanance`.`username` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
