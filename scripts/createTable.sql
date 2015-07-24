DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userID` int NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `userCategoryID` int NOT NULL,
  `isAdmin` boolean NOT NULL,
  `createdOn` datetime NOT NULL,
  UNIQUE(`userName`),
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'admin','password',1,true,'2015-07-22 12:00:00'),(2,'phillip','passmc',2,false,'2015-07-22 12:00:00'),(3,'narita','passpa',3,false,'2015-07-22 12:00:00'),(4,'jey','passjo',1,false,'2015-07-22 12:00:00'),(5,'justin','passtu',2,false,'2015-07-22 12:00:00'),(6,'ryan','passpe',1,false,'2015-07-22 12:00:00');
UNLOCK TABLES;

DROP TABLE IF EXISTS `points`;
CREATE TABLE `points` (
  `userID` int NOT NULL,
  `points` int NOT NULL,
  -- `created` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- LOCK TABLES `points` WRITE;
INSERT INTO `points` VALUES (1,100),(2,90),(3,80),(4,70),(5,60),(6,50);
UNLOCK TABLES;

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `productID` int NOT NULL,
  `productPrice` double NOT NULL,
  `productImage` varchar(255) NOT NULL,
  `productName` varchar(255) NOT NULL,
  `productDescription` varchar(1000) NOT NULL,
  `productPoints` int NOT NULL,
  `productCategoryID` int NOT NULL,
  PRIMARY KEY (`productID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

-- LOCK TABLES `products` WRITE;
INSERT INTO `products` VALUES (1,70,'bootstrap/images/pic.jpg','nike','lorem ipsum shoe',10,1),(2,70,'bootstrap/images/pic1.jpg','adidas','lorem ipsum shoe',10,2),(3,70,'bootstrap/images/pic2.jpg','new balance','lorem ipsum shoe',10,3),(4,70,'bootstrap/images/pic3.jpg','puma','lorem ipsum shoe',10,1),(5,70,'bootstrap/images/pic4.jpg','asics','lorem ipsum shoe',10,2),(6,70,'bootstrap/images/pic5.jpg','fila','lorem ipsum shoe',10,3);
UNLOCK TABLES;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `categoryID` int NOT NULL,
  `categoryName` varchar(255) NOT NULL,
  `categoryDiscount` int NOT NULL,
  PRIMARY KEY (`categoryID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 

-- LOCK TABLES `categories` WRITE;
INSERT INTO `categories` VALUES (0,'new member',10),(1,'bronze',15),(2,'silver',20),(3,'gold',25);
UNLOCK TABLES;

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `userID` int NOT NULL,
  `orderID` int NOT NULL,
  `totalOrderPrice` double NOT NULL,
  `orderedOn` int NOT NULL,
   PRIMARY KEY (`userId`, `orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- LOCK TABLES `orders` WRITE;
UNLOCK TABLES;

DROP TABLE IF EXISTS `orderDetails`;
CREATE TABLE `orderDetails` (
  `orderNumber` int NOT NULL,
  `productID` int NOT NULL,
  `productSoldAt` double NOT NULL,
   PRIMARY KEY (`orderNumber`,`productSoldAt`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- LOCK TABLES `orderDetails` WRITE;
UNLOCK TABLES;
