Feature: 01.Form Authentication

  Scenario: Form Authentication
    Given browser is open
    And user select the form authentication
    When user fill in UserName with "tomsmith"
    And user fill in Password with "SuperSecretPassword!"
    And hits login
    Then user is navigated to the secure area
    And user sign out from page
    Then user navigate back to the home page





