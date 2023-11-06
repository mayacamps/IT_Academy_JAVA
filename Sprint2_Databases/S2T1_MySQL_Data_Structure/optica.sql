-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema optica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema optica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `optica` DEFAULT CHARACTER SET utf8 ;
USE `optica` ;

-- -----------------------------------------------------
-- Table `optica`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optica`.`employee` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nif` VARCHAR(9) NOT NULL,
  `name` VARCHAR(20) NOT NULL,
  `surname1` VARCHAR(30) NOT NULL,
  `surname2` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nif_UNIQUE` (`nif` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optica`.`client`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optica`.`client` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `surname1` VARCHAR(30) NOT NULL,
  `surname2` VARCHAR(30) NOT NULL,
  `phone` VARCHAR(15) NOT NULL COMMENT 'may have country code',
  `email` VARCHAR(60) NOT NULL,
  `registration_date` DATETIME NOT NULL,
  `recom_client_id` INT(10) UNSIGNED NULL DEFAULT NULL COMMENT 'id of client who recommended this new client (if recommended by someone)',
  `employee_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `recom_client_id` (`recom_client_id` ASC) ,
  INDEX `employee_id` (`employee_id` ASC) ,
  CONSTRAINT `fk_client_client`
    FOREIGN KEY (`recom_client_id`)
    REFERENCES `optica`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `optica`.`employee` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optica`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optica`.`address` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(250) NOT NULL,
  `number` INT(10) UNSIGNED NOT NULL,
  `floor` VARCHAR(3) NULL DEFAULT NULL COMMENT 'not int in case of ENT (entresuelo), A(atico) or similars',
  `door` VARCHAR(2) NULL DEFAULT NULL,
  `city` VARCHAR(45) NOT NULL,
  `zipcode` INT(11) NOT NULL COMMENT '5 digit zip code',
  `country` VARCHAR(3) NOT NULL COMMENT 'countries coded following ISO 3166-1 alpha-3',
  `client_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `client_id` (`client_id` ASC) ,
  CONSTRAINT `fk_address_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `optica`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optica`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optica`.`supplier` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `telephone` VARCHAR(15) NOT NULL COMMENT 'may have country code',
  `fax` VARCHAR(15) NOT NULL COMMENT 'may have country code',
  `nif` VARCHAR(9) NOT NULL,
  `address_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nif_UNIQUE` (`nif` ASC) ,
  INDEX `address_id` (`address_id` ASC) ,
  CONSTRAINT `fk_supplier_address1`
    FOREIGN KEY (`address_id`)
    REFERENCES `optica`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optica`.`brand`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optica`.`brand` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `supplier_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `supplier_id` (`supplier_id` ASC) ,
  CONSTRAINT `fk_brand_supplier1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `optica`.`supplier` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optica`.`glasses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optica`.`glasses` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `l_grad` FLOAT NULL DEFAULT NULL COMMENT 'left eye graduation',
  `r_grad` FLOAT NULL DEFAULT NULL COMMENT 'right eye graduation',
  `frame_type` ENUM('floating', 'plastic rimmed', 'metallic') NOT NULL,
  `frame_color` VARCHAR(45) NOT NULL,
  `l_color` VARCHAR(45) NOT NULL COMMENT 'left crystal color',
  `r_color` VARCHAR(45) NOT NULL COMMENT 'right crystal color',
  `price` FLOAT UNSIGNED NOT NULL,
  `brand_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `brand_id` (`brand_id` ASC) ,
  CONSTRAINT `fk_glasses_brand1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `optica`.`brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `optica`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `optica`.`order` (
  `client_id` INT(10) UNSIGNED NOT NULL,
  `glasses_id` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`client_id`, `glasses_id`),
  INDEX `glasses_id` (`glasses_id` ASC) ,
  INDEX `client_id` (`client_id` ASC) ,
  CONSTRAINT `fk_client_has_glasses_client1`
    FOREIGN KEY (`client_id`)
    REFERENCES `optica`.`client` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_client_has_glasses_glasses1`
    FOREIGN KEY (`glasses_id`)
    REFERENCES `optica`.`glasses` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
