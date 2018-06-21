-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cs230-pz
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cs230-pz
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cs230-pz` DEFAULT CHARACTER SET utf8 ;
USE `cs230-pz` ;

-- -----------------------------------------------------
-- Table `cs230-pz`.`patient`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cs230-pz`.`patient` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `patientFirstName` VARCHAR(45) NOT NULL,
  `birthDate` DATE NOT NULL,
  `patientLastName` VARCHAR(45) NULL DEFAULT NULL,
  `JMBG` VARCHAR(45) NOT NULL,
  `addedBy` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 18
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cs230-pz`.`pregled_pacijenta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cs230-pz`.`pregled_pacijenta` (
  `IDPregleda` INT(11) NOT NULL AUTO_INCREMENT,
  `datumPregleda` DATETIME NULL DEFAULT NULL,
  `sledeciPregled` DATETIME NULL DEFAULT NULL,
  `opisPregleda` VARCHAR(500) NOT NULL,
  `patient_ID` INT(11) NOT NULL,
  `users_email` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`IDPregleda`),
  INDEX `fk_pregled_pacijenta_patient1_idx` (`patient_ID` ASC),
  CONSTRAINT `fk_pregled_pacijenta_patient1`
    FOREIGN KEY (`patient_ID`)
    REFERENCES `cs230-pz`.`patient` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 60
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cs230-pz`.`user_groups`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cs230-pz`.`user_groups` (
  `email` VARCHAR(256) NOT NULL,
  `groupName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cs230-pz`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cs230-pz`.`users` (
  `email` VARCHAR(256) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`email`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
