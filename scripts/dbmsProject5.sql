-- phpMyAdmin SQL Dump
-- version 4.4.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 22, 2015 at 08:01 AM
-- Server version: 5.6.25
-- PHP Version: 5.5.20

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbmsProject5`
--

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `categoryID` int(11) NOT NULL,
  `categoryName` varchar(255) NOT NULL,
  `categoryDiscount` int(11) NOT NULL,
  `minPointsRequired` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`categoryID`, `categoryName`, `categoryDiscount`, `minPointsRequired`) VALUES
(0, 'New Member', 10, 0),
(1, 'Bronze', 15, 20),
(2, 'Silver', 20, 50),
(3, 'Gold', 25, 70);

-- --------------------------------------------------------

--
-- Table structure for table `orderDetails`
--

CREATE TABLE IF NOT EXISTS `orderDetails` (
  `orderNumber` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `productSoldAt` double NOT NULL,
  `createdOn` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orderDetails`
--

INSERT INTO `orderDetails` (`orderNumber`, `productID`, `productSoldAt`, `createdOn`) VALUES
(1, 3, 70, '2015-07-22 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `userID` int(11) NOT NULL,
  `orderID` int(11) NOT NULL,
  `totalOrderPrice` double NOT NULL DEFAULT '0',
  `orderedOn` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`userID`, `orderID`, `totalOrderPrice`, `orderedOn`) VALUES
(4, 1, 70, '2015-07-22 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `points`
--

CREATE TABLE IF NOT EXISTS `points` (
  `userID` int(11) NOT NULL,
  `points` int(11) NOT NULL,
  `pointsRenewalDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `points`
--

INSERT INTO `points` (`userID`, `points`, `pointsRenewalDate`) VALUES
(1, 0, '2015-07-22 12:00:00'),
(2, 100, '2015-07-28 00:00:00'),
(3, 55, '2015-07-28 00:00:00'),
(4, 60, '2015-07-22 12:00:00'),
(5, 0, '2015-07-22 12:00:00'),
(6, 0, '2015-07-22 12:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `productID` int(11) NOT NULL,
  `productPrice` double NOT NULL,
  `productImage` varchar(255) NOT NULL,
  `productName` varchar(255) NOT NULL,
  `productDescription` varchar(1000) NOT NULL,
  `productPoints` int(11) NOT NULL,
  `productCategoryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`productID`, `productPrice`, `productImage`, `productName`, `productDescription`, `productPoints`, `productCategoryID`) VALUES
(1, 70, 'bootstrap/images/pic.jpg', 'Nike', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 10, 1),
(2, 70, 'bootstrap/images/pic1.jpg', 'Adidas', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 30, 2),
(3, 70, 'bootstrap/images/pic2.jpg', 'New balance', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 60, 3),
(4, 70, 'bootstrap/images/pic3.jpg', 'Puma', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 10, 1),
(5, 70, 'bootstrap/images/pic4.jpg', 'Asics', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 30, 2),
(6, 70, 'bootstrap/images/pic5.jpg', 'Fila', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 60, 3);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userID` int(11) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `userPassword` varchar(255) NOT NULL,
  `userCategoryID` int(11) NOT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `createdOn` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `userName`, `userPassword`, `userCategoryID`, `isAdmin`, `createdOn`) VALUES
(1, 'admin', 'password', 0, 1, '2015-07-22 12:00:00'),
(2, 'phillip', 'passmc', 3, 0, '2015-07-22 12:00:00'),
(3, 'narita', 'passpa', 2, 0, '2015-07-22 12:00:00'),
(4, 'jey', 'passjo', 0, 0, '2015-07-22 12:00:00'),
(5, 'justin', 'passtu', 0, 0, '2015-07-22 12:00:00'),
(6, 'ryan', 'passpe', 0, 0, '2015-07-22 12:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`categoryID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `userID` (`userID`);

--
-- Indexes for table `points`
--
ALTER TABLE `points`
  ADD PRIMARY KEY (`userID`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`productID`),
  ADD KEY `productCategoryID` (`productCategoryID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`),
  ADD UNIQUE KEY `userName` (`userName`),
  ADD UNIQUE KEY `userName_2` (`userName`),
  ADD KEY `userCategoryID` (`userCategoryID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`);

--
-- Constraints for table `points`
--
ALTER TABLE `points`
  ADD CONSTRAINT `points_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`userID`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`productCategoryID`) REFERENCES `categories` (`categoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`userCategoryID`) REFERENCES `categories` (`categoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


UPDATE `dbmsProject5`.`users` SET `userPassword` = '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8' WHERE `users`.`userID` = 1; UPDATE `dbmsProject5`.`users` SET `userPassword` = '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8' WHERE `users`.`userID` = 2; UPDATE `dbmsProject5`.`users` SET `userPassword` = '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8' WHERE `users`.`userID` = 3; UPDATE `dbmsProject5`.`users` SET `userPassword` = '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8' WHERE `users`.`userID` = 4; UPDATE `dbmsProject5`.`users` SET `userPassword` = '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8' WHERE `users`.`userID` = 5; UPDATE `dbmsProject5`.`users` SET `userPassword` = '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8' WHERE `users`.`userID` = 6; 


UPDATE `dbmsProject5`.`users` SET `userName` = 'admin@uga.edu' WHERE `users`.`userID` = 1; UPDATE `dbmsProject5`.`users` SET `userName` = 'phillip@uga.edu' WHERE `users`.`userID` = 2; UPDATE `dbmsProject5`.`users` SET `userName` = 'narita@uga.edu' WHERE `users`.`userID` = 3; UPDATE `dbmsProject5`.`users` SET `userName` = 'jey@uga.edu' WHERE `users`.`userID` = 4; UPDATE `dbmsProject5`.`users` SET `userName` = 'justin@uga.edu' WHERE `users`.`userID` = 5; UPDATE `dbmsProject5`.`users` SET `userName` = 'ryan@uga.edu' WHERE `users`.`userID` = 6;

