Feature: Guru99 Techpanda Ecommerce Application Functionality.

Scenario: Verigy cost of product in list page and detail page are same.
Given  User opens the application "http://live.techpanda.org/index.php/" in the browser
When User clicks on the mobile menu
And In the list of all products read the cost of "SONY XPERIA" and note the cost
When User clicks on SONY XPERIA mobile 
And user reads the cost of SONY XPERIA mobile in detail page
Then cost from list page and detail page should be same.
