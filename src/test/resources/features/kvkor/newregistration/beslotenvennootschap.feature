@NieuweInschrijvingBV
Feature: OR frontoffice inlog

  Background: Feature: OR frontoffice inlog

  Scenario: Registration Besloten Vennootschap
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Besloten Vennootschap"
    And the mandatory data is entered
    Then the user can validate, sign and submit the assignment