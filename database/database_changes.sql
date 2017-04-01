CREATE  TABLE `crossover_db`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `amount` INT NOT NULL ,
  `from` VARCHAR(80) NOT NULL ,
  `to` VARCHAR(80) NOT NULL ,
  `is_done` TINYINT NULL ,
  `account_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `account_id`
    FOREIGN KEY (`account_id` )
    REFERENCES `crossover_db`.`user` (`account_id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	
	--adding roles
	INSERT INTO `crossover_db`.`role` (`name`) VALUES ('user');
	INSERT INTO `crossover_db`.`role` (`name`) VALUES ('admin');


	--change "from" to "from_city" and "to" to "to_city"
	ALTER TABLE `crossover_db`.`orders` CHANGE COLUMN `from` `from_city` VARCHAR(80) NOT NULL  , CHANGE COLUMN `to` `to_city` VARCHAR(80) NOT NULL  ;

	--add price_amount and currency to "orders" table
	ALTER TABLE `crossover_db`.`orders` ADD COLUMN `price_amount` INT NULL  AFTER `account_id` ;
ALTER TABLE `crossover_db`.`orders` ADD COLUMN `currency` VARCHAR(45) NULL  AFTER `price_amount` ;

	
	