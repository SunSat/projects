CREATE SCHEMA `healthapp` ;

CREATE TABLE `healthapp`.`user` (
  `id` BIGINT(10) NOT NULL,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(500) NULL,
  `password_hash` VARCHAR(500) NULL,
  `creation_time` VARCHAR(30) NULL,
  `expiry_time` VARCHAR(30) NULL,
  `email` VARCHAR(255) NULL,
  `email_confirmation_token` VARCHAR(255) NULL,
  `email_token_expiry` VARCHAR(30) NULL,
  `user_account_status` VARCHAR(20) NULL,
  `modified_time` VARCHAR(30) NULL,
  `deleted` TINYINT(1) NULL,
  `message` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC));

CREATE TABLE `healthapp`.`login` (
  `id` BIGINT(10) NOT NULL,
  `user_id` BIGINT(10) NULL,
  `login_time` VARCHAR(30) NULL,
  `logout_time` VARCHAR(30) NULL,
  `status` VARCHAR(50) NULL,
  `message` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `Login_UserId_To_User_UserId_idx` (`user_id` ASC),
  CONSTRAINT `Login_User_Id_To_User_User_Id`
  FOREIGN KEY (`user_id`)
  REFERENCES `healthapp`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

ALTER TABLE `healthapp`.`login`
ADD COLUMN `login_source_id` BIGINT(10) NULL AFTER `user_id`,
ADD INDEX `Login_To_Login_Source_ID_idx` (`login_source_id` ASC);
ALTER TABLE `healthapp`.`login`
ADD CONSTRAINT `Login_To_Login_Source_ID`
FOREIGN KEY (`login_source_id`)
REFERENCES `healthapp`.`loginsource` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

CREATE TABLE `healthapp`.`loginsource` (
  `id` BIGINT(10) NOT NULL,
  `userid` BIGINT(10) NULL,
  `source` VARCHAR(50) NULL,
  PRIMARY KEY (`id`),
  INDEX `loginSource_To_UserId_idx` (`userid` ASC),
  CONSTRAINT `loginSource_To_UserId`
  FOREIGN KEY (`userid`)
  REFERENCES `healthapp`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `healthapp`.`oldpassword` (
  `id` BIGINT(10) NOT NULL,
  `user_id` BIGINT(10) NULL,
  `old_password` VARCHAR(500) NULL,
  `old_password_hash` VARCHAR(500) NULL,
  `creation_time` VARCHAR(30) NULL,
  `expiry_time` VARCHAR(30) NULL,
  `message` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  INDEX `oldpassword_user_id_to_User_User_id_idx` (`user_id` ASC),
  CONSTRAINT `oldpassword_user_id_to_User_User_id`
  FOREIGN KEY (`user_id`)
  REFERENCES `healthapp`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);