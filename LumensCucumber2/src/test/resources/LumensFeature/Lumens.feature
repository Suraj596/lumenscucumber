Feature: Lumens.com Application TestCases (End to End validation)

@createaccount
Scenario Outline:  TC001 Account Creation  

Given user should open link
Then click on accountand enter credentials "<SheetName>" and "<RowNumber>"
And click on submit
Examples:
|SheetName|RowNumber|
|CreateAccount|3|

@loginandtitle 
Scenario Outline: TC002 Login and TC003 Verify Title
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
And Click on login button
Examples:
|SheetName|RowNumber|
|CreateAccount|2|

@tabandfilter
Scenario Outline: TC004 Tab and TC005 Apply filter
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
Then Click on login button
Then Click on ceiling lights and select large chandeliers 
And Select the product by applying filter
Examples:
|SheetName|RowNumber|
|CreateAccount|0|


@addandview
Scenario Outline: TC006 Addproduct and TC007 Viewproduct filter
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
Then Click on login button
Then Click on ceiling lights and select large chandeliers 
Then Select the product by applying filter
And Able to add the product and view the added product in cart
Examples:
|SheetName|RowNumber|
|CreateAccount|0|


@search
Scenario Outline: TC008 Search
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
Then Click on login button
And Able to search the product "<SheetName>" and "<RowNumber>"
Examples:
|SheetName|RowNumber|
|CreateAccount|0|


@livechatvalid
Scenario Outline: TC009 livechat
 
Given User should nagivate to url
Then User able to select livechat and give credentials "<SheetName>" and "<RowNumber>"
And Click on submit button
Examples:
|SheetName|RowNumber|
|CreateAccount|0|


@livechatinvalid
Scenario Outline: TC0010 Invalidlivechat
 
Given User should nagivate to url
Then User able to select livechat and give invalid credentials "<SheetName>" and "<RowNumber>"
And Click on submit button invalid
Examples:
|SheetName|RowNumber|
|CreateAccount|1|



@removecart
Scenario Outline: TC011 removefromcart
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
And Click on login button
And Able to remove product from cart
Examples:
|SheetName|RowNumber|
|CreateAccount|0|


@couponcode
Scenario Outline: TC012 couponcode
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
And Click on login button
And Able to apply couponcode "<SheetName>" and "<RowNumber>"
Examples:
|SheetName|RowNumber|
|CreateAccount|0|


@scrollupdown 
Scenario Outline: TC013 scrollupdown
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
Then Click on login button
And Able to scroll updown the page
Examples:
|SheetName|RowNumber|
|CreateAccount|2|



@navigateback
Scenario Outline: TC014 navigateback
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
Then Click on login button
And Able to navigate back to home page
Examples:
|SheetName|RowNumber|
|CreateAccount|2|


@quantity
Scenario Outline: TC016 quantity
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
Then Click on login button
Then Click on ceiling lights and select large chandeliers 
Then Select the product by applying filter
And Able to increase the quantity "<SheetName>" and "<RowNumber>"
Examples:
|SheetName|RowNumber|
|CreateAccount|0|

@zipcode
Scenario Outline: TC017 zipcode
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
And Click on login button
And Able to apply zipcode "<SheetName>" and "<RowNumber>"
Examples:
|SheetName|RowNumber|
|CreateAccount|0|


@logout
Scenario Outline: TC017 logout
 
Given User should nagivate to url
Then User able to give credentials "<SheetName>" and "<RowNumber>"
Then Click on login button
And Able to logout 
Examples:
|SheetName|RowNumber|
|CreateAccount|2|
