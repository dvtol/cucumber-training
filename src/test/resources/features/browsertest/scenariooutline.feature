@Smoketest

Feature: User wants to visit the website and login
  AC 1: The user should be able to enter an username
  AC 2: The user should be able to enter a password
  AC 3: There should be an error message shown if the user tries to login with incorrect credentials

  Background: Training (test) page to login

  Scenario Outline: 1 User logs in with invalid credentials
    Given the user visits the training login page
    When the user enters the username with "<username>"
    And the user enters the password "<password>"
    And the user clicks the signin button
    Then the user should receive the following error message "U kunt niet worden aangemeld. Controleer uw gebruikersnaam en wachtwoord en probeer het opnieuw."

    Examples:
      | username | password |
      | cursus   | fout     |
      | fout     | selenium |
      | fout     | fout     |
