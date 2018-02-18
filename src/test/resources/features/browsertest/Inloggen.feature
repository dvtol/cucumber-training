@Regression
Feature: Als gebruiker wil ik inloggen zodat ik op de cucumber pagina uit kom

  Background:

    Scenario: 1 Inloggen met een valide gebruikersnaam en wachtwoord
      Given the user has opened a browser
      When the user enters "www.testautomationschool.nl/test" in the browser
      Then the user is on the login page