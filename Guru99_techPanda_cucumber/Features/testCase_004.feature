Feature: Guru99 Techpanda Ecommerce Application Functionality.

Scenario: Verify user able to compare 2 products
Given  User opens the application "http://live.techpanda.org/index.php/" in the browser
When User clicks on the mobile menu
And user clicks on Add to compare link for 2 mobiles Sony Xperia and IPhone
And click on compare button
Then pop up window should open and details of 2 products should be there.
And close the po up window