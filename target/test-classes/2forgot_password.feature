Feature: 03.Forgot Password

  Scenario: Forgot Password

    Given user on the main page
    And user select the Forgot Password element
    When user fill in email with "test@gmail.com"
    Then user click submit
