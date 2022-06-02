-- MySQL dump 10.13  Distrib 8.0.27, for macos12.0 (x86_64)
--
-- Host: localhost    Database: DIGIBANK
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `C_VISTA`
--

DROP TABLE IF EXISTS `C_VISTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `C_VISTA` (
  `limMax` int NOT NULL,
  `moneda` int DEFAULT NULL,
  `tipoCuenta` varchar(255) DEFAULT NULL,
  `idProducto` bigint NOT NULL,
  PRIMARY KEY (`idProducto`),
  CONSTRAINT `FKd4gd05g7p7fyxit6uyd026kvn` FOREIGN KEY (`idProducto`) REFERENCES `PRODUCTO` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `C_VISTA`
--

LOCK TABLES `C_VISTA` WRITE;
/*!40000 ALTER TABLE `C_VISTA` DISABLE KEYS */;
INSERT INTO `C_VISTA` VALUES (15000000,0,'Caja de ahorro',5),(20000000,1,'Cuenta Corriente',6);
/*!40000 ALTER TABLE `C_VISTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (8),(8);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_AUTOMOTOR`
--

DROP TABLE IF EXISTS `P_AUTOMOTOR`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `P_AUTOMOTOR` (
  `tipoVe` int DEFAULT NULL,
  `idProducto` bigint NOT NULL,
  PRIMARY KEY (`idProducto`),
  CONSTRAINT `FK2xsdu4a4ugfeklilxhle9brgd` FOREIGN KEY (`idProducto`) REFERENCES `PRESTAMO` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_AUTOMOTOR`
--

LOCK TABLES `P_AUTOMOTOR` WRITE;
/*!40000 ALTER TABLE `P_AUTOMOTOR` DISABLE KEYS */;
INSERT INTO `P_AUTOMOTOR` VALUES (0,3),(1,4);
/*!40000 ALTER TABLE `P_AUTOMOTOR` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `P_INMOBILIARIO`
--

DROP TABLE IF EXISTS `P_INMOBILIARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `P_INMOBILIARIO` (
  `tipoInm` int DEFAULT NULL,
  `idProducto` bigint NOT NULL,
  PRIMARY KEY (`idProducto`),
  CONSTRAINT `FKaxpqpy1bcgryb7f1ig3j5yjxy` FOREIGN KEY (`idProducto`) REFERENCES `PRESTAMO` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `P_INMOBILIARIO`
--

LOCK TABLES `P_INMOBILIARIO` WRITE;
/*!40000 ALTER TABLE `P_INMOBILIARIO` DISABLE KEYS */;
INSERT INTO `P_INMOBILIARIO` VALUES (0,1),(1,2);
/*!40000 ALTER TABLE `P_INMOBILIARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRESTAMO`
--

DROP TABLE IF EXISTS `PRESTAMO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRESTAMO` (
  `cantidadCuotas` int NOT NULL,
  `valorCuota` int NOT NULL,
  `idProducto` bigint NOT NULL,
  PRIMARY KEY (`idProducto`),
  CONSTRAINT `FKrye5avwdv29nvox9bv5nfdeb` FOREIGN KEY (`idProducto`) REFERENCES `PRODUCTO` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRESTAMO`
--

LOCK TABLES `PRESTAMO` WRITE;
/*!40000 ALTER TABLE `PRESTAMO` DISABLE KEYS */;
INSERT INTO `PRESTAMO` VALUES (200,50000,1),(100,70000,2),(50,3000,3),(40,5000,4);
/*!40000 ALTER TABLE `PRESTAMO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCTO`
--

DROP TABLE IF EXISTS `PRODUCTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODUCTO` (
  `idProducto` bigint NOT NULL,
  `clase` int DEFAULT NULL,
  `montoMaximo` int NOT NULL,
  `nombreProducto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `nombreProducto_UNIQUE` (`nombreProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTO`
--

LOCK TABLES `PRODUCTO` WRITE;
/*!40000 ALTER TABLE `PRODUCTO` DISABLE KEYS */;
INSERT INTO `PRODUCTO` VALUES (1,0,10000000,'Tu casa'),(2,0,7000000,'Tu apartamento'),(3,0,150000,'Tu auto YA!'),(4,0,200000,'Tu camioneta hoy mismo !!!'),(5,1,15000000,'Caja de Ahorro simple'),(6,1,20000000,'Cuenta Corriente');
/*!40000 ALTER TABLE `PRODUCTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PRODUCTO_SEGMENTO`
--

DROP TABLE IF EXISTS `PRODUCTO_SEGMENTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PRODUCTO_SEGMENTO` (
  `idProducto` bigint NOT NULL,
  `idSegmento` bigint NOT NULL,
  PRIMARY KEY (`idProducto`,`idSegmento`),
  KEY `FKpllerxo7ff9o460q59go1m6hp` (`idSegmento`),
  CONSTRAINT `FK1cajdss9muv6kakls61wrl119` FOREIGN KEY (`idProducto`) REFERENCES `PRODUCTO` (`idProducto`),
  CONSTRAINT `FKpllerxo7ff9o460q59go1m6hp` FOREIGN KEY (`idSegmento`) REFERENCES `SEGMENTO` (`idSegmento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PRODUCTO_SEGMENTO`
--

LOCK TABLES `PRODUCTO_SEGMENTO` WRITE;
/*!40000 ALTER TABLE `PRODUCTO_SEGMENTO` DISABLE KEYS */;
INSERT INTO `PRODUCTO_SEGMENTO` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(1,2),(2,2),(3,2),(4,2),(1,3),(2,3),(3,3);
/*!40000 ALTER TABLE `PRODUCTO_SEGMENTO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SEGMENTO`
--

DROP TABLE IF EXISTS `SEGMENTO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SEGMENTO` (
  `idSegmento` bigint NOT NULL,
  `nombreSegmento` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idSegmento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEGMENTO`
--

LOCK TABLES `SEGMENTO` WRITE;
/*!40000 ALTER TABLE `SEGMENTO` DISABLE KEYS */;
INSERT INTO `SEGMENTO` VALUES (1,'Jóvenes'),(2,'Standard'),(3,'Premium');
/*!40000 ALTER TABLE `SEGMENTO` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-02 14:38:26
