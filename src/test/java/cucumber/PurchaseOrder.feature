Feature: Purchase the order from Ecommerce Website

Background:
Given I landed on Ecommerce page
Scenario Outline: Positive test of submitting the order

Given Logged in with username <username> and password <password>
When I add product <productname> from cart
And  Checkout <productname> and submit the order
Then I verify "THANKYOU FOR THE ORDER." message displayed on confirmationpage

Examples:
|username							 |	password	|	productname	|
|ravishan1992@gmail.com|	#ravi@123	|	ZARA COAT 3	|
