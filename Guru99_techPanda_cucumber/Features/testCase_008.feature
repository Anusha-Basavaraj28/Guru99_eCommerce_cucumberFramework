Feature: Guru99 Techpanda Ecommerce Application Functionality.

Scenario: Verify user can able to change or reorder previously added product.
Given  User opens the application "http://live.techpanda.org/index.php/" in the browser
When user clicks on my account link
And login with email "IrAQJBNv@gmail.com" and password "abAB@123"
When user clicks on Reorder and change QTY to "10" and click update
Then Grand total should be changed.
When user completes billing and shipping information
Then order should be placed and orderId should be generated
