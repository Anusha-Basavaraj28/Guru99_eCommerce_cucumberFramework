Feature: Guru99 Techpanda Ecommerce Application Functionality.

Scenario: Verify user can not add more products in the cart than available in the store.
Given  User opens the application "http://live.techpanda.org/index.php/" in the browser
When User clicks on the mobile menu
And User clicks on SONY XPERIA add to cart button
And change QTY value to "1000" and clicks UPDATE button
Then user should get the error message.
When User clicks on Empty Cart link in the footer of list of all mobiles
Then Cart should be Empty