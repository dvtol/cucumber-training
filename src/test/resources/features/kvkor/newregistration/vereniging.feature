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
    And within "Adresgegevens rechtspersoon" the user enters the "Activiteitomschrijving" with "Dit is een activiteitomschrijving"
    Then click on the Volgende button
    And within "Bestuurder(s)" the user enters the "Datum_waarop_de_functionaris_in_functie_is_getreden" with "01-01-2018"
    And within "Bestuurder(s)" the user chooses for "hasBsn" the radiobutton "Nee"
    And within "Bestuurder(s)" the user enters the "Achternaam" with "Testmiep"
    And within "Bestuurder(s)" the user enters the Geboortedatum with "01-01-1980"
    And within "Bestuurder(s)" the user enters the "Geboorteplaats" with "Delft"
    And within "Bestuurder(s)" the user chooses for "Geslacht" the option "Vrouwelijk"
    And within "Bestuurder(s)" the user enters the "Postcode" with "1061TL"
    And within "Bestuurder(s)" the user enters the Huisnummer with "17"

