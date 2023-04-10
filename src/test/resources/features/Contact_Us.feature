Feature: WebDriver University - Contact Us page

  Scenario: Validate Successful Submission - Unique data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on submit button
    Then I should be presented with a successful contact us submission message
