@NewRegistrationVereniging
Feature: OR frontoffice login

  Background: Feature: OR frontoffice login

  Scenario: Registration Vereniging
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Vereniging"
    And within "Basisgegevens van de Vereniging" the user enters the unique "Naam_rechtspersoon" with "Vereniging"
    And within "Basisgegevens van de Vereniging" the user enters the "Zetel" with "Alkmaar"
    And within "Basisgegevens van de Vereniging" the user enters the "Datum_oprichting" with "01-01-2018"
    And within "Basisgegevens van de Vereniging" the user enters the "Akte_datum" with "01-01-2018"
    Then click on the Volgende button
    And within "Adresgegevens rechtspersoon" the user enters the "Postcode" with "3447GT"
    And within "Adresgegevens rechtspersoon" the user enters the "Huisnummer" with "1"