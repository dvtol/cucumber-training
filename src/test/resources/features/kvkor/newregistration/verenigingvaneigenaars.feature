@NieuweInschrijvingVvE
Feature: OR frontoffice login

  Background: Feature: OR frontoffice login

  Scenario: Registration Vereniging van Eigenaars
    Given the user opens the OR frontoffice application
    When the user is logged in and starts with a new registration with legal form "Vereniging van Eigenaars"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the unique "Naam_rechtspersoon" with "VvE"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the "Zetel" with "Utrecht"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the "Datum_akte_van_oprichting" with "01-01-2018"
    And within "Basisgegevens van de Vereniging van Eigenaars" the user enters the "Datum_ingang" with "01-01-2018"
    Then click on the Volgende button
    And within "Adresgegevens rechtspersoon" the user enters the "Postcode" with "8223WL"
    And within "Adresgegevens rechtspersoon" the user enters the "Huisnummer" with "111"
    And within "Adresgegevens rechtspersoon" the user enters the "Activiteitomschrijving" with "vullen adresgegevens"
    Then click on the Volgende button
