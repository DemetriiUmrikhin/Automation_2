Feature: Login Page

  Scenario: Verify that the 'Forgot Password' link redirects to the correct page
    Given the user is on the login page
    When the user clicks on the 'I don't remember my password' link
    Then the user should be redirected to the password recovery page
    And the user should see the text "Password Recovery"


  Scenario Outline: Verify login with invalid email formats
    Given the user is on the login page
    When the user enters "<invalid_email>" in the "username" field
    And the user enters "TestPassword123!" in the "password" field
    And the user clicks the "Log In" button
    Then the user should see error message "Invalid e-mail address and/or password"

    Examples:
      | invalid_email        |
      | user@domain          |
      | user@domain,com      |
      | user_at_domain.com   |
      | @domain.com          |
      | user@                |
