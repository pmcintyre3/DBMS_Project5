-- gets all possible discounts for each member
select *
from products, categories
where categories.categoryID>=products.productCategoryID;

-- gets all possible discount for each user
select users.userId, users.userName, products.productID, products.productPrice, products.productCategoryID, categories.categoryDiscount
from users, categories, products
where users.userCategoryID = categories.categoryID and users.userCategoryID>=products.productCategoryID;

-- gets the products the user will not get a discount on
select users.userId, users.userName, products.productID, products.productPrice, products.productCategoryID, categories.categoryDiscount
from users, categories, products
where users.userCategoryID = categories.categoryID and users.userCategoryID<products.productCategoryID;

--query for graph
select categories.categoryID,COUNT(products.productCategoryID)
from orderDetails, products, categories
where orderDetails.prodId = products.productID and products.productCategoryID = categories.categoryID
group by categories.categoryID = products.productCategoryID;
