@RestTest

Feature: Get (personal) data via rest api calls

  Scenario: User calls web service to get a person by his/her name
    Given a person with the name Jantje
    When a user retrieves the name by xml
    Then the status code is 200