INSERT INTO `categories` (`categoryID`, `categoryName`, `categoryDiscount`, `minPointsRequired`) VALUES
(0, 'New Member', 10, 0),
(1, 'Bronze', 15, 20),
(2, 'Silver', 20, 50),
(3, 'Gold', 25, 70);

INSERT INTO `orders` (`userID`, `orderID`, `orderAmount`, `orderedOn`, `productID`) VALUES
(3, 1, 56, '2015-07-27 00:00:00', 1),
(6, 2, 70, '2015-07-27 00:00:00', 6),
(5, 3, 70, '2015-07-27 00:00:00', 4),
(2, 4, 52.5, '2015-07-27 00:00:00', 2);


INSERT INTO `points` (`userID`, `points`, `pointsRenewalDate`, `userCategoryID`) VALUES
(1, 0, '2015-07-22 12:00:00', 0),
(2, 130, '2015-07-28 00:00:00', 3),
(3, 75, '2015-07-28 00:00:00', 2),
(4, 0, '2015-07-25 00:00:00', 3),
(5, 0, '2015-07-27 00:00:00', 0),
(6, 0, '2015-07-27 00:00:00', 2);

INSERT INTO `products` (`productID`, `productPrice`, `productImage`, `productName`, `productDescription`, `productPoints`, `productCategoryID`) VALUES
(1, 70, 'bootstrap/images/pic.jpg', 'Nike', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 10, 1),
(2, 70, 'bootstrap/images/pic1.jpg', 'Adidas', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 30, 2),
(3, 70, 'bootstrap/images/pic2.jpg', 'New balance', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 60, 3),
(4, 70, 'bootstrap/images/pic3.jpg', 'Puma', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 10, 1),
(5, 70, 'bootstrap/images/pic4.jpg', 'Asics', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 30, 2),
(6, 70, 'bootstrap/images/pic5.jpg', 'Fila', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 60, 3);

INSERT INTO `users` (`userID`, `userName`, `userPassword`, `isAdmin`, `createdOn`) VALUES
(1, 'admin@uga.edu', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 1, '2015-07-22 12:00:00'),
(2, 'phillip@uga.edu', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 0, '2015-07-22 12:00:00'),
(3, 'narita@uga.edu', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 0, '2015-07-22 12:00:00'),
(4, 'jey@uga.edu', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 0, '2015-07-22 12:00:00'),
(5, 'justin@uga.edu', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 0, '2015-07-22 12:00:00'),
(6, 'ryan@uga.edu', '5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8', 0, '2015-07-22 12:00:00');