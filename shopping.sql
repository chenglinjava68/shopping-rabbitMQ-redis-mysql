-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gouwu
-- ------------------------------------------------------
-- Server version	5.6.27-log

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
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `price` decimal(9,2) NOT NULL,
  `totalSales` int(11) NOT NULL DEFAULT '0',
  `promotionPrice` decimal(3,2) NOT NULL DEFAULT '1.00',
  `isActivity` tinyint(2) DEFAULT '0',
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1032 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1000,'充气娃娃跳楼价','高仿真绝对手感一流',1.99,123,0.02,1,'2014-01-01 00:00:00','2016-11-01 00:00:00',32432,NULL),(1001,'充气娃娃跳楼价','高仿真绝对手感一流',1.99,123,0.02,0,NULL,NULL,32432,NULL),(1002,'充气娃娃跳楼价','高仿真绝对手感一流',2.99,123,0.02,1,NULL,NULL,32432,NULL),(1003,'充气娃娃跳楼价','高仿真绝对手感一流',3.99,123,0.02,1,NULL,NULL,32432,NULL),(1004,'充气娃娃跳楼价','高仿真绝对手感一流',4.99,123,0.02,1,NULL,NULL,32432,NULL),(1005,'充气娃娃跳楼价','高仿真绝对手感一流',5.99,123,0.02,1,NULL,NULL,32432,NULL),(1006,'充气娃娃跳楼价','高仿真绝对手感一流',6.99,123,0.02,1,NULL,NULL,32432,NULL),(1007,'充气娃娃跳楼价','高仿真绝对手感一流',7.99,123,0.02,1,NULL,NULL,32432,NULL),(1008,'充气娃娃跳楼价','高仿真绝对手感一流',8.99,123,0.02,1,NULL,NULL,32432,NULL),(1009,'充气娃娃跳楼价','高仿真绝对手感一流',9.99,123,0.02,1,NULL,NULL,32432,NULL),(1010,'充气娃娃跳楼价','高仿真绝对手感一流',10.99,123,0.02,1,NULL,NULL,32432,NULL),(1011,'充气娃娃跳楼价','高仿真绝对手感一流',11.99,123,0.02,1,NULL,NULL,32432,NULL),(1012,'充气娃娃跳楼价','高仿真绝对手感一流',12.99,123,0.02,1,NULL,NULL,32432,NULL),(1013,'充气娃娃跳楼价','高仿真绝对手感一流',13.99,123,0.02,1,NULL,NULL,32432,NULL),(1014,'充气娃娃跳楼价','高仿真绝对手感一流',14.99,123,0.02,1,NULL,NULL,32432,NULL),(1015,'充气娃娃跳楼价','高仿真绝对手感一流',15.99,123,0.02,1,NULL,NULL,32432,NULL),(1016,'充气娃娃跳楼价','高仿真绝对手感一流',16.99,123,0.02,1,NULL,NULL,32432,NULL),(1017,'充气娃娃跳楼价','高仿真绝对手感一流',17.99,123,0.02,1,NULL,NULL,32432,NULL),(1018,'充气娃娃跳楼价','高仿真绝对手感一流',18.99,123,0.02,1,NULL,NULL,32432,NULL),(1019,'充气娃娃跳楼价','高仿真绝对手感一流',19.99,123,0.02,1,NULL,NULL,32432,NULL),(1020,'充气娃娃跳楼价','高仿真绝对手感一流',20.99,123,0.02,1,NULL,NULL,32432,NULL),(1021,'充气娃娃跳楼价','高仿真绝对手感一流',21.99,123,0.02,1,NULL,NULL,32432,NULL),(1022,'充气娃娃跳楼价','高仿真绝对手感一流',22.99,123,0.02,1,NULL,NULL,32432,NULL),(1023,'充气娃娃跳楼价','高仿真绝对手感一流',23.99,123,0.02,1,NULL,NULL,32432,NULL),(1024,'充气娃娃跳楼价','高仿真绝对手感一流',24.99,123,0.02,1,NULL,NULL,32432,NULL),(1025,'充气娃娃跳楼价','高仿真绝对手感一流',25.99,123,0.02,1,NULL,NULL,32432,NULL),(1026,'充气娃娃跳楼价','高仿真绝对手感一流',26.99,123,0.02,1,NULL,NULL,32432,NULL),(1027,'充气娃娃跳楼价','高仿真绝对手感一流',27.99,123,0.02,1,NULL,NULL,32432,NULL),(1028,'充气娃娃跳楼价','高仿真绝对手感一流',28.99,123,0.02,1,NULL,NULL,32432,NULL),(1029,'充气娃娃跳楼价','高仿真绝对手感一流',29.99,123,0.02,1,NULL,NULL,32432,NULL),(1030,'充气娃娃跳楼价','高仿真绝对手感一流',30.99,123,0.02,1,NULL,NULL,32432,NULL),(1031,'充气娃娃跳楼价','高仿真绝对手感一流',31.99,123,0.02,1,NULL,NULL,32432,NULL);
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `orderId` char(200) CHARACTER SET utf8 NOT NULL,
  `goodsId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `price` decimal(9,2) NOT NULL,
  `promotionPrice` decimal(3,2) NOT NULL DEFAULT '1.00',
  `status` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('0e12251b-9198-4282-8a11-b03eb806d701',1000,1,1.99,0.02,NULL,'2016-03-12 21:48:10'),('3c5d4e83-75f2-499c-b3b7-0ca1b13084ec',1000,1,1.99,0.02,NULL,'2016-03-12 21:49:22'),('5dcc1454-64c7-4485-8d30-4457687a3568',1012,1,12.99,0.02,NULL,'2016-03-12 21:55:32'),('6b068e6d-6956-4084-ada5-6c4c884189f4',1000,1,1.99,0.02,NULL,NULL),('7e3eb520-dcf0-49b8-85a7-a056b23f3f3b',1001,1,1.99,0.02,NULL,'2016-03-12 21:55:16'),('80eb6aa5-a42d-4bed-9f54-65e887b3dc2b',1001,1,1.99,0.02,NULL,'2016-03-12 21:54:52'),('9958e81c-8f04-4871-bc79-f7793caf8b06',1000,1,9.99,0.01,NULL,NULL),('9e880256-8af2-4dec-8de3-00dce33cde1e',1000,1,1.99,0.02,NULL,NULL),('acae3455-32e7-444b-976a-7a7a359a3f19',1009,1,9.99,0.02,NULL,'2016-03-12 21:55:26'),('c6bb5871-5626-4718-b7d8-2158c01c40b4',1001,1,1.99,0.02,NULL,'2016-03-12 21:55:19'),('d8f9bdc5-8ad2-4b01-bcba-d39f1ba6d867',1001,1,1.99,0.02,NULL,'2016-03-12 21:55:22'),('db509123-214b-4a73-840e-f8f274290d94',1000,1,1.99,0.02,NULL,'2016-03-12 21:48:42'),('dc5f4de2-88f4-49bc-a2dd-194dc50429ed',1000,1,1.99,0.02,NULL,'2016-03-12 21:48:51'),('sir93ids93u-32s',1000,1,9.99,0.01,NULL,NULL);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET latin1 NOT NULL,
  `password` varchar(45) CHARACTER SET latin1 NOT NULL,
  `nickname` varchar(45) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3','I\'m ur father');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'gouwu'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-13 10:35:56
