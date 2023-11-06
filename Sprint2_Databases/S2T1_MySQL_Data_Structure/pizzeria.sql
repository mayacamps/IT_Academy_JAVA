-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pizzeria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pizzeria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pizzeria` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema universidad
-- -----------------------------------------------------
USE `pizzeria` ;

-- -----------------------------------------------------
-- Table `pizzeria`.`province`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`province` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_province` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `name` (`name_province` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`location` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_location` VARCHAR(45) NOT NULL,
  `province_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `province_id`),
  INDEX `province_id` (`province_id` ASC) ,
  CONSTRAINT `fk_location_province`
    FOREIGN KEY (`province_id`)
    REFERENCES `pizzeria`.`province` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`customer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname1` VARCHAR(45) NOT NULL,
  `surname2` VARCHAR(45) NOT NULL,
  `address` VARCHAR(200) NOT NULL,
  `postal_code` INT NOT NULL COMMENT '5 digit postal code',
  `phone` VARCHAR(15) NOT NULL COMMENT 'following E.164: maximum 15 digits for international phone numbers.',
  `location_id` INT UNSIGNED NOT NULL,
  `province_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `location_id` (`location_id` ASC, `province_id` ASC) ,
  INDEX `name` (`name` ASC) ,
  INDEX `province_id` (`province_id` ASC) ,
  CONSTRAINT `fk_customer_location1`
    FOREIGN KEY (`location_id` , `province_id`)
    REFERENCES `pizzeria`.`location` (`id` , `province_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`store`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`store` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(200) NOT NULL,
  `postal_code` INT UNSIGNED NOT NULL COMMENT '5 digit postal code\n',
  `location_id` INT UNSIGNED NOT NULL,
  `province_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `location_id` (`location_id` ASC, `province_id` ASC) ,
  CONSTRAINT `fk_store_location1`
    FOREIGN KEY (`location_id` , `province_id`)
    REFERENCES `pizzeria`.`location` (`id` , `province_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`employee` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `surname1` VARCHAR(45) NOT NULL,
  `surname2` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(9) NOT NULL,
  `phone` INT UNSIGNED NULL DEFAULT NULL,
  `type` ENUM('cook', 'delivery') NOT NULL,
  `store_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `store_id` (`store_id` ASC) ,
  UNIQUE INDEX `nif_UNIQUE` (`nif` ASC) ,
  CONSTRAINT `fk_employee_store1`
    FOREIGN KEY (`store_id`)
    REFERENCES `pizzeria`.`store` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`home_delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`home_delivery` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date_time` DATETIME NOT NULL,
  `employee_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `employee_id` (`employee_id` ASC) ,
  CONSTRAINT `fk_home_delivery_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `pizzeria`.`employee` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `date_time` DATETIME NOT NULL,
  `home_or_pickup` ENUM('home', 'pick_up') NOT NULL,
  `product_quant` INT UNSIGNED NOT NULL,
  `price` FLOAT UNSIGNED NOT NULL,
  `customer_id` INT UNSIGNED NOT NULL,
  `store_id` INT UNSIGNED NOT NULL,
  `home_delivery_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_id` (`customer_id` ASC) ,
  INDEX `store_id` (`store_id` ASC) ,
  INDEX `home_delivery_id` (`home_delivery_id` ASC) ,
  CONSTRAINT `fk_order_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `pizzeria`.`customer` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_store1`
    FOREIGN KEY (`store_id`)
    REFERENCES `pizzeria`.`store` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_home_delivery1`
    FOREIGN KEY (`home_delivery_id`)
    REFERENCES `pizzeria`.`home_delivery` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`category` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `name` (`name_category` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name_prod` ENUM('pizza', 'hamburger', 'drink') NOT NULL,
  `description` VARCHAR(200) NOT NULL,
  `image` VARCHAR(45) NULL,
  `price` FLOAT UNSIGNED NOT NULL,
  `category_id_category` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `category_id` (`category_id_category` ASC) ,
  INDEX `name` (`name_prod` ASC) ,
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_id_category`)
    REFERENCES `pizzeria`.`category` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzeria`.`order_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzeria`.`order_has_product` (
  `order_id_order` INT UNSIGNED NOT NULL,
  `product_id_product` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`order_id_order`, `product_id_product`),
  INDEX `product_id` (`product_id_product` ASC) ,
  INDEX `order_id` (`order_id_order` ASC) ,
  CONSTRAINT `fk_order_has_product_order1`
    FOREIGN KEY (`order_id_order`)
    REFERENCES `pizzeria`.`order` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_order_has_product_product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `pizzeria`.`product` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
