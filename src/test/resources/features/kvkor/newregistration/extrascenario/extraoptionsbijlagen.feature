@NewRegistrationExtraOptionsBijlagen
Feature: Add and remove extra location scenario - OR frontoffice

  Background: Feature: Extra scenario's OR frontoffice - new registration

    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Besloten Vennootschap"
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button
    Then click on the Volgende button

  Scenario: Delete added attachment(s) with legal type BV
    And within "Bijlage(n)" the user uploads the attachment "Akte van oprichting.pdf" for "Akte van oprichting (verplicht)"
    And click on the Delete button