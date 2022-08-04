-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: muebles_h_l
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `Cliente_id` int NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(8) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Identificacion` int NOT NULL,
  `Celular` varchar(15) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  PRIMARY KEY (`Cliente_id`),
  UNIQUE KEY `Identificacion` (`Identificacion`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'CLI-0001','Anastasia','del Socorro',1234567890,'3200000000','Calle 5 # 8 - 25, Tangamandapio'),(2,'CLI-0002','Petronio','Euclides',1234567891,'3100000000','Cra 15 # 24 -14, Somondoco'),(3,'CLI-0003','Jacinta','Trinidad Díaz',1234567892,'3120000000','Calle 8 # 8 - 8, Cucaita'),(4,'CLI-0004','Rupertino','Feo',1234567893,'3180000000','Calle 13 # 23 - 12, Sutamarchan'),(5,'CLI-0005','Satellizer','L. Bridget',1124253423,'3203604234','Freezing'),(6,'CLI-0006','Pepito','Eutanasio',124234254,'3212143446','Calle siempre viva # 32 - 71'),(7,'CLI-0007','Yilver','Risafloja',564564,'564564','Calle'),(8,'CLI-0008','Modificación','sdfsd',23453,'345','dfg'),(14,'CLI-0014','Hermelindo','Ortiz',4574,'56745','Calle'),(15,'CLI-0015','Eustaquio','PK',9788,'897','kl;jm'),(16,'CLI-0016','Prueba 100','sdf',4,'34','df'),(18,'CLI-0018','Camila','Herminda',675,'678','Cle'),(19,'CLI-0019','Hola','Mundo',897,'87','Cla'),(21,'CLI-0021','Ramiriqui ','sdg',8972345,'980','sdf'),(22,'CLI-0022','Ramiiy asf ','sdg',89723455,'980','sdf'),(23,'CLI-0023','Daniel','Parra',4564,'3456798','dfgjhd'),(28,'CLI-0028','Anatoli','dfgsdfg',111111111,'324523','dsfgdfg'),(29,'CLI-0029','agregado','sdg',564545646,'564','xcv'),(32,'CLI-0032','Percy','wertwert',554,'23453','sdgfsdfg'),(40,'CLI-0040','dfgdf','dfgdfg',456456,'45645','dfgdfg'),(41,'CLI-0041','Luis Alfredo Parra Jorge','sefw',23452,'342','wewe'),(42,'CLI-0042','Cliente','42',5645645,'67867','dfgf'),(43,'CLI-0043','Sthepany','Tamayo',12345,'00000','Calle falsa'),(45,'CLI-0045','pedillo','dfgdf',40564,'4564','ghfg'),(46,'CLI-0046','Prueba 500','awefse',345345,'345','tgr'),(47,'CLI-0047','Gualá','jujuj',9845,'4564','gfhf'),(49,'CLI-0048','sdfsdf','sdfsdf',123,'345345','sdfsdf'),(52,'CLI-0050','Prueba','Enésima',112233,'3432','fvjdf'),(53,'CLI-0053','Heidi','Sanchez',132455646,'23423423','Quito'),(54,'CLI-0054','Jacinta','Petronia',546608,'4484','Calle Falsa'),(55,'CLI-0055','df','dfsg',404056,'46','cbngh'),(56,'CLI-0056','Prueba','Enésima',1234154,'654','Caalleee');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Asignar_Codigo_Cliente` BEFORE INSERT ON `clientes` FOR EACH ROW BEGIN
	DECLARE siguiente_id INT;
    IF (SELECT MAX(Cliente_id) FROM Clientes) > 0 THEN
		SET siguiente_id = (SELECT MAX(Cliente_id)+1 ultimo FROM Clientes);
    ELSE 
		SET siguiente_id = 1;
    END IF;
	
    SET NEW.Codigo = CONCAT('CLI-', LPAD(siguiente_id, 4, '0'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `diseño_materiales`
--

DROP TABLE IF EXISTS `diseño_materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diseño_materiales` (
  `Prod_Material_id` int NOT NULL AUTO_INCREMENT,
  `Diseño_id` int NOT NULL,
  `Material_id` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`Prod_Material_id`),
  KEY `FK_Producto_Materiales_Materiales_Material_id_idx` (`Material_id`),
  KEY `FK_producto_Materiales_Producto_Diseño_id_idx` (`Diseño_id`),
  CONSTRAINT `FK_Producto_Materiales_Materiales_Material_id` FOREIGN KEY (`Material_id`) REFERENCES `materiales` (`Material_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_producto_Materiales_Producto_Diseño_id` FOREIGN KEY (`Diseño_id`) REFERENCES `diseños` (`Diseño_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseño_materiales`
--

LOCK TABLES `diseño_materiales` WRITE;
/*!40000 ALTER TABLE `diseño_materiales` DISABLE KEYS */;
INSERT INTO `diseño_materiales` VALUES (2,25,16,5),(4,8,8,20);
/*!40000 ALTER TABLE `diseño_materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diseños`
--

DROP TABLE IF EXISTS `diseños`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diseños` (
  `Diseño_id` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  `Imagen` varchar(60) NOT NULL,
  PRIMARY KEY (`Diseño_id`),
  UNIQUE KEY `Referencia` (`Referencia`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseños`
--

LOCK TABLES `diseños` WRITE;
/*!40000 ALTER TABLE `diseños` DISABLE KEYS */;
INSERT INTO `diseños` VALUES (1,'DIS-0001','sala_L_001','Sala en L roja','sdfsdf'),(2,'DIS-0002','ghi','def','jklmnñ'),(4,'DIS-0004','Nombreee','Tipoooooooooo','imagen'),(5,'DIS-0005','nombre','tipo','imagen'),(7,'DIS-0007','Juego de Muebles en L Azul - Cuero','Sala','dfgsdfg'),(8,'DIS-0008','Juego de muebles en L Rojo - Gamuza','Sala','dfgd'),(14,'DIS-0014','Armario rojo','Closets','rtyhrt'),(15,'DIS-0015','aaaaa','bbbbb','ccccc'),(18,'DIS-0018','rtyt','tryurt','tyut'),(19,'DIS-0019','tydrt','tryrt','lllll'),(20,'DIS-0020','Diseño','aaaaa','cccccc'),(22,'DIS-0021','Prueba','Diseño','sefdf'),(24,'DIS-0023','Juego de Muebles en L Azul - Gamuza','Gamuza','rtyhtjfg'),(25,'DIS-0024','aaaaaa','fgd','dfgdf');
/*!40000 ALTER TABLE `diseños` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Asignar_Referencia_Diseño` BEFORE INSERT ON `diseños` FOR EACH ROW BEGIN
	DECLARE siguiente_id INT;
    IF (SELECT MAX(Diseño_id) FROM Diseños) > 0 THEN
		SET siguiente_id = (SELECT MAX(Diseño_id)+1 FROM Diseños);
	ELSE 
		SET siguiente_id = 1;
	END IF;
	SET NEW.Referencia = CONCAT('DIS-', LPAD(siguiente_id, 4, '0'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiales` (
  `Material_id` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Costo` double NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`Material_id`),
  UNIQUE KEY `Referencia` (`Referencia`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiales`
--

LOCK TABLES `materiales` WRITE;
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` VALUES (1,'MAT-0001','Aglomerado',50000,5),(2,'MAT-0002','Madera',100000,9),(3,'MAT-0003','asdasfas',1000000,90),(4,'MAT-0004','bbbbbb',1111111,6),(6,'MAT-0006','dfgdf',34534,1001),(8,'MAT-0008','sdfsdcvbn',34534,40),(10,'MAT-0010','dfgdaaaaf',9075,101),(11,'MAT-0011','456456',234454545,3),(13,'MAT-0013','Material',1254,3),(15,'MAT-0014','mmmmmm',11111,8),(16,'MAT-0016','aaaa',234,3);
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Asignar_Referencia_Material` BEFORE INSERT ON `materiales` FOR EACH ROW BEGIN
	DECLARE siguiente_id INT;
    IF (SELECT MAX(Material_id) FROM Materiales) > 0 THEN
		SET siguiente_id = (SELECT MAX(Material_id) + 1 FROM Materiales);
	ELSE
		SET siguiente_id = 1;
	END IF;
	SET NEW.Referencia = CONCAT('MAT-', LPAD(siguiente_id, 4, '0'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ordencompra_diseños`
--

DROP TABLE IF EXISTS `ordencompra_diseños`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordencompra_diseños` (
  `OrdComp_Dise_id` int NOT NULL AUTO_INCREMENT,
  `OrdComp_id` int NOT NULL,
  `Diseño_id` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`OrdComp_Dise_id`),
  KEY `FK_OrdenCompra_Diseños_OrdenesCompra_Ord_Comp_id_idx` (`OrdComp_id`),
  KEY `FK_OrdenCompra_Diseños_Diseño_Diseño_id_idx` (`Diseño_id`),
  CONSTRAINT `FK_OrdenCompra_Diseños_Diseño_Diseño_id` FOREIGN KEY (`Diseño_id`) REFERENCES `diseños` (`Diseño_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_OrdenCompra_Diseños_OrdenesCompra_Ord_Comp_id` FOREIGN KEY (`OrdComp_id`) REFERENCES `ordenescompra` (`OrdComp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompra_diseños`
--

LOCK TABLES `ordencompra_diseños` WRITE;
/*!40000 ALTER TABLE `ordencompra_diseños` DISABLE KEYS */;
INSERT INTO `ordencompra_diseños` VALUES (1,3,25,20);
/*!40000 ALTER TABLE `ordencompra_diseños` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordencompra_productos`
--

DROP TABLE IF EXISTS `ordencompra_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordencompra_productos` (
  `OrdComp_Prod_id` int NOT NULL AUTO_INCREMENT,
  `OrdComp_id` int NOT NULL,
  `Producto_id` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`OrdComp_Prod_id`),
  KEY `FK_OrdenCompra_Productos_Productos_Producto_id_idx` (`Producto_id`),
  KEY `FK_OrdenCompra_Productos_OrdenesCompra_OrdComp_id_idx` (`OrdComp_id`),
  CONSTRAINT `Cod_OrdComp` FOREIGN KEY (`OrdComp_id`) REFERENCES `ordenescompra` (`OrdComp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Cod_Producto` FOREIGN KEY (`Producto_id`) REFERENCES `productos` (`Producto_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompra_productos`
--

LOCK TABLES `ordencompra_productos` WRITE;
/*!40000 ALTER TABLE `ordencompra_productos` DISABLE KEYS */;
INSERT INTO `ordencompra_productos` VALUES (1,3,10,10000),(2,3,8,2),(3,1,5,5);
/*!40000 ALTER TABLE `ordencompra_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenescompra`
--

DROP TABLE IF EXISTS `ordenescompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenescompra` (
  `OrdComp_id` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `Cliente_id` int NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Completada` tinyint(1) DEFAULT '0',
  `VentaEfectiva` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`OrdComp_id`),
  KEY `FK_Ordenes_Compra_Clientes_Cliente_id_idx` (`Cliente_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK_OrdenesCompra_Clientes_Cliente_id` FOREIGN KEY (`Cliente_id`) REFERENCES `clientes` (`Cliente_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenescompra`
--

LOCK TABLES `ordenescompra` WRITE;
/*!40000 ALTER TABLE `ordenescompra` DISABLE KEYS */;
INSERT INTO `ordenescompra` VALUES (1,'ORD-0001',54,'2022-07-17 02:42:27',0,0),(3,'ORD-0003',54,'2022-08-03 01:20:26',0,0);
/*!40000 ALTER TABLE `ordenescompra` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Asignar_Referencia_OrdenCompra` BEFORE INSERT ON `ordenescompra` FOR EACH ROW BEGIN
	DECLARE siguiente_id INT;
    IF (SELECT MAX(OrdComp_id) FROM OrdenesCompra) > 0 THEN
		SET siguiente_id = (SELECT MAX(OrdComp_id) + 1 FROM OrdenesCompra);
	ELSE
		SET siguiente_id = 1;
	END IF;
	SET NEW.Referencia = CONCAT('ORD-', LPAD(siguiente_id, 4, '0'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `Producto_id` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  `Precio` double NOT NULL,
  `Cantidad` int NOT NULL,
  `Diseño_id` int NOT NULL,
  PRIMARY KEY (`Producto_id`),
  UNIQUE KEY `Referencia` (`Referencia`),
  UNIQUE KEY `Nombre` (`Nombre`),
  KEY `fk_productos_diseños_diseño_id_idx` (`Diseño_id`),
  CONSTRAINT `fk_productos_diseños_diseño_id` FOREIGN KEY (`Diseño_id`) REFERENCES `diseños` (`Diseño_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'PRO-0001','sdfgsdfhg','sdfghsdf',456456,1,1),(4,'PRO-0004','fdghfg','fghfg',56757,4,3453),(5,'PRO-0005','dfsgdf','dsfgsd',343,1,4),(6,'PRO-0006','aaaaaaaaa','bbbbbbbbbb',111111111,1,5),(7,'PRO-0007','gggggg','aaaaaa',124,8,8),(8,'PRO-0008','Sala','asds',34564,4,7),(10,'PRO-0010','aaaaa','ccccc',334,3,25);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Asignar_Referencia_Producto` BEFORE INSERT ON `productos` FOR EACH ROW BEGIN
	DECLARE siguiente_id INT;
    IF (SELECT MAX(Producto_id) FROM Productos) > 0 THEN
		SET siguiente_id = (SELECT MAX(Producto_id)+1 FROM Productos);
	ELSE
		SET siguiente_id = 1;
	END IF;
	
	SET NEW.Referencia = CONCAT('PRO-', LPAD(siguiente_id, 4, '0'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `Venta_id` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `OrdComp_id` int NOT NULL,
  `Fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Venta_id`),
  KEY `FK_Ventas_OrdenesCompra_OrdComp_id_idx` (`OrdComp_id`) /*!80000 INVISIBLE */,
  CONSTRAINT `FK_Ventas_OrdenesCompra_OrdComp_id` FOREIGN KEY (`OrdComp_id`) REFERENCES `ordenescompra` (`OrdComp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
INSERT INTO `ventas` VALUES (1,'VEN-0001',3,'2022-08-03 01:42:36');
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `Asignar_Referencia_Venta` BEFORE INSERT ON `ventas` FOR EACH ROW BEGIN
	DECLARE siguiente_id INT;
    IF (SELECT MAX(Venta_id) FROM Ventas) > 0 THEN
		SET siguiente_id = (SELECT MAX(Venta_id)+1 FROM Ventas);
	ELSE
		SET siguiente_id = 1;
	END IF;
	
	SET NEW.Referencia = CONCAT('VEN-', LPAD(siguiente_id, 4, '0'));
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-03 21:33:59
