-- MySQL dump 10.13  Distrib 5.6.16, for Win32 (x86)
--
-- Host: localhost    Database: crossover_db
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` int(11) NOT NULL,
  `from_city` varchar(80) NOT NULL,
  `to_city` varchar(80) NOT NULL,
  `price_amount` int(11) DEFAULT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `is_done` tinyint(4) DEFAULT NULL,
  `account_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcc5mvdryp68daty5jvdxb9fds` (`account_id`),
  CONSTRAINT `account_id` FOREIGN KEY (`account_id`) REFERENCES `user` (`account_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FKcc5mvdryp68daty5jvdxb9fds` FOREIGN KEY (`account_id`) REFERENCES `user` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,1,'madride','london',NULL,NULL,1,'wew'),(2,1,'madride','london',NULL,NULL,1,'wew'),(3,1,'madride','london',NULL,NULL,1,'wew'),(4,1,'madride','london',NULL,NULL,1,'wew'),(5,1,'madride','london',NULL,NULL,1,'wew'),(6,1,'madride','london',NULL,NULL,1,'wew'),(7,1,'Madrid','London',NULL,NULL,1,'wew'),(8,1,'Madrid','London',NULL,NULL,1,'wew'),(9,1,'Madrid','London',NULL,NULL,1,'wew'),(10,1,'Madrid','London',100,'1',1,'wew'),(11,1,'Madrid','London',100,'1',1,'MZeyvnRWD'),(12,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(13,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(14,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(15,1,'Paris','New York',350,'1',1,'8jnV9B03J'),(16,1,'New York','Paris',450,'0',1,'8jnV9B03J'),(17,1,'Sydney','Dubai',1000,'2',1,'8jnV9B03J'),(18,1,'Paris','New York',350,'1',1,'8jnV9B03J'),(19,1,'Madrid','London',100,'1',1,'8jnV9B03J'),(20,1,'Madrid','London',100,'1',1,'8jnV9B03J'),(21,1,'Paris','New York',350,'1',1,'8jnV9B03J'),(22,1,'Madrid','London',100,'1',1,'8jnV9B03J'),(23,1,'Paris','New York',350,'1',1,'8jnV9B03J'),(24,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(25,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(26,1,'Sydney','Dubai',1000,'2',1,'8jnV9B03J'),(27,1,'Dubai','Sydney',3000,'3',1,'8jnV9B03J'),(28,1,'Sydney','Dubai',1000,'2',1,'8jnV9B03J'),(29,1,'Dubai','Sydney',3000,'3',1,'8jnV9B03J'),(30,1,'Dubai','Sydney',3000,'3',1,'8jnV9B03J'),(31,1,'Paris','New York',350,'1',1,'8jnV9B03J'),(32,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(33,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(34,1,'Paris','New York',350,'1',1,'8jnV9B03J'),(35,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(36,1,'Dubai','Sydney',3000,'3',1,'8jnV9B03J'),(37,1,'New York','Paris',450,'0',1,'8jnV9B03J'),(38,1,'New York','Paris',450,'0',1,'8jnV9B03J'),(39,1,'London','Madrid',100,'1',1,'8jnV9B03J'),(40,1,'New York','Paris',450,'0',1,'8jnV9B03J');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;

INSERT INTO `role` VALUES (2,'ROLE_ADMIN_ROLE'),(1,'ROLE_USER_ROLE');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `account_id` varchar(45) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(45) NOT NULL,
  `role_id` int(11) NOT NULL,
  `currency` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  KEY `fk_user_role_idx` (`role_id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('8jnV9B03J','hend.muhammad.rizq@gmail.com','12345',1,'1'),('a4DkvQKbA','hesham@fd.oio','12345678',1,'0'),('AmoVjL142','hassan@gmail.com','12345',1,'0'),('Eo6v3vEpB','hesham@dfjd.do','wjehriew',1,'0'),('Eo6v9eejL','hatem@gmail.com','12345',2,'0'),('j8e6dB3NL','test12@gmial.dfon','swdfmkws',1,'0'),('mvqJ4kP9Z','test1q12@gmial.dfon','swdfmkws',1,'0'),('MZeVNEL7D','test1q2@gmial.dfon','swdfmkws',1,'0'),('MZeyvnRWD','user2@gmail.com','12345',1,'2'),('NoL1wO7W8','wsrf/wq@esrf.wew','wdrfnj',1,'1'),('testID','jkfrnje@ekrn.er','kmenkw',1,'2'),('VaB1vm36B','osama@gmail.com','wkje',1,'0'),('VaB1vQZ81','ahmed@gmail.com','12345',1,'0'),('wew','email@test.com','12345',1,'2'),('ZNAPdJdNO','test@gmial.dfon','swdfmkws',1,'0');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-02 23:23:26
