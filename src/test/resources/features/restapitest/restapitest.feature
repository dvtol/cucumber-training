@RestTest

Feature: Get (personal) data via rest api calls

  Scenario: User calls web service to get a person by his/her name
    Given a person with the name John
    And a the user is retrieved data in JSON format
    Then the status code is 200