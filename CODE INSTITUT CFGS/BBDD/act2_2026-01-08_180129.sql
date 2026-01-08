-- Active: 1767885358260@@localhost@3306@act2ambcanvis
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: act2
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dni` int(8) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `prApellido` varchar(30) NOT NULL,
  `sgApellido` varchar(30) DEFAULT NULL,
  `Domicilio` varchar(200) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `devolucion`
--

DROP TABLE IF EXISTS `devolucion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `devolucion` (
  `CodVenta` int(10) NOT NULL,
  `numLinea` int(10) NOT NULL,
  `Fecha` datetime NOT NULL,
  `Estado` varchar(100) NOT NULL,
  `TipoDev` int(2) NOT NULL,
  PRIMARY KEY (`CodVenta`,`numLinea`,`Fecha`),
  CONSTRAINT `devolucion_ibfk_1` FOREIGN KEY (`CodVenta`, `numLinea`) REFERENCES `lineaventa` (`CodVenta`, `numLinea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `director`
--

DROP TABLE IF EXISTS `director`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `director` (
  `dni` int(8) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `prApellido` varchar(30) NOT NULL,
  `sgApellido` varchar(30) DEFAULT NULL,
  `Domicilio` varchar(200) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `lineaventa`
--

DROP TABLE IF EXISTS `lineaventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineaventa` (
  `CodVenta` int(10) NOT NULL,
  `numLinea` int(10) NOT NULL,
  `cantidad` int(4) NOT NULL,
  PRIMARY KEY (`CodVenta`,`numLinea`),
  CONSTRAINT `lineaventa_ibfk_1` FOREIGN KEY (`CodVenta`) REFERENCES `venta` (`CodVenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `precio`
--

DROP TABLE IF EXISTS `precio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `precio` (
  `CodProd` int(10) NOT NULL,
  `Fecha` date NOT NULL,
  `precio` int(5) NOT NULL,
  PRIMARY KEY (`CodProd`,`Fecha`),
  CONSTRAINT `precio_ibfk_1` FOREIGN KEY (`CodProd`) REFERENCES `producto` (`CodProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `CodProducto` int(10) NOT NULL,
  `Descripcion` varchar(300) NOT NULL,
  `Descuento` int(3) DEFAULT NULL,
  `IVA` int(3) NOT NULL,
  PRIMARY KEY (`CodProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `supermercado`
--

DROP TABLE IF EXISTS `supermercado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supermercado` (
  `CodSup` int(10) NOT NULL AUTO_INCREMENT,
  `Direccion` varchar(200) NOT NULL,
  `Superficie` int(10) NOT NULL,
  `esAlquiler` tinyint(1) NOT NULL,
  `FECHA` date NOT NULL,
  `DNI` int(8) DEFAULT NULL,
  PRIMARY KEY (`CodSup`),
  KEY `DNI` (`DNI`),
  CONSTRAINT `supermercado_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `director` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vendedor`
--

DROP TABLE IF EXISTS `vendedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedor` (
  `dni` int(8) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `prApellido` varchar(30) NOT NULL,
  `sgApellido` varchar(30) DEFAULT NULL,
  `Domicilio` varchar(200) NOT NULL,
  `Telefono` int(9) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `CodSup` int(10) DEFAULT NULL,
  PRIMARY KEY (`dni`),
  KEY `CodSup` (`CodSup`),
  CONSTRAINT `vendedor_ibfk_1` FOREIGN KEY (`CodSup`) REFERENCES `supermercado` (`CodSup`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `CodVenta` int(10) NOT NULL,
  `Fecha` datetime NOT NULL,
  `dniVend` int(8) DEFAULT NULL,
  `dniCl` int(8) DEFAULT NULL,
  PRIMARY KEY (`CodVenta`),
  KEY `dniVend` (`dniVend`),
  KEY `dniCl` (`dniCl`),
  CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`dniVend`) REFERENCES `vendedor` (`dni`),
  CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`dniCl`) REFERENCES `cliente` (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'act2'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-01-08 18:01:31
