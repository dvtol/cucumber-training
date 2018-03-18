@Smoketest

Feature: User wants to visit the website and login
  AC 1: The user should be able to enter an username
  AC 2: The user should be able to enter a password
  AC 3: There should be an error message shown if the user tries to login with incorrect credentials
  AC 4: The user should be on the Cucumber page if the correct credentials are entered

  Background: Training (test) page to login

    Given the user visits the training login page

  Scenario: 1 User logs in with invalid credentials
    When the user enters the "username" "test"
        #And the user enters the "password" "test"
        #And the user clicks the signin button
        #Then the user should receive the following error message "U kunt niet worden aangemeld. Controleer uw gebruikersnaam en wachtwoord en probeer het opnieuw."

  Scenario: 2 User logs in with valid credentials
    When the user enters the "username" "cursus"
        #And the user enters the "password" "selenium"
        #And the user clicks the signin button
        #Then the user should be on the default landing page of the cucumber website

  Scenario Outline: 3 User logs in with invalid credentials
    When the user enters the username with "<username>"
    And the user enters the password "<password>"
      #And the user clicks the signin button
      #Then the user should receive the following error message "U kunt niet worden aangemeld. Controleer uw gebruikersnaam en wachtwoord en probeer het opnieuw."

    Examples:
        #    | username | password |
        #    | cursus   | fout     |

