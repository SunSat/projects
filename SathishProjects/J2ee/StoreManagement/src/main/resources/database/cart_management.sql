create database `cart_management`;

CREATE TABLE `cart_management`.`item` (
  `itemid` INT NOT NULL,
  `name` VARCHAR(100) NULL,
  `message` VARCHAR(100) NULL,
  `initial_price` FLOAT NULL,
  `reserved_price` FLOAT NULL,
  `start_date` DATE NULL,
  `end_date` DATE NULL,
  `quantity` INT NULL,
  `state` VARCHAR(45) NULL,
  PRIMARY KEY (`itemid`),
  UNIQUE INDEX `itemid_UNIQUE` (`itemid` ASC));

CREATE TABLE `cart_management`.`user` (
  `userid` INT NOT NULL,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `user_name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `mobile_no` VARCHAR(45) NULL,
  `admin` VARCHAR(5) NULL,
  `type` VARCHAR(45) NULL,
  `rank` VARCHAR(45) NULL,
  PRIMARY KEY (`userid`),
  UNIQUE INDEX `userid_UNIQUE` (`userid` ASC));

CREATE TABLE `cart_management`.`address` (
  `addressid` INT NOT NULL,
  `userid` INT NULL,
  `type` VARCHAR(20) NULL,
  `address1` VARCHAR(50) NULL,
  `address2` VARCHAR(50) NULL,
  `city` VARCHAR(20) NULL,
  `state` VARCHAR(20) NULL,
  `country` VARCHAR(20) NULL,
  `zip_code` VARCHAR(10) NULL,
  `landmark` varchar(40) Null,
  PRIMARY KEY (`addressid`),
  UNIQUE INDEX `addressid_UNIQUE` (`addressid` ASC),
  INDEX `user_to_address_idx` (`userid` ASC),
  CONSTRAINT `user_to_address`
  FOREIGN KEY (`userid`)
  REFERENCES `cart_management`.`user` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `cart_management`.`payment` (
  `paymentid` INT NOT NULL,
  `userid` INT NULL,
  `payment_type` VARCHAR(10) NULL,
  `card_user_name` VARCHAR(45) NULL,
  `card_no` INT NULL,
  `card_expiry_date` DATE NULL,
  `card_type` VARCHAR(15) NULL,
  `bank_name` VARCHAR(45) NULL,
  `user_name` VARCHAR(45) NULL,
  PRIMARY KEY (`paymentid`),
  INDEX `user_To_payment_idx` (`userid` ASC),
  CONSTRAINT `user_To_payment`
  FOREIGN KEY (`userid`)
  REFERENCES `cart_management`.`user` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `cart_management`.`order` (
  `orderid` INT NOT NULL,
  `amount` FLOAT NULL,
  `payment_type` VARCHAR(45) NULL,
  `created_date` DATE NULL,
  `order_state` VARCHAR(45) NULL,
  PRIMARY KEY (`orderid`));

CREATE TABLE `cart_management`.`user_order` (
  `id` INT NOT NULL,
  `userid` INT NULL,
  `orderid` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_To_order_idx` (`userid` ASC),
  INDEX `order_To_userOrder_idx` (`orderid` ASC),
  CONSTRAINT `user_To_userOrder`
  FOREIGN KEY (`userid`)
  REFERENCES `cart_management`.`user` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `order_To_userOrder`
  FOREIGN KEY (`orderid`)
  REFERENCES `cart_management`.`order` (`orderid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `cart_management`.`order_item` (
  `id` INT NOT NULL,
  `orderid` INT NULL,
  `itemid` INT NULL,
  `quantity` INT NULL,
  `each_item_cost` FLOAT NULL,
  `total_cost` FLOAT NULL,
  PRIMARY KEY (`id`),
  INDEX `item_To_orderItem_idx` (`itemid` ASC),
  INDEX `order_To_orderItem_idx` (`orderid` ASC),
  CONSTRAINT `item_To_orderItem`
  FOREIGN KEY (`itemid`)
  REFERENCES `cart_management`.`item` (`itemid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `order_To_orderItem`
  FOREIGN KEY (`orderid`)
  REFERENCES `cart_management`.`order` (`orderid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `cart_management`.`comment` (
  `commentid` INT NOT NULL,
  `itemid` INT NULL,
  `userid` INT NULL,
  `rating` INT NULL,
  `comment_text` TEXT NULL,
  `created_date` DATE NULL,
  PRIMARY KEY (`commentid`),
  INDEX `user_To_comment_idx` (`userid` ASC),
  INDEX `item_To_comment_idx` (`itemid` ASC),
  CONSTRAINT `user_To_comment`
  FOREIGN KEY (`userid`)
  REFERENCES `cart_management`.`user` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `item_To_comment`
  FOREIGN KEY (`itemid`)
  REFERENCES `cart_management`.`item` (`itemid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `cart_management`.`category` (
  `categoryid` INT NOT NULL,
  `parent_category_id` INT NULL,
  `category_name` VARCHAR(45) NULL,
  PRIMARY KEY (`categoryid`));

CREATE TABLE `cart_management`.`category_item` (
  `id` INT NOT NULL,
  `categoryid` INT NULL,
  `itemid` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_To_categoryItem_idx` (`categoryid` ASC),
  INDEX `item_To_categoryIteam_idx` (`itemid` ASC),
  CONSTRAINT `category_To_categoryItem`
  FOREIGN KEY (`categoryid`)
  REFERENCES `cart_management`.`category` (`categoryid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `item_To_categoryIteam`
  FOREIGN KEY (`itemid`)
  REFERENCES `cart_management`.`item` (`itemid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);

CREATE TABLE `cart_management`.`shipment` (
  `shipmentid` INT NOT NULL,
  `orderid` INT NULL,
  `itemid` INT NULL,
  `userid` INT NULL,
  `addressid` INT NULL,
  `current_state` VARCHAR(45) NULL,
  `shipment_date` DATE NULL,
  PRIMARY KEY (`shipmentid`),
  INDEX `item_To_shipment_idx` (`itemid` ASC),
  INDEX `order_To_shipment_idx` (`orderid` ASC),
  INDEX `user_To_shipment_idx` (`userid` ASC),
  INDEX `address_To_shipment_idx` (`addressid` ASC),
  CONSTRAINT `item_To_shipment`
  FOREIGN KEY (`itemid`)
  REFERENCES `cart_management`.`item` (`itemid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `order_To_shipment`
  FOREIGN KEY (`orderid`)
  REFERENCES `cart_management`.`order` (`orderid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `user_To_shipment`
  FOREIGN KEY (`userid`)
  REFERENCES `cart_management`.`user` (`userid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `address_To_shipment`
  FOREIGN KEY (`addressid`)
  REFERENCES `cart_management`.`address` (`addressid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
