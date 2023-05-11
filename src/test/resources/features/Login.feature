@login

Feature: WebDriver University - Login page

  Scenario: Validate Successful Login - specific data
    Given I access the webdriver university login page
    When I enter a specific username "webdriver"
    And I enter a specific password webdriver123
    And I click on Login button
    Then I should be presented with a successful login message

  Scenario: Validate Unsuccessful Login - unique data
    Given I access the webdriver university login page
    When I enter a unique username
    And I enter a unique password
    And I click on Login button
    Then I should be presented with an unsuccessful login message
