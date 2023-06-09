Feature: Guru99 Techpanda Ecommerce Application Functionality.



Scenario: Verify user can able to purchase the product theough the registered email id.
Given  User opens the application "http://live.techpanda.org/index.php/" in the browser
When user clicks on my account link
And login with email "IrAQJBNv@gmail.com" and password "abAB@123"
When user clicks on my wishlist link
And in the next page clicks ADD to cart link
And clicks on Proceed to checkout
And enters shipping informaion
And clicks continue
Then shipping cost should be generTED
And clicks continue2
And in payment information select check/money order radio button and click continue
Then in the total amount shipping cost sholud be added
When user clicks on place order button
Then order should be placed and orderId should be generated



