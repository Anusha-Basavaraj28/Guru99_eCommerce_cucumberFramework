Feature: Guru99 Techpanda Ecommerce Application Functionality.

Scenario: Verify items in Mobile list page can be sorted by name.
Given User opens the application "http://live.techpanda.org/index.php/" in the browser
Then Title of the page should be "Home page"
When User clicks on the mobile menu
Then Tile of the page should be "Mobile"
When User selects sort by drope down as name
Then all the products should be sorted by name.

