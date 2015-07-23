
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` char(50) NOT NULL,
  `user` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `catId` int NOT NULL,
  `admin` boolean NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES ('1','admin','password',1,true),('2','phillip','passmc',2,false),('3','narita','passpa',3,false),('4','jey','passjo',1,false),('5','justin','passtu',2,false),('6','ryan','passpe',1,false);
UNLOCK TABLES;

DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `userId` char(50) NOT NULL,
  `points` int NOT NULL,
  -- `created` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- LOCK TABLES `points` WRITE;
INSERT INTO `points` VALUES ('1',100),('2',90),('3',80),('4',70),('5',60),('6',50);
UNLOCK TABLES;

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `price` int NOT NULL,
  `image` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `points` int NOT NULL,
  `catId` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

-- LOCK TABLES `products` WRITE;
INSERT INTO `products` VALUES (1,70,'bootstrap/images/pic.jpg','nike',10,1),(2,70,'bootstrap/images/pic1.jpg','adidas',10,2),(3,70,'bootstrap/images/pic2.jpg','new balance',10,3),(4,70,'bootstrap/images/pic3.jpg','puma',10,1),(5,70,'bootstrap/images/pic4.jpg','asics',10,2),(6,70,'bootstrap/images/pic5.jpg','fila',10,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `discount` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

-- LOCK TABLES `categories` WRITE;
INSERT INTO `categories` VALUES (0,'new member',10),(1,'bronze',15),(2,'silver',20),(3,'gold',25);
UNLOCK TABLES;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int NOT NULL,
  `prodId` int NOT NULL,
  `createdOn` int NOT NULL,
   PRIMARY KEY (`id`, `prodId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- LOCK TABLES `orders` WRITE;
UNLOCK TABLES;






