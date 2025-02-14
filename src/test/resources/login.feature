Feature: Login Page

Scenario: Verify that the 'Verify you are human' checkbox is working correctly
  Given the user is on the login page
  When the user enters a valid username in the "username" field
  And the user enters a valid password in the "password" field
  And the user checks the 'Verify you are human' checkbox
  And the user clicks the "login" button
  Then the user should be successfully redirected to the main page
  And the user should see a message confirming the login

Scenario Outline: Verify login functionality with various invalid email formats
  Given the user is on the login page
  When the user enters "<invalid_email>" in the "username" field
  And the user enters a valid password in the "password" field
  And the user checks the 'Verify you are human' checkbox
  And the user clicks the "login" button
  Then the user should see an error message indicating an invalid email format
  Examples:
    | invalid_email      |
    | user@domain        |
    | user@domain,com    |
    | user_at_domain.com |
