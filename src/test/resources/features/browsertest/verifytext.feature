@Smoketest

Feature: User wants to verify text on the page after login

  Background: Training (test) page to verify text

    Given the user visits the training login page

  Scenario: 1 User is logging in and verifies text on the page
    Then the user enters the "username" "cursus"
    Then the user enters the "password" "selenium"
    And the user clicks the signin button
    And the user is verifying text "Simple, human collaboration" on the page

  Scenario: 2 User visits website and verifies title
    And the user is verifying pagetitle text on the page

