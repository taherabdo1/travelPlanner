SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `crossover_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `crossover_db` ;

-- -----------------------------------------------------
-- Table `crossover_db`.`role`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `crossover_db`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crossover_db`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `crossover_db`.`user` (
  `account_id` VARCHAR(45) NOT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `role_id` INT NOT NULL ,
  PRIMARY KEY (`account_id`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  INDEX `fk_user_role_idx` (`role_id` ASC) ,
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role_id` )
    REFERENCES `crossover_db`.`role` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `crossover_db` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
