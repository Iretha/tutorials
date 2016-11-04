Feature: Stock managment

Scenario: Modify stock products
Given stock is initialized with the following products
|	id	|	product_code	|	expiryDate	|
|	0		| 0    					| 04-11-2016  |
|	1		| 0    					| 04-10-2016  |
|	2		| 1    					| 04-09-2016  |
When products with following data are added to stock
|	id	|	product_code	|	expiryDate	|
|	3		| 2    					| 01-11-2016  |
|	4		| 2    					| 01-11-2016  |
|	5		| 0    					| 01-11-2016  |
Then in stock are 3 products with product code 0
And  in stock are 1 products with product code 1
And  in stock are 2 products with product code 2