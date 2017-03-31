CREATE  TABLE `crossover_db`.`orders` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `amount` INT NOT NULL ,
  `from` VARCHAR(80) NOT NULL ,
  `to` VARCHAR(80) NOT NULL ,
  `is_done` TINYINT NULL ,
  PRIMARY KEY (`id`) ,
  CONSTRAINT `account_id`
    FOREIGN KEY (`id` )
    REFERENCES `crossover_db`.`user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

	
	--adding roles
	INSERT INTO `crossover_db`.`role` (`name`) VALUES ('user');
	INSERT INTO `crossover_db`.`role` (`name`) VALUES ('admin');

	
	