

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` char(50) NOT NULL,
  `user` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `catId` int NOT NULL,
  `admin` boolean NOT NULL,
  -- `created` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'admin','password',1,true),(2,'phillip','passmc',2,false),(3,'narita','passpa',3,false),(4,'jey','passjo',1,false),(5,'justin','passtu',2,false),(6,'ryan','passpe',1,false);
UNLOCK TABLES;

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `price` int NOT NULL,
  `image` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `points` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

LOCK TABLES `products` WRITE;
INSERT INTO `products` VALUES (1,70,'file','nike',10),(2,70,'file','adidas',10),(3,70,'file','new balance',10),(4,70,'file','puma',10),(5,70,'file','asics',10),(6,70,'file','fila',10);
UNLOCK TABLES;

DROP TABLE IF EXISTS `products`;

CREATE TABLE `categories` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `discount` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

LOCK TABLES `categories` WRITE;
INSERT INTO `categories` VALUES (1,70,'file','nike',10),(2,70,'file','adidas',10),(3,70,'file','new balance',10),(4,70,'file','puma',10),(5,70,'file','asics',10),(6,70,'file','fila',10);
UNLOCK TABLES;



