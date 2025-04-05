Feature: Verify Homepage Elements

  Scenario: Verify that the 'Web Hosting' link redirects to the correct page
    Given I navigate to the InMotion Hosting homepage
    When the page is fully loaded
    Then I should see the link with id "webHostingDropDown" and title "Web Hosting"
    And I click the Web Hosting link
    And I should be redirected to "/web-hosting"

  Scenario: Verify that the 'Support' link redirects to the correct page
    Given I navigate to the InMotion Hosting homepage
    When the page is fully loaded
    Then I should see the link with id "supportDropDown" and title "Support"
    And I click the Support Center link
    And I should be redirected to "/support/"