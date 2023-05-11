@contact-us

Feature: WebDriver University - Contact Us page

  Scenario: Validate Successful Submission - Unique data
    Given I access the webdriver university contact us page
    When I enter a unique first name
    And I enter a unique last name
    And I enter a unique email address
    And I enter a unique comment
    And I click on submit button
    Then I should be presented with a successful contact us submission message


  Scenario: Validate Successful Submission - specific data
    Given I access the webdriver university contact us page
    When I enter a specific first name Sarah
    And I enter a specific last name Mohammad
    And I enter a specific email address Sarah123@mail.com
    And I enter a specific comment "How's job search going for this week?"
    And I click on submit button
    Then I should be presented with a successful contact us submission message