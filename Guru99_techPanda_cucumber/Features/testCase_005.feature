Feature: Guru99 Techpanda Ecommerce Application Functionality.

Scenario: Verify user can create account and can share wish list to other people through email
Given  User opens the application "http://live.techpanda.org/index.php/" in the browser
When user clicks on my account link
And clicks create account link and fill user information
And user clicks on register button
Then user Registration should be done
When user clicks on TV menu
And user adds LG LCD to wishlist
And user clicks on share wishlist link
And enters email and message and clicks on share wishlist
Then wish list should be shared