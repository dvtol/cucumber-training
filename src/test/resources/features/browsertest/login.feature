@Smoketest
Feature: User wants to visit the website and login

  Background: Training (test) page to login

    Given the user visits the training login page


    Scenario: 1 User logs in with invalid credentials
      Then the user enters the "username" "test"
      Then the user enters the "password" "test"
      And the user clicks the signin button

    Scenario: 2 User logs in with valid credentials
      Then the user enters the "username" "cursus"
      Then the user enters the "password" "selenium"
      And the user clicks the signin button
