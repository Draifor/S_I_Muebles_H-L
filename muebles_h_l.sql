-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: muebles_h_l
-- ------------------------------------------------------
-- Server version	8.0.29

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
  `Cod_Cliente` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Identificacion` int NOT NULL,
  `Celular` varchar(15) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  PRIMARY KEY (`Cod_Cliente`),
  UNIQUE KEY `Identificacion` (`Identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Anastasia','del Socorro',1234567890,'3200000000','Calle 5 # 8 - 25, Tangamandapio'),(2,'Petronio','Euclides',1234567891,'3100000000','Cra 15 # 24 -14, Somondoco'),(3,'Jacinta','Trinidad Díaz',1234567892,'3120000000','Calle 8 # 8 - 8, Cucaita'),(4,'Rupertino','Feo',1234567893,'3180000000','Calle 13 # 23 - 12, Sutamarchan'),(5,'Satellizer','L. Bridget',1124253423,'3203604234','Freezing'),(6,'Pepito','Eutanasio',124234254,'3212143446','Calle siempre viva # 32 - 71'),(7,'Yilver','Risafloja',564564,'564564','Calle'),(8,'Modificación','sdfsd',23453,'345','dfg'),(14,'Hermelindo','Ortiz',4574,'56745','Calle'),(15,'Eustaquio','PK',9788,'897','kl;jm'),(16,'Prueba 100','sdf',4,'34','df'),(18,'Camila','Herminda',675,'678','Cle'),(19,'Hola','Mundo',897,'87','Cla'),(21,'Ramiriqui ','sdg',8972345,'980','sdf'),(22,'Ramiiy asf ','sdg',89723455,'980','sdf'),(23,'Daniel','Parra',4564,'3456798','dfgjhd'),(28,'Anatoli','dfgsdfg',111111111,'324523','dsfgdfg'),(29,'agregado','sdg',564545646,'564','xcv'),(32,'Percy','wertwert',554,'23453','sdgfsdfg'),(37,'sdfsd','dfsdfs',3434,'34534','3gdgd'),(38,'srfserf','sdfsdf',34534,'4355','rgtet'),(40,'dfgdf','dfgdfg',456456,'45645','dfgdfg'),(41,'Luis Alfredo Parra Jorge','sefw',23452,'342','wewe'),(42,'dfg','dfgdfg',5645645,'67867','dfgf'),(43,'Sthepany','Tamayo',12345,'00000','Calle falsa');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diseños`
--

DROP TABLE IF EXISTS `diseños`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diseños` (
  `Cod_Diseño` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  `Imagen` varchar(60) NOT NULL,
  PRIMARY KEY (`Cod_Diseño`),
  UNIQUE KEY `Referencia` (`Referencia`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diseños`
--

