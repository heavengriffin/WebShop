-- MySQL dump 10.13  Distrib 8.0.31, for macos12 (x86_64)
--
-- Host: localhost    Database: shop
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `telephone_number` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (1,'Rebecca','Hastings','4445 Heritage Road, Fresno, CA 93721','\n559-699-6010','RebeccaH@royalgoods.com','Hastings123'),(2,'Hector','Wisniewski','4441 Wood Street, New Orleans, LA 70113','985-790-5600','HectorW@royalgoods.com','Wisniewski123'),(3,'Earl','Jones','780 Mattson Street, Portland, OR 97232','503-380-7854','EarlJ@royalgoods.com','Jones123');
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyers`
--

DROP TABLE IF EXISTS `buyers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `buyers` (
  `buyer_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `address` varchar(100) NOT NULL,
  `telephone_number` varchar(45) DEFAULT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `number_of_products_bought` int DEFAULT '0',
  PRIMARY KEY (`buyer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyers`
--

LOCK TABLES `buyers` WRITE;
/*!40000 ALTER TABLE `buyers` DISABLE KEYS */;
INSERT INTO `buyers` VALUES (9,'Andrew','Kitchens','1393 Fowler Avenue, Lawrenceville, GA 30245','770-237-4119','AndrewK@gmail.com','Kitchens123',0),(10,'Maureen','Mims','889 Long Street, Gainesville, FL 32601','352-225-3279','MaureenM@gmail.com','Mims123',0),(11,'Ashton','Neeley','4712 Oral Lake Road, Wayzata, MN 55391','952-473-6531','AshtonN@gmail.com','Neeley123',0),(12,'Samantha','Glaze','4611 Harley Brook Lane, State College, PA 16803','814-620-7119','SamanthaG@gmail.com','Glaze123',0),(13,'Ruby','Bush','883 Maxwell Street, Hartford, CT 06103','860-751-4448','RubyB@gmail.com','Bush123',0),(14,'Ester','Tinsley','2533 Bates Brothers Road, Westerville, OH 43081','614-249-5506','EsterT@gmail.com','Tinsley123',0),(15,'Robert','Farmer','1490 Kembery Drive,Wheaton, IL 60187','630-588-9864','RobertF@gmail.com','Farmer123',0),(16,'Stanley','Bertsch','4056 Davis Court,Carbondale, IL 62901','618-952-7695','StanleyB@gmail.com','Bertsch123',0),(17,'Mary','Jones','3615 Shadowmar Drive, New Orleans, LA 70087','504-909-0903','MaryJ@gmail.com','Jones123',0),(18,'Kyle','Williams','4892 Norma Avenue, Dayton, OH 45402','937-227-4438','KyleW@gmail.com','Williams123',0),(22,'Philip','Doss','4020 Palmer Road, Westerville, OH 43081','614-722-8161','PhilipD@gmail.com','Doss123',0);
/*!40000 ALTER TABLE `buyers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `quantity_in_stock` int NOT NULL,
  `unit_price` int NOT NULL,
  `items_sold` int DEFAULT '0',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'adidas Terrex sneakers','sneakers',6,240,0),(2,'nike Air sneakers','sneakers',6,230,0),(3,'Sketchers sneakers','sneakers',6,210,0),(4,'Levi\'s trousers','trousers',5,160,0),(5,'Tommy Hilfiger trousers','trousers',6,170,0),(6,'Legend trousers','trousers',6,130,0),(7,'Levi\'s T-shirt','T-shirt',5,100,0),(8,'Tommy Hilfiger T-shirt','T-shirt',6,90,0),(9,'Legend T-shirt','T-shirt',5,80,0),(10,'Levi\'s jacket','jacket',6,190,0),(11,'Tommy Hilfiger jacket','jacket',5,180,0),(12,'Legend jacket','jacket',4,170,0),(13,'Armani jeans','jeans',8,200,0),(14,'Armani jacket','jacket',8,210,0),(19,'Gucci T-shirt','T-shirt',8,100,1),(21,'Gucci trousers','trousers',9,180,0),(23,'Gucci jacket','jacket',9,210,0),(32,'test','test',10,100,0);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `sale_id` int NOT NULL AUTO_INCREMENT,
  `product_id` int NOT NULL,
  `buyer_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`sale_id`),
  KEY `product_id_fk_idx` (`product_id`),
  KEY `buyer_id_fk_idx` (`buyer_id`),
  CONSTRAINT `buyer_id_fk` FOREIGN KEY (`buyer_id`) REFERENCES `buyers` (`buyer_id`),
  CONSTRAINT `product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-02 16:01:24
