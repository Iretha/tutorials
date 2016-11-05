Feature: Stock managment

Scenario: Add stock products
Given stock is initialized with the following products
|	id	|	type					|	expiryDate	|
|	0		| BREAD_MAMAS   | 04/11/2016  |
|	1		| BREAD_MAMAS   | 04/10/2016  |
|	2		| BREAD_PAPAS   | 04/09/2016  |
When products with following data are added to stock
|	id	|	type					|	expiryDate	|
|	3		| SUGAR_SWEET   | 01/11/2016  |
|	4		| SUGAR_SWEET   | 01/11/2016  |
|	5		| BREAD_MAMAS   | 01/11/2016  |
Then in stock are 3 products with product type BREAD_MAMAS
And  in stock are 1 products with product type BREAD_PAPAS
And  in stock are 2 products with product type SUGAR_SWEET
When product of type SUGAR_SWEET is removed
Then in stock are 1 products with product type SUGAR_SWEET 