LOCK TABLES `diseños` WRITE;
/*!40000 ALTER TABLE `diseños` DISABLE KEYS */;
INSERT INTO `diseños` VALUES (1,'Sala','sala_L_001','Sala en L roja','sdfsdf'),(2,'abc','ghi','def','jklmnñ'),(4,'refere','Nombreee','Tipoooooooooo','imagen'),(5,'referen','nombre','tipo','imagen'),(7,'sdfgdf','dfg','dfgdsfg','dfgsdfg'),(8,'DIS-0001','dfgd','dfgdf','dfgd'),(14,'DIS-0009','ftghr','rtyhr','rtyhrt'),(15,'DIS-0015','dfgdf','dfgdf','dfgdf'),(17,'DIS-0016','erter','ertere','ert');
/*!40000 ALTER TABLE `diseños` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiales`
--

DROP TABLE IF EXISTS `materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materiales` (
  `Cod_Material` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Costo` double NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`Cod_Material`),
  UNIQUE KEY `Referencia` (`Referencia`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiales`
--

LOCK TABLES `materiales` WRITE;
/*!40000 ALTER TABLE `materiales` DISABLE KEYS */;
INSERT INTO `materiales` VALUES (1,'aglom01','Aglomerado',50000,5),(2,'mad001','Madera',100000,9),(3,'adasa','asdasfas',1000000,90),(4,'aaaaa','bbbbbb',1111111,6),(6,'sdfg','dfgdf',34534,1001),(8,'sefsdf','sdfsdcvbn',34534,41),(10,'sdfgds','dfgdaaaaf',9075,101),(11,'dfghfg','456456',234454545,3),(12,'sdfs','sdfsde',4334,11);
/*!40000 ALTER TABLE `materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordencompra_diseños`
--

DROP TABLE IF EXISTS `ordencompra_diseños`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordencompra_diseños` (
  `Cod_OrdComp_Dise` int NOT NULL AUTO_INCREMENT,
  `Cod_OrdComp` int NOT NULL,
  `Cod_Diseño` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`Cod_OrdComp_Dise`),
  KEY `FK_OrdenCompra_Diseños_OrdenesCompra_Cod_Ord_Comp_idx` (`Cod_OrdComp`),
  KEY `FK_OrdenCompra_Diseños_Diseño_Cod_Diseño_idx` (`Cod_Diseño`),
  CONSTRAINT `FK_OrdenCompra_Diseños_Diseño_Cod_Diseño` FOREIGN KEY (`Cod_Diseño`) REFERENCES `diseños` (`Cod_Diseño`),
  CONSTRAINT `FK_OrdenCompra_Diseños_OrdenesCompra_Cod_Ord_Comp` FOREIGN KEY (`Cod_OrdComp`) REFERENCES `ordenescompra` (`Cod_OrdComp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompra_diseños`
--

LOCK TABLES `ordencompra_diseños` WRITE;
/*!40000 ALTER TABLE `ordencompra_diseños` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordencompra_diseños` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordencompra_productos`
--

DROP TABLE IF EXISTS `ordencompra_productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordencompra_productos` (
  `Cod_OrdComp_Prod` int NOT NULL AUTO_INCREMENT,
  `Cod_OrdComp` int NOT NULL,
  `Cod_Producto` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`Cod_OrdComp_Prod`),
  KEY `FK_OrdenCompra_Productos_Productos_Cod_Producto_idx` (`Cod_Producto`),
  KEY `FK_OrdenCompra_Productos_OrdenesCompra_Cod_OrdComp_idx` (`Cod_OrdComp`),
  CONSTRAINT `Cod_OrdComp` FOREIGN KEY (`Cod_OrdComp`) REFERENCES `ordenescompra` (`Cod_OrdComp`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Cod_Producto` FOREIGN KEY (`Cod_Producto`) REFERENCES `productos` (`Cod_Producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordencompra_productos`
--

LOCK TABLES `ordencompra_productos` WRITE;
/*!40000 ALTER TABLE `ordencompra_productos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ordencompra_productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordenescompra`
--

DROP TABLE IF EXISTS `ordenescompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordenescompra` (
  `Cod_OrdComp` int NOT NULL AUTO_INCREMENT,
  `Cod_Cliente` int NOT NULL,
  `Fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Completada` tinyint(1) DEFAULT '0',
  `VentaEfectiva` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`Cod_OrdComp`),
  KEY `FK_Ordenes_Compra_Clientes_Cod_Cliente_idx` (`Cod_Cliente`),
  CONSTRAINT `FK_OrdenesCompra_Clientes_Cod_Cliente` FOREIGN KEY (`Cod_Cliente`) REFERENCES `clientes` (`Cod_Cliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordenescompra`
--

LOCK TABLES `ordenescompra` WRITE;
/*!40000 ALTER TABLE `ordenescompra` DISABLE KEYS */;
INSERT INTO `ordenescompra` VALUES (1,1,'2022-07-17 02:42:27',0,0);
/*!40000 ALTER TABLE `ordenescompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_materiales`
--

DROP TABLE IF EXISTS `producto_materiales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_materiales` (
  `Cod_Prod_Material` int NOT NULL AUTO_INCREMENT,
  `Cod_Producto` int NOT NULL,
  `Cod_Material` int NOT NULL,
  `Cantidad` int NOT NULL,
  PRIMARY KEY (`Cod_Prod_Material`),
  KEY `FK_producto_Materiales_Producto_Cod_Producto_idx` (`Cod_Producto`),
  KEY `FK_Producto_Materiales_Materiales_Cod_Material_idx` (`Cod_Material`),
  CONSTRAINT `FK_Producto_Materiales_Materiales_Cod_Material` FOREIGN KEY (`Cod_Material`) REFERENCES `materiales` (`Cod_Material`),
  CONSTRAINT `FK_producto_Materiales_Producto_Cod_Producto` FOREIGN KEY (`Cod_Producto`) REFERENCES `productos` (`Cod_Producto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_materiales`
--

LOCK TABLES `producto_materiales` WRITE;
/*!40000 ALTER TABLE `producto_materiales` DISABLE KEYS */;
/*!40000 ALTER TABLE `producto_materiales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `Cod_Producto` int NOT NULL AUTO_INCREMENT,
  `Referencia` varchar(8) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Tipo` varchar(30) NOT NULL,
  `Precio` double NOT NULL,
  `Cantidad` int NOT NULL,
  `Cod_Diseño` int NOT NULL,
  PRIMARY KEY (`Cod_Producto`),
  UNIQUE KEY `Referencia` (`Referencia`),
  UNIQUE KEY `Nombre` (`Nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'sdfg','sdfgsdfhg','sdfghsdf',456456,1,1),(2,'aaaaaa','werwerwe','dfwe',12312,15,123),(4,'sdfghfg','fdghfg','fghfg',56757,4,3453);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ventas`
--

DROP TABLE IF EXISTS `ventas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas` (
  `Cod_Venta` int NOT NULL AUTO_INCREMENT,
  `FacturaID` varchar(10) NOT NULL,
  `Cod_OrdComp` int NOT NULL,
  `Fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Cod_Venta`),
  KEY `FK_Ventas_OrdenesCompra_Cod_OrdComp_idx` (`Cod_OrdComp`),
  CONSTRAINT `FK_Ventas_OrdenesCompra_Cod_OrdComp` FOREIGN KEY (`Cod_OrdComp`) REFERENCES `ordenescompra` (`Cod_OrdComp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas`
--

LOCK TABLES `ventas` WRITE;
/*!40000 ALTER TABLE `ventas` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-07-22  9:19:19
