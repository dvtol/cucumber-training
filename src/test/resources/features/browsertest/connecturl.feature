@Smoketest

Feature: User wants to visit the website and perform action(s)
  AC 1: The user should be able to visit the Cucumber website
  AC 2: The user should be on click another tab on the website

  Background: Making use of the official Cucumber page

    Given the user visits the official Cucumber page

  Scenario: 1 User logs in with invalid password
    And the user selects a different tab on the website