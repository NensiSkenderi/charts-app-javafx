CREATE DATABASE  IF NOT EXISTS `simon_app` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `simon_app`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: simon_app
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activity_trail`
--

DROP TABLE IF EXISTS `activity_trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_trail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `activity_name` text NOT NULL,
  `date_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `suer_activity_idx` (`user_id`),
  CONSTRAINT `user_activity` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_trail`
--

LOCK TABLES `activity_trail` WRITE;
/*!40000 ALTER TABLE `activity_trail` DISABLE KEYS */;
INSERT INTO `activity_trail` VALUES (1,'Change Password','2020-06-20 16:13:33',1),(2,'Login','2020-06-22 11:45:07',1),(3,'Logout','2020-06-22 11:45:16',1),(44,'Logout','2020-06-26 11:18:20',1),(45,'Login','2020-06-26 11:22:14',1),(46,'Logout','2020-06-26 11:22:20',1),(47,'Login','2020-06-26 12:33:31',1),(48,'Login','2020-06-26 12:34:11',1),(49,'Logout','2020-06-26 12:34:38',1),(50,'Login','2020-06-26 12:35:56',1),(51,'Logout','2020-06-26 12:36:17',1),(52,'Login','2020-06-26 13:19:53',1),(53,'Login','2020-06-26 13:21:41',1),(54,'Login','2020-06-26 13:23:19',1),(55,'Login','2020-06-26 13:25:04',1),(56,'Login','2020-06-26 13:26:10',1),(57,'Logout','2020-06-26 13:27:26',1),(58,'Login','2020-06-26 13:27:51',1),(59,'Login','2020-06-26 13:30:47',1),(60,'Login','2020-06-26 13:32:30',1),(61,'Logout','2020-06-26 13:32:51',1),(62,'Login','2020-06-26 13:32:58',1),(63,'Logout','2020-06-26 13:33:10',1),(64,'Login','2020-06-26 13:34:55',1),(65,'Login','2020-06-26 13:43:43',1),(66,'Logout','2020-06-26 14:36:05',1);
/*!40000 ALTER TABLE `activity_trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `country` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('SK'),('FR'),('CZ'),('IL'),('DE'),('IE'),('DE'),('HU'),('EL'),('DK'),('SE'),('PL'),('TR'),('NL'),('BE'),('PT'),('CH'),('HU'),('BG'),('BE'),('NO'),('IT'),('CY'),('UK'),('SI'),('ES'),('FI'),('CA'),('UK'),('DE'),('DE'),('US'),('AT'),('NL'),('CH'),('SE'),('CH'),('FR'),('DE'),('BE'),('HR'),('FR'),('DE'),('NO'),('ES'),('UK'),('UK'),('IE'),('DK'),('SE'),('DE'),('NL'),('IT'),('FR'),('NL'),('NL'),('EL'),('NL'),('EL'),('BE'),('BE'),('IT'),('UK'),('UK'),('DE'),('DE'),('IE'),('PL'),('AT'),('PT'),('DE'),('DK'),('EL'),('PT'),('DE'),('EL'),('IE'),('ES'),('FR'),('AT'),('PL'),('SE'),('HU'),('CZ'),('NL'),('CH'),('SE'),('NO'),('FR'),('IT'),('FR'),('ES'),('DE'),('LT'),('BE'),('BE'),('HR'),('NO'),('FR'),('DE'),('NO'),('FR'),('AT'),('ES'),('UK'),('FR'),('FR'),('SK'),('IE'),('IT'),('DK'),('SE'),('DE'),('IE'),('NL'),('NO'),('BE'),('ES'),('AR'),('BR'),('IT'),('IE'),('AT'),('DE'),('FI'),('DK'),('UK'),('CH'),('NL'),('NO'),('UK'),('NO'),('NO'),('FI'),('AT'),('BE'),('DE'),('FR'),('DE'),('PT'),('EL'),('EL'),('UK'),('PT'),('DE'),('CY'),('IT'),('EL'),('IT'),('EL'),('DE'),('DE'),('CH'),('ES'),('IT'),('JM'),('IT'),('BR'),('BR'),('US'),('ES'),('BR'),('PT'),('AR'),('UK'),('UK'),('UK'),('DK'),('SE'),('ES'),('SE'),('ES'),('ES'),('IT'),('DE'),('SE'),('DE'),('UK'),('DE'),('DE'),('AT'),('DE'),('NL'),('DE'),('AT'),('DE'),('CH'),('CA'),('DK'),('DK'),('CH'),('FR'),('FI'),('BE'),('UK'),('NL'),('EL'),('NL'),('UK'),('EL'),('IT'),('BE'),('BE'),('FR'),('NL'),('CH'),('UK'),('FR'),('FR'),('EL'),('BE'),('ZA'),('ES'),('DE'),('RO'),('TR'),('IT'),('FI'),('BR'),('ES'),('SE'),('ES'),('FR'),('CL'),('IE'),('FR'),('SI'),('PL'),('AR'),('BE'),('PT'),('AT'),('PL'),('CZ'),('CH'),('FR'),('IT'),('ES'),('LT'),('BE'),('HR'),('ES'),('FR'),('SK'),('IE'),('IT'),('DK'),('SE'),('DK'),('BG'),('CN'),('CN'),('CN'),('CH'),('CN'),('UK'),('CN'),('UK'),('DE'),('UK'),('AT'),('HU'),('CH'),('FR'),('IT'),('ES'),('BE'),('BE'),('HR'),('AT'),('ES'),('FR'),('UK'),('IE'),('IT'),('DK'),('SE'),('DE'),('FR'),('PL'),('SE'),('HU'),('CZ'),('NO'),('FR'),('IT'),('ES'),('LT'),('BE'),('BE'),('NO'),('AT'),('ES'),('FR'),('UK'),('SK'),('DE'),('IE'),('BE'),('ES'),('ES'),('DE'),('ES'),('FR'),('IT'),('PT'),('EL'),('IT'),('AT'),('ES'),('ES'),('IT'),('IT'),('BE'),('PT'),('DE'),('PT'),('IT'),('ES'),('ES'),('CH'),('IT'),('ES'),('UK'),('FR'),('CY'),('TR'),('ES'),('UK'),('ES'),('ES'),('UK'),('NL'),('ES'),('ES'),('ES'),('IT'),('IT'),('IT'),('CA'),('FR'),('FR'),('DE'),('FR'),('UK'),('FR'),('IS'),('NL'),('NL'),('PT'),('PT'),('DE'),('ES'),('NL'),('EL'),('AT'),('RO'),('NL'),('NL'),('IS'),('DE'),('EL'),('FR'),('EL'),('EL'),('IT'),('PT'),('IT'),('AT'),('IT'),('FR'),('BE'),('IT'),('IT'),('FR'),('IT'),('ES'),('IT'),('ES'),('ES'),('DE'),('DK'),('CH'),('AT'),('PL'),('SE'),('HU'),('CZ'),('NL'),('NO'),('CH'),('FR'),('IT'),('ES'),('LT'),('BE'),('BE'),('HR'),('NO'),('DE'),('AT'),('ES'),('FR'),('UK'),('SK'),('IE'),('IT'),('DK'),('SE'),('DE'),('IE'),('UK'),('DE'),('CH'),('CA'),('CH'),('CN'),('CN'),('CN'),('UK'),('UK'),('CN'),('NL'),('NL'),('UK'),('FR'),('AT'),('PL'),('SE'),('HU'),('CZ'),('NL'),('NO'),('FR'),('ES'),('LT'),('BE'),('BE'),('HR'),('DE'),('FR'),('AT'),('ES'),('FR'),('UK'),('FR'),('SK'),('IE'),('IT'),('DK'),('SE'),('DE'),('IE'),('CH'),('DE'),('PL'),('FI'),('CH'),('FR'),('FI'),('ES'),('DE'),('ES'),('UK'),('BE'),('UK'),('FR'),('KR'),('NL'),('FR'),('AT'),('SE'),('NO'),('IT'),('FR'),('BE'),('HR'),('FR'),('ES'),('UK'),('IE'),('IT'),('DK'),('SE'),('DE'),('IE'),('DE'),('SE'),('FR'),('ES'),('ES'),('DE'),('IT'),('FR'),('DE'),('CH'),('BE'),('FR'),('AT'),('PL'),('HU'),('CZ'),('NL'),('CH'),('FR'),('IT'),('FR'),('ES'),('LT'),('BE'),('BE'),('HR'),('DE'),('FR'),('AT'),('ES'),('FR'),('UK'),('FR'),('SK'),('IE'),('IT'),('DK'),('SE'),('DE'),('IT'),('IT'),('IT'),('IT'),('UK'),('FR'),('IT'),('UK'),('PT'),('CH'),('DE'),('NL'),('ES'),('ES'),('ES'),('FR'),('FI'),('FR'),('IT'),('IE'),('ES'),('DE'),('UK'),('IT'),('DE'),('DE'),('IT'),('IT'),('IT'),('DE'),('PT'),('ES'),('UK'),('UK'),('SE'),('IL'),('DE'),('DE'),('BE'),('BE'),('UK'),('PL'),('CH'),('NL'),('FR'),('IT'),('DE'),('DE'),('UK'),('UK'),('NL'),('UK'),('CA'),('UK'),('ES'),('BE'),('RO'),('NL'),('IT'),('FR'),('PL'),('NL'),('BE'),('LT'),('PT'),('PL'),('FI'),('LT'),('EL'),('IT'),('ES'),('BE'),('UK'),('NL'),('ES'),('FR'),('FR'),('FR'),('FR'),('FR'),('FR'),('FR'),('FR'),('IT'),('FR'),('FR'),('FR'),('FR'),('FR'),('FR'),('FR'),('FR'),('UK'),('DE'),('CZ'),('ES'),('AT'),('PL'),('IE'),('IE'),('DE'),('PL'),('UK'),('RO'),('AT'),('NL'),('FR'),('BE'),('PT'),('SK'),('NL'),('EL'),('BE'),('DE'),('FI'),('UK'),('US'),('NL'),('BE'),('UK'),('ES'),('UK'),('UK'),('BE'),('UK'),('DE'),('DE'),('CH'),('BE'),('CH'),('NL'),('ES'),('CZ'),('US'),('ES'),('US'),('SE'),('SE'),('UK'),('SE'),('UK'),('DE'),('UK'),('UK'),('UK'),('ES'),('DE'),('US'),('BE'),('BE'),('UK'),('UK'),('IL'),('DE'),('DE'),('IL'),('PE'),('IT'),('IT'),('TW'),('TR'),('BG'),('IL'),('ES'),('PL'),('IT'),('FR'),('IT'),('IT'),('NL'),('FR'),('ES'),('EL'),('EL'),('IT'),('ES'),('ES'),('UK'),('UK'),('NL'),('FR'),('FR'),('AT'),('DE'),('FR'),('DE'),('DE'),('FR'),('IT'),('AT'),('DE'),('DE'),('FR'),('DE'),('BG'),('AT'),('ES'),('CH'),('FR'),('FR'),('AT'),('FR'),('AT'),('FR'),('DE'),('AT'),('FR'),('BE'),('AT'),('DE'),('DE'),('DE'),('FR'),('DE'),('AT'),('UK'),('NL'),('SE'),('UK'),('SE'),('EL'),('FR'),('DK'),('EL'),('DE'),('FR'),('NO'),('IE'),('FR'),('FR'),('ES'),('ES'),('IE'),('FR'),('UK'),('UK'),('SI'),('SI'),('RU'),('US'),('AU'),('US'),('SG'),('PL'),('US'),('RU'),('US'),('PL'),('US'),('US'),('UK'),('CH'),('NO'),('UK'),('UK'),('NO'),('DE'),('FI'),('NL'),('IT'),('UK'),('UK'),('UK'),('IT'),('UK'),('IT'),('FI'),('FR'),('EE'),('US'),('NL'),('PL'),('UK'),('UK'),('ES'),('NL'),('UK'),('ES'),('UK'),('IT'),('IT'),('UK'),('ES'),('PL'),('NL'),('ES'),('NL'),('HU'),('ES'),('BG'),('ZA'),('TW'),('EE'),('IS'),('ES'),('DE'),('ES'),('CY'),('FR'),('NL'),('LT'),('RO'),('TR'),('IT'),('IT'),('BE'),('DE'),('ES'),('LV'),('ES'),('SE'),('PL'),('ES'),('BE'),('IL'),('DE'),('IE'),('NO'),('CZ'),('BR'),('FR'),('BE'),('LU'),('RU'),('SK'),('SI'),('PL'),('BE'),('AT'),('PT'),('UK'),('JP'),('CN'),('CN'),('CN'),('UK'),('DE'),('AR'),('DE'),('CN'),('FR'),('FR'),('FR'),('CH'),('FR'),('IT'),('ES'),('AU'),('NL'),('AU'),('UK'),('FR'),('ES'),('IT'),('IT'),('AU'),('ES'),('IT'),('FR'),('FR'),('DE'),('DE'),('FR'),('UK'),('FR'),('FR'),('NL'),('DE'),('FR'),('ES'),('EL'),('IT'),('EL'),('ES'),('EL'),('ES'),('ES'),('DK'),('NL'),('EE'),('BE'),('ES'),('ES'),('SK'),('UK'),('FI'),('DE'),('EL'),('DE'),('IT'),('SI'),('TR'),('BE'),('ES'),('LV'),('NL'),('ES'),('BE'),('SE'),('LT'),('IE'),('UK'),('TR'),('NO'),('DE'),('LT'),('UK'),('BE'),('DK'),('IE'),('AT'),('FR'),('IT'),('SK'),('FR'),('PL'),('PT'),('DE'),('UK'),('NO'),('ES'),('IE'),('UK'),('PT'),('UK'),('RO'),('EL'),('NL'),('TR'),('DE'),('ES'),('SE'),('DE'),('PT'),('IE'),('TR'),('IT'),('DK'),('FR'),('UK'),('UK'),('NL'),('PL'),('NL'),('PL'),('ES'),('ES'),('ES'),('ES'),('ES'),('UK'),('ES'),('FR'),('IE'),('ES'),('ES'),('ES'),('UK'),('DE'),('DE'),('IE'),('CA'),('NL'),('BE'),('FI'),('FR'),('CY'),('CH'),('IT'),('EL'),('BG'),('FR'),('DE'),('EL'),('IT'),('EL'),('HR'),('EL'),('NO'),('CH'),('DE'),('NO'),('DE'),('UK'),('IT'),('FR'),('FI'),('DE'),('FR'),('BE'),('ES'),('FR'),('CH'),('IT'),('IT'),('FR'),('IE'),('DE'),('NL'),('UK'),('AT'),('IT'),('UK'),('NL'),('DE'),('DE'),('DE'),('DE'),('IT'),('NL'),('NL'),('UK'),('IT'),('DE'),('UK'),('UK'),('DE'),('UK'),('ES'),('FR'),('CH'),('CH'),('DE'),('HR'),('DE'),('DE'),('IT'),('UK'),('DE'),('SE'),('FR'),('FR'),('FR'),('TR'),('FR'),('EL'),('TR'),('CY'),('TR'),('IT'),('EL'),('EG'),('EL'),('JO'),('CY'),('CA'),('IT'),('SK'),('SE'),('DE'),('SE'),('FR'),('SE'),('IT'),('SE'),('SE'),('LU'),('BE'),('FR'),('ES'),('IT'),('BE'),('BE'),('SE'),('IT'),('DE'),('IT'),('DE'),('IT'),('BE'),('FR'),('CZ'),('FR'),('CZ'),('DE'),('ES'),('FR'),('FR'),('IS'),('DE'),('BE'),('BE'),('DE'),('DE'),('DE'),('NO'),('UK'),('FR'),('FR'),('FR'),('FR'),('DE'),('UK'),('SE'),('UK'),('AT'),('UK'),('UK'),('FR'),('FR'),('DK'),('DE'),('DK'),('DE'),('DE'),('UK'),('UK'),('UK'),('UK'),('NL'),('FR'),('UK'),('IT'),('IT'),('DE'),('IT'),('CH'),('FR'),('IT'),('FR'),('ES'),('UK'),('FR'),('UK'),('NL'),('FR'),('UK'),('BE'),('IT'),('BE'),('UK'),('FR'),('ES'),('DE'),('DE'),('ES'),('CH'),('FR'),('ES'),('NL'),('AT'),('UK'),('NL'),('DE'),('UK');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(64) NOT NULL,
  `password` text NOT NULL,
  `full_name` varchar(64) NOT NULL,
  `phone_number` varchar(16) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `access` varchar(45) NOT NULL DEFAULT 'User',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'nensi','SVBeJD6bYDbRsaOcHffhsw==','Nensi Skenderi','06993100861','nensiskenderi20@gmail.com','User'),(2,'test','fVh1S70Ge+JCh7K6sd6cuA==','test','555','test@gmail.com','User'),(3,'simon','NcqvfpjSfK6C711z8K+KPg==','Simon Di Luca','745637','simon@gmail.com','User'),(4,'test1','+hAPmUBkujpmueuaHl8G/Q==','test1','333','333@gmai.com','Admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-30 15:49:44
