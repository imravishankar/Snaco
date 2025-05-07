Feature: Error Validation 

Scenario Outline: Positive test of submitting the order 
	Given I landed on Ecommerce page 
	When Logged in with username <username> and password <password>
	Then "Incorrect email or password." message displayed.
	
	Examples: 
		|name							 |	password	|
		|ravishan1992@gmail.com			 |	#ravi@123	|